package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SplitPay extends AppCompatActivity {

    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addButton;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_pay);

        lv = (ListView)findViewById(R.id.listview);
        addButton = (Button) findViewById(R.id.add);
        itemText = (EditText) findViewById(R.id.Ids);
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(SplitPay.this,android.R.layout.simple_list_item_multiple_choice,itemList);
        View.OnClickListener addListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();
            }
        };
        addButton.setOnClickListener(addListener);
        lv.setAdapter(adapter);
    }
}
