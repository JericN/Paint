package GUI.ToolPanels;

import EventListener.ToolSelectEventListener;
import GUI.MainPanels.CanvasPanel;
import Method.Variables;

import javax.swing.*;
import java.awt.*;

public class FillButton extends JButton {
    CanvasPanel canvasPanel;

    public FillButton(CanvasPanel canvasPanel) {
        Variables.addToolButtons(this);
        this.canvasPanel = canvasPanel;
        this.setText("Fill");
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(40, 20));
        this.addActionListener(new ToolSelectEventListener(canvasPanel, this));
    }
}
