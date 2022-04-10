package com.example.sqliteroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Admin.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AdminDao adminDao();
}
