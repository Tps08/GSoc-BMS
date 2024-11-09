package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewPetitionAdmin extends AppCompatActivity {

    TextView titleViewAdmin,emailViewAdmin,textViewAdmin;
    RadioGroup radioGrpStatus;
    Button setStatusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_petition_admin);

        Intent intent = getIntent();
        String petitionTitleAdmin = intent.getStringExtra("titleAdmin");
        String petitionText_Admin = intent.getStringExtra("petitionTextAdmin");
        String petitionEmailAdmin = intent.getStringExtra("emailAdmin");
        String department = intent.getStringExtra("department");

        titleViewAdmin= findViewById(R.id.email_alert_admin);
        emailViewAdmin= findViewById(R.id.coordinates_admin_alert);
        textViewAdmin= findViewById(R.id.textMyPetition);
        radioGrpStatus= findViewById(R.id.radioGrp_status);
        setStatusBtn= findViewById(R.id.setStatusBtn);

        titleViewAdmin.setText(petitionTitleAdmin);
        emailViewAdmin.setText(petitionEmailAdmin);
        textViewAdmin.setText(petitionText_Admin);
        setStatusBtn.setOnClickListener(v -> updateStaus(petitionTitleAdmin,petitionEmailAdmin,petitionText_Admin,department));
    }

    @SuppressLint("NonConstantResourceId")
    private void updateStaus(String petitionTitleAdmin, String petitionEmailAdmin, String petitionText_admin, String petitionDepartment_admin) {

        String status;
        int k = radioGrpStatus.getCheckedRadioButtonId();

        switch(k){
            case R.id.in_progress_status:
                status = "in progress" ;
                break;
            case R.id.resolved_status:
                status = "resolved" ;
                break;

            default:
                status = "pending";
        }

        Petition petition = new Petition(petitionEmailAdmin,petitionText_admin,status,petitionTitleAdmin);
        DatabaseReference dbUser = FirebaseDatabase.getInstance().getReference("petitions").child(petitionDepartment_admin).child(petitionTitleAdmin);
        dbUser.setValue(petition).addOnCompleteListener(task -> {
            Intent intent = new Intent(ViewPetitionAdmin.this,FirstScreen_admin.class);
            startActivity(intent);
        });

    }

}