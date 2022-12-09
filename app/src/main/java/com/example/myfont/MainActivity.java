package com.example.myfont;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView search;
    EditText main;
    RecyclerView Rv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        search = findViewById(R.id.search);
        Rv = findViewById(R.id.Rv);

        Rv.setLayoutManager(new LinearLayoutManager(this));
        FontAdapter fontadapter = new FontAdapter(this,"myfonts");
        Rv.setAdapter(fontadapter);


    }

    @Override
    public void onClick(View view) {
        String s = main.getText().toString();
        FontAdapter fontAdapter = new FontAdapter(this,s);
        Rv.setAdapter(fontAdapter);
    }
}