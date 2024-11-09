package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMyPetition extends AppCompatActivity {

    TextView titleMyPetition,emailMyPetition,textMyPetition,StatusMyPetition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_petition);

        titleMyPetition= findViewById(R.id.email_alert_admin);
        emailMyPetition= findViewById(R.id.coordinates_admin_alert);
        textMyPetition= findViewById(R.id.textMyPetition);
        StatusMyPetition= findViewById(R.id.statusMyPetition);

        Intent intent=getIntent();
        String title_my_Petition = intent.getStringExtra("title_my_petition");
        String email_my_Petition = intent.getStringExtra("email_my_petition");
        String text_my_Petition = intent.getStringExtra("text_my_petition");
        String status_my_Petition = intent.getStringExtra("status_my_petition");

        titleMyPetition.setText(title_my_Petition);
        emailMyPetition.setText(email_my_Petition);
        textMyPetition.setText(text_my_Petition);
        StatusMyPetition.setText(status_my_Petition);

    }
}