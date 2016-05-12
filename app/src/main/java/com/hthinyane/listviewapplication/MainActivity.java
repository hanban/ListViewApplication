package com.hthinyane.listviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        String[] values = getResources().getStringArray(R.array.People);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++)
            list.add(values[i]);

//        ArrayAdapter arrayAdapter =
//                new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        MySimpleArrayAdapter arrayAdapter = new MySimpleArrayAdapter(this, values);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Clicked on ListItem Number " + position,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}


