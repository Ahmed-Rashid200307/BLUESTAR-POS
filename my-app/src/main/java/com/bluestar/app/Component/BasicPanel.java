package com.bluestar.app.Component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class BasicPanel extends JPanel{

    private String name;
    private boolean active = false;

    public BasicPanel(String name, boolean hasSidePanel ,Dimension sidePanelDimension){
        
        this.name = name;
    }

    public void setActive(){
        this.active = true;
    }

    public boolean isActive(){
        return active;
    }
}
