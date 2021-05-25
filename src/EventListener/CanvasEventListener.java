package EventListener;

import GUI.MainPanels.CanvasPanel;
import Method.Method;
import Enum.ToolType;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CanvasEventListener extends MouseAdapter implements MouseMotionListener, MouseListener {
    Method method;
    CanvasPanel canvasPanel;
    public static ToolType type;

    public CanvasEventListener(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        method = new Method(canvasPanel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        run(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        run(e);
    }

    public void run(MouseEvent e) {
        if (type == ToolType.PAINT) {
            method.setPixel(new Point(e.getX(), e.getY()));
        } else if (type == ToolType.ERASER) {
            method.removePixel(new Point(e.getX(), e.getY()));
        } else if (type == ToolType.COLOR_PICKER) {
            method.setColor(new Point(e.getX(), e.getY()), canvasPanel.getCanvas());
        }else if (type == ToolType.FILL) {
            method.fillArea(new Point(e.getX(), e.getY()), canvasPanel.getCanvas());
        }
    }
}
