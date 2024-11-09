package com.tps.gsocbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class IntroScreen extends AppCompatActivity {

    Button ToAdminBtn,ToStudentBtn;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        mAuth= FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){

            Intent intent;
            String email_user = mAuth.getCurrentUser().getEmail();
            assert email_user != null;
            String email_rev = reverse(email_user);

            intent= new Intent(this,FirstScreen.class);
            startActivity(intent);
        }

        ToAdminBtn= findViewById(R.id.ToAdminBtn);
        ToStudentBtn= findViewById(R.id.ToStudentBtn);
        ToAdminBtn.setOnClickListener(v -> {
            Intent intent= new Intent(IntroScreen.this,login_admin.class);
            startActivity(intent);
        });
        ToStudentBtn.setOnClickListener(v -> {
            Intent intent= new Intent(IntroScreen.this,LoginPage.class);
            startActivity(intent);
        });



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private String reverse(String s) {
        int n = s.length();
        StringBuilder rev = new StringBuilder();
        for(int i =n-1;i>=0;i--){
            rev.append(s.charAt(i));

        }

        return rev.toString();

    }
}