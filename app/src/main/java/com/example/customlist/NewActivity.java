package com.example.customlist;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Contacts;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class NewActivity extends AppCompatActivity {

    private ListView lv;

    String url;

    private static String JSON_URL = "https://api.github.com/repositories";
    ArrayList<HashMap<String, String>> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        List = new ArrayList<>();
        lv = findViewById(R.id.listView);

        NewActivity.GetData getdata = new NewActivity.GetData();
        getdata.execute();


    }

    public class GetData extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... strings) {
            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);

                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("PeopleList");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    url = jsonObject1.getString("url");


                    HashMap<String, String> PeopleList = new HashMap<>();

                    PeopleList.put("url", url);


                    List.add(PeopleList);


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            ListAdapter adapter = new SimpleAdapter(
                    NewActivity.this,
                    List,
                    R.layout.activity_new,
                    new String[]{"url"},
                    new int[]{R.id.textView});

            lv.setAdapter(adapter);
        }
    }
}