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
        Person one = new Person ("grit","mojombo");
        Person two = new Person ("merb-core","wycats");
        Person three = new Person ("rubinius","rubinius");
        Person four = new Person ("god","mojombo");
        Person five = new Person ("jsawesome","vanpelt");
        Person six = new Person ("jspec","wycats");
        Person seven = new Person ("exception_logger","defunkt");
        Person eight = new Person ("ambition","defunkt");
        Person nine = new Person ("restful-authentication","technoweenic");
        
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
