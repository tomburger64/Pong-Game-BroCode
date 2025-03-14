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

    // empty object type vars ↓
    Thread gameThread; // a thread runs code independently (useful for listening for inputs)
    Image image; // is used for "drawing" everything before showing it on screen
    Graphics graphics; // is like a paintbrush, it can draw shapes, images, text, etc, has methods for drawing the wanted stuff
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
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBall() {

    }

    public void newPaddles() {

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight()); // using methods instead of the vars in case the gamepanel size was automatically adjusted (probably due to OS I guess ?)
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {

    }

    public void move() {

    }

    public void checkCollision() {

    }

    public void run() {
        // game loop, updates positions, collisions, etc, also refreshes the screen
        // long type is like an int but can store bigger value
        long lastTime = System.nanoTime(); // gets the current time ("nano", so really precisely ig)

        double amountOfTicks = 60.0; // update the game at 60 fps
        double ns = 1000000000 / amountOfTicks; // how many nanoseconds per frame
        double delta = 0; // used to track when the update should happen
        while(true) {
            long now = System.nanoTime(); // gets current time in nanoseconds
            delta += (now -lastTime)/ns; // add the time difference to delta (between first nanotime measurement and the lastly run one)
            lastTime = now; // update the lastTime

            if (delta >= 1) { // if enough time has passed for an update
                move(); // updates objects positions
                checkCollision(); // updates collisions
                repaint(); // redraws the screen
                delta--; // not exactly but resets delta to 0
            }
        }
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
