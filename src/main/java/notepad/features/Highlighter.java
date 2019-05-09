/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad.features;

import javax.swing.text.DefaultHighlighter;
import java.awt.*;

/**
 *
 * @author Serven
 */
public class Highlighter extends DefaultHighlighter.DefaultHighlightPainter {

    public Highlighter(Color c) {
        super(c);
    }
}
