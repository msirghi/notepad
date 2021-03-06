package notepad;

import notepad.features.ChangeFontSize;
import notepad.windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * Starting Point
 *
 * @author msirghi
 */
public class Application {
    private static Logger logger = Logger.getLogger(ChangeFontSize.class.getName());

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setTitle("Notepad 0.2");
        window.setBounds(0, 0, 700, 700);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
        window.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/res/browse.png");
        window.setIconImage(icon.getImage());
        logger.info("Application started.");
    }

}
