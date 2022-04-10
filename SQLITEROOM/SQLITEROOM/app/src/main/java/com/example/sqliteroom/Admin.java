package com.example.sqliteroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Admin {
    @PrimaryKey
    public int Id;
    @ColumnInfo(name = "name")
    public String name;

    public Admin() {
    }

    public Admin(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
