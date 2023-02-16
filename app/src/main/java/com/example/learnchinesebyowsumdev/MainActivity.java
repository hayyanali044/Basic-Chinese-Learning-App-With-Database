package com.example.learnchinesebyowsumdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    final String lessons[] = {"Lesson 1: Alphabets", "Lesson 2: Numbers", "Lesson 3: Everyday Items", "Lesson 4: Sentence Structures", "Lessons by Tutors", "Tutors List", "Progress"};
    ListView lessons_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //------------------BROADCAST RECIEVERS------------------
        registerReceiver(new BatteryReciever(),new IntentFilter()); //BATTERY LOW
        registerReceiver(new BatteryRecieverCharging(),new IntentFilter()); //CHARGER CONNECTED
        registerReceiver(new ChargerDisconnected(),new IntentFilter()); //CHARGER DISCONNECTED

        //ADAPTER LIST FOR FIRST ACTIVITY
        lessons_list = findViewById(R.id.lessons_list);
        ArrayAdapter<String> lessons_list_adp = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, lessons);
        lessons_list.setAdapter(lessons_list_adp);
        lessons_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(MainActivity.this, Lesson1_Activity.class));
                    finish();
                }
                if(i==1){
                    startActivity(new Intent(MainActivity.this, Lesson2_Activity.class));
                    finish();
                }
                if(i==2){
                    startActivity(new Intent(MainActivity.this,Lesson3_Activity.class));
                    finish();
                }
                if(i==3){
                    startActivity(new Intent(MainActivity.this,Lesson4_Activity.class));
                    finish();
                }
                if(i==4){
                    startActivity(new Intent(MainActivity.this, LessonsByTutorsActivity.class));
                    finish();
                }
                if (i==5){
                    startActivity(new Intent(MainActivity.this, TutorsListActivity.class));
                    finish();
                }
                if (i==6){
                    startActivity(new Intent(MainActivity.this, ProgressActivity.class));
                    finish();
                }
            }
        });
    }
}