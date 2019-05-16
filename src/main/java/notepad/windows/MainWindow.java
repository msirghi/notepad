package notepad.windows;

import notepad.features.ChangeFontSize;
import notepad.features.Highlighter;
import notepad.features.LineCounter;
import notepad.features.NewTab;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.logging.Logger;


/**
 * Main Frame for Application
 * @author msirghi
 */
public class MainWindow extends javax.swing.JFrame {
    private AboutWindow aboutWindow;
    private ChangeFontSize changeFontSize;
    private LineCounter lineCounter;
    private String filename;
    private Clipboard clipboard = getToolkit().getSystemClipboard();
    private DefaultHighlighter.DefaultHighlightPainter highlighter = new Highlighter(Color.YELLOW);
    private static Logger logger = Logger.getLogger(ChangeFontSize.class.getName());

    private JMenuItem copyText;
    private JMenuItem cutText;
    private JMenuItem exit;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JPanel statusPanel;
    private JScrollPane jScrollPane1;
    private JMenuItem newFile;
    private JMenuItem openFile;
    private JMenuItem pasteText;
    private JMenuItem saveFile;
    private JButton searchButton;
    private JTextField searchField;
    private JTextArea textArea;
    private JTabbedPane jTabbedPane2;
    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JButton undoButton;
    private JButton copyButton;
    private JButton cutButton;
    private JButton pasteButton;
    private JButton functionButton1;
    private JButton functionButton2;
    private JButton printButton;

    private NewTab newTab;

    private void initShortcuts() {
        cutText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        copyText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        pasteText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
    }

    private void initIcons() {
        try {
            ImageIcon newFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/new.png")));
            ImageIcon openFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/open.png")));
            ImageIcon saveFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/save.png")));
            ImageIcon cutFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/cut.png")));
            ImageIcon copyFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/copy.png")));
            ImageIcon pasteFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/paste.png")));
            ImageIcon exitFileIcon = new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/exit.png")));

            newFile.setIcon(newFileIcon);
            saveFile.setIcon(saveFileIcon);
            openFile.setIcon(openFileIcon);
            cutText.setIcon(cutFileIcon);
            copyText.setIcon(copyFileIcon);
            pasteText.setIcon(pasteFileIcon);
            exit.setIcon(exitFileIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MainWindow() {
        initializeComponents();
        initIcons();
        initShortcuts();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        changeFontSize = new ChangeFontSize(this);
        aboutWindow = new AboutWindow(this);
        lineCounter = new LineCounter(textArea, jScrollPane1);
        jScrollPane1.setViewportView(textArea);
        jTabbedPane2.addTab("Document 1", jScrollPane1);
    }

    public void changeFontSize(int size) {
        textArea.setFont(new Font("Courier", Font.PLAIN, size));
        lineCounter.getLines().setFont(new Font("Courier", Font.PLAIN, size));
    }

    private void featureComponents() {
        newButton.setContentAreaFilled(true);
        openButton.setContentAreaFilled(true);
        saveButton.setContentAreaFilled(true);
        printButton.setContentAreaFilled(true);
        cutButton.setContentAreaFilled(true);
        copyButton.setContentAreaFilled(true);
        pasteButton.setContentAreaFilled(true);
        functionButton1.setContentAreaFilled(true);
        functionButton2.setContentAreaFilled(true);

        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        saveButton.addActionListener(this::saveFileActionPerformed);

        openButton.setFocusable(false);
        openButton.setHorizontalTextPosition(SwingConstants.CENTER);
        openButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        openButton.addActionListener(this::openFileActionPerformed);

        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(SwingConstants.CENTER);
        newButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        newButton.addActionListener(this::newFileActionPerformed);

        printButton.setFocusable(false);
        printButton.setHorizontalTextPosition(SwingConstants.CENTER);
        printButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        printButton.addActionListener(this::printButtonActionPerformed);

        cutButton.setFocusable(false);
        cutButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cutButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        cutButton.addActionListener(this::cutTextActionPerformed);

        pasteButton.setFocusable(false);
        pasteButton.setHorizontalTextPosition(SwingConstants.CENTER);
        pasteButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        pasteButton.addActionListener(this::pasteTextActionPerformed);

        copyButton.setFocusable(false);
        copyButton.setHorizontalTextPosition(SwingConstants.CENTER);
        copyButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        copyButton.addActionListener(this::copyTextActionPerformed);

        undoButton.setFocusable(false);
        undoButton.setHorizontalTextPosition(SwingConstants.CENTER);
        undoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        undoButton.addActionListener(this::undoButtonActionPerformed);

        functionButton1.setFocusable(false);
        functionButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        functionButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
        functionButton1.addActionListener(this::functionButton1ActionPerformed);

        functionButton2.setFocusable(false);
        functionButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        functionButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        functionButton2.addActionListener(this::functionButton2ActionPerformed);

        jMenu1.setText("File");

        newFile.setText("New");
        newFile.addActionListener(this::newFileActionPerformed);
        jMenu1.add(newFile);

        openFile.setText("Open");
        openFile.addActionListener(this::openFileActionPerformed);
        jMenu1.add(openFile);

        saveFile.setText("Save");
        saveFile.addActionListener(this::saveFileActionPerformed);
        jMenu1.add(saveFile);

        exit.setText("Exit");
        exit.addActionListener(this::exitActionPerformed);
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);
        jMenu2.setText("Edit");

        cutText.setText("Cut");
        cutText.addActionListener(this::cutTextActionPerformed);
        jMenu2.add(cutText);

        copyText.setText("Copy");
        copyText.addActionListener(this::copyTextActionPerformed);
        jMenu2.add(copyText);

        pasteText.setText("Paste");
        pasteText.addActionListener(this::pasteTextActionPerformed);
        jMenu2.add(pasteText);

        jMenuBar1.add(jMenu2);
        setJMenuBar(jMenuBar1);
    }

    private void initializeComponents() {
        functionButton1 = new JButton();
        functionButton2 = new JButton();
        cutButton = new JButton();
        pasteButton = new JButton();
        copyButton = new JButton();
        undoButton = new JButton();
        printButton = new JButton();
        statusPanel = new JPanel();
        jTabbedPane2 = new JTabbedPane();
        searchButton = new JButton();
        searchField = new JTextField();
        jScrollPane1 = new JScrollPane();
        textArea = new JTextArea();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        newFile = new JMenuItem();
        openFile = new JMenuItem();
        saveFile = new JMenuItem();
        exit = new JMenuItem();
        jMenu2 = new JMenu();
        cutText = new JMenuItem();
        copyText = new JMenuItem();
        pasteText = new JMenuItem();
        try {
            openButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/open.png"))));
            saveButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/save.png"))));
            newButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/new.png"))));
            copyButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/copy.png"))));
            pasteButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/paste.png"))));
            cutButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/cut.png"))));
            undoButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/undo.png"))));
            printButton = new JButton(new ImageIcon(ImageIO.read(new FileInputStream("src/main/res/print.png"))));

        } catch (IOException e) {
            e.printStackTrace();
        }

        GroupLayout statusPanelLayout = new GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
                statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
                statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 8, Short.MAX_VALUE)
        );


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        searchButton.setText("Search");
        searchButton.setPreferredSize(new Dimension(70, 23));
        searchButton.addActionListener(this::searchButtonActionPerformed);
        searchField.addActionListener(this::searchFieldActionPerformed);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        GroupLayout jPanel1Layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );

        featureComponents();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane2)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(openButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(printButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cutButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pasteButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(copyButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(undoButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(functionButton1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addComponent(functionButton2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(statusPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(openButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(saveButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(printButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cutButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pasteButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(copyButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(undoButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(functionButton1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(functionButton2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane2, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextArea(textArea, searchField.getText());
    }

    private void removeHighLight(JTextComponent textComp) {
        javax.swing.text.Highlighter removeHigh = textComp.getHighlighter();
        javax.swing.text.Highlighter.Highlight[] removeHighlighted = removeHigh.getHighlights();

        for (javax.swing.text.Highlighter.Highlight highlight : removeHighlighted) {
            if (highlight.getPainter() instanceof Highlighter) {
                removeHigh.removeHighlight(highlight);
            }
        }
    }

    private void searchTextArea(JTextComponent textComponent, String textString) {
        removeHighLight(textComponent);
        if(textString.length() == 0)
            return;

        try {
            javax.swing.text.Highlighter highlight = textComponent.getHighlighter();
            Document document = textComponent.getDocument();
            String text = document.getText(0, document.getLength());

            int position = 0;
            while((position = text.toUpperCase().indexOf(textString.toUpperCase(), position)) >= 0) {
                highlight.addHighlight(position, position+textString.length(), highlighter);
                position += textString.length();
            }
        } catch (Exception e) {
            System.out.println("Error with searchTextArea.");
        }
    }

    private void searchFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void printButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void undoButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void functionButton1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void functionButton2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void newFileActionPerformed(ActionEvent evt) {
        textArea.setText("");
        setTitle("Notepad 0.1");
        newTab = new NewTab(new JTextArea(), jTabbedPane2);
    }

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FileDialog fileDialog = new FileDialog(MainWindow.this, "Open File", FileDialog.LOAD);
            fileDialog.setVisible(true);

            if (!fileDialog.getFile().equals(null)) {
                filename = fileDialog.getDirectory() + fileDialog.getFile();
                setTitle(filename);
            }

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                StringBuilder sb = new StringBuilder();

                newTab = new NewTab(new JTextArea() ,jTabbedPane2);

                reader.lines().forEach(line -> {
                    sb.append(line).append("\n");
                    newTab.getTextArea().setText(sb.toString());
                });
                reader.close();
            } catch (IOException e) {
                System.out.println("Error. File not found.");
            }
        } catch (NullPointerException e) {
        logger.warning("No file selected!");
    }

}
    private void saveFileActionPerformed(ActionEvent evt) {
        FileDialog fileDialog = new FileDialog(MainWindow.this, "Save File",
                FileDialog.SAVE);
        fileDialog.setVisible(true);

        if(!fileDialog.getFile().equals(null)) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
        }

        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(textArea.getText());
            setTitle(filename);
            fileWriter.close();
        } catch(IOException e) {
            System.out.println("Error occurred file.");
        }
    }

    private void exitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void cutTextActionPerformed(ActionEvent evt) {
        String cutString = textArea.getSelectedText();
        StringSelection cutSelection = new StringSelection(cutString);
        clipboard.setContents(cutSelection, cutSelection);
        textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
    }

    private void copyTextActionPerformed(ActionEvent evt) {
        String copyText = textArea.getSelectedText();
        StringSelection copySelection = new StringSelection(copyText);
        clipboard.setContents(copySelection, copySelection);
    }

    private void pasteTextActionPerformed(ActionEvent evt) {
        try {
            Transferable pasteText = clipboard.getContents(MainWindow.this);
            String sel = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(sel, textArea.getSelectionStart(), textArea.getSelectionEnd());
        } catch(Exception e) {
            System.out.println("Error in paste method.");
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
