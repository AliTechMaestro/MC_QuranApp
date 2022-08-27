package com.example.quran_app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Parah extends AppCompatActivity  {

    QuranArabicText qat=new QuranArabicText();
    ListView listView;
    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parah);

        listView=findViewById(R.id.parahView);

        Intent intent = getIntent();
        int start = intent.getIntExtra("start", 0);
        int end = intent.getIntExtra("end", 0);

        for (int i = start; i < end; i++) {
            data.add(qat.QuranArabicText[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.quran_text,data);
        listView.setAdapter(arrayAdapter);

    }

}