package com.example.zomaggyapiseroproject;

public class Model2 {

    String ID;
    String ResName;
    String Ratings;
    String city;

    public Model2(String ID, String resName, String ratings, String city) {
        this.ID = ID;
        this.ResName = resName;
        this.Ratings = ratings;
        this.city = city;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getResName() {
        return ResName;
    }

    public void setResName(String resName) {
        ResName = resName;
    }

    public String getRatings() {
        return Ratings;
    }

    public void setRatings(String ratings) {
        Ratings = ratings;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
