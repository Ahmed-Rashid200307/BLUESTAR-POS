package com.bluestar.app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Database {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    public Database(){

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            Utils.logError(e);
        }
    }

    public void Connect(String url, String username, String password){

        this.url = url;
        this.username = username;
        this.password = password;
        try {
            
            connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception e) {
            Utils.logError(e);
        }

    }

    public ResultSet query(String query){
        try {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return res;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
