package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SplitPay extends AppCompatActivity {


    private ArrayList<String> itemList;
    private ArrayAdapter adapter;
    private EditText itemText;
    private Button addButton;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_pay);

        lv = (ListView)findViewById(R.id.listview);
        addButton = (Button) findViewById(R.id.add);
        itemText = (EditText) findViewById(R.id.Ids);
        itemList = new ArrayList<String>();
        adapter = new ArrayAdapter(SplitPay.this,android.R.layout.simple_list_item_1,itemList);
        lv.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();
            }
        });

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "You clicked on item name: " + adapter.getItem(position),Toast.LENGTH_LONG).show();
//            }
//        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               final int which_item = position;
               new AlertDialog.Builder(SplitPay.this)
                       .setIcon(android.R.drawable.ic_delete)
                       .setTitle(" Are you sure ?")
                       .setMessage(" Do you want to delete this person")
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               itemList.remove(which_item);
                               adapter.notifyDataSetChanged();
                           }
                       })
                       .setNegativeButton("No",null)
                       .show();
                return false;
            }
        });
    }
}
