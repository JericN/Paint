package GUI.ToolPanels;

import EventListener.ToolSelectEventListener;
import GUI.CanvasPanels.CanvasPanel;

import javax.swing.*;
import java.awt.*;

public class ColorPickerButton extends JButton {
    CanvasPanel canvasPanel;

    public ColorPickerButton(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.setText("Picker");
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(20, 20));
        this.addActionListener(new ToolSelectEventListener(canvasPanel));
    }
}
