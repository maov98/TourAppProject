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


public class HotelsFragment extends Fragment {

    public HotelsFragment() {
    }

    ArrayList<Hotels> HotelArray;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotels, container, false);
        HotelArray = new ArrayList<Hotels>();
        HotelsArrayAdapter hotelAdapter = new HotelsArrayAdapter(getContext(),HotelArray);

        HotelArray.add(new Hotels(getString(R.string.hotel1),R.drawable.hotel1,getString(R.string.hotelDes1)));
        HotelArray.add(new Hotels(getString(R.string.hotel2),R.drawable.hotel2,getString(R.string.hotelDes2)));
        HotelArray.add(new Hotels(getString(R.string.hotel3),R.drawable.hotel3,getString(R.string.hotelDes3)));
        HotelArray.add(new Hotels(getString(R.string.hotel4),R.drawable.hotel4,getString(R.string.hotelDes4)));


        ListView listView =  view.findViewById(R.id.hotelListView);
        listView.setAdapter(hotelAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DetailFragment detailFragment = new DetailFragment();
                String placeDescription = HotelArray.get(position).getDescription();
                String placeTitle = HotelArray.get(position).getTitle();
                Integer drawable = HotelArray.get(position).getImageId();
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
