package GUI.MainPanels;

import EventListener.CanvasEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    ArrayList<Point> posArr;
    ArrayList<Color> colArr;
    BufferedImage canvas;

    public CanvasPanel() {
        canvas = new BufferedImage(1200, 900, BufferedImage.TYPE_INT_ARGB);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(1200, 900));
        this.setBackground(Color.WHITE);
        this.addMouseListener(new CanvasEventListener(this));
        this.addMouseMotionListener(new CanvasEventListener(this));
        posArr = new ArrayList<>();
        colArr = new ArrayList<>();
        Graphics2D g2D = canvas.createGraphics();
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public BufferedImage getCanvas() {
        return canvas;
    }

    public void setCanvasData(Point pos, Color col, int rad) {
        Graphics2D g2D = canvas.createGraphics();
        g2D.setColor(col);
        Shape theCircle = new Ellipse2D.Double(pos.x - rad, pos.y - rad, 2.0 * rad, 2.0 * rad);
        g2D.fill(theCircle);
        this.grabFocus();
        this.repaint();
    }
    public void setCanvasData(BufferedImage canvas){
        this.canvas = canvas;
        this.grabFocus();
        this.repaint();
    }


    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(canvas, 0, 0, null);
        g2D.dispose();
    }
}
