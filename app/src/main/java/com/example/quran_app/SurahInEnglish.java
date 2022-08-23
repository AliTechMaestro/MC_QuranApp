package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SurahInEnglish extends AppCompatActivity {

    ListView listview;


    QDH qdh = new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_in_english);

        String[] surahNames = qdh.englishSurahNames;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,surahNames);
        listview = findViewById(R.id.engListView);
        listview.setAdapter(arrayAdapter);

    }
}