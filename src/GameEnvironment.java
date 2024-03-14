import java.util.ArrayList;
import java.util.List;

/**
 * There are going to be many objects a Ball can collide with.
 * The GameEnvironment class will be a collection of such things.
 * The ball will know the game environment, and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {
    private List<Collidable>  collidables = new ArrayList<Collidable>();

    /**
     * Add the given collidable to the environment.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Returns closest collision.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle r;
        List<Point> closestPointToCollision = new ArrayList<>();
        //Adds to a list all closest points of each collidable which the trajectory of the ball can intersect with
        for (Collidable c: this.collidables) {
            r = c.getCollisionRectangle();
            Point pointClosest = trajectory.closestIntersectionToStartOfLine(r);
            if (pointClosest != null) {
                closestPointToCollision.add(pointClosest);
            }
        }
        //The closet collision point
        Point closest = trajectory.closestIntersectionPointFromListToLine(closestPointToCollision);
        if (closest == null) {
            return null;
        }
        Collidable closestCollidable = null;
        //Finds the triangle of the closest collidable which the closet collision point belongs to
        for (Collidable c: this.collidables) {
            r = c.getCollisionRectangle();
            if (trajectory.closestIntersectionToStartOfLine(r) != null) {
                if (trajectory.closestIntersectionToStartOfLine(r).equals(closest)) {
                    closestCollidable = c;
                }
            }
        }
        //collision info
        return new CollisionInfo(closest, closestCollidable);


    }

    /**
     * Returns the list of collidables.
     *
     * @return the list of collidables
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

}
