package com.example.miguelortiz.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class PlacesArrayAdapter extends ArrayAdapter<Places> {

    private Context currentContext;

    public PlacesArrayAdapter(Context context, ArrayList<Places> placesToVisit){
        super(context,0,placesToVisit);
        this.currentContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.places_list, parent, false);
        }

        Places currentPlace = getItem(position);
        TextView descriptionextView = (TextView) listItemView.findViewById(R.id.placesDescription);
        ImageView placeImage = (ImageView) listItemView.findViewById(R.id.placesImage);
        TextView actionButton = (TextView) listItemView.findViewById(R.id.placesActionButton);
        descriptionextView.setText(currentPlace.getTitle());
        placeImage.setImageResource(currentPlace.getImageId());

        return listItemView;

    }
}
