package EventListener;

import GUI.CanvasPanels.CanvasPanel;
import Method.ToolMethod;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class DocumentFilterListener extends DocumentFilter implements DocumentListener{
    ToolMethod method;
    public DocumentFilterListener(CanvasPanel canvasPanel) {
        method = new ToolMethod(canvasPanel);
    }
    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
        System.out.printf("%d, %d, %s\n\n",offs,length,str);
        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text += str;
        if(offs==0 && str.equals("0")){
            return;
        }
        if ((fb.getDocument().getLength() + str.length() - length) <= 2 && text.matches("[0-9]+")) {
            super.replace(fb, offs, length, str, a);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("here");
        String text = null;
        try {
            text = e.getDocument().getText(0, e.getDocument().getLength());
        } catch (BadLocationException badLocationException) {
            badLocationException.printStackTrace();
        }
        method.setBrushSize(Integer.parseInt(text));
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("here");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("here");
    }
}
