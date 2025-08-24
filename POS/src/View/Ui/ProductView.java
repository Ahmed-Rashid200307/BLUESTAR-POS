package View.Ui;

import java.awt.Dimension;

import Component.BasicPanel;

public class ProductView extends BasicPanel{

    private String name;

    public ProductView(String name,Dimension panelDimension, boolean hasSidePanel) {
        super(panelDimension, hasSidePanel);
        //TODO Auto-generated constructor stub

        this.name = name;

        setStructure();
    }
    
}
