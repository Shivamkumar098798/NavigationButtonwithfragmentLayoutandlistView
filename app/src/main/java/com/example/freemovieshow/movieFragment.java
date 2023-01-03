package com.example.freemovieshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link movieFragment} factory method to
 * create an instance of this fragment.
 */
public class movieFragment extends Fragment {
    ListView listView;
    FloatingActionButton floatingActionButton;
    String[] name={"war","beast","love and thunder","iron movie 2","avanger","spiderman",
            "war","beast","love and thunder","iron movie 2","avanger","spiderman",
            "war","beast","love and thunder","iron movie 2","avanger","spiderman"};
    Integer[] image = {R.drawable.war,R.drawable.beast,R.drawable.thorloveandthunder,R.drawable.ironman2,R.drawable.avangers,R.drawable.spideman,
            R.drawable.war,R.drawable.beast,R.drawable.thorloveandthunder,R.drawable.ironman2,R.drawable.avangers,R.drawable.spideman,
            R.drawable.war,R.drawable.beast,R.drawable.thorloveandthunder,R.drawable.ironman2,R.drawable.avangers,R.drawable.spideman,};

    String[] directors = {"Joe Johnston", "James Gunn", "Anthony Russo", "Jon Watts", "Taika Waititi",
            "Joe Johnston", "James Gunn", "Anthony Russo", "Jon Watts", "Taika Waititi"};

    String[] year = {"2011", "2014", "2018", "2019", "2017","2011", "2014", "2018", "2019", "2017"};
   /* String[] urls = {"https://www.linkedin.com/in/shivam-kumar--/","https://9xflix.autos/m/raw-beast-2022/",
            "https://9xflix.autos/m/thor-love-and-thunder-2022/","https://9xflix.autos/m/iron-man-2-2010-dual-audio-hindi/",
            "https://9xflix.autos/m/avengers-infinity-war-2018-dual-audio-hindi/","https://www.instagram.com/shivam0.231",
            "https://www.linkedin.com/in/shivam-kumar--/",};*/

    public movieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);





    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        floatingActionButton = getView().findViewById(R.id.floatingActionButton);






        listView = getView().findViewById(R.id.listview1);
        myAdapter myAdapter = new myAdapter( (Activity) getContext(),image,name,directors,year);
        listView.setAdapter(myAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), clickactionview.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("poster", image[i]);
                intent.putExtra("creator", directors[i]);
                intent.putExtra("year", year[i]);
                startActivity(intent);
            }
        });
    }
}