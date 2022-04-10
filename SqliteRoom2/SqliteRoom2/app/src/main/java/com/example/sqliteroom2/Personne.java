package com.example.sqliteroom2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="PERSONNE")
public class Personne {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name ="name")
    private String name;

    public Personne() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
