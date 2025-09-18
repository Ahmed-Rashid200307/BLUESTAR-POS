package com.bluestar.app.controller;

import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        mainScreen.setupPanels(defaulSettings.getSettingAsListMap("views").iterator());
  
        mainScreen.initializeActivePanel();
        mainScreen.show();
    
        try {
            db.Connect(defaulSettings.getSetting("dbUrl").toString()
            ,defaulSettings.getSetting("dbUser").toString()
            , defaulSettings.getSetting("dbPassword").toString());

        } catch (Exception e) {
            Utils.logError(e);
        }

        setCurrentScreenInfo();
    }


    private void setCurrentScreenInfo(){
        // dbItems.
    }


}
