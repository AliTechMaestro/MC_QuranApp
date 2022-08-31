package com.example.quran_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search extends AppCompatActivity {
    Button urduTrans,engTrans,searchBtn;
    ListView listViewAyat,listViewTrans,engListView;
    EditText searchValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBtn = findViewById(R.id.btnSearch);
        searchValue = findViewById(R.id.searchVal);
        listViewAyat = findViewById(R.id.ayatListView);
        listViewTrans = findViewById(R.id.TransListView);
        engListView = findViewById(R.id.TransEngListView);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHelper = new DBHelper(Search.this);
                Integer text=Integer.parseInt(searchValue.getText().toString());
                List<String> ayat = dbHelper.search(text);
                List<String> verseTranslation = dbHelper.getUrduTranslation(text);
                List<String> engTrans = dbHelper.getEngTranslation(text);
                ArrayAdapter verse = new ArrayAdapter<String>(Search.this, R.layout.quran_text,ayat);
                ArrayAdapter translation = new ArrayAdapter<String>(Search.this,R.layout.list_item_text,verseTranslation);
                ArrayAdapter engTranslation = new ArrayAdapter<String>(Search.this,R.layout.list_item_text,engTrans);
                listViewAyat.setAdapter(verse);
                listViewTrans.setAdapter(translation);
                engListView.setAdapter(engTranslation);
            }
        });
    }
}