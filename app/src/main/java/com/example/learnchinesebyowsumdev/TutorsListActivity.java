package com.example.learnchinesebyowsumdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class TutorsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors_list);
        getSupportActionBar().hide();
        Button go_back_to_main = findViewById(R.id.go_back_to_main);

        go_back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TutorsListActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}