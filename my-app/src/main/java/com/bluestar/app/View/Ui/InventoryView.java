package com.bluestar.app.View.Ui;

import java.awt.Dimension;

import com.bluestar.app.Component.BasicPanel;

public class InventoryView extends BasicPanel{

    private String name;

    public InventoryView(String name,Dimension panelDimension, boolean hasSidePanel) {
        super(panelDimension, hasSidePanel);
        //TODO Auto-generated constructor stub

        this.name = name;

        // setStructure();
    }
    
}
