package com.example.learnchinesebyowsumdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {
    private ProgressDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        getSupportActionBar().hide();
        Button to_mainactivity = findViewById(R.id.to_mainactivity);
        Button return_to_main = findViewById(R.id.return_to_main);
        EditText name = findViewById(R.id.enter_name);
        EditText age = findViewById(R.id.enter_age);
        Spinner gender = findViewById(R.id.enter_gender);
        Spinner learner_level = findViewById(R.id.enter_learner_level);
        Spinner lessons_completed = findViewById(R.id.enter_lessons_completed);

        dbHandler = new ProgressDBHandler(ProgressActivity.this);

        to_mainactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = name.getText().toString();
                String _age = age.getText().toString();
                String _gender = gender.getItemAtPosition(0).toString();
                String _learner_level = learner_level.getItemAtPosition(0).toString();
                String _lessons_completed = lessons_completed.getItemAtPosition(0).toString();

                if(_name.isEmpty() || _age.isEmpty() || _gender.isEmpty() || _learner_level.isEmpty() || _lessons_completed.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill all entities!", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewProgress(_name, _age, _gender, _learner_level, _lessons_completed);
                Toast.makeText(getApplicationContext(),"Information Submitted",Toast.LENGTH_SHORT).show();
                name.setText("");
                age.setText("");
                gender.setTop(0);
                learner_level.setTop(0);
                lessons_completed.setTop(0);

                startActivity(new Intent(ProgressActivity.this, MainActivity.class));
            }
        });

        return_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProgressActivity.this, MainActivity.class));
            }
        });

    }
}