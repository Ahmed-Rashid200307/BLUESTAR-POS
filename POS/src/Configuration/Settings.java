package Configuration;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import component.BasicPanel;

public class Settings {
    
    private ArrayList<BasicPanel> panels = new ArrayList<>();

    
    public Settings(){

        addPanelsToList();


    }

    private void addPanelsToList(){
        panels.add(new BasicPanel(new Dimension(200, 200), false));
    } 

    public ArrayList<BasicPanel> getPanelInstances() {

        return panels;
    }
}
