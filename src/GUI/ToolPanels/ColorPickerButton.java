package GUI.ToolPanels;

import EventListener.ToolSelectEventListener;
import GUI.MainPanels.CanvasPanel;
import Method.Variables;

import javax.swing.*;
import java.awt.*;

public class ColorPickerButton extends JButton {
    CanvasPanel canvasPanel;

    public ColorPickerButton(CanvasPanel canvasPanel) {
        Variables.addToolButtons(this);
        this.canvasPanel = canvasPanel;
        this.setText("Picker");
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(40, 20));
        this.addActionListener(new ToolSelectEventListener(canvasPanel));
    }
}
