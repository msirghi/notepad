package notepad.features;

import javax.swing.*;

public class NewTab extends JPanel {
    private JTextArea textArea;
    private JTabbedPane jTabbedPane;
    private static int tabCounter = 1;

    public NewTab(JTextArea textArea, JTabbedPane jTabbedPane) {
        this.textArea = textArea;
        this.jTabbedPane = jTabbedPane;

        openNewTab();
    }

    private void openNewTab() {
        jTabbedPane.addTab("Document " + ++tabCounter, new JScrollPane(textArea));
        jTabbedPane.setSelectedIndex(tabCounter - 1);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
