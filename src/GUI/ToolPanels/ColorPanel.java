package GUI.ToolPanels;

import EventListener.ColorWheelEventListener;
import GUI.CanvasPanels.CanvasPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorPanel extends JPanel {
    public static BufferedImage img = null;
    CanvasPanel canvasPanel;
    public ColorPanel(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.setPreferredSize(new Dimension(200, 200));
        this.addMouseListener(new ColorWheelEventListener(canvasPanel));
        this.addMouseMotionListener(new ColorWheelEventListener(canvasPanel));
    }

    public void setImage(BufferedImage img){
        ColorPanel.img = img;
        this.repaint();
    }



    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
