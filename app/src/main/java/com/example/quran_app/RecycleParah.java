package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecycleParah extends AppCompatActivity {

    String[] paraUrdu,paraEng;
    ListView listView;
    RecyclerView recyclerViewPara;

    QDH qdh = new QDH();
    QuranArabicText qat = new QuranArabicText();
    ArrayList<String> paraData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_parah);

        paraUrdu = qdh.ParahName;
        paraEng = qdh.englishParahName;

        recyclerViewPara = findViewById(R.id.recycleParah);


        RecycleParahAdapter recyclerAdapter = new RecycleParahAdapter(this,paraUrdu,paraEng);
        recyclerViewPara.setAdapter(recyclerAdapter);
        recyclerViewPara.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        listView=findViewById(R.id.quranParah);

        Intent intent = getIntent();
        int start = intent.getIntExtra("start", 0);
        int end = intent.getIntExtra("end", 0);


//      adding surahData to arrayList
        for (int i = start; i < end; i++) {
            paraData.add(qat.QuranArabicText[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.quran_text,paraData);
        listView.setAdapter(arrayAdapter);
    }
}