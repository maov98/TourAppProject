package com.example.miguelortiz.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantArrayAdapter extends ArrayAdapter<Restaurant> {

    private Context currentContext;

    public RestaurantArrayAdapter(Context context, ArrayList<Restaurant> restaurantsToVisit){
        super(context,0,restaurantsToVisit);
        this.currentContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.restaurant_list, parent, false);
        }

        Restaurant currentItem = getItem(position);
        TextView descriptionextView = (TextView) listItemView.findViewById(R.id.restaurantDescription);
        ImageView placeImage = (ImageView) listItemView.findViewById(R.id.restaurantImage);
        TextView actionButton = (TextView) listItemView.findViewById(R.id.restaurantActionButton);
        descriptionextView.setText(currentItem.getDescription());
        placeImage.setImageResource(currentItem.getImageId());

        return listItemView;

    }
}
