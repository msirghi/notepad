package notepad.windows;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HelpWindow {
    public HelpWindow(JMenu about) {
        JMenuItem help = new JMenuItem("Help");
        about.add(help);
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
        JLabel textInHelp = new JLabel("Help Window", JLabel.CENTER);
        textInHelp.setText("<html>Shortcuts:<br/>CTRL+N: new tab" +
                "<br/>CTRL+Q: close app <br/> CTRL+S: save tab" +
                "<br/>CTRL+O: open file <br/><br/>Feel free to write an email:" +
                "<br/>mr.serven@yahoo.com<br/><br/>Any help is appreciated.<br/><br/>2019</html>");
        textInHelp.setAlignmentX(0);
        textInHelp.setAlignmentY(0);
        help.addActionListener(e -> {
            JFrame helpWindow = new JFrame("Help");
            helpWindow.setSize(300,300);
            helpWindow.setResizable(false);
            helpWindow.setLocationRelativeTo(null);
            helpWindow.setVisible(true);
            helpWindow.add(textInHelp);
        });
    }
}
