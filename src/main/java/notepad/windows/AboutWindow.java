package notepad.windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutWindow extends JFrame {
    private MainWindow mainWindow;

    public AboutWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        JFrame f2 = new JFrame("About");
        display(f2);
    }

    private void display(JFrame f2) {
        JMenu about = new JMenu("About");
        JMenuBar bar = mainWindow.getJMenuBar();
        bar.add(about);
        JMenuItem frame = new JMenuItem("About");
        about.add(frame);
        JLabel label = new JLabel("About Window", JLabel.CENTER);
        label.setAlignmentX(0);
        label.setAlignmentY(0);

        frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setSize(300,300);
                f2.setResizable(false);
                f2.setLocationRelativeTo(null);
                f2.setVisible(true);
                f2.add(label);
            }
        });
    }
}
