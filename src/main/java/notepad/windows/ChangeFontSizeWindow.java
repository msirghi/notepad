package notepad.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

public class ChangeFontSizeWindow extends JFrame {
    private int size;
    private JLabel warning;
    private static Logger logger = Logger.getLogger(ChangeFontSizeWindow.class.getName());
    private static JMenuBar bar;
    private MainWindow mainWindow;

    public ChangeFontSizeWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        bar = mainWindow.getJMenuBar();
        displayChangeFontSizeWindow(new JFrame("Change Size"));
    }

    private void displayChangeFontSizeWindow(JFrame changeFontSizeWindow) {
        JMenu options = new JMenu("Options");
        bar.add(options);
        JMenuItem changeSizeFrame = new JMenuItem("Change Size");
        options.add(changeSizeFrame);

        JLabel label = new JLabel("Set font size", JLabel.LEFT);
        label.setAlignmentX(0);
        label.setAlignmentY(0);

        JTextField jTextField = new JTextField(10);
        changeFontSizeWindow.getContentPane().setLayout(new FlowLayout());
        JButton button = new JButton("set");

        changeSizeFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFontSizeWindow.setSize(250,100);
                changeFontSizeWindow.setResizable(false);
                changeFontSizeWindow.setLocationRelativeTo(null);
                changeFontSizeWindow.setVisible(true);
                changeFontSizeWindow.add(label);
                changeFontSizeWindow.add(jTextField);
                changeFontSizeWindow.add(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            size = new Integer(jTextField.getText());
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Wrong format!","Warning",
                                    JOptionPane.ERROR_MESSAGE);
                            logger.warning("Wrong font size format!");
                            return;
                        }
                        mainWindow.changeFontSize(size);
                        changeFontSizeWindow.setVisible(false);
                    }
                });
            }
        });
    }

}
