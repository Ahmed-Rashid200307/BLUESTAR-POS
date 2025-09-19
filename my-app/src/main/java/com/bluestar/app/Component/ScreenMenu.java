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
    }

    private void setMenuBar(){
        this.setOpaque(true);
        this.setBackground(new Color(154, 165, 127));
        this.setPreferredSize(new Dimension(screenToSetDimension.width, 30));
    }

    // create button instance for each option and add to menuButtons
    public void setOptionsToDisplay(String label){

     
        menuButtons.add(new JButton(label));
        System.out.println(menuButtons.size());


    }

    /**
     * Adds all the buttons in the menuButtons list to the menu bar.
     * 
     */
    public void addOptionToMenu() {

        menuButtons.forEach((btn) -> {
            this.add(btn);
        });
    }
}
