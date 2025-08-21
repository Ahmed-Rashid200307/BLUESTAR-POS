package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import component.ScreenMenu;
import component.SidePanel;

public class Screen {

    private Dimension screenDimension;
    private JFrame mainFrame = new JFrame();
    private JMenuBar menuBar;
    private Panel sidePanel;
    private String title;

    // Constructor
    // Sets Jframe dimensions and adds menu to the frame
    public Screen(Dimension screenDimension, String title){
        this.screenDimension = screenDimension;
        this.title = title;
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(new Color(230, 239, 255));;
        mainFrame.setLayout(null);

        setFrameTitle();
        setFrameDimension();


        addMenuToScreen();
        // this.screenPanes = getAllPaneInstances();
        // this.currentPane = setCurrentPane();
        // Creates and adds side panel to the screen frame
        addSidePanelToScreen();
        showCurrentMainPanel();
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

    private void addSidePanelToScreen(){
        sidePanel = getSidePanel(20, 100);
        mainFrame.add(sidePanel);

    }

    private Panel getSidePanel(int percentWidth, int percentHeight ){
        
        int width = (int) ((percentWidth / 100.0) * screenDimension.width);
        int height = (int) ((percentHeight / 100.0) * screenDimension.height);
        System.out.println(width);
        
        return new SidePanel(width, height);
    }

    public void show(){
        mainFrame.setVisible(true);
    }
    
}
