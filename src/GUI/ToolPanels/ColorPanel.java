package GUI.ToolPanels;

import EventListener.ColorWheelEventListener;
import GUI.MainPanels.CanvasPanel;

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

    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
