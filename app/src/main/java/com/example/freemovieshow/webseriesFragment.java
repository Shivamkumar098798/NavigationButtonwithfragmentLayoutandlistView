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
 * Use the {@link webseriesFragment} factory method to
 * create an instance of this fragment.
 */
public class webseriesFragment extends Fragment {
    ListView listView;
    String[] name={"peaky blinders","money heist","mirzapur","panchayat","family man 2","scam 1992",
            "Family man2","mirzapur","money heist","panchayat","peaky blinders","scam 1992"};
    Integer[] image ={R.drawable.peakyblinders,R.drawable.moneyheist,R.drawable.mirzapur,R.drawable.panchayat,R.drawable.familyman2,
            R.drawable.scam1992,R.drawable.peakyblinders,R.drawable.moneyheist,R.drawable.mirzapur,R.drawable.panchayat,R.drawable.familyman2,R.drawable.scam1992};
    String[] released_date = {"1999","1991","1992","1994","2005","2050","1999","1991","1992","1994","2005","2050"};

    String[] rating = {"5/10","10/10","8/10","6/10","5/10","3.5/10","5/10","10/10","8/10","6/10","5/10","3.5/10"};
    //String[] urls = {"https://www.figma.com/@shivam123","https://hdmovies.store/category/web-series/",};

    public webseriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webseries, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getView().findViewById(R.id.listview3);
        myAdapter myAdapter = new myAdapter( (Activity) getContext(),image,name,released_date,rating);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), clickactionview.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("poster", image[i]);
                intent.putExtra("released date", released_date[i]);
                intent.putExtra("rating", rating[i]);
                startActivity(intent);
            }
        });
    }
}