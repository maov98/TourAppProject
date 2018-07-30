package com.example.miguelortiz.tourapp;

public class Places  {

    private String lPlaceTitle;
    int lImageResourceId;
    String lPlacedescription;

    public Places(String title, int imageRsourceId,String description){

        lPlacedescription = description;
        lImageResourceId = imageRsourceId;
        lPlaceTitle = title;
    }

    public String getTitle(){

        return lPlaceTitle;
    }

    public int getImageId(){

        return lImageResourceId;
    }

    public String getDescription(){

        return lPlacedescription;
    }
}
