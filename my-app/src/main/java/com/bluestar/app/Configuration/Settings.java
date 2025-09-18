package com.bluestar.app.Configuration;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.bluestar.app.controller.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Settings {

    private Map<String, Object> items;
    
    public Settings(){

        readConfig();


    }

    public Map<String, Object> getJSON(){
        return items;
    }



    /**
     * Reads the configuration file located at the root of the project.
     * The configuration file is in JSON format.
     * This method reads the file and parses it into a Map which can be accessed
     * using the getJSON() method. If there is any error reading the file, it will
     * be logged.
     * */
    private void readConfig(){

        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/src/main/java/com/bluestar/app/config.json"));
            items = gson.fromJson(reader, Map.class);
        
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
    public Object getSetting(String item){

        return items.get(item);
    }

    public List<Map<String, Object>> getSettingAsListMap(String item){
        return (List<Map<String, Object>>) items.get(item);
    }
}
