package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnection extends SQLiteOpenHelper {
    public DBConnection(Context context){
        super(context,"Personnes.db",null,1);

    }

    public void insertAdmin(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name",name);
        db.insert("Admin",null,contentValues);
    }
    public void deleterow(Integer id){
        SQLiteDatabase db= this.getWritableDatabase();
        String[] condition= new String[]{String.valueOf(id)};
        db.delete("Admin","ID=?",condition);
    }

    public void updateRow(String name, Integer id){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("update Admin set Name='"+name+"'where ID="+String.valueOf(id));
    }
    @SuppressLint("Range")
    public ArrayList getAllRecord(){
        ArrayList list= new ArrayList();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * FROM Admin",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            list.add(cursor.getString(cursor.getColumnIndex("ID"))+ ":" + cursor.getString(cursor.getColumnIndex("Name")));
            cursor.moveToNext();

        }
        return list;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Admin (ID INTEGER PRIMARY KEY, Name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Admin");
        onCreate(sqLiteDatabase);

    }
}
