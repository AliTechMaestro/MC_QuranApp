package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    EditText editText;
    Button searchBtn;
    TextView result;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.searchVal);
        searchBtn = findViewById(R.id.searchBtn);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(Search.this);
                String list = dbHelper.getQuranData(editText.getText().toString());
                ArrayAdapter arrayAdapter = new ArrayAdapter<QuranModel>
                        (Search.this,R.layout.quran_text, Integer.parseInt(list));
                listView = findViewById(R.id.searchListView);
                listView.setAdapter(arrayAdapter);

            }
        });

    }
}