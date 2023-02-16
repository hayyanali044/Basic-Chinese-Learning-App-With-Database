package com.example.learnchinesebyowsumdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class LessonsByTutorsActivity extends AppCompatActivity {
    final String[] tutors_and_lessons= {"1) Miss Baozhai                                                        3", "2) Miss Chyou                                                      1", "3) Miss Chun Li                                                       4", "4) Sir Shuchang                                                    2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_by_tutors);
        getSupportActionBar().hide();
        Button back_to_main_btn = findViewById(R.id.back_to_main);
        ListView lessons_by_tutors = findViewById(R.id.lessons_by_tutors);
        ArrayAdapter<String> lessons_by_tutors_adp = new ArrayAdapter<String>(LessonsByTutorsActivity.this, android.R.layout.simple_list_item_1, tutors_and_lessons);
        lessons_by_tutors.setAdapter(lessons_by_tutors_adp);

        back_to_main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LessonsByTutorsActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}