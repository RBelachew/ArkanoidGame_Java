//ID: 324488287
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The Paddle is the player in the game. It is a rectangle that is controlled by the arrow keys, and moves
 * according to the player key presses. It should implement the Sprite and the Collidable interfaces.
 * It should also know how to move to the left and to the right.
 */
public class Paddle implements Sprite, Collidable {
    private Block block;
    private double speed = 8;
    private KeyboardSensor keyboard;

    /**
     * Instantiates a new Paddle.
     *
     * @param keyboard the keyboard
     * @param widthOfPaddle the width of paddle
     */
    public Paddle(KeyboardSensor keyboard, int widthOfPaddle) {
        this.keyboard = keyboard;
        this.block = new Block(new Rectangle(new Point(400 - (widthOfPaddle / 2), 560),
                widthOfPaddle, 30), Color.ORANGE, 0);
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        //Makes sure the paddle will move until the left border
        if (this.getCollisionRectangle().getUpperLeft().getX() <= 25) {
            return;
        }
        Rectangle rectangle = new Rectangle(new Point(block.getCollisionRectangle().getUpperLeft().getX()
                - speed, block.getCollisionRectangle().getUpperLeft().getY()),
                this.block.getCollisionRectangle().getWidth(), this.block.getCollisionRectangle().getHeight());


        block.setRectangle(rectangle);
    }

    /**
     * Move right.
     */
    public void moveRight() {
        //Makes sure the paddle will move until the right border
        if (this.getCollisionRectangle().getUpperLeft().getX() >= 775 - this.block.getCollisionRectangle().getWidth()) {
            return;
        }
        Rectangle rectangle = new Rectangle(new Point(block.getCollisionRectangle().getUpperLeft().getX()
                + speed, block.getCollisionRectangle().getUpperLeft().getY()),
                this.block.getCollisionRectangle().getWidth(), this.block.getCollisionRectangle().getHeight());

        block.setRectangle(rectangle);
    }
    /**
     * @Override
     * Checks if the "left" or "right" keys are pressed, and if so move it accordingly.
     */
    public void timePassed() {
        //Moves left
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        //Moves right
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    /**
     * @Override
     * Gets a DrawSurface and draws the paddle.
     *
     * @param d the DrawSurface
     */
    public void drawOn(DrawSurface d) {
        //Draws rectangle of the paddle
        d.setColor(this.block.getColor());
        d.fillRectangle((int) this.block.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.block.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.block.getCollisionRectangle().getWidth(),
                (int) this.block.getCollisionRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.block.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.block.getCollisionRectangle().getWidth(),
                (int) this.block.getCollisionRectangle().getHeight());
    }



    /**
     * @Override
     * Returns the rectangle of the paddle.
     * @return the rectangle of the paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
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
        double startX = this.getCollisionRectangle().getUpperLeft().getX();
        double width = this.getCollisionRectangle().getWidth();
        double speed1 = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        //Returns the new velocity in case of the collision point is under the upper edge of paddle
        if ((collisionPoint.getY() - 0.1) > this.getCollisionRectangle().getUpperLeft().getY()) {
            return this.block.hit(hitter, collisionPoint, currentVelocity);
        }
        /*Thinks of the paddle as having 5 equally-spaced regions.
        The behavior/velocity of the ball's bounce depends on where it hits the paddle.
         */
        if (collisionPoint.getX() <= startX + (width / 5)) {
            Velocity velocity = Velocity.fromAngleAndSpeed(150, speed1);
            return velocity;
        } else if (collisionPoint.getX() <= startX + (2 * width / 5)) {
            Velocity velocity = Velocity.fromAngleAndSpeed(120, speed1);
            return velocity;
        } else if (collisionPoint.getX() <= startX + (3 * width / 5)) {
            return this.block.hit(hitter, collisionPoint, currentVelocity);
        } else if (collisionPoint.getX() <= startX + (4 * width / 5)) {
            Velocity velocity = Velocity.fromAngleAndSpeed(60, speed1);
            return velocity;
        } else {
            Velocity velocity = Velocity.fromAngleAndSpeed(30, speed1);
            return velocity;
        }
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
    /**
     * Removes this paddle from the game it gets.
     *
     * @param game the game
     */
    public void removePaddle(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

}