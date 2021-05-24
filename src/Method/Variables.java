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
    }
    CanvasPanel canvasPanel;

    public Variables(CanvasPanel cp){
        canvasPanel = cp;
        global.color = Color.BLACK;
    }
}
