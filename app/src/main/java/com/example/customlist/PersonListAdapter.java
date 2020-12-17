package com.example.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PersonListAdapter extends ArrayAdapter<Person>
{
    private static final String TAG = "PersonListAdapter";
    private Context mContext ;
    int mResource ;

    public PersonListAdapter(Context context,int resource, ArrayList<Person> objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String repname = getItem(position).getRepname();
        String owname = getItem(position).getOwname();
        Person person = new Person (repname,owname);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate (mResource,parent,false );
        TextView tvName = (TextView) convertView.findViewById(R.id.tv1);
        TextView tvName2 = (TextView) convertView.findViewById(R.id.tv2);
        tvName.setText(repname);
        tvName2.setText(owname);
        return convertView;
    }
    }

