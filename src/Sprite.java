import biuoop.DrawSurface;

/**
 * An interface - Sprite.
 * Sprites can be drawn on the screen, and can be notified that time has passed
 * (so that they know to change their position / shape / appearance / etc).
 */
public interface Sprite {
    /**
     * draws the sprite to the screen.
     *
     * @param d the DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * Notifies the sprite that time has passed.
     */
    void timePassed();
}
