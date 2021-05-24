package Method;

import GUI.CanvasPanels.CanvasPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Variables {

    public static class global{
        static BufferedImage colorWheel;
        static Color color;
        static int brushRadius;
    }

    CanvasPanel canvasPanel;

    public Variables(CanvasPanel cp){
        canvasPanel = cp;
        global.color = Color.BLACK;
        global.brushRadius = 5;
    }

    public void setColor(Point pos){
        System.out.println("1");
        global.color = new Color(global.colorWheel.getRGB((int)pos.getX(), (int) pos.getY()));
    }
    public void setColor(Point pos, BufferedImage img){
        System.out.println("2");
        System.out.println(img.getRGB((int)pos.getX(), (int) pos.getY()));
        global.color = new Color(img.getRGB((int)pos.getX(), (int) pos.getY()));
    }
    public void setColor(Color col){
        global.color = col;
    }
    public void setBrushRadius(int rad){
        global.brushRadius = rad;
    }
}
