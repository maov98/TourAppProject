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


public class RestaurantFragment extends Fragment {



    public RestaurantFragment() {

    }

    ArrayList<Restaurant> restaurantsArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        restaurantsArray = new ArrayList<Restaurant>();
        RestaurantArrayAdapter restaurantArrayAdapterdapter = new RestaurantArrayAdapter(getContext(),restaurantsArray);

        restaurantsArray.add(new Restaurant(getString(R.string.restaurant1),R.drawable.restaurant1,getString(R.string.restaurantDes1)));
        restaurantsArray.add(new Restaurant(getString(R.string.restaurant2),R.drawable.restaurant2,getString(R.string.restaurantDes2)));
        restaurantsArray.add(new Restaurant(getString(R.string.restaurant3),R.drawable.restaurant3,getString(R.string.restaurantDes3)));

        ListView listView =  view.findViewById(R.id.restaurantListView);
        listView.setAdapter(restaurantArrayAdapterdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DetailFragment detailFragment = new DetailFragment();
                String itemTitle = restaurantsArray.get(position).getDescription();
                Integer drawable = restaurantsArray.get(position).getImageId();
                String itemDescription = restaurantsArray.get(position).getAddress();
                Bundle bundle = new Bundle();
                bundle.putString(getString(R.string.bundle1),itemTitle);
                bundle.putInt(getString(R.string.bundle2),drawable);
                bundle.putString(getString(R.string.bundle3),itemDescription);
                detailFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.detailedLayout,detailFragment).commit();
            }
        });




        return view;
    }

}
