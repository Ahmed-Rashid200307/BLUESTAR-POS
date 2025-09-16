package com.bluestar.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.bluestar.app.Configuration.Settings;
import com.bluestar.app.View.Screen;
import com.bluestar.app.controller.CoreController;
import com.bluestar.app.controller.Database;


public class App {

    private static Toolkit GetScreenProperties(){
        return Toolkit.getDefaultToolkit();
    }

    private static void Start() {

        // Setting app paramenters
        Toolkit screenDimention = GetScreenProperties();

        Dimension screenDimension = screenDimention.getScreenSize();
        
        String title = "BLUESTAR POS SYSTEM";
        
        Database db = new Database();

        Settings defaultSettings = new Settings();

        // Screen instance with given screen dimentions and showing it
        Screen appScreen = new Screen(screenDimension, title, defaultSettings);
        
        // Connects everything together db items to screen display, handles events
        CoreController controller = new CoreController(appScreen, db, defaultSettings);

        // sets up controller dependensies
        controller.Initialize();
        
    
    }
    public static void main(String[] args) throws Exception {
        
        // Start the whole app
        Start();
    }
}
