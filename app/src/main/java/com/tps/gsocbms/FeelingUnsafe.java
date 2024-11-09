package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class FeelingUnsafe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_unsafe);
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(this,FirstScreen.class);
        startActivity(intent);
        //super.onBackPressed();
    }
}