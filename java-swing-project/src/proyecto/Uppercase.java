package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Uppercase {
    
    public static class UppercaseListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char ch = e.getKeyChar();
            if (Character.isLowerCase(ch)) {
                e.consume(); // Prevent default behavior (displaying character)
                ((JTextField) e.getSource()).replaceSelection(String.valueOf(Character.toUpperCase(ch)));
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // No action needed here
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // No action needed here
        }
    }
}
