import java.awt.*;
import java.awt.event.*;
import java.util.*; // ← I doubt importing everything will be worth it perf wise, but I mean come on it's a pong game
import javax.swing.*;

// holds a gamepanel
// basically the window that holds mini/maximize + close button, nothing more
public class GameFrame extends JFrame {

    // empty var of object type (I'm new to those)
    GamePanel panel;

    public GameFrame() {
        panel = new GamePanel();

        // methods from mostly java.awt.* and javax.swing.* imports
        this.add(panel); // adds gamepanel to the frame
        this.setTitle("Pong Game");
        this.setResizable(false); // can the user resize the window
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ↓ adjusts the size of the Jframe to fit the gamepanel's
        this.pack(); // from Jframe (javax.swing)
        this.setVisible(true); // sets if it's visible (duh)
        this.setLocationRelativeTo(null); // makes frame appear at center of screen (by default top left)
    }

}
