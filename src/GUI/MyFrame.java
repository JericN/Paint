package GUI;
import GUI.CanvasPanels.*;
import GUI.ToolPanels.*;

import Method.Method;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MyFrame{
    JFrame frame;
    CanvasPanel canvasPanel;
    JPanel toolPanel;
    Method method;
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
        method = new Method(canvasPanel);
        frame.add(canvasPanel);

    }
    public void setToolPanel() {
        toolPanel = new ToolPanel(canvasPanel);
        frame.add(toolPanel);
    }

}
