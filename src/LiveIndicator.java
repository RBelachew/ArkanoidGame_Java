//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ScoreIndicator is a sprite which will be in charge of displaying the current score.
 * The ScoreIndicator will hold a reference to the scores counter,
 * and will be added to the game as a sprite positioned at the top of the screen.
 */
public class LiveIndicator implements Sprite {
    private Counter lives;

    /**
     * Instantiates a new Score indicator.
     *
     * @param lives the score counter
     */
    public LiveIndicator(Counter lives) {
        this.lives = lives;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(20, 20, "Lives:" + this.lives.getValue(), 15);
    }

    @Override
    public void timePassed() {

    }
}