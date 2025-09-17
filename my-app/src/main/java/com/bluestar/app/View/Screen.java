package com.bluestar.app.View;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.bluestar.app.Component.BasicPanel;
import com.bluestar.app.Component.ScreenMenu;
import com.bluestar.app.Configuration.Settings;
import com.bluestar.app.controller.Utils;

public class Screen {

    private Dimension screenDimension;
    private JFrame mainFrame = new JFrame();
    private JMenuBar menuBar;
    private ArrayList<BasicPanel> basicPanels;
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
    public void setPanelsToPane(ArrayList<BasicPanel> basicPanels){

        this.basicPanels = basicPanels;
    }
    
    // Set any one of the panel which is active
    public void initializeActivePanel(){

        try {
            if (validateActiveStates()){
    
                basicPanels.forEach((panel)-> {
                      
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

        for(BasicPanel panel: basicPanels){
            
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
    
}
