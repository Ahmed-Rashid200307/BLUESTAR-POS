package com.bluestar.app.View.Ui;

import java.awt.Dimension;

import com.bluestar.app.Component.BasicPanel;

public class Inventory extends BasicPanel{

    private String name;

    public Inventory(String name,Dimension panelDimension, boolean hasSidePanel) {
        super(panelDimension, hasSidePanel);
        //TODO Auto-generated constructor stub

        this.name = name;

        // setStructure();
    }
    
}
