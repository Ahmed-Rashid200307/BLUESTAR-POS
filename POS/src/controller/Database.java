package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    Connection connection;

    public Database(){

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            Utils.logError(e);
        }
    }

    public void Connect(String url, String username, String password){

        try {
            
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            Utils.logError(e);
        }

    }
}
