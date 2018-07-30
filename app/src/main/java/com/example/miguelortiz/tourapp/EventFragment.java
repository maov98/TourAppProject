package com.example.miguelortiz.tourapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class EventFragment extends Fragment {

    public EventFragment() {
    }

    ArrayList<Events> eventlArray;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event, container, false);
        eventlArray = new ArrayList<Events>();
        EventsArrayAdapter eventAdapter = new EventsArrayAdapter(getContext(),eventlArray);



        eventlArray.add(new Events(getString(R.string.event1),R.drawable.event1,getString(R.string.eventDes1)));
        eventlArray.add(new Events(getString(R.string.event2),R.drawable.event2,getString(R.string.eventDes2)));
        eventlArray.add(new Events(getString(R.string.event3),R.drawable.event3,getString(R.string.eventDes3)));
        eventlArray.add(new Events(getString(R.string.event4),R.drawable.event4,getString(R.string.eventDes4)));


        ListView listView =  view.findViewById(R.id.eventListView);
        listView.setAdapter(eventAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DetailFragment detailFragment = new DetailFragment();
                String placeDescription = eventlArray.get(position).getDescription();
                String placeTitle = eventlArray.get(position).getTitle();
                Integer drawable = eventlArray.get(position).getImageId();
                Bundle bundle = new Bundle();
                bundle.putString(getString(R.string.bundle1),placeTitle);
                bundle.putInt(getString(R.string.bundle2),drawable);
                bundle.putString(getString(R.string.bundle3),placeDescription);
                detailFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.detailedLayout,detailFragment).commit();
            }
        });

        return view;

    }

}
