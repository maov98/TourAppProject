package com.example.miguelortiz.tourapp;

public class Events {

    private String lEventTitle;
    int lImageResourceId;
    String lEventDescription;

    public Events(String title, int imageRsourceId,String description){

        lEventDescription = description;
        lImageResourceId = imageRsourceId;
        lEventTitle = title;
    }

    public String getTitle(){

        return lEventTitle;
    }

    public int getImageId(){

        return lImageResourceId;
    }

    public String getDescription(){

        return lEventDescription;
    }
}
