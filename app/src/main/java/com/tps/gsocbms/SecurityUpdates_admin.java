package com.tps.gsocbms;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecurityUpdates_admin extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_updates_admin);

        findViewById(R.id.coordinates_admin_alert);
        findViewById(R.id.email_alert_admin);


    }
}