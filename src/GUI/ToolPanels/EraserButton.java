package GUI.ToolPanels;

import EventListener.EraseEventListener;
import GUI.CanvasPanels.CanvasPanel;

import javax.swing.*;
import java.awt.*;

public class EraserButton extends JButton {
    CanvasPanel canvasPanel;
    public EraserButton(CanvasPanel canvasPanel){
        this.canvasPanel = canvasPanel;
        this.setPreferredSize(new Dimension(20,20));
        this.addActionListener(new EraseEventListener(canvasPanel));
    }
}
