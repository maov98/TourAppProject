package com.example.miguelortiz.tourapp;

public class Hotels {

    private String lHotelTitle;
    int lImageResourceId;
    String lHotelDescription;

    public Hotels(String title, int imageRsourceId,String description){

        lHotelDescription = description;
        lImageResourceId = imageRsourceId;
        lHotelTitle = title;
    }

    public String getTitle(){

        return lHotelTitle;
    }

    public int getImageId(){

        return lImageResourceId;
    }

    public String getDescription(){

        return lHotelDescription;
    }

}
