package com.example.myinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dataKapalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kapal);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Data Barang");
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}