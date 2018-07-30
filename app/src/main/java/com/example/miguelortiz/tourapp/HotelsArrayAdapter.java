package com.example.miguelortiz.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelsArrayAdapter extends ArrayAdapter<Hotels> {

    private Context currentContext;

    public HotelsArrayAdapter(Context context, ArrayList<Hotels> hotelsToVisit){
        super(context,0,hotelsToVisit);
        this.currentContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.hotels_list, parent, false);
        }

        Hotels currentItem = getItem(position);
        TextView descriptionextView = (TextView) listItemView.findViewById(R.id.hotelDescription);
        ImageView placeImage = (ImageView) listItemView.findViewById(R.id.hotelImage);
        TextView actionButton = (TextView) listItemView.findViewById(R.id.hotelActionButton);
        descriptionextView.setText(currentItem.getTitle());
        placeImage.setImageResource(currentItem.getImageId());

        return listItemView;

    }
}
