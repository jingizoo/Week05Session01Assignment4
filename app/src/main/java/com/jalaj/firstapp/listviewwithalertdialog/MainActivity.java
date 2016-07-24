package com.jalaj.firstapp.listviewwithalertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.jalaj.firstapp.listviewwithalertdialog.adapter.ContactAdapter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AlertDialog aD;
    EditText w5EdTxtName, w5EdTtAge,w5EdTxtDoB;
    ListView w5ListView;
    ArrayList <Contact> arrayList;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        arrayList = new ArrayList<Contact>();

      /*  try {
            arrayList.add(new Contact("Jalaj",new SimpleDateFormat("MMM/dd/yyyy").parse("DEC/24/1984"),32));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
         contactAdapter = new ContactAdapter(arrayList,this);
        w5ListView = (ListView)findViewById(R.id.w5ListView);
        w5ListView.setAdapter(contactAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        AlertDialog.Builder aDB = new AlertDialog.Builder(this);
        aDB.setMessage("Please Enter the Details:");
        aDB.setTitle("Data Entry App");
        View alertDialogView = LayoutInflater.from(this).inflate(R.layout.layout_relative_alertdialog,null);
        w5EdTtAge = (EditText)alertDialogView.findViewById(R.id.w5EdTxtAge);
        w5EdTxtName = (EditText)alertDialogView.findViewById(R.id.w5EdTxtName);
        w5EdTxtDoB = (EditText)alertDialogView.findViewById(R.id.w5EdTxtDoB);
        aDB.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                java.util.Date date= null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                try {
                   // date = dateFormat.parse(w5EdTxtDoB.getText().toString());
                    date = dateFormat.parse("12/12/1977");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                arrayList.add(new Contact(w5EdTxtName.getText().toString(),date,Integer.parseInt(w5EdTtAge.getText().toString())));
                contactAdapter.notifyDataSetChanged();
            }
        });
        aDB.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        });
               aD =  aDB.create();

        aD.setView(alertDialogView);
        aD.show();

        return super.onOptionsItemSelected(item);
    }
}
