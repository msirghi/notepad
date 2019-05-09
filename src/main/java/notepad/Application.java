package notepad;

import notepad.windows.MainWindow;

import javax.swing.*;

/**
 * Starting Point
 *
 * @author Serven
 */
public class Application {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setTitle("Notepad 1.0");
        window.setBounds(0, 0, 700, 700);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
