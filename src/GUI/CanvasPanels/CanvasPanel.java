package GUI.CanvasPanels;

import EventListener.DocumentFilterListener;
import EventListener.MouseEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    ArrayList<Point> posArr;
    ArrayList<Color> colArr;
    int brushSize;
    BufferedImage canvas;

    public CanvasPanel() {
        canvas = new BufferedImage(600, 900, BufferedImage.TYPE_INT_ARGB);

        this.setPreferredSize(new Dimension(600, 900));
        this.setBackground(Color.WHITE);
        this.addMouseListener(new MouseEventListener(this));
        this.addMouseMotionListener(new MouseEventListener(this));
        posArr = new ArrayList<>();
        colArr = new ArrayList<>();
        brushSize = 5;
    }

    public void setCanvasData(Point pos, Color col) {
        Graphics2D g2D = canvas.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setColor(col);
        Shape theCircle = new Ellipse2D.Double(pos.x - brushSize, pos.y - brushSize, 2.0 * brushSize, 2.0 * brushSize);
        g2D.fill(theCircle);
        this.repaint();
    }

    public void setBrushSize(int size) {
        brushSize = size;
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(canvas, 0, 0, null);
    }
}
