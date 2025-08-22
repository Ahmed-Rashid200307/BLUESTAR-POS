

import view.Screen;
import java.awt.Dimension;
import java.awt.Toolkit;

import Configuration.Settings;


public class App {

    private static Toolkit GetScreenProperties(){
        return Toolkit.getDefaultToolkit();
    }

    private static void Start() throws Exception {

        // Setting app paramenters
        Toolkit screenDimention = GetScreenProperties();

        Dimension screenDimension = screenDimention.getScreenSize();
        
        String title = "BLUESTAR POS SYSTEM";
        
        // Database db = new Database();
        // Connection to Database
        // db.connect();

        Settings defaultSettings = new Settings();

        // Screen instance with given screen dimentions and showing it
        Screen appScreen = new Screen(screenDimension, title, defaultSettings);
        appScreen.show();
        
    
    }
    public static void main(String[] args) throws Exception {
        
        // Start the whole app
        Start();
    }
}
