import java.awt.*;
import java.awt.event.*;
import java.util.*; // ← I doubt importing everything will be worth it perf wise, but I mean come on it's a pong game
import javax.swing.*;

// holds a gamepanel
// basically the window that holds mini/maximize + close button
public class GameFrame extends JFrame {

    GamePanel panel = new GamePanel();

    public GameFrame() {

    }

}
