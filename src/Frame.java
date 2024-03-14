import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Frame class generates frame and is responsible for changing direction when a ball hitting the window border.
 */
public class Frame {

    private Point topLeft;
    private Point bottomRight;
    private int width;
    private int height;

    /**
     * Instantiates a new Frame.
     *
     * @param x      the x value of top left point of the frame
     * @param y      the y value of top left point of the frame
     * @param width  the width of frame
     * @param height the height of frame
     */
    public Frame(int x, int y, int width, int height) {
        this.topLeft = new Point(x, y);
        this.bottomRight = new Point(x + width, y + height);
        this.width = width;
        this.height = height;
    }

    /**
     * Changes direction when a ball hitting the window border.
     *
     * @param ball the ball
     */
    public void ballHit(Ball ball) {
        if (ball != null) {
            //top border
            if (ball.getY() - ball.getSize() <= this.topLeft.getY()) {
                ball.setVelocity(ball.getVelocity().getDx(), ball.getVelocity().getDy() * -1);
            }
            //bottom border
            if (ball.getY() + ball.getSize() >= this.bottomRight.getY()) {
                ball.setVelocity(ball.getVelocity().getDx(), ball.getVelocity().getDy() * -1);
            }
            //left border
            if (ball.getX() - ball.getSize() <= this.topLeft.getX()) {
                ball.setVelocity(ball.getVelocity().getDx() * -1, ball.getVelocity().getDy());
            }
            //right border
            if (ball.getX() + ball.getSize() >= this.bottomRight.getX()) {
                ball.setVelocity(ball.getVelocity().getDx() * -1, ball.getVelocity().getDy());
            }
        }
    }

    /**
     * Draws the frame.
     *
     * @param d     the drawSurface
     * @param color the color of frame
     */
    public void drawOn(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillRectangle((int) topLeft.getX(), (int) topLeft.getY(), (int) (bottomRight.getX() - topLeft.getX()),
                (int) (bottomRight.getY() - topLeft.getY()));
    }

    /**
     * Returns the top left point of frame.
     *
     * @return the top left point of frame
     */
    public Point getTopLeft() {
        return this.topLeft;
    }

    /**
     * Returns the bottom right point of frame.
     *
     * @return the bottom right point of frame
     */
    public Point getBottomRight() {
        return this.bottomRight;
    }

    /**
     * Returns the width of frame.
     *
     * @return the width of frame
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the height of frame.
     *
     * @return the height of frame
     */
    public int getHeight() {
        return this.height;
    }
}
