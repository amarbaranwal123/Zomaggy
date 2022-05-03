package com.example.zomaggyapiseroproject;

public class Model3 {

    String text;
    int image;
    String userID;

    public Model3(String text, int image, String userID) {
        this.text = text;
        this.image = image;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
