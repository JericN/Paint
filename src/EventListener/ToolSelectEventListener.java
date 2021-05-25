package EventListener;


import GUI.MainPanels.CanvasPanel;
import GUI.ToolPanels.*;
import Method.*;
import Enum.ToolType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToolSelectEventListener implements ActionListener {
    Method method;
    JButton tool;
    ArrayList<JButton> toolArr;

    public ToolSelectEventListener(CanvasPanel canvasPanel, JButton tool) {
        this.method = new Method(canvasPanel);
        this.tool = tool;
        toolArr = method.getToolButtons();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src instanceof PaintButton) {
            CanvasEventListener.type = ToolType.PAINT;

            focus(src);
        } else if (src instanceof EraserButton) {
            CanvasEventListener.type = ToolType.ERASER;
            focus(src);

        } else if (src instanceof ColorPickerButton) {
            CanvasEventListener.type = ToolType.COLOR_PICKER;
            focus(src);
        }else if (src instanceof FillButton) {
            CanvasEventListener.type = ToolType.FILL;
            focus(src);
        }
    }

    public void focus(Object src) {
        for (JButton b : toolArr) {
            if (b.getClass() != src.getClass()) {
                b.setBackground(Color.WHITE);
            } else {
                b.setBackground(Color.CYAN);
            }
        }
    }
}
