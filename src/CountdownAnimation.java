//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will appear on the screen for (numOfSeconds / countFrom)
 * seconds, before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private double counter;


    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the number of seconds
     * @param countFrom    the integer we count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.counter = countFrom;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        d.drawText(400, 250, (int) (counter + 1) + "", 50);
        this.counter = this.counter - (this.countFrom / this.numOfSeconds) / (1000 / 60);
    }
    @Override
    public boolean shouldStop() {
        return counter <= 0;
    }

}