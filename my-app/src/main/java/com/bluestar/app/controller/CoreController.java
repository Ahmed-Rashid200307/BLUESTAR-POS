package com.bluestar.app.controller;

import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.bluestar.app.Component.BasicPanel;
import com.bluestar.app.Configuration.Settings;
import com.bluestar.app.View.Screen;
import com.google.gson.JsonObject;

public class CoreController {
    
    private Screen mainScreen;
    private Database db;
    private Settings defaulSettings;
    private ArrayList<BasicPanel> panels = new ArrayList<>();
    private List<?> dbItems =  new ArrayList<>();

    public CoreController(Screen mainScreen, Database db, Settings defaultSettings){

        this.mainScreen = mainScreen;
        this.db = db;
        this.defaulSettings = defaultSettings;
        
    }

    /**
     * Sets up the whole application.
     * 
     * This method sets up the settings from the configuration file, shows the main screen and connects to the database.
     * If there is any error connecting to the database, it will be logged.
     */
    public void Initialize(){

        setupPanels();

        
        mainScreen.setPanelsToPane(panels);   
        mainScreen.show();
        mainScreen.initializeActivePanel();
    
        try {
            db.Connect(defaulSettings.getSetting("dbUrl") ,defaulSettings.getSetting("dbUser"), defaulSettings.getSetting("dbPassword"));

        } catch (Exception e) {
            Utils.logError(e);
        }

        setCurrentScreenInfo();
    }


    private void setCurrentScreenInfo(){
        // dbItems.
    }

        /**
     * Parses the panels from the configuration file and adds them to the panels list
     * The panels are added in the order they are in the configuration file
     * The active property is used to determine if the panel should be active or not
     */
    public void setupPanels(){
        defaulSettings.getJSON().get("views").getAsJsonArray().forEach((panel) -> {

            try {
                JsonObject jsonobj = panel.getAsJsonObject();
                Class<?> c = Class.forName(jsonobj.get("value").getAsString());
                Constructor<?> cons = c.getConstructor(String.class,Dimension.class, boolean.class);
                BasicPanel object = (BasicPanel)cons.newInstance(jsonobj.get("value").getAsString(),new Dimension(40, 40), jsonobj.get("enabled").getAsBoolean());

                if(jsonobj.get("visible").getAsBoolean()){
                    object.setActive();
                    panels.add(object);
                }
                else{
                    panels.add(object);
                }
            } catch (Exception e) {
                Utils.logError(e);
            }
        });

    } 
}
