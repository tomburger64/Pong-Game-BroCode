import java.awt.*;
import java.awt.event.*;
import java.util.*; // ← I doubt importing everything will be worth it perf wise, but I mean come on it's a pong game
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    /*
    * GAME_WIDTH var ↓ :
    * static so that all objects use this var from the class and not from their own individual instances
    *
    * final is like const in javascript (just learned it)
    * used so that it doesn't accidentally change at some point
    * (didn't sound so bad until I thought about something like 8 quintillion)
    *
    * Also when using final always capitalize the var name (just a convention)
    * value is in pixels
    */
    static final int GAME_WIDTH = 1000;
    
    // GAME_HEIGHT ↓ :
    // (int) means it's cutting of the decimal part of the var so that it keeps being an int
    // this calculation is to keep the ratio of an irl ping pong table
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (5.0/9));

    // used in gamepanel constructor
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    // empty vars that only accept object type values ↓
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1; // player 1
    Paddle paddle2; // player 2
    Ball ball;
    Score score;

    public GamePanel() {
        // create new paddles & ball on start
        newPaddles();
        newBall();
        // create new score obj while sending the GamePanel dimensions too
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true); // makes a window listen for keyboard inputs
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        // fist time I touch a thread
        // a thread runs code independently (useful for listening for inputs)
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBall() {

    }

    public void newPaddles() {

    }

    public void paint(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void move() {

    }

    public void checkCollision() {

    }

    public void run() {

    }

    // innerclass (first time I use one)
    // manages the kb inputs
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {

        }
    }

}
