package Method;

import GUI.MainPanels.CanvasPanel;
import Enum.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Variables {
    static ArrayList<JButton> toolButtons;
    static Map<BrushStroke, ArrayList<Point>> dataStrokes;
    static BufferedImage colorWheel;
    static Color currentColor;
    static int currentBrushRadius;
    static BrushStroke currentStroke;

    CanvasPanel canvasPanel;

    public Variables() {
        toolButtons = new ArrayList<>();
        setDataStrokes(currentBrushRadius);
        currentColor = Color.BLACK;
        currentBrushRadius = 5;
        currentStroke = BrushStroke.CIRCLE;
    }

    public Variables(CanvasPanel cp) {
        canvasPanel = cp;
    }
    private void setDataStrokes(int rad){
        dataStrokes = new HashMap<>();
        ArrayList<Point> SQUARE = new ArrayList<>();
        ArrayList<Point> CIRCLE = new ArrayList<>();
        ArrayList<Point> SLASH = new ArrayList<>();

        for (int i = -rad; i <= rad ; i++) {
            for (int j = -rad; j <= rad; j++) {
                SQUARE.add(new Point(j,i));
            }
        }
        dataStrokes.put(BrushStroke.SQUARE,SQUARE);

        int r = (int) Math.pow(rad,2);
        for (Point point : SQUARE) {
            int x = (int) Math.pow(point.getX(), 2);
            int y = (int) Math.pow(point.getY(), 2);
            if (x + y < r) {
                CIRCLE.add(point);
            }
        }
        dataStrokes.put(BrushStroke.CIRCLE,CIRCLE);

        for (int i = -rad; i <= rad ; i++) {
            for (int j = -rad; j <= rad; j++) {
               if(i==j){
                   SLASH.add(new Point(i-2,j));
                   SLASH.add(new Point(i-1,j));
                   SLASH.add(new Point(i,j));
                   SLASH.add(new Point(i+1,j));
                   SLASH.add(new Point(i+2,j));
               }
            }
        }
        dataStrokes.put(BrushStroke.SLASH,SLASH);

    }


    public static void addToolButtons(JButton b) {
        toolButtons.add(b);
    }

    public ArrayList<JButton> getToolButtons() {
        return toolButtons;
    }

    public void setColor(Point pos) {
        currentColor = new Color(colorWheel.getRGB((int) pos.getX(), (int) pos.getY()));
    }

    public void setColor(Point pos, BufferedImage img) {
        System.out.println(img.getRGB((int) pos.getX(), (int) pos.getY()));
        currentColor = new Color(img.getRGB((int) pos.getX(), (int) pos.getY()));
    }

    public void setBrushRadius(int rad) {
        currentBrushRadius = rad;
        setDataStrokes(currentBrushRadius);
    }
}
