package com.bluestar.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.bluestar.app.Configuration.Settings;
import com.bluestar.app.View.Screen;

public class CoreController {
    
    private Screen mainScreen;
    private Database db;
    private Settings defaulSettings;
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

        defaulSettings.setupPanels();

                
        mainScreen.loadBasicPanel();   
        mainScreen.setActivePanel();
        mainScreen.show();
    
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
}
