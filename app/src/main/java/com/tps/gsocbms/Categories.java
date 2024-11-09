package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Categories extends AppCompatActivity {

    ImageView administrative,academic,nonAcademic,hostelRelated,cleanliness,submitted_animation;
    FirebaseAuth mAuth;
    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        administrative= findViewById(R.id.Administrative);
        academic= findViewById(R.id.Academic);
        nonAcademic= findViewById(R.id.NonAcademic);
        hostelRelated= findViewById(R.id.Hostel_Related);
        cleanliness = findViewById(R.id.Cleanliness);
        mAuth= FirebaseAuth.getInstance();
        submitted_animation= findViewById(R.id.submitted_animation);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        Intent intent=getIntent();
        String petitionTextNew = intent.getStringExtra("petitionText");
        String petitionTitleNew = intent.getStringExtra("petitionTitle");

        String email = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();
        Petition petition= new Petition(email,petitionTextNew,"pending",petitionTitleNew);
        DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference("petitions");


        administrative.setOnClickListener(v -> dbUsers.child("administrative").child(petitionTitleNew).setValue(petition).addOnCompleteListener(task -> {
            submitted_animation.setVisibility(View.VISIBLE);


            Drawable drawable = submitted_animation.getDrawable();
            if (drawable instanceof AnimatedVectorDrawableCompat) {
                avd = (AnimatedVectorDrawableCompat) drawable;
                avd.start();
            } else if (drawable instanceof AnimatedVectorDrawable) {
                avd2 = (AnimatedVectorDrawable) drawable;
                avd2.start();
            }
            new Handler().postDelayed(() -> {
                Intent intent1 = new Intent(Categories.this, FirstScreen.class);
                startActivity(intent1);
            }, 500);
        }));

        academic.setOnClickListener(v -> dbUsers.child("academic").child(petitionTitleNew).setValue(petition).addOnCompleteListener(task -> {
            submitted_animation.setVisibility(View.VISIBLE);


            Drawable drawable = submitted_animation.getDrawable();
            if (drawable instanceof AnimatedVectorDrawableCompat) {
                avd = (AnimatedVectorDrawableCompat) drawable;
                avd.start();
            } else if (drawable instanceof AnimatedVectorDrawable) {
                avd2 = (AnimatedVectorDrawable) drawable;
                avd2.start();
            }

            new Handler().postDelayed(() -> {
                Intent intent1 = new Intent(Categories.this, FirstScreen.class);
                startActivity(intent1);
            }, 500);
        }));

        nonAcademic.setOnClickListener(v -> dbUsers.child("non academic").child(petitionTitleNew).setValue(petition).addOnCompleteListener(task -> {
            submitted_animation.setVisibility(View.VISIBLE);


            Drawable drawable = submitted_animation.getDrawable();
            if (drawable instanceof AnimatedVectorDrawableCompat) {
                avd = (AnimatedVectorDrawableCompat) drawable;
                avd.start();
            } else if (drawable instanceof AnimatedVectorDrawable) {
                avd2 = (AnimatedVectorDrawable) drawable;
                avd2.start();
            }
            new Handler().postDelayed(() -> {
                Intent intent1 = new Intent(Categories.this, FirstScreen.class);
                startActivity(intent1);
            }, 500);
        }));

        hostelRelated.setOnClickListener(v -> dbUsers.child("hostel related").child(petitionTitleNew).setValue(petition).addOnCompleteListener(task -> {
            submitted_animation.setVisibility(View.VISIBLE);


            Drawable drawable = submitted_animation.getDrawable();
            if (drawable instanceof AnimatedVectorDrawableCompat) {
                avd = (AnimatedVectorDrawableCompat) drawable;
                avd.start();
            } else if (drawable instanceof AnimatedVectorDrawable) {
                avd2 = (AnimatedVectorDrawable) drawable;
                avd2.start();
            }
            new Handler().postDelayed(() -> {
                Intent intent1 = new Intent(Categories.this, FirstScreen.class);
                startActivity(intent1);
            }, 500);
        }));

        cleanliness.setOnClickListener(v -> dbUsers.child("cleanliness and hygiene").child(petitionTitleNew).setValue(petition).addOnCompleteListener(task -> {
            submitted_animation.setVisibility(View.VISIBLE);


            Drawable drawable = submitted_animation.getDrawable();
            if (drawable instanceof AnimatedVectorDrawableCompat) {
                avd = (AnimatedVectorDrawableCompat) drawable;
                avd.start();
            } else if (drawable instanceof AnimatedVectorDrawable) {
                avd2 = (AnimatedVectorDrawable) drawable;
                avd2.start();
            }
            new Handler().postDelayed(() -> {
                Intent intent1 = new Intent(Categories.this, FirstScreen.class);
                startActivity(intent1);
            }, 500);
        }));
    }


}