package controller;

import java.util.ArrayList;
import java.util.List;

import Configuration.Settings;
import View.Screen;

public class CoreController {
    
    private Screen mainScreen;
    private Database db;
    private Settings defaulSettings;
    private String url;
    private String dbUser;
    private String dbPassword;
    private List<?> dbItems =  new ArrayList<>();

    public CoreController(Screen mainScreen, Database db, Settings defaultSettings){

        this.mainScreen = mainScreen;
        this.db = db;
        this.defaulSettings = defaultSettings;

        
    }

    public void Initialize(){
    
        setDbCredentials();
        db.Connect(url ,dbUser, dbPassword);
        setCurrentScreenInfo();
    }

    private void setDbCredentials(){
        try {

            dbUser = defaulSettings.getDbUser();
            dbPassword = defaulSettings.getDbPassword();

        } catch (Exception e) {
            Utils.logError(e);
        }
    }

    private void setCurrentScreenInfo(){
        dbItems.
    }
}
