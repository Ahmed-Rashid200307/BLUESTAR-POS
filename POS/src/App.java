

import view.Screen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class App {

    private static Toolkit GetScreenProperties(){
        return Toolkit.getDefaultToolkit();
    }

    private static void Start() {

        // Setting app paramenters
        Toolkit screenDimention = GetScreenProperties();

        Dimension screenDimension = screenDimention.getScreenSize();
        
        String title = "BLUESTAR POS SYSTEM";
        
        // Database db = new Database();
        // Connection to Database
        // db.connect();

        // Screen instance with given screen dimentions and showing it
        Screen intital = new Screen(screenDimension, title);
        intital.show();
        
    
    }
    public static void main(String[] args) throws Exception {
        
        // Start the whole app
        Start();
    }
}
