package Method;

import GUI.MainPanels.CanvasPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Variables {
    static ArrayList<JButton> toolButtons;
    static BufferedImage colorWheel;
    static BufferedImage canvas;
    static Color color;
    static int brushRadius;

    CanvasPanel canvasPanel;

    public Variables(){
        toolButtons = new ArrayList<>();
    }
    public Variables(CanvasPanel cp) {
        canvasPanel = cp;
        color = Color.BLACK;
        brushRadius = 5;
    }

    public static void addToolButtons(JButton b) {
        toolButtons.add(b);
    }

    public ArrayList<JButton> getToolButtons(){
        return toolButtons;
    }

    public void setColor(Point pos) {
        System.out.println("1");
        color = new Color(colorWheel.getRGB((int) pos.getX(), (int) pos.getY()));
    }

    public void setColor(Point pos, BufferedImage img) {
        System.out.println("2");
        System.out.println(img.getRGB((int) pos.getX(), (int) pos.getY()));
        color = new Color(img.getRGB((int) pos.getX(), (int) pos.getY()));
    }

    public void setColor(Color col) {
        color = col;
    }

    public void setBrushRadius(int rad) {
        brushRadius = rad;
    }
}
