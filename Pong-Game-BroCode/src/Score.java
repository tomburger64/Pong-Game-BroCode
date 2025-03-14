import java.awt.*;
import java.awt.event.*;
import java.util.*; // ← I doubt importing everything will be worth it perf wise, but I mean come on it's a pong game
import javax.swing.*;

public class Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1; // p1 score
    int player2; // p2 score

    // My guess is we're passing the gamepanel dims so we can show the score where we want relatively
    public Score(int GAME_WIDTH, int GAME_HEIGHT) {

    }

    public void drawScore(Graphics g) {

    }
}
