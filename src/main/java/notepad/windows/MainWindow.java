package notepad.windows;

import notepad.features.ChangeFontSize;
import notepad.features.Highlighter;
import notepad.features.LineCounter;

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
import java.security.KeyStore;


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

    private void initShortcuts() {
        cutText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        copyText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        pasteText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
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
        initShortcuts();
    }

    public MainWindow() {
        initComponents();
        initIcons();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        changeFontSize = new ChangeFontSize(this);
        aboutWindow = new AboutWindow(this);
        lineCounter = new LineCounter(textArea, jScrollPane1);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton toolbar_new = new JButton(new ImageIcon(this.getClass().getResource("src/main/res/new.png")));
        toolbar_new.setToolTipText("Kek");
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(toolbar_new);
    }

    public void changeFontSize(int size) {
        textArea.setFont(new Font("Courier", Font.PLAIN, size));
        lineCounter.getLines().setFont(new Font("Courier", Font.PLAIN, size));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cutText = new javax.swing.JMenuItem();
        copyText = new javax.swing.JMenuItem();
        pasteText = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchButton.setText("Search");
        searchButton.setPreferredSize(new Dimension(70, 23));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jMenu1.add(newFile);

        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveFile);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        cutText.setText("Cut");
        cutText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutTextActionPerformed(evt);
            }
        });
        jMenu2.add(cutText);

        copyText.setText("Copy");
        copyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTextActionPerformed(evt);
            }
        });
        jMenu2.add(copyText);

        pasteText.setText("Paste");
        pasteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteTextActionPerformed(evt);
            }
        });
        jMenu2.add(pasteText);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.setText("");
        setTitle(filename);
    }

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {
        FileDialog fileDialog = new FileDialog(MainWindow.this, "Open File",
                                FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(!fileDialog.getFile().equals(null)) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();

            String line = null;

            while((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                textArea.setText(sb.toString());
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("Error. File not found.");
        }
    }

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void cutTextActionPerformed(java.awt.event.ActionEvent evt) {
        String cutString = textArea.getSelectedText();
        StringSelection cutSelection = new StringSelection(cutString);
        clipboard.setContents(cutSelection, cutSelection);
        textArea.replaceRange("", textArea.getSelectionStart(),
                textArea.getSelectionEnd());
    }

    private void copyTextActionPerformed(java.awt.event.ActionEvent evt) {
        String copyText = textArea.getSelectedText();
        StringSelection copySelection = new StringSelection(copyText);
        clipboard.setContents(copySelection, copySelection);
    }

    private void pasteTextActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Transferable pasteText = clipboard.getContents(MainWindow.this);
            String sel = (String) pasteText
                    .getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(sel, textArea.getSelectionStart(),
                    textArea.getSelectionEnd());
        } catch(Exception e) {
            System.out.println("Error.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    private javax.swing.JMenuItem copyText;
    private javax.swing.JMenuItem cutText;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem pasteText;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
