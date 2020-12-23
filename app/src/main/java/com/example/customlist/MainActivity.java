package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Contacts;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    String repname , owname;

    private static String JSON_URL ="https://api.github.com/repositories";
    ArrayList<HashMap<String,String>>List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List = new ArrayList<>();
        lv = findViewById(R.id.listView);

        GetData getdata = new GetData();
        getdata.execute();


    }

    public class GetData extends AsyncTask<String, String, String>
    {


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
                }
                finally {
                   if (urlConnection != null) {
                      urlConnection.disconnect();
                }
            }
        }
        catch (Exception e){
                e.printStackTrace();
        }
            return current;
                }

        @Override
        protected void onPostExecute(String s){
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("PeopleList");

                for(int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    repname = jsonObject1.getString("name");
                    owname = jsonObject1.getString("full_name");

                    HashMap<String,String> PeopleList = new HashMap<>();

                    PeopleList.put("name", repname);
                    PeopleList.put("full_name", owname);

                    List.add(PeopleList);



                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this,
                    List,
                    R.layout.adapter_view_layout,
                    new String[] {"name", "full_name"},
                    new int[]{R.id.tv1,R.id.tv2});

                    lv.setAdapter(adapter);


        }
            }



}
