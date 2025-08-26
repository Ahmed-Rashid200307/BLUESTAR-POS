package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

public class SidePanel extends Panel{

    private int width;
    private int height;

    public SidePanel(int width, int height){
        this.width = width;
        this.height = height;

        this.setBackground(new Color(255,255,255));
        this.setSize(width, height);
    }
    
}
