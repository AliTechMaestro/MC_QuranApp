package com.example.quran_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);


        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_SurahUrdu:
                        Toast.makeText(getApplicationContext(),"Surah (Urdu) is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(MainActivity.this,SurahInUrdu.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_SurahEng:
                        Toast.makeText(getApplicationContext(),"Surah (Eng) is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(MainActivity.this,SurahInEnglish.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_ParaUrdu:
                        Toast.makeText(getApplicationContext(),"Parah (Urdu) is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(MainActivity.this,ParahUrdu.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_ParaEng:
                        Toast.makeText(getApplicationContext(),"Parah (Eng) is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent4 = new Intent(MainActivity.this,ParahEng.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });
   }
}