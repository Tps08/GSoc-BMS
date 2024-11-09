package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class WritePetition extends AppCompatActivity {


    EditText petition,petitionTitle;
    Button submitPetition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_petition);

        petition= findViewById(R.id.petition);
        submitPetition= findViewById(R.id.submitPetition);
        petitionTitle= findViewById(R.id.petitionTitle);




        submitPetition.setOnClickListener(v -> {

            String petitionTitleText = petitionTitle.getText().toString();
            String petitionText= petition.getText().toString();

            if(petitionTitleText.length()==0){
                petitionTitle.setError("Title cannot be empty");
                petition.requestFocus();
                return;
            }
            if(petitionText.length()==0){
                petition.setError("Body of petition cannot be empty");
                petition.requestFocus();
                return;
            }

            Intent intent = new Intent(WritePetition.this,Categories.class);
            intent.putExtra("petitionText",petitionText);
            intent.putExtra("petitionTitle",petitionTitleText);
            startActivity(intent);




        });
    }
}