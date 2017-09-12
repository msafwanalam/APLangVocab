package com.example.safwan.aplangvocabbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        registerClickCallback();
    }
    public void populateListView(){
        String [] myItems = {"Vocab Sheet 1", "Vocab Sheet 2", "Vocab Sheet 3", "Vocab Sheet 4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.da_item, myItems);

        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);
    }

    private void registerClickCallback(){
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id){
                TextView textView = (TextView) viewClicked;
                String message = "You clicked # " + position + ", which is string: " + textView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
