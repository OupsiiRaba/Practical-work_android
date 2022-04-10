package com.example.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends BaseAdapter {
    private Context context;
    ArrayList<Contact> eltList = new ArrayList<Contact>();
    //public constructor


    public Adapter(ArrayList<Contact> eltList, Context context) {
        this.context=context;
        this.eltList = eltList;
    }



    @Override
    public int getCount() {

        return  eltList.size() ;
    }

    @Override
    public Object getItem(int i) {
        return eltList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.activity_item_list, viewGroup, false);
        }


        // get the TextView for item name and item description
        TextView textViewItemName = view.findViewById(R.id.Name);
        TextView textViewItemJob = view.findViewById(R.id.Job);
        TextView textViewItemPhone = view.findViewById(R.id.Tel);
        TextView textViewItemEmail = view.findViewById(R.id.Email);

        // get current item to be displayed
        Contact contact= eltList.get(i);


        //sets the text for item name and item description from the current item object
        textViewItemName.setText(contact.getFirstName());
        textViewItemJob.setText(contact.getJob());
        textViewItemEmail.setText(contact.getEmail());
        textViewItemPhone.setText(contact.getPhone());



        // returns the view for the current row
        return view;
    }

    }

