package com.example.freemovieshow;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;


public class clickactionview extends AppCompatActivity {


    ImageView dposter;
    TextView dname, dcreator, relyear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickactionview);

        dposter = findViewById(R.id.dposter);
        dname = findViewById(R.id.name);
        dcreator = findViewById(R.id.dcreator);
        relyear = findViewById(R.id.year);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer image = intent.getIntExtra("poster", R.drawable.avangers);
        String director = intent.getStringExtra("creator");
        String year = intent.getStringExtra("year");

        dposter.setImageResource(image);
        dname.setText(name);
        dcreator.setText(director);
        relyear.setText(year);

    }
}