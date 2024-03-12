//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Ball class draws balls (which are circles) and move them across the screen.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Ball.
     *
     * @param center the center of ball
     * @param r      the radius of ball
     * @param color  the color of ball
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x     the x value of the center point of ball
     * @param y     the y value of the center point of ball
     * @param r     the r of ball
     * @param color the color of ball
     */
    public Ball(int x, int y, int r, Color color) {

        this(new Point(x, y), r, color);
    }


    /**
     * Returns the x value of the center point of ball.
     *
     * @return the x value
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Returns the y value of the center point of ball.
     *
     * @return the y value
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Returns the radius of ball.
     *
     * @return the radius
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Returns the color of ball.
     *
     * @return the color of ball
     */
    public Color getColor() {
        return this.color;
    }


    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Set the velocity of ball.
     *
     * @param v1 the velocity
     */
    public void setVelocity(Velocity v1) {

        this.v = v1;
    }

    /**
     * Set the velocity of ball.
     *
     * @param dx the step on the x axis
     * @param dy the step on the y axis
     */
    public void setVelocity(double dx, double dy) {

        this.v = new Velocity(dx, dy);
    }

    /**
     * Returns the velocity of ball.
     *
     * @return the velocity of ball
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Moves one step.
     */
    public void moveOneStep() {
        //Checks the trajectory of the ball and if it is going to hit a collidable it changes his velocity
        if (this.getVelocity() != null) {
            Line trajectory = new Line(this.center, new Point(this.center.getX() + this.v.getDx(),
                    this.center.getY() + this.v.getDy()));
            CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
            //If there is a collidable it updates the new velocity
            if (collisionInfo != null) {
                this.v = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.v);
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment1 the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Add the ball to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * Removes this ball from the game it gets.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    /**
     * Sets the radius of the ball.
     *
     * @param i the new radius
     */
    public void setR(int i) {
        this.r = i;
    }


}