package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    ListView listview;
//    QDH qdh = new QDH();


    Button surahEng,surahUrdu,engPara,urduPara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        surahEng = findViewById(R.id.engSuraBtn);
        surahUrdu = findViewById(R.id.urduSuraBtn);
        engPara = findViewById(R.id.engParaBtn);
        urduPara = findViewById(R.id.urduParaBtn);

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

        engPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ParahEng.class);
                startActivity(intent);
            }
        });

        urduPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ParahUrdu.class);
                startActivity(intent);
            }
        });






 
    }
}