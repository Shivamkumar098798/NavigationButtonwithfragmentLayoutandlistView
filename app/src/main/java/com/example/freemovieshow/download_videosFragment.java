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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link download_videosFragment} factory method to
 * create an instance of this fragment.
 */
public class download_videosFragment extends Fragment {
    ListView listView;
    String[] name_of_movies={"war","peaky","money hist"};
    Integer[] image={R.drawable.war,R.drawable.peakyblinders,R.drawable.moneyheist};
    String[] downloaded_date={"2/2022","3/2022","10/2022"};
    String[] watching_time={"1:20:20","2:30:00","1:00:00"};
   // String[] urls={"https://www.linkedin.com/in/shivam-kumar--/","https://www.instagram.com/shivam0.231","https://keepupindia.com/wp-admin"};


    public download_videosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_download_videos, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getView().findViewById(R.id.listview4);
        myAdapter myAdapter = new myAdapter( (Activity) getContext(),image,name_of_movies,downloaded_date,watching_time);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), clickactionview.class);
                intent.putExtra("name", name_of_movies[i]);
                intent.putExtra("poster", image[i]);
                intent.putExtra("date", downloaded_date[i]);
                intent.putExtra("time", watching_time[i]);
                startActivity(intent);
            }
        });
    }
}