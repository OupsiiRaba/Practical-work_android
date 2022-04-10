package com.example.sqliteroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AdminDao {
    @Query("Select * FROM Admin")
    List<Admin> getAllRecord();
    @Insert
    void Insert(Admin admin);
    @Delete
    void Delete(Admin admin);
    @Update
    void update(Admin admin);
}
