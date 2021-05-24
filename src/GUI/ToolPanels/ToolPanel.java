package GUI.ToolPanels;

import GUI.CanvasPanels.CanvasPanel;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {
    CanvasPanel canvasPanel;

    public ToolPanel(CanvasPanel canvasPanel){
        this.canvasPanel = canvasPanel;
        this.setPreferredSize(new Dimension(300,900));
        this.setBackground(Color.GRAY);
        MigLayout layout = new MigLayout(
                new LC().align("center","center")
        );
        this.setLayout(layout);
        initializeTools();
    }
    public void initializeTools(){
        this.add(new ColorPanel(canvasPanel),"wrap");
        this.add(new BrushPanel(canvasPanel),"wrap");
        this.add(new PaintButton(canvasPanel),"wrap, center");
        this.add(new EraserButton(canvasPanel),"wrap, center");
        this.add(new ColorPickerButton(canvasPanel),"wrap, center");
    }

}
