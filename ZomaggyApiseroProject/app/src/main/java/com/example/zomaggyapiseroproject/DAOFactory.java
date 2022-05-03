package com.example.zomaggyapiseroproject;

import java.sql.SQLException;

public class DAOFactory{
    public static ZomaggyDAOInterface createDAOObject(){
        return  new ZomaggyDAO();
    }
}
