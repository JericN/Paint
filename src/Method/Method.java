package Method;

import GUI.MainPanels.CanvasPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Method extends ImageBuffer {

    public Method(CanvasPanel canvasPanel) {
        super(canvasPanel);
    }

    public void setPixel(Point pos) {
        canvasPanel.setCanvasData(pos, color, brushRadius);
    }

    public void removePixel(Point pos) {
        canvasPanel.setCanvasData(pos, Color.WHITE, brushRadius);
    }

    public void fillArea(Point pos, BufferedImage canvas) {
        getPosArr(canvas,canvas.getRGB(pos.x,pos.y), color.getRGB(),pos.x,pos.y);
        canvasPanel.setCanvasData(canvas);
    }

    public void getPosArr(BufferedImage canvas,int target,int replace, int x, int y) {
        if (target != canvas.getRGB(x,y)) {
            return;
        }
        canvas.setRGB(x,y,replace);
        getPosArr(canvas,target,replace,x+1,y);
        getPosArr(canvas,target,replace,x-1,y);
        getPosArr(canvas,target,replace,x,y+1);
        getPosArr(canvas,target,replace,x,y-1);

    }


}
