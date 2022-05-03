package com.example.zomaggyapiseroproject;

public class DAOLoginFactory {
    public static ZomaggyDAOLoginInterface createDAOObject(){
        return  new ZomaggyDAOLogin();
    }
}
