package com.example.miguelortiz.tourapp;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class PlacesFragment extends Fragment {

    public PlacesFragment() {
    }

    ArrayList<Places> placesArray;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_places, container, false);
        placesArray = new ArrayList<Places>();
        PlacesArrayAdapter placesAdapter = new PlacesArrayAdapter(getContext(),placesArray);

        placesArray.add(new Places(getString(R.string.place1),R.drawable.copanhonduras1,getString(R.string.placeDes1)));
        placesArray.add(new Places(getString(R.string.place2),R.drawable.copanhonduras2,getString(R.string.placeDes2)));
        placesArray.add(new Places(getString(R.string.place3),R.drawable.copanhonduras3,getString(R.string.placeDes3)));
        placesArray.add(new Places(getString(R.string.place4),R.drawable.copanhonduras4,getString(R.string.placeDes4)));
        placesArray.add(new Places(getString(R.string.place5),R.drawable.copanhonduras5,getString(R.string.placeDes5)));
        placesArray.add(new Places(getString(R.string.place6),R.drawable.copanhonduras6,getString(R.string.placeDes6)));

        ListView listView =  view.findViewById(R.id.placesListView);
        listView.setAdapter(placesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DetailFragment detailFragment = new DetailFragment();
                String placeDescription = placesArray.get(position).getDescription();
                String placeTitle = placesArray.get(position).getTitle();
                Integer drawable = placesArray.get(position).getImageId();
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
