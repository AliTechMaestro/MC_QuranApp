package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item_text,surahNames);
        listview = findViewById(R.id.engListView);
        listview.setAdapter(arrayAdapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int start = qdh.SSP[i];
                int end;
                QuranArabicText qat = new QuranArabicText();
                if(start==6342){
                    end = qat.QuranArabicText.length+1;
                }
                else{
                    end = qdh.SSP[i+1];
                }
                Intent intent = new Intent(SurahInEnglish.this, Surah.class);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                startActivity(intent);
            }
        });

    }
}