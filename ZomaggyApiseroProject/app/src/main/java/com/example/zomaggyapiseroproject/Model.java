package com.example.zomaggyapiseroproject;
public class Model {
    String text;
    String number;
    String link;

    Model(String text, String number , String link)
    {
        this.text=text;
        this.number=number;
        this.link=link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}