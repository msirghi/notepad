package notepad.windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutWindow extends JFrame {
    private MainWindow mainWindow;
    private JMenuBar bar;

    public AboutWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        bar = mainWindow.getJMenuBar();
        displayAboutWindow(new JFrame("About"));
    }

    private void displayAboutWindow(JFrame aboutWindow) {
        JMenu about = new JMenu("About");
        bar.add(about);
        JMenuItem aboutFrame = new JMenuItem("About");
        about.add(aboutFrame);
        JLabel textInAbout = new JLabel("About Window", JLabel.CENTER);
        textInAbout.setAlignmentX(0);
        textInAbout.setAlignmentY(0);

        aboutFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutWindow.setSize(300,300);
                aboutWindow.setResizable(false);
                aboutWindow.setLocationRelativeTo(null);
                aboutWindow.setVisible(true);
                aboutWindow.add(textInAbout);
            }
        });
    }
}
