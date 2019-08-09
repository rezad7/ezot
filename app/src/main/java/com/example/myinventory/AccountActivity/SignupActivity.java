package com.example.myinventory.AccountActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myinventory.MainActivity;
import com.example.myinventory.R;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class SignupActivity extends AppCompatActivity {

    ImageView ImgProfil;
    static int PReqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImgUri;

    private EditText Inputemail,Inputpassword,Inputname,Inputpassword2;
    private Button Btnreg;
    private Button BtnLog;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Inputemail = (EditText)findViewById(R.id.email);
        Inputname = (EditText)findViewById(R.id.name);
        Inputpassword = (EditText)findViewById(R.id.password);
        Inputpassword2 = (EditText)findViewById(R.id.cnfrmpassword);
        Btnreg = findViewById(R.id.sign_up_button);
        BtnLog = findViewById(R.id.sign_in_button);

        mAuth = FirebaseAuth.getInstance();
        BtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }
        });

        Btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Btnreg.setVisibility(View.INVISIBLE);
                final String email = Inputemail.getText().toString();
                final String name = Inputname.getText().toString();
                final String password = Inputpassword.getText().toString();
                final String password2 = Inputpassword2.getText().toString();

            if (email.isEmpty() || name.isEmpty() || password.isEmpty() || !password.equals(password2)) {

            //something goes wrong : all field must be filled
                showMessage("please verify all fields");
                Btnreg.setVisibility(View.VISIBLE);

            }

            else {
                //everything is ok and all fields are filled now we can start creating user account
                CreateUserAccount(email,name,password);
                Toast.makeText(SignupActivity.this, "Sign up succesfully", Toast.LENGTH_SHORT).show();
                finish();


            }

            }
        });

    ImgProfil = findViewById(R.id.ImgProfil);
    ImgProfil.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Build.VERSION.SDK_INT >= 22) {
                checkAndRequestForPermission();

            } else {
                openGalerry();
            }
        }
    });
    }

    private void CreateUserAccount(String email, final String name, String password) {

    //this methode create user account with specifik email and password
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //usser account created succesfully
                            showMessage("Account created");
                            //after we created user account we need to update profil pic and name
                            updateUserInfo(name,pickedImgUri,mAuth.getCurrentUser());

                        }

                        else
                        {

                            //account creation failed
                            showMessage("account creation failed" + task.getException().getMessage());
                            Btnreg.setVisibility(View.VISIBLE);


                        }
                    }
                });




    }

    //update user and name
    private void updateUserInfo(final String name, Uri pickedImgUri, final FirebaseUser currentUser) {
    //first we need to upload user photo to firebase storage and get Url


        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("user_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //image upload succesfully
                //now we can get our image url

            imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {

                    //url contain user image url

                    UserProfileChangeRequest profilUpdate = new UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .setPhotoUri(uri)
                            .build();

                    currentUser.updateProfile(profilUpdate)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        //user info update succesfuly
                                        showMessage("Register Complete");
                                        updateUI();

                                    }
                                }
                            });
                }
            });
            }
        });

    }

    private void updateUI() {

        Intent LoginActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(LoginActivity);
        finish();

    }

    private void showMessage(String message) {

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }

    private void openGalerry() {
        //Todo open galery permission

        Intent galerryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galerryIntent.setType("image/*");
        startActivityForResult(galerryIntent,REQUESCODE);
    }

    private void checkAndRequestForPermission() {
        if (ContextCompat.checkSelfPermission(SignupActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(SignupActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)){

                Toast.makeText(SignupActivity.this,"please accept for required permission",Toast.LENGTH_SHORT).show();
            }

            else
            {
                ActivityCompat.requestPermissions(SignupActivity.this,
                                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                                    PReqCode);
            }

        }
            else
                openGalerry();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null ) {


            pickedImgUri = data.getData() ;
            ImgProfil.setImageURI(pickedImgUri);
        }
    }
}