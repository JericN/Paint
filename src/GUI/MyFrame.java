package GUI;
import GUI.CanvasPanels.*;
import GUI.ToolPanels.*;

import EventListener.MouseEventListener;
import Method.ToolMethod;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MyFrame{
    JFrame frame;
    CanvasPanel canvasPanel;
    CanvasPanel canvasPanelB;
    JPanel toolPanel;
    ToolMethod method;
    ToolMethod methodB;
    public MyFrame(){
        setMainFrame();
    }
    private void setMainFrame(){
        frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new MigLayout());
        setPanels();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void setPanels(){
        setCanvasPanel();
        setToolPanel();
    }
    public void setCanvasPanel(){
        canvasPanel = new CanvasPanel();
        method = new ToolMethod(canvasPanel);
        frame.add(canvasPanel);
        canvasPanelB = new CanvasPanel();
        methodB = new ToolMethod(canvasPanelB);
        frame.add(canvasPanelB);
    }
    public void setToolPanel() {
        toolPanel = new ToolPanel(canvasPanel);
        frame.add(toolPanel);
    }

}
