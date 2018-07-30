package com.example.miguelortiz.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsArrayAdapter extends ArrayAdapter<Events> {

    private Context currentContext;

    public EventsArrayAdapter(Context context, ArrayList<Events> placesToVisit){
        super(context,0,placesToVisit);
        this.currentContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.events_list, parent, false);
        }

        Events currentPlace = getItem(position);
        TextView descriptionextView = (TextView) listItemView.findViewById(R.id.eventDescription);
        ImageView placeImage = (ImageView) listItemView.findViewById(R.id.eventImage);
        TextView actionButton = (TextView) listItemView.findViewById(R.id.eventActionButton);
        descriptionextView.setText(currentPlace.getTitle());
        placeImage.setImageResource(currentPlace.getImageId());

        return listItemView;

    }
}
