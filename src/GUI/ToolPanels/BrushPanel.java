package GUI.ToolPanels;

import EventListener.BrushEventListener;
import EventListener.ToolSelectEventListener;
import GUI.MainPanels.CanvasPanel;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import Enum.*;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class BrushPanel extends JPanel {
    JTextField brushSizeField;
    CanvasPanel canvasPanel;
    JComboBox brushType;

    public BrushPanel(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.setPreferredSize(new Dimension(200, 50));
        this.setBackground(Color.WHITE);
        MigLayout layout = new MigLayout(
                new LC().align("center", "center")
        );
        this.setLayout(layout);
        addComponents();
    }

    public void addComponents() {
        JLabel label1 = new JLabel("Brush Size: ");
        this.add(label1);
        brushSizeField = new JTextField("5");
        brushSizeField.setPreferredSize(new Dimension(50, 25));
        brushSizeField.setHorizontalAlignment(SwingConstants.CENTER);
        AbstractDocument document = (AbstractDocument) brushSizeField.getDocument();
        document.setDocumentFilter(new BrushEventListener(canvasPanel, brushSizeField));
        brushSizeField.addFocusListener(new BrushEventListener(canvasPanel, brushSizeField));
        this.add(brushSizeField);

        brushType = new JComboBox(new BrushStroke[]{BrushStroke.SLASH, BrushStroke.CIRCLE, BrushStroke.SQUARE});
        brushType.addActionListener(new ToolSelectEventListener(canvasPanel));
        this.add(brushType);
    }

}
