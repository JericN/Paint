package GUI.ToolPanels;

import EventListener.DocumentFilterListener;
import GUI.CanvasPanels.CanvasPanel;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class BrushChangerPanel extends JPanel {
    JTextField brushSize;
    CanvasPanel canvasPanel;
    public BrushChangerPanel(CanvasPanel canvasPanel){
        this.canvasPanel=canvasPanel;
        this.setPreferredSize(new Dimension(200,100));
        this.setBackground(Color.WHITE);
        MigLayout layout = new MigLayout(
                new LC().align("center","center")
        );
        this.setLayout(layout);
        addComponents();
    }

    public void addComponents(){
        JLabel label1 = new JLabel("Brush Size: ");
        this.add(label1);

        brushSize = new JTextField();
        brushSize.setPreferredSize(new Dimension(100,50));
        AbstractDocument document = (AbstractDocument) brushSize.getDocument();
        document.setDocumentFilter(new DocumentFilterListener(canvasPanel));
        document.addDocumentListener(new DocumentFilterListener(canvasPanel));
        this.add(brushSize);
    }

}
