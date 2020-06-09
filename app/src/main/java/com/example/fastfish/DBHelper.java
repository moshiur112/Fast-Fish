package com.example.fastfish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Fastfish";
    public static final String TABLE_NAME = "FastfishTable";
    public static final String username = "username";
    public static final String password = "password";
    public static final String highscore = "highscore";


    public DBHelper(Context context) {
        super(context, DB_NAME, null   , 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table FastfishTable " +
                        "(username text primary key, password text, highscore text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Fastfish");
        onCreate(sqLiteDatabase);
    }


    public boolean insertData (String username, String password,  String highscore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("highscore", highscore);
        long result = db.insert("FastfishTable", null, contentValues);
        if(result == -1) {
            return false;
        }

        return true;
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from FastfishTable", null );

        return res;
    }
    public boolean signIn(String un, String pw) {
       Cursor res = getData();
       while (res.moveToNext()) {
           if(res.getString(0).equals(un)) {
               if(res.getString(1).equals(pw)) {
                   setData(un, pw, Integer.parseInt(res.getString(1)));
                   return true;
               }
                    }

       }
                return false;
    }
    public void setData(String un, String pw, int score) {
        User.setUsername(un);
        User.setPassword(pw);
        User.setHighScore(score);
    }

    public boolean updateData(String iusername,String ipassword,String ihighscore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(username,iusername);
        contentValues.put(password,ipassword);
        contentValues.put(highscore,ihighscore);

        db.update(TABLE_NAME, contentValues, "username = ?",new String[] { iusername });
        return true;
    }




}
