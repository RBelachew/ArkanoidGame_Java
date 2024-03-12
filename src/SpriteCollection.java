//ID: 324488287
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * SpriteCollection class will hold a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> listOfSprites = new ArrayList<>();

    /**
     * Adds a sprite to list.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        listOfSprites.add(s);
    }

    /**
     * Notifies all time passed.Call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> listOfSprites1 = new ArrayList<>(this.listOfSprites);
        for (Sprite p: listOfSprites1) {
            p.timePassed();
        }
    }

    /**
     * Calls drawOn(d) on all sprites.
     *
     * @param d the DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> listOfSprites1 = new ArrayList<>(this.listOfSprites);
        for (Sprite p: listOfSprites1) {
            p.drawOn(d);
        }
    }

    /**
     * Returns the list of sprites.
     *
     * @return the list of sprites
     */
    public List<Sprite> getListOfSprites() {
        return this.listOfSprites;
    }
}