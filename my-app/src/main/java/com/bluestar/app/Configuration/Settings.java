package com.bluestar.app.Configuration;

import java.awt.Dimension;
import java.io.FileReader;
import java.util.ArrayList;

import com.bluestar.app.Component.BasicPanel;
import com.bluestar.app.controller.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Settings {
    
    private ArrayList<BasicPanel> panels = new ArrayList<>();
    private Gson gson = new Gson();
    private JsonObject jsonobj;
    
    public Settings(){

        readConfig();
        addPanelsToList();


    }

    private void addPanelsToList(){
        panels.add(new BasicPanel(new Dimension(200, 200), false));
    } 

    public ArrayList<BasicPanel> getPanelInstances() {

        return panels;
    }

    private void readConfig(){

        try {       
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/src/main/java/com/bluestar/app/config.json"));
            jsonobj = JsonParser.parseReader(reader).getAsJsonObject();   
        
        } catch (Exception e) {
            Utils.logError(e);
        }
    }

    public String getSetting(String item){

        return jsonobj.get(item).getAsString();
    }
}
