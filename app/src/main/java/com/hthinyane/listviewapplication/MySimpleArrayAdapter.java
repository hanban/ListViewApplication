package com.hthinyane.listviewapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by H.Thinyane on 2016-05-11.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<String> {


    private final Context context;
    private final String [] values;
    private String [] filenames;

    public MySimpleArrayAdapter (Context context, String [] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;

        this.filenames = new String [values.length];
        for (int i =0; i < filenames.length; i++) {
            filenames[i] = values[i].toLowerCase();
//            Log.d("HTHINYANE", filenames[i]);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.rowLabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.rowImage);
        textView.setText(values[position]);

        // get the resource ID from the context for the particular filename
        int resID = context.getResources().getIdentifier(filenames[position], "drawable", context.getPackageName());
        imageView.setImageResource(resID);

        return rowView;

    }
}
