package com.avenueinfotech.recycleradapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> mAdapter;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<String> mNames = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            mNames.add(getRandomName());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNames.add(getRandomName());
                mAdapter.notifyDataSetChanged();
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mNames);
        listView.setAdapter(mAdapter);
    }

    private String getRandomName() {
        String [] names = new String []{
                "hamnna","Rohan","saharah","Axis",
                "Kate","Winselt","Julia","Akbat",
                "Birba","Adbsjdd","nasjk","wancmik"
        };
        return names[random.nextInt(names.length)];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
