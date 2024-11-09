package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class FirstScreen_admin extends AppCompatActivity{

    ImageView Logout_admin,administrative_admin,academic_admin,nonAcademic_admin,hostelRelated_admin,cleanliness_admin,securityAlert_admin;
    FirebaseAuth mAuth;
    String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen_admin);

        administrative_admin= findViewById(R.id.Administrative_admin);
        academic_admin= findViewById(R.id.Academic_admin);
        nonAcademic_admin= findViewById(R.id.NonAcademic_admin);
        hostelRelated_admin= findViewById(R.id.HostelRelated_admin);
        cleanliness_admin= findViewById(R.id.Cleanliness_admin);
        securityAlert_admin= findViewById(R.id.securityAlert_admin);

        Intent intent= new Intent(FirstScreen_admin.this,showPetitions.class);

        administrative_admin.setOnClickListener(v -> {
            department= "administrative";
            intent.putExtra(Intent.EXTRA_TEXT,department);
            startActivity(intent);
        });
        academic_admin.setOnClickListener(v -> {
            department= "academic";
            intent.putExtra(Intent.EXTRA_TEXT,department);
            startActivity(intent);
        });
        nonAcademic_admin.setOnClickListener(v -> {
            department= "non academic";
            intent.putExtra(Intent.EXTRA_TEXT,department);
            startActivity(intent);
        });
        hostelRelated_admin.setOnClickListener(v -> {
            department= "hostel related";
            intent.putExtra(Intent.EXTRA_TEXT,department);
            startActivity(intent);
        });
        cleanliness_admin.setOnClickListener(v -> {
            department= "cleanliness and hygiene";
            intent.putExtra(Intent.EXTRA_TEXT,department);
            startActivity(intent);
        });


        Logout_admin= findViewById(R.id.Logout_admin);
        mAuth=FirebaseAuth.getInstance();
        Logout_admin.setOnClickListener(v -> {
            mAuth.signOut();
            Intent intent12 = new Intent(FirstScreen_admin.this,login_admin.class);
            startActivity(intent12);
        });

        securityAlert_admin.setOnClickListener(v -> {
            Intent intent1= new Intent(FirstScreen_admin.this,SecurityUpdates_admin.class);
            startActivity(intent1);
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}