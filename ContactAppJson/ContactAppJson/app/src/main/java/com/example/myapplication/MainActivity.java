package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.lv_contacts);

        ArrayList<Contact> contacts = getContacts();
        Adapter adapter= new Adapter(contacts,this);
        listView.setAdapter(adapter);

        listView.setOnTouchListener(new SwipeListener(this,listView,contacts));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String phone =  ((TextView) view.findViewById(R.id.Tel)).getText().toString();
                Uri number = Uri.parse("tel:" + phone);

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(number);
                startActivity(intent);

            }
        });
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("contact.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("contacts");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String firstName = jo_inside.getString("firstName");
                String lastName = jo_inside.getString("lastName");
                String email = jo_inside.getString("email");
                String phone = jo_inside.getString("phone");
                String job = jo_inside.getString("job");

                Contact contact = new Contact(firstName, lastName,job,phone ,email);
                contacts.add(contact);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return contacts;
    }

}