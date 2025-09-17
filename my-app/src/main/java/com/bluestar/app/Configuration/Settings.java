package com.bluestar.app.Configuration;

import java.awt.Dimension;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import com.bluestar.app.Component.BasicPanel;
import com.bluestar.app.controller.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Settings {
    
    private Gson gson = new Gson();
    private JsonObject jsonobj;
    
    public Settings(){

        readConfig();


    }

    public JsonObject getJSON(){
        return jsonobj;
    }


    /**
     * Reads the configuration file and parses it into a json object.
     * It then saves the json object to the class instance variable.
     * If there is an error while reading the file, it logs the error.
     */
    private void readConfig(){

        try {       
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/src/main/java/com/bluestar/app/config.json"));
            jsonobj = JsonParser.parseReader(reader).getAsJsonObject();   
        
        } catch (Exception e) {
            Utils.logError(e);
        }
    }

    /**
     * Retrieves a setting from the configuration file given the item name.
     * 
     * @param item the name of the setting to retrieve
     * @return the value of the setting as a string
     */
    public String getSetting(String item){

        return jsonobj.get(item).getAsString();
    }
}
