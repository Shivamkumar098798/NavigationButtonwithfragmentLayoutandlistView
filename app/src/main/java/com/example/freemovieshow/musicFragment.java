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
 * Use the {@link musicFragment} factory method to
 * create an instance of this fragment.
 */
public class musicFragment extends Fragment {
    ListView listView;
    String[] name= {"Spotify","Wynk Music","Resso music","Gaana","Amazon Music","Hungama","Youtube Music","JioSaavn",
            "Spotify","Wynk Music","Resso music","Gaana","Amazon Music","Hungama","Youtube Music","JioSaavn",};
    Integer[] image= {R.drawable.spotify,R.drawable.wynkmusic,R.drawable.resso,R.drawable.gaana,R.drawable.amazon_music,
            R.drawable.hungama,R.drawable.youtube,R.drawable.jiosaavn,R.drawable.spotify,R.drawable.wynkmusic,R.drawable.resso,R.drawable.gaana,R.drawable.amazon_music,
            R.drawable.hungama,R.drawable.youtube,R.drawable.jiosaavn,};
    String[] artists = {"The Weeknd","The Weeknd", "One Direction", "Eminem", "Eminem",
            "The Weeknd","The Weeknd", "One Direction", "Eminem", "Eminem"};

    String[] year = {"2020", "2022", "2014", "2010", "2002","2020", "2022", "2014", "2010", "2002" };
   // String[] urls = {"https://open.spotify.com/","https://www.wynk.in/music","https://www.linkedin.com/in/shivam-kumar--/",
         //   "https://open.gaana.com/","https://music.amazon.in/","https://www.hungama.com/","https://music.youtube.com/",};


    public musicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getView().findViewById(R.id.listview2);
        myAdapter myAdapter = new myAdapter( (Activity) getContext(),image,name,year,artists);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), clickactionview.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("poster", image[i]);
                intent.putExtra("creator", artists[i]);
                intent.putExtra("year", year[i]);
                startActivity(intent);
            }
        });
    }
}