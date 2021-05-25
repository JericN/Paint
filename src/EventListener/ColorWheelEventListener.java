package EventListener;


import GUI.MainPanels.CanvasPanel;
import Method.Method;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ColorWheelEventListener extends MouseAdapter implements MouseMotionListener, MouseListener {
    Method method;

    public ColorWheelEventListener(CanvasPanel canvasPanel) {
        method = new Method(canvasPanel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        method.setColor(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        method.setColor(new Point(e.getX(), e.getY()));
    }
}
