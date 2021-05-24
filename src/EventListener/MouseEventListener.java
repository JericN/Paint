package EventListener;


import GUI.CanvasPanels.CanvasPanel;
import GUI.ToolPanels.ColorChangerPanel;
import Method.ToolMethod;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEventListener extends MouseAdapter implements MouseMotionListener,MouseListener  {
    ToolMethod method;
    public MouseEventListener(CanvasPanel canvasPanel) {
        method = new ToolMethod(canvasPanel);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof CanvasPanel){
            method.setPixel(new Point(e.getX(),e.getY()));
        }else if(source instanceof ColorChangerPanel){
            method.setColor(new Point(e.getX(),e.getY()));
        }

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof CanvasPanel){
            method.setPixel(new Point(e.getX(),e.getY()));
        }else if(source instanceof ColorChangerPanel){
            method.setColor(new Point(e.getX(),e.getY()));
        }
    }
}
