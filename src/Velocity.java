/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {

    private double dx;
    private double dy;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p the point we want to change
     * @return the point with the new position
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * Creates a new velocity taking an angle and a speed.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //Sinus trial + the identity of: sin(90-a)=cos(a)
        double dx = speed * Math.cos((angle * Math.PI) / 180);
        //Sinus trial
        double dy = speed * Math.sin((angle * Math.PI) / 180);
        return new Velocity(dx, -dy);
    }

    /**
     * Returns the dx value of this velocity.
     *
     * @return the dx value of this velocity
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Returns the dy value of this velocity.
     *
     * @return the dy value of this velocity
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * Setts the velocity of ball.
     *
     * @param dx1 the step on the x axis
     * @param dy1 the step on the y axis
     */
    public void setVelocity(double dx1,  double dy1) {
        this.dx = dx1;
        this.dy = dy1;
    }

}
