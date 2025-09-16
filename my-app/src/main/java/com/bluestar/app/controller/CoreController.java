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
        mainScreen.show();
        
    }

    public void Initialize(){
    
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
