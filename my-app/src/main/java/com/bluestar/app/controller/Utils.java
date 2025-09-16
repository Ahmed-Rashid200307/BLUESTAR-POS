package com.bluestar.app.controller;

import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    
    public static void logError(Exception e){
        try {
            FileWriter myWriter = new FileWriter("log.txt");
            myWriter.write(e.getMessage());
            myWriter.close();
        } catch (IOException exep) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
