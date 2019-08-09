package com.example.myinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView DataKpl,DataBrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DataKpl = findViewById(R.id.DataKpl);
        DataBrg = findViewById(R.id.DataBrg);

        DataKpl.setOnClickListener(this);
        DataBrg.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent i ;

        switch (view.getId()) {
            case R.id.DataKpl : i = new Intent(this,dataKapalActivity.class);startActivity(i); break;
            case R.id.DataBrg :i = new Intent(this,ListMainActivity.class);startActivity(i); break;
            default:break;
        }
    }
}

