package com.example.freemovieshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class myAdapter extends ArrayAdapter<Integer>{

    Integer[] image;
    String[] name;
    String[] urls;
    Activity context;

    public myAdapter(Activity context, Integer[] image, String[] name,String[] years, String[] dcreator) {
        super(context, R.layout.custom_layout,image);
        this.image = image;
        this.name = name;
        //this.urls = urls;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

       /* Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
        context.startActivity(intent);*/

        View rowView = inflater.inflate(R.layout.custom_layout,null,true);

        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView textView= rowView.findViewById(R.id.textView2);

        imageView.setImageResource(image[position]);
        textView.setText(name[position]);
        return rowView;
    }

}
