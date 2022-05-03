package com.example.zomaggyapiseroproject;

public class Model1 {

    String text;
    String number;
    String price;


    Model1(String text, String number , String price)
    {
        this.text=text;
        this.number=number;
        this.price=price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String link) {
        this.price = price;
    }

}
