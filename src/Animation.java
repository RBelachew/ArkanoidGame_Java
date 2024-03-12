//ID: 324488287
import biuoop.DrawSurface;

/**
 * The interface Animation holds game-specific logic and stopping conditions methods which could be
 * differ from class to class.
 */
public interface Animation {
    /**
     * Does one frame of level.doOneFrame(DrawSurface) is in charge of the game-specific logic.
     * Like displaying the sprites and notifying them time has passed, and keeping track of the
     * number of balls and blocks.
     *
     * @param d the draw surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * ShouldStop() is in charge of stopping conditions.
     *
     * @return the a boolean value
     */
    boolean shouldStop();


}
