import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ScoreIndicator is a sprite which will be in charge of displaying the current score.
 * The ScoreIndicator will hold a reference to the scores counter,
 * and will be added to the game as a sprite positioned at the top of the screen.
 */
public class GameIndicator implements Sprite {
    private String nameOfLevel;

    /**
     * Instantiates a new Score indicator.
     *
     * @param nameOfLevel the score counter
     */
    public GameIndicator(String nameOfLevel) {
        this.nameOfLevel = nameOfLevel;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(500, 20, "Level Name: " + this.nameOfLevel, 15);
    }

    @Override
    public void timePassed() {

    }
}
