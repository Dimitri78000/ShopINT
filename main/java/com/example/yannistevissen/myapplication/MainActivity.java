package com.example.yannistevissen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import java.util.*;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private AutoCompleteTextView search_bar;
    private ListView list_item;
    String[] Products =
            {
                "Pâtes","Charcuterie","Céréales","Soda","Sandwiches","Riz","Yaourt","Alcool","Jus","Lait","Pizza","Biscuits","Café","Thé","Gel douche","Mouchoirs","Gobelets","Beurre","Sel","Fromage","Shampoing","Feuilles","Stylo"
            };
    ArrayList<String> List = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_bar = (AutoCompleteTextView) findViewById(R.id.search_bar);
        button = (Button) findViewById(R.id.button);
        list_item = (ListView) findViewById(R.id.list_item) ;
        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,Products);
        final ArrayAdapter<String> adapterList = new ArrayAdapter(this,android.R.layout.simple_list_item_1,List);
        search_bar = (AutoCompleteTextView)findViewById(R.id.search_bar);
        search_bar.setThreshold(0);
        search_bar.setAdapter(adapter);
        if (search_bar.getText().toString()!="") {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // The user just clicked
                    List.add(search_bar.getText().toString());
                    list_item.setAdapter(adapterList);
                    search_bar.setText("");
                }
            });
        }
        }
    }



