package notepad.features;

import notepad.windows.MainWindow;

import javax.swing.*;
import java.util.logging.Logger;

public class NewTab extends JPanel {
    private JTextArea textArea;
    private JTabbedPane jTabbedPane;
    private static int tabCounter = 1;
    private static Logger logger = Logger.getLogger(NewTab.class.getName());

    public NewTab(JTextArea textArea, JTabbedPane jTabbedPane) {
        this.textArea = textArea;
        this.jTabbedPane = jTabbedPane;
        openNewTab();
        logger.info("Tab added.");
    }

    private void openNewTab() {
        jTabbedPane.addTab("Document " + ++tabCounter, new JScrollPane(textArea));
        jTabbedPane.setSelectedIndex(tabCounter - 1);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
