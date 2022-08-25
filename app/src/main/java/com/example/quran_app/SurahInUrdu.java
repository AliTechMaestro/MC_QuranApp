package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quran_app.QDH;

public class SurahInUrdu extends AppCompatActivity{
    ListView listView;

    QDH qdh=new QDH();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_in_urdu);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,qdh.urduSurahNames);
        listView = findViewById(R.id.urduListView);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int start = qdh.SSP[i];
                int end = qdh.SSP[i+1];
                QuranArabicText qat = new QuranArabicText();
                if (start == 6342) {
                    end = qat.QuranArabicText.length - 1;
                }
                Intent intent = new Intent(SurahInUrdu.this, Surah.class);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                startActivity(intent);
            }
        });
    }
}