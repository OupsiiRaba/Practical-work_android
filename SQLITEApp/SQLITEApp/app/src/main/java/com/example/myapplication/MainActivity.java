package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView= (ListView) findViewById(R.id.list);
        DBConnection dbConnection= new DBConnection(this);
        ArrayList<String> list= dbConnection.getAllRecord();
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }

    public void Enregistrer (View view){

        TextView nom= findViewById(R.id.name);
        ListView listView= findViewById(R.id.list);

        DBConnection db= new DBConnection(this);
        db.insertAdmin(nom.getText().toString());

        ArrayList<String> arrayList= db.getAllRecord();
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        nom.setText("");
    }

    public void update (View view){
        TextView nom= findViewById(R.id.name);
        EditText id= findViewById(R.id.idinput);
        ListView listView= findViewById(R.id.list);

        DBConnection dbConnection= new DBConnection(this);
        dbConnection.updateRow(nom.getText().toString(),Integer.parseInt(id.getText().toString()));

        ArrayList<String> arrayList= dbConnection.getAllRecord();
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);
        nom.setText("");
        id.setText("");
    }

    public void supprimer (View view){

        TextView id= findViewById(R.id.idinput);
        ListView listView= findViewById(R.id.list);
        DBConnection dbConnection= new DBConnection(this);
        dbConnection.deleterow(Integer.parseInt(id.getText().toString()));

        ArrayList<String> arrayList= dbConnection.getAllRecord();
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        id.setText("");

    }




}