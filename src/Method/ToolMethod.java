package Method;

import GUI.CanvasPanels.CanvasPanel;
import GUI.ToolPanels.ColorChangerPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ToolMethod extends ImageBuffer{

    public ToolMethod(CanvasPanel canvasPanel) {
        super(canvasPanel);
    }

    public void setPixel(Point pos){

        canvasPanel.setCanvasData(pos, global.color);
    }
    public void setColor(Point pos){
        global.color = new Color(global.colorWheel.getRGB((int)pos.getX(), (int) pos.getY()));
    }
    public void setBrushSize(int size){
        System.out.println(size);
        canvasPanel.setBrushSize(size);
    }


}
