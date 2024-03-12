//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A Block class implements the Collidable ,Sprite and HitNotifier interfaces.
 * Block is going to be something we collide into.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private int hitPoint;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     * @param hitPoint  the number appears on the block
     */
    public Block(Rectangle rectangle, Color color, int hitPoint) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitPoint = hitPoint;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     */
    public Block(Rectangle rectangle) {
        this(rectangle, Color.BLACK, 0);
    }

    /**
     * @Override
     * Returns the "collision shape" of the object.
     *
     * @return rectangle-the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    /**
     * @Override
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint     the collision point
     * @param currentVelocity    the current velocity
     * @param hitter    the hitter ball
     * @return velocity returns a new velocity expected after the hit
     *
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        //Updates the new score which appears on the block after the hit
        if (hitPoint > 0) {
            hitPoint--;
        }
        //top border
        if ((Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) <= 0.1)
                && currentVelocity.getDy() > 0) {
            newVelocity = new Velocity(newVelocity.getDx(), newVelocity.getDy() * -1);
            //bottom border
        } else if ((Math.abs(collisionPoint.getY() - this.rectangle.getLowerRight().getY()) <= 0.1)
                && currentVelocity.getDy() < 0) {
            newVelocity = new Velocity(newVelocity.getDx(), newVelocity.getDy() * -1);
        }
        //left border
        if ((Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) <= 0.1)
                && currentVelocity.getDx() > 0) {
            newVelocity = new Velocity(newVelocity.getDx() * -1, newVelocity.getDy());
            //right border
        } else if ((Math.abs(collisionPoint.getX() - this.rectangle.getLowerRight().getX()) <= 0.1)
                && currentVelocity.getDx() < 0) {
            newVelocity = new Velocity(newVelocity.getDx() * -1, newVelocity.getDy());
        }

        this.notifyHit(hitter);

        return newVelocity;
    }
    /**
     * @Override
     * Gets a DrawSurface and draws the block.
     *
     * @param d     the DrawSurface
     *
     */
    public void drawOn(DrawSurface d) {
        //Fills rectangle with its color
        d.setColor(this.color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //Draws rectangle with black
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());

    }
    /**
     * @Override
     * Just for now without implements.
     */
    public void timePassed() {
    }

    /**
     * Add to game this block.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * Sets the rectangle of the block.
     *
     * @param rectangle1 the rectangle
     */
    public void setRectangle(Rectangle rectangle1) {
        this.rectangle = rectangle1;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Removes this block from the game it gets.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
    /**
     *  It will be called whenever a hit() occurs, and notifiers all of the registered
     *  HitListener objects by calling their hitEvent method.
     *
     * @param hitter the hitter ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        // Adds hl as a listener to hit events.
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        //Removes hl from the list of listeners to hit events.
        this.hitListeners.remove(hl);
    }

    /**
     * Returns the number appears on the block.
     *
     * @return the number appears on the block
     */
    public int getHitPoint() {
        return this.hitPoint;
    }

}