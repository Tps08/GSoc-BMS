package com.tps.gsocbms;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class FirstScreen extends AppCompatActivity {

    NavigationView NavView;
    ActionBarDrawerToggle Toggle;
    DrawerLayout drawerLayout;
    // --Commented out by Inspection (1/24/2023 9:06 PM):Toolbar toolbar;
    FirebaseAuth mAuth;
    TextView ToPetitionPage;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavView= findViewById(R.id.navmenu);
        drawerLayout= findViewById(R.id.drawer);

        ToPetitionPage = findViewById(R.id.ToCategory);
        ToPetitionPage.setOnClickListener(v -> {
            Intent intent= new Intent(FirstScreen.this,WritePetition.class);
            startActivity(intent);
        });

        Toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(Toggle);
        Toggle.syncState();

        NavView.setNavigationItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.menu_profile :
                    Intent intent = new Intent(FirstScreen.this,MyProfile.class);
                    startActivity(intent);
                    finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.menu_emerg :
                    Intent intent1 = new Intent(FirstScreen.this, FeelingUnsafe.class);
                    startActivity(intent1);
                    finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.menu_logout :

                    mAuth= FirebaseAuth.getInstance();
                    mAuth.signOut();
                    Intent intent2 = new Intent(FirstScreen.this,IntroScreen.class);
                    startActivity(intent2);
                    finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.menu_alerts:

                    Intent intent3 = new Intent(FirstScreen.this,SecurityUpdates_admin.class);
                    startActivity(intent3);
                    finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }


            return true;
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