package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import  com.example.quran_app.QDH;

public class MainActivity extends AppCompatActivity {

//    ListView listview;
//    QDH qdh = new QDH();


    Button surahEng,surahUrdu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        surahEng = findViewById(R.id.englishSurah);
        surahUrdu = findViewById(R.id.urduSurah);

        surahEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this,SurahInEnglish.class);
                startActivity(intent);
            }
        });
        surahUrdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this,SurahInUrdu.class);
                startActivity(intent);
            }
        });

 
    }
}