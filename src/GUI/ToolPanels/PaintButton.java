package GUI.ToolPanels;

import EventListener.ToolSelectEventListener;
import GUI.CanvasPanels.CanvasPanel;

import javax.swing.*;
import java.awt.*;

public class PaintButton extends JButton {
    CanvasPanel canvasPanel;

    public PaintButton(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.setText("Paint");
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(20, 20));
        this.addActionListener(new ToolSelectEventListener(canvasPanel));
    }
}
