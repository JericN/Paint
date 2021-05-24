package EventListener;


import GUI.CanvasPanels.CanvasPanel;
import GUI.ToolPanels.ColorPickerButton;
import GUI.ToolPanels.EraserButton;
import GUI.ToolPanels.PaintButton;
import Method.Method;
import Enum.ToolType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolSelectEventListener implements ActionListener {
    Method method;
    public ToolSelectEventListener(CanvasPanel canvasPanel) {
        this.method = new Method(canvasPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src instanceof PaintButton){
            CanvasEventListener.type = ToolType.PAINT;
        }else if (src instanceof EraserButton){
            CanvasEventListener.type = ToolType.ERASER;
        }else if (src instanceof ColorPickerButton){
            CanvasEventListener.type = ToolType.COLOR_PICKER;
        }
    }
}
