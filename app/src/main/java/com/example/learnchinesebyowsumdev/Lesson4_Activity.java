package com.example.learnchinesebyowsumdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lesson4_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);
        getSupportActionBar().hide();
        Button back = findViewById(R.id.back);
        Button done = findViewById(R.id.done);
        Button next = findViewById(R.id.next);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lesson4_Activity.this, Lesson3_Activity.class));
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Congratulations! You have completed all lessons of Chinese Language!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Lesson4_Activity.this, MainActivity.class));
                finish();
            }
        });
    }
}