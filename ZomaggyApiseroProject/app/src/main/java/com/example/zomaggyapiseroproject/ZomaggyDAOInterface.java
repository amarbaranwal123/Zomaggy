package com.example.zomaggyapiseroproject;

import java.sql.SQLException;

public interface ZomaggyDAOInterface {

    public int createDAOProfile(ZomaggyEntity ze) throws SQLException;
    public boolean loginDAOProfile(ZomaggyEntity ze) throws SQLException;
    public ZomaggyEntity viewDAOProfile(ZomaggyEntity ze);
    public int deleteDAOProfile(ZomaggyEntity ze);
    public int updateDAOProfile(ZomaggyEntity ze) throws SQLException;
}
