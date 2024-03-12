//ID: 324488287
/**
 * The Collidable interface will be used by things that can be collided with.
 *
 * */
public interface Collidable {

    /**
     * Returns the "collision shape" of the object.
     *
     * @return rectangle-the "collision shape" of the object.
     * */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint     the collision point
     * @param currentVelocity    the current velocity
     * @param hitter    the hitter ball
     * @return velocity returns a new velocity expected after the hit
     *
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}