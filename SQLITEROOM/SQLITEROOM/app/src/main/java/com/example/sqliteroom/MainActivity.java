package com.example.sqliteroom;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AdminDao adminDao;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView ls = (ListView) findViewById(R.id.liste);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "Personnes3.db").allowMainThreadQueries().build();
        adminDao = db.adminDao();
        List<Admin> liste = adminDao.getAllRecord();
        ArrayAdapter Adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,Listin(liste));
        ls.setAdapter(Adapter);
    }

    public void Enregistrer(View view) {
        List<Admin> liste;
        EditText chID = findViewById(R.id.editExtId);
        TextView nom = findViewById(R.id.editxtname);
        ListView ls = (ListView) findViewById(R.id.liste);
        liste = adminDao.getAllRecord();
        adminDao.Insert(new Admin(Integer.parseInt(chID.getText().toString()),nom.getText().toString()));
        liste = adminDao.getAllRecord();
        ArrayAdapter myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Listin(liste));
        ls.setAdapter(myAdapter);
        nom.setText("");
    }
    public void Update(View view) {
        List<Admin> liste;
        TextView chNom = findViewById(R.id.editxtname);
        EditText chID = findViewById(R.id.editExtId);
        ListView ls = (ListView) findViewById(R.id.liste);
        liste = adminDao.getAllRecord();
        Admin a = liste.get(Integer.parseInt(chID.getText().toString())-1);
        a.setName(chNom.getText().toString());
        adminDao.update(a);
        liste = adminDao.getAllRecord();
        ArrayAdapter myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Listin(liste));
        ls.setAdapter(myAdapter);
        chNom.setText(""); chID.setText("");
    }
    public void Supprimer(View view) {
        List<Admin> liste;
        TextView chId = findViewById(R.id.editExtId);
        ListView ls = (ListView) findViewById(R.id.liste);
        liste = adminDao.getAllRecord();
        adminDao.Delete(liste.get(Integer.parseInt(chId.getText().toString())-1));
        liste = adminDao.getAllRecord();
        ArrayAdapter myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Listin(liste));
        ls.setAdapter(myAdapter);
        chId.setText("");
    }
    ArrayList Listin(List<Admin> l){
        ArrayList<String> maliste = new ArrayList<>();
        for(int i=0;i<l.size();i++){
            maliste.add(l.get(i).getId()+": " +  l.get(i).getName());
        }
        return maliste;
    }



}
