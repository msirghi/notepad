package notepad.features;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;

public class LineCounter {
    private static JTextArea textArea;
    private static JTextArea lines;
    private static JScrollPane jScrollPane1;

    public LineCounter(JTextArea textArea, JScrollPane jScrollPane1) {
        LineCounter.textArea = textArea;
        LineCounter.jScrollPane1 = jScrollPane1;
        LineCounter.lines = new JTextArea("  1 ");
        displayCounter();
    }

    private void displayCounter() {
        lines.setBackground(Color.LIGHT_GRAY);
        lines.setEditable(false);
        textArea.add(lines);
        textArea.getDocument().addDocumentListener(new DocumentListener(){
            private String getText(){
                int caretPosition = textArea.getDocument().getLength();
                Element root = textArea.getDocument().getDefaultRootElement();
                String text = "  1 " + System.getProperty("line.separator");
                int i = 2;
                while (i < root.getElementIndex(caretPosition) + 2) {
                    if(i == 2)
                        text += "  " + i + " " + System.getProperty("line.separator") + " ";
                    else if(i < 10)
                        text += " " +  i + " " + System.getProperty("line.separator") + " ";
                    else if(i < 100)
                        text += " " +  i + "  " + System.getProperty("line.separator") + " ";
                    else if(i < 1000)
                        text += " " +  i + "   " + System.getProperty("line.separator") + " ";
                    else if(i < 10000)
                        text += " " +  i + "    " + System.getProperty("line.separator") + " ";
                    else
                        text += " " +  i + "    " + System.getProperty("line.separator") + " ";
                    i++;
                }
                return text;
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

            @Override
            public void insertUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

        });
        jScrollPane1.getViewport().add(textArea);
        jScrollPane1.setRowHeaderView(lines);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
