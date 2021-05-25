package EventListener;

import GUI.MainPanels.CanvasPanel;
import Method.Method;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BrushSizeListener extends DocumentFilter implements FocusListener {
    Method method;
    JTextField textField;

    public BrushSizeListener(CanvasPanel canvasPanel, JTextField textField) {
        method = new Method(canvasPanel);
        this.textField = textField;
    }

    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet a) throws BadLocationException {
        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text += str;
        System.out.printf("%d, %d, %s", offset, length, str);
        if (offset == 0 && str.equals("0")) {
            return;
        }
        if ((fb.getDocument().getLength() + str.length() - length) <= 2 && text.matches("[0-9]+")) {
            super.replace(fb, offset, length, str, a);
        }
        method.setBrushRadius(Integer.parseInt(textField.getText()));
    }

    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        if (fb.getDocument().getLength() - length == 0) {
            method.setBrushRadius(1);
        }
        super.remove(fb, offset, length);
    }

    @Override
    public void focusGained(FocusEvent e) {
        textField.selectAll();
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().equals("")) {
            textField.setText("1");
        }
        method.setBrushRadius(Integer.parseInt(textField.getText()));
    }
}
