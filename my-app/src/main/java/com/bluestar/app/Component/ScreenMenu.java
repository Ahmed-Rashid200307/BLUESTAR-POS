package com.bluestar.app.Component;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuBar;

public class ScreenMenu extends JMenuBar{

    private Dimension screenToSetDimension;
    private ArrayList<JButton> menuButtons = new ArrayList<JButton>();

    public ScreenMenu(Dimension screenDimension){
        screenToSetDimension = screenDimension;

        // set bar dimensions etc
        setMenuBar();

        // Add as many buttons as needed provided the labels
        // by option it means button
        setOptionsToDisplay("Inventory","Customer","Transactions");
        addOptionToMenu();
    }

    private void setMenuBar(){
        this.setOpaque(true);
        this.setBackground(new Color(154, 165, 127));
        this.setPreferredSize(new Dimension(screenToSetDimension.width, 30));
    }

    // create button instance for each option and add to menuButtons
    private void setOptionsToDisplay(String... labels){

        for(String label: labels){
            menuButtons.add(new JButton(label));
        }

    }

    // Just simply adding to buttons to menuBar
    private void addOptionToMenu() {

        menuButtons.forEach((btn) -> {
            this.add(btn);
        });
    }
}
