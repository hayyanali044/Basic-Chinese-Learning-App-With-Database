package com.example.learnchinesebyowsumdev;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ProgressDBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "ProgressDatabase";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Progress";
    private static final String NAME_COL = "Name";
    private static final String AGE_COL = "Age";
    private static final String GENDER_COL = "Gender";
    private static final String LEARNER_LEVEL_COL = "Learner Level";
    private static final String LESSONS_COMPLETED_COL = "Lessons Completed";

    public ProgressDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = new StringBuilder().append("CREATE TABLE ").append(TABLE_NAME).append(" (").append(NAME_COL).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ").append(AGE_COL).append(" TEXT,").append(GENDER_COL).append(" TEXT,").append(LEARNER_LEVEL_COL).append(" TEXT,").append(LESSONS_COMPLETED_COL).append(" TEXT)").toString();
        db.execSQL(query);
    }

    public void addNewProgress(String name, String age, String gender, String learner_level, String lessons_completed){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(AGE_COL, age);
        values.put(GENDER_COL, gender);
        values.put(LEARNER_LEVEL_COL, learner_level);
        values.put(LESSONS_COMPLETED_COL, lessons_completed);

        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
