package com.example.myinventory;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myinventory.Adapter.Inventory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ListMainActivity extends AppCompatActivity implements RecyclerView_Config.FirebaseDataListener {

    private static String TAG = ListMainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private RecyclerView_Config mAdapter;
    private ArrayList<Inventory> daftarInventory;
    private EditText mCodeM, mLokasi, mRack, mMatDesc, mDept, muom, mBeginingstck, mPriceStck, mTotal, mdate, mIn, mOut, mNote, mStock, mTotalStck;
    private androidx.appcompat.widget.Toolbar mToolbar;
    private FloatingActionButton mFloatingActionButton;

    //variabel yang merefers ke Firebase Database
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.table_main);

        setupToolbar(R.id.toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        //mDatabaseReference =mFirebaseInstance.getReference("inventory-3242e");

//        Query mQueryRef = mDatabaseReference.child("inventory");
//        mQueryRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Inventory inventory = dataSnapshot.getValue(Inventory.class);
//
//                Log.e(TAG, "inventoryaaa "+inventory.getNo());
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        mDatabaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Inventory post = dataSnapshot.getValue(Inventory.class);
//
//                Log.e(TAG, "aaaaa "+post.getDate());
//
//                System.out.println(post);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });


//        FirebaseDatabase.getInstance()
//                .getReference()
//                .child("inventory")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
//                            Inventory object = dataSnap.getValue(Inventory.class);
//
//                            Log.e(TAG,"object "+object.getKey());
//
//                            // Use your object as needed
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        mDatabase.child("inventory-3242e").child("inventory").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.e(TAG, "DataSnapshot "+dataSnapshot.toString());
//                //This will loop through all items. Add variables to arrays or lists as required
//                for (DataSnapshot snap : dataSnapshot.getChildren()){
//                    Log.e(TAG, "snap "+snap.getKey());
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });

//        Query mQueryRef = mDatabaseReference.child("inventory");
//
//        mQueryRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Log.d(TAG, "onDataChange():" + dataSnapshot.toString());
//
//                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
//                    Inventory bullet = snapshot.getValue(Inventory.class);
//                    Log.d(TAG, "bullet():" + bullet.getNo());
//                    //bullets.put(snapshot.getKey(), bullet);
//                }
//
//                //Iterate and Print your bullets hashmap here.
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.e(TAG, "Failed to read Bullet list.", error.toException());
//
//            }
//        });


//        mDatabaseReference.child("inventory-3242e").child("inventory").addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Iterable<DataSnapshot> contactChildren = dataSnapshot.getChildren();
//                Log.e(TAG, "dataSnapshot "+dataSnapshot.getKey());
//
//                daftarInventory = new ArrayList<>();
//                for (DataSnapshot mDataSnapshot : contactChildren) {
//                    Log.e(TAG, "aaaaabbb "+mDataSnapshot.getKey());
//
//                    Inventory inventory = mDataSnapshot.getValue(Inventory.class);
//
//                    Log.e(TAG, "inventory "+inventory.getNo());
//
//                    inventory.setKey(mDataSnapshot.getKey());
//                    daftarInventory.add(inventory);
//                }
//                mAdapter = new RecyclerView_Config(ListMainActivity.this, daftarInventory);
//                mRecyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // TODO: Implement this method
//                //  Toast.makeText(ListMainActivity.this, databaseError.getDetails()+" "+databaseError.getMessage(),Toast.LENGTH_LONG).show();
//            }
//
//        });

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("inventory-3242e").child("inventory");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        collectPhoneNumbers((Map<String,Inventory>) dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.tambah);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tambah barang
                dialogTambahBarang();
            }
        });

        }

    /* method ketika data di klik
     */

        @Override
        public void onDataClick(final Inventory inventory, int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih Aksi");

            builder.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialogUpdateInventory(inventory);

                }
            });
            builder.setNegativeButton("HAPUS", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    hapusDataInventory(inventory);
                }

            });
            builder.setNeutralButton("BATAL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            Dialog dialog = builder.create();
            dialog.show();
        }
            //setup android toolbar
            private void setupToolbar(int id){
                mToolbar = (Toolbar) findViewById(id);
                setSupportActionBar(mToolbar);
            }

            //dialog tambah barang / alert dialog
            private void dialogTambahBarang(){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("TAMBAH DATA ITEM");
            View view = getLayoutInflater().inflate(R.layout.activity_form, null);

                mCodeM = (EditText)view.findViewById(R.id.CodeM);
                mLokasi = (EditText)view.findViewById(R.id.Lokasi);
                mRack = (EditText)view.findViewById(R.id.Rack);
                mDept = (EditText)view.findViewById(R.id.Dept);
                mMatDesc = (EditText)view.findViewById(R.id.MatDesc);
                muom = (EditText)view.findViewById(R.id.uom);
                mBeginingstck = (EditText)view.findViewById(R.id.Beginingstck);
                mPriceStck = (EditText)view.findViewById(R.id.PriceStck);
                mTotal = (EditText)view.findViewById(R.id.Total);
                mdate = (EditText)view.findViewById(R.id.date);
                mIn = (EditText)view.findViewById(R.id.In);
                mOut = (EditText)view.findViewById(R.id.Out);
                mNote = (EditText)view.findViewById(R.id.Note);
                mStock = (EditText)view.findViewById(R.id.Stock);
                mTotalStck = (EditText)view.findViewById(R.id.TotalStck);

                builder.setView(view);

                //button simpan barang / submit barang
                builder.setPositiveButton("SIMPAN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String code_MaterialInventory = mCodeM.getText().toString();
                        String lokasiInventory = mLokasi.getText().toString();
                        String rack_NumberInventory = mRack.getText().toString();
                        String material_descInventory = mMatDesc.getText().toString();
                        String deptInventory = mDept.getText().toString();
                        String uomInventory = muom.getText().toString();
                        String begining_StockInventory = mBeginingstck.getText().toString();
                        String price_unitInventory = mPriceStck.getText().toString();
                        String total_Inventory = mTotal.getText().toString();
                        String dateInventory = mdate.getText().toString();
                        String inputInventory = mIn.getText().toString();
                        String outputInventory = mOut.getText().toString();
                        String noteInventory = mNote.getText().toString();
                        String stockInventory = mStock.getText().toString();
                        String total_sInventory = mTotalStck.getText().toString();

                        if (!code_MaterialInventory.isEmpty() && !lokasiInventory.isEmpty() && !rack_NumberInventory.isEmpty() && !material_descInventory.isEmpty() && !deptInventory.isEmpty() && !uomInventory.isEmpty() && !begining_StockInventory.isEmpty() && !price_unitInventory.isEmpty() && !total_Inventory.isEmpty() && !dateInventory.isEmpty() && !inputInventory.isEmpty() && !outputInventory.isEmpty() && !noteInventory.isEmpty() && !stockInventory.isEmpty() && !total_sInventory.isEmpty()){
                            submitDataInventory(new Inventory(code_MaterialInventory, lokasiInventory, rack_NumberInventory, material_descInventory, deptInventory, uomInventory, begining_StockInventory, price_unitInventory, total_Inventory, dateInventory, inputInventory, outputInventory, noteInventory, stockInventory, total_sInventory));
                        }

                        else {

                            Toast.makeText(ListMainActivity.this,"Data Harus diisi!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                //button kembali
                builder.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }

    private void collectPhoneNumbers(Map<String,Inventory> users) {

        ArrayList<Long> phoneNumbers = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Inventory> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            phoneNumbers.add((Long) singleUser.get("Lokasi"));
        }

        System.out.println(phoneNumbers.toString());
    }

            //dialog update barang / update data barang
            private void dialogUpdateInventory(final Inventory inventory){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("In/Out");
            View view = getLayoutInflater().inflate(R.layout.activity_trans, null);

                mCodeM = (EditText)view.findViewById(R.id.CodeM);
                mLokasi = (EditText)view.findViewById(R.id.Lokasi);
                mRack = (EditText)view.findViewById(R.id.Rack);
                mDept = (EditText)view.findViewById(R.id.Dept);
                mMatDesc = (EditText)view.findViewById(R.id.MatDesc);
                muom = (EditText)view.findViewById(R.id.uom);
                mBeginingstck = (EditText)view.findViewById(R.id.Beginingstck);
                mPriceStck = (EditText)view.findViewById(R.id.PriceStck);
                mTotal = (EditText)view.findViewById(R.id.Total);
                mdate = (EditText)view.findViewById(R.id.date);
                mIn = (EditText)view.findViewById(R.id.In);
                mOut = (EditText)view.findViewById(R.id.Out);
                mNote = (EditText)view.findViewById(R.id.Note);
                mStock = (EditText)view.findViewById(R.id.Stock);
                mTotalStck = (EditText)view.findViewById(R.id.TotalStck);


                mCodeM.setText(inventory.getCode_Material());
                mLokasi.setText(inventory.getLokasi());
                mRack.setText(inventory.getRack_Number());
                mDept.setText(inventory.getDept());
                mMatDesc.setText(inventory.getMaterial_desc());
                muom.setText(inventory.getUom());
                mBeginingstck.setText(inventory.getBegining_Stock());
                mPriceStck.setText(inventory.getPrice_unit());
                mTotal.setText(inventory.getTotal_());
                mdate.setText(inventory.getDate());
                mIn.setText(inventory.getInput());
                mOut.setText(inventory.getOutput());
                mNote.setText(inventory.getNote());
                mStock.setText(inventory.getStock());
                mTotalStck.setText(inventory.getTotal_s());

                builder.setView(view);

                //final Barang mBarang = (Barang)getIntent().getSerializableExtra("

                if (inventory !=null){
                    builder.setPositiveButton("SIMPAN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            inventory.setCode_Material(mCodeM.getText().toString());
                            inventory.setLokasi(mLokasi.getText().toString());
                            inventory.setRack_Number(mRack.getText().toString());
                            inventory.setMaterial_desc(mMatDesc.getText().toString());
                            inventory.setDept(mDept.getText().toString());
                            inventory.setBegining_Stock(mBeginingstck.getText().toString());
                            inventory.setPrice_unit(mPriceStck.getText().toString());
                            inventory.setTotal_(mTotal.getText().toString());
                            inventory.setDate(mdate.getText().toString());
                            inventory.setInput(mIn.getText().toString());
                            inventory.setOutput(mOut.getText().toString());
                            inventory.setNote(mNote.getText().toString());
                            inventory.setStock(mStock.getText().toString());
                            inventory.setDate(mdate.getText().toString());
                            inventory.setTotal_s(mTotalStck.getText().toString());
                            updateDataInventory(inventory);
                        }
                    });
                }
                builder.setNegativeButton("BATAL", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });

                Dialog dialog = builder.create();
                dialog.show();


            }


            private void submitDataInventory(Inventory inventory){

            mDatabaseReference.child("inventory").push().setValue(inventory).addOnSuccessListener(this, new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(ListMainActivity.this, "Data berhasil di simpan!", Toast.LENGTH_LONG)
                            .show();
                }
            });
        }


            private void updateDataInventory(Inventory inventory){
            mDatabaseReference.child("inventory").child(inventory.getKey()).setValue(inventory).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(ListMainActivity.this,"Data berhasil di update !", Toast.LENGTH_LONG).show();
                }
            });
            }

            private void hapusDataInventory(Inventory inventory){
            if (mDatabaseReference != null) {
                mDatabaseReference.child("inventory").child(inventory.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ListMainActivity.this,"Data berhasil dihapus!", Toast.LENGTH_LONG).show();
                    }
                });
            }
            }
        }






