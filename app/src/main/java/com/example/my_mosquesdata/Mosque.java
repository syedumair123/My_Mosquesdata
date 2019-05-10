package com.example.my_mosquesdata;

public class Mosque {
    private int ID;
    private String name;
    private int longtitude;
    private int latitude;
    private String imageurl;
    private String address;
    private String topics_name;
    private int farvoriate;
    private int favoriate_id;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongitude() {
        return longtitude;
    }

    public void setLongitude(int longitude) {
        this.longtitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMosque_name() {
        return topics_name;
    }

    public void setMosque_name(String mosque_name) {
        this.topics_name = mosque_name;
    }

    public int getFavorite() {
        return farvoriate;
    }

    public void setFavorite(int favorite) {
        this.farvoriate = favorite;
    }

    public int getFavorite_id() {
        return favoriate_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favoriate_id = favorite_id;
    }
}
