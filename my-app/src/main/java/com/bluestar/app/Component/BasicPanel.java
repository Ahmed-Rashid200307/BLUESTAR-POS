package com.bluestar.app.Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

public class BasicPanel extends Panel{

    private Dimension panelDimension;
    private boolean active = false;

    public BasicPanel(Dimension panelDimension, boolean hasSidePanel){
        
        this.panelDimension = panelDimension;
        this.setBackground(new Color(30,30,30));
        this.setSize(panelDimension);
    }

    public void setActive(){
        this.active = true;
    }

    public boolean isActive(){
        return active;
    }
}
