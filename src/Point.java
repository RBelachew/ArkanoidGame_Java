/**
 * A point has an x and a y value, and can measure the distance to other points, and if it is equal to another point.
 */
public class Point {
    // a x and a y value
     private double x;
     private double y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x value
     * @param y the y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance -- return the distance of this point to the other point.
     *
     * @param other the other point
     * @return the distance value
     */
    public double distance(Point other) {
        double disX = this.x - other.getX();
        double disY = this.y - other.getY();
        double sum = Math.pow(disX, 2) + Math.pow(disY, 2);
        double distance = Math.sqrt(sum);
        return distance;
    }

    /**
     * Equals -- return true if the points are equal, false otherwise.
     *
     * @param other the other point
     * @return a boolean value-return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other != null) {
            if ((Math.abs(this.x - other.getX()) < 0.01) && (Math.abs(this.y  - other.getY()) < 0.01)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the x value of this point.
     *
     * @return the x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the y value of this point.
     *
     * @return the y value of this point
     */
    public double getY() {
        return this.y;
    }
}
