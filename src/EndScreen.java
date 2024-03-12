//ID: 324488287
import biuoop.DrawSurface;

/**
 * Once the game is over (either the player died, or he managed to clear all the levels),
 * we will display the final score.
 */
public class EndScreen implements Animation {
    private String endScreen;

    /**
     * Instantiates a new End screen.
     *
     * @param status Message of game results
     */
    public EndScreen(String status) {
        this.endScreen = status;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(160, d.getHeight() / 2, this.endScreen, 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
