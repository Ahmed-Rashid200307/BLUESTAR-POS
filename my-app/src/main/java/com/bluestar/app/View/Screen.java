package com.bluestar.app.View;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.bluestar.app.Component.BasicPanel;
import com.bluestar.app.Component.ScreenMenu;
import com.bluestar.app.Configuration.Settings;
import com.bluestar.app.controller.Utils;
import com.google.gson.JsonObject;

public class Screen {

    private Dimension screenDimension;
    private JFrame mainFrame = new JFrame();
    private JMenuBar menuBar;
    private ArrayList<BasicPanel> panels = new ArrayList<>();
    private BasicPanel currentPanel;
    private String title;

    private Settings settings;

    // Constructor
    // Sets Jframe dimensions and adds menu to the frame
    public Screen(Dimension screenDimension, String title, Settings setting){
        this.settings = setting;

        this.screenDimension = screenDimension;
        this.title = title;
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(new Color(0, 0, 0));
        setFrameTitle();
        setFrameDimension();

        addMenuToScreen();
        // this.screenPanes = getAllPaneInstances();
        // this.currentPane = setCurrentPane();


        // Creates and shows current main panel
        // showCurrentBasicPanel();
    }

    private void setFrameTitle(){
        mainFrame.setTitle(title);
    }

    private void setFrameDimension(){
        mainFrame.setSize(screenDimension);
        
    }

    // Gets menu bar instance and sets it to frame
    private void addMenuToScreen(){
        mainFrame.setJMenuBar(getMenuBar());
    }

    // New menu bar instance
    private JMenuBar getMenuBar(){
        return new ScreenMenu(screenDimension);
    }

    // Loads all availabile panels from settings

    
    // Set any one of the panel which is active
    public void initializeActivePanel(){

        try {
            if (validateActiveStates()){
    
                panels.forEach((panel)-> {
                      
                    if (panel.isActive()){
                        currentPanel = panel;
                        mainFrame.add(currentPanel);
                        
                    }
    
                });
            }
        } catch (Exception e) {
            Utils.logError(e);            
        }

    }

    // checks only one panel is active else throws error
    private boolean validateActiveStates() throws Exception{

        int activePanels = 0;

        for(BasicPanel panel: panels){
            
            if(panel.isActive()){
                activePanels ++;
            }
        }

        if (activePanels > 1){
            throw new Exception("Only one panel can be active at a time");
        }
        else{
            return true;
        }
    }

    public void show(){
        mainFrame.setVisible(true);
    }
    
            /**
     * Parses the panels from the configuration file and adds them to the panels list
     * The panels are added in the order they are in the configuration file
     * The active property is used to determine if the panel should be active or not
     */
    public void setupPanels(Iterator<Map<String, Object>> panelsIterator){
        
        while(panelsIterator.hasNext()){
            Map<String, Object> panel = panelsIterator.next();
            System.out.println(panel.get("value"));
            try {
                Class<?> c = Class.forName(panel.get("value").toString());
                Constructor<?> cons = c.getConstructor(boolean.class ,String.class, boolean.class ,Dimension.class);
                BasicPanel object = (BasicPanel)cons.newInstance((String)panel.get("name")
                , (boolean)panel.get("enabled")
                , new Dimension(40, 40));
                
                if((boolean) panel.get("visible")){
                    object.setActive();
                    panels.add(object);
                }
                else{
                    panels.add(object);
                }
            } catch (Exception e) {
                System.out.println(e);
                Utils.logError(e);
            }
            
        }
        System.out.println(panels.size());
    } 
}
