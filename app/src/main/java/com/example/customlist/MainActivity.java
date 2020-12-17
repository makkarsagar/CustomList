package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate : Started.");

        ListView mListView = (ListView) findViewById(R.id.listView);
        Person one = new Person ("Repository 1","OwnerO1");
        Person two = new Person ("Repository 2","OwnerO2");
        Person three = new Person ("Repository 3","OwnerO3");
        Person four = new Person ("Repository 4","OwnerO4");
        Person five = new Person ("Repository 5","OwnerO5");
        Person six = new Person ("Repository 6","OwnerO6");
        Person seven = new Person ("Repository 7","OwnerO7");
        Person eight = new Person ("Repository 8","OwnerO8");
        Person nine = new Person ("Repository 9","OwnerO9");

         ArrayList <Person> peopleList = new ArrayList<>()  ;
         peopleList.add(one);
        peopleList.add(two);
        peopleList.add(three);
        peopleList.add(four);
        peopleList.add(five);
        peopleList.add(six);
        peopleList.add(seven);
        peopleList.add(eight);
        peopleList.add(nine);

        PersonListAdapter adapter = new PersonListAdapter(this,R.layout.adapter_view_layout,peopleList);
        mListView.setAdapter(adapter);
    }
}
