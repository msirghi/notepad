package notepad;

import notepad.windows.ChangeFontSize;
import notepad.windows.MainWindow;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * Starting Point
 *
 * @author Serven
 */
public class Application {
    static Logger logger = Logger.getLogger(ChangeFontSize.class.getName());

    public static void main(String[] args) {
        logger.info("Application started.");
        MainWindow window = new MainWindow();
        window.setTitle("Notepad 1.0");
        window.setBounds(0, 0, 700, 700);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
