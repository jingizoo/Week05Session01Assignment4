package com.jalaj.firstapp.listviewwithalertdialog.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jalaj.firstapp.listviewwithalertdialog.Contact;
import com.jalaj.firstapp.listviewwithalertdialog.R;

import java.util.ArrayList;

/**
 * Created by jalajmehta on 7/23/16.
 */

public class ContactAdapter extends BaseAdapter {
    ArrayList <Contact> arrayList;
    LayoutInflater layoutInflater;

    public ContactAdapter(ArrayList arrayList, Context ctx) {
        this.arrayList  = arrayList;
        layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.layout_relative_list,parent,false);

        Contact contact = (Contact) getItem(position);
        TextView w5TxtName = (TextView) convertView.findViewById(R.id.w5TxtName);
        TextView w5TxtAge =  (TextView) convertView.findViewById(R.id.w5TxtAge);
        TextView w5TxtDoB =  (TextView) convertView.findViewById(R.id.w5TxtDoB);

        w5TxtAge.setText(contact.getAge()+"");
        w5TxtName.setText(contact.getName());
        w5TxtDoB.setText(contact.getDateOfBirth().toString());

        return convertView;
    }
}
