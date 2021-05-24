package EventListener;


import GUI.CanvasPanels.CanvasPanel;
import Method.Method;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EraseEventListener implements ActionListener {
    Method method;
    public EraseEventListener(CanvasPanel canvasPanel) {
        this.method = new Method(canvasPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        method.setColor(Color.WHITE);
    }
}
