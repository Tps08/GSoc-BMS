package com.tps.gsocbms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyProfile extends AppCompatActivity {

    TextView myProfile_emailID,textView1,textView2,textView3;
    ProgressBar myProfileProgressBar;
    FirebaseAuth mAuth;
    private RecyclerView myPetition_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        textView1= findViewById(R.id.textView1);
        textView2= findViewById(R.id.textView2);
        textView3= findViewById(R.id.textView3);

        textView1.setBackgroundColor(Color.RED);
        textView2.setBackgroundColor(Color.YELLOW);
        textView3.setBackgroundColor(Color.GREEN);

        myProfileProgressBar= findViewById(R.id.my_petition_progressBar);
        myProfileProgressBar.setVisibility(View.VISIBLE);
        mAuth= FirebaseAuth.getInstance();
        myProfile_emailID= findViewById(R.id.myProfile_emailID);
        myProfile_emailID.setText(Objects.requireNonNull(mAuth.getCurrentUser()).getEmail());

        loadMyPetitions();
    }

    public void loadMyPetitions() {
        List<Petition> myPetition = new ArrayList<>();
        myPetition_recyclerView= findViewById(R.id.myPetitions_recyclerView);

        myPetition_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i=1;i<=5;i++){
            String s;
            if(i==1){
                s="administrative";

                Function(s, myPetition);
            }

            else if(i==2){
                s="academic";
                Function(s, myPetition);

            }
            else if (i==3){
                s="non academic";
                Function(s, myPetition);
            } else if(i==4){
                s="hostel related";
                Function(s, myPetition);
            } else {
                s="cleanliness and hygiene";
                Function(s, myPetition);
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(this,FirstScreen.class);
        startActivity(intent);
        //super.onBackPressed();
    }

    public void Function(String s, List<Petition>myPetition){

        DatabaseReference dbusers= FirebaseDatabase.getInstance().getReference("petitions").child(s);
        dbusers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot dsUser: snapshot.getChildren()){
                        Petition petition = dsUser.getValue(Petition.class);
                        assert petition != null;
                        String s =  petition.email;
                        if(s.equalsIgnoreCase(Objects.requireNonNull(mAuth.getCurrentUser()).getEmail()))
                        { myPetition.add(petition);}
                    }
                    myProfileProgressBar.setVisibility(View.GONE);
                    MyProfileAdapter myPetAdapter = new MyProfileAdapter(MyProfile.this,myPetition);
                    myPetition_recyclerView.setAdapter(myPetAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}