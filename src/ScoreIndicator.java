//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ScoreIndicator is a sprite which will be in charge of displaying the current score.
 * The ScoreIndicator will hold a reference to the scores counter,
 * and will be added to the game as a sprite positioned at the top of the screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score counter
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 25);
        d.setColor(Color.BLACK);
        d.drawText(300, 20, "Score: " + this.score.getValue(), 15);
    }

    @Override
    public void timePassed() {

    }
}