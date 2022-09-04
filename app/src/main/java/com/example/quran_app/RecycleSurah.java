package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecycleSurah extends AppCompatActivity {

    String[] surahUrdu,surahEng;
    ListView listView;
    RecyclerView recyclerViewSurah;

    QDH qdh = new QDH();
    QuranArabicText qat = new QuranArabicText();
    ArrayList<String> surahData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle_surah);

        surahUrdu = qdh.urduSurahNames;
        surahEng = qdh.englishSurahNames;

        recyclerViewSurah = findViewById(R.id.recycleSurah);

        RecycleSurahAdapter recyclerAdapter = new RecycleSurahAdapter(this,surahUrdu,surahEng);
        recyclerViewSurah.setAdapter(recyclerAdapter);
        recyclerViewSurah.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        listView=findViewById(R.id.quranSurah);

        Intent intent = getIntent();
        int start = intent.getIntExtra("start", 0);
        int end = intent.getIntExtra("end", 0);


//      adding surahData to arrayList
        for (int i = start; i < end-1; i++) {
            surahData.add(qat.QuranArabicText[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.quran_text, surahData);
        listView.setAdapter(arrayAdapter);
    }
}