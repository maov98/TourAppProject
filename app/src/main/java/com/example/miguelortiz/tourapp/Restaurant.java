package com.example.miguelortiz.tourapp;

public class Restaurant {

    private String lPlacedescription;
    int lImageResourceId;
    String lAddress;

    public Restaurant(String description, int imageRsourceId, String address){

        lPlacedescription = description;
        lImageResourceId = imageRsourceId;
        lAddress = address;
    }

    public String getDescription(){

        return lPlacedescription;
    }

    public int getImageId(){

        return lImageResourceId;
    }

    public String getAddress(){

        return lAddress;
    }
}
