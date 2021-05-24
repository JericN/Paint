package GUI.ToolPanels;

import EventListener.MouseEventListener;
import GUI.CanvasPanels.CanvasPanel;
import Method.ToolMethod;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorChangerPanel extends JPanel {
    public static BufferedImage img = null;
    CanvasPanel canvasPanel;
    public ColorChangerPanel(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.setPreferredSize(new Dimension(200, 200));
        this.addMouseListener(new MouseEventListener(canvasPanel));
        this.addMouseMotionListener(new MouseEventListener(canvasPanel));
    }

    public void setImage(BufferedImage img){
        ColorChangerPanel.img = img;
        this.repaint();
    }



    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
