package notepad.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

public class ChangeFontSize extends JFrame {
    private int size;
    private JLabel warning;
    static Logger logger = Logger.getLogger(ChangeFontSize.class.getName());
    JPanel jPanel;

    private MainWindow mainWindow;

    public ChangeFontSize(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        JFrame changeSizeWindow = new JFrame("Change Size");
        display(changeSizeWindow);
    }

    private void display(JFrame changeSizeWindow) {
        JMenu options = new JMenu("Options");
        JMenuBar bar = mainWindow.getJMenuBar();
        bar.add(options);
        JMenuItem frame = new JMenuItem("Change Size");
        options.add(frame);

        JLabel label = new JLabel("Set font size", JLabel.LEFT);
        label.setAlignmentX(0);
        label.setAlignmentY(0);

        JTextField jTextField = new JTextField(10);
        changeSizeWindow.getContentPane().setLayout(new FlowLayout());
        JButton button = new JButton("set");

        frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSizeWindow.setSize(250,100);
                changeSizeWindow.setResizable(false);
                changeSizeWindow.setLocationRelativeTo(null);
                changeSizeWindow.setVisible(true);
                changeSizeWindow.add(label);
                changeSizeWindow.add(jTextField);
                changeSizeWindow.add(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { try {
                            size = new Integer(jTextField.getText());
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Wrong format!","Warning",
                                    JOptionPane.ERROR_MESSAGE);
                            logger.warning("Wrong font size format!");
                            return;
                        }
                        mainWindow.changeSize(size);
                        changeSizeWindow.setVisible(false);
                    }
                });
            }
        });
    }

}
