package com.bluestar.app.Component;

import java.awt.Dimension;

import javax.swing.JPanel;

public class BasicPanel extends JPanel{

    private String name;
    private boolean active = false;

    public BasicPanel(boolean isActive ,String name, boolean hasSidePanel ,Dimension sidePanelDimension){
        
        this.name = name;
        this.active = isActive;
    }

    public void setActive(){
        this.active = true;
    }

    public boolean isActive(){
        return active;
    }
}
