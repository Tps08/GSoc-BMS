package com.tps.gsocbms;

import static java.util.Collections.reverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpPage extends AppCompatActivity {

    EditText editTextemail,editTextpassword,editTextName,editTextAdmissionNo;
    ProgressBar progressbar;
    private FirebaseAuth mAuth;
    TextView backtologin;
    Button SignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        editTextemail = (EditText) findViewById(R.id.emailAddress);
        editTextpassword= (EditText) findViewById(R.id.password);
        editTextName= (EditText) findViewById(R.id.name);
        editTextAdmissionNo= (EditText) findViewById(R.id.admissionno);
        progressbar= (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        backtologin= (TextView) findViewById(R.id.backtologin);
        SignUpButton= (Button) findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }

        });
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, LoginPage.class);
                startActivity(intent);
            }
                });

    }


    public void registerUser() {
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String admission = editTextAdmissionNo.getText().toString().trim();

        String email_2 = reverse(email);

        if (email_2.length() == 0) {
            editTextemail.setError("Please enter a valid Email Address");
            editTextemail.requestFocus();
            return;
        } else {
            if (email_2.substring(0, 9).equalsIgnoreCase("ni.tismb@")) {
                if (email.isEmpty()) {
                    editTextemail.setError("Please enter your email address");
                    editTextemail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextemail.setError("Please enter a valid email");
                    editTextemail.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    editTextpassword.setError("Please enter your password");
                    editTextpassword.requestFocus();
                    return;
                }
                if (name.isEmpty()) {
                    editTextName.setError("Please enter your name");
                    editTextName.requestFocus();
                    return;
                }
                if (admission.isEmpty()) {
                    editTextAdmissionNo.setError("Please enter your Admission No");
                    editTextAdmissionNo.requestFocus();
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressbar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpPage.this, FirstScreen.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "Email is already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "An unexpected error occurred.Please try again or check your internet connection", Toast.LENGTH_SHORT).show();
                                progressbar.setVisibility(View.GONE);
                            }
                        }
                    }
                });
                    } else {
                        editTextemail.setError("Please login with your college email credentials.");
                        editTextemail.requestFocus();
            }
        }
            }


            @Override
            public void onBackPressed () {
                Intent intent = new Intent(this, LoginPage.class);
                startActivity(intent);
                //super.onBackPressed();
            }

            public String reverse(String s){
                int n = s.length();
                String rev = "";
                for (int i = n - 1; i >= 0; i--) {
                    rev =rev+(s.charAt(i));

                }

                return rev;
            }


        }

