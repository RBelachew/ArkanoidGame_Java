import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class holds information of rectangle which is aligned with the axes.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Instantiates a new Rectangle-creates a new rectangle with location and width/height.
     *
     * @param upperLeft the upper left point
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns a (possibly empty) List of intersection points with the specified line.
     *
     * @param line the line
     * @return the list
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<Point>();
        //Checks intersection points with the specified line
        for (int i = 0; i < line.arrayOfIntersectionPoints(this).length; i++) {
            if (line.arrayOfIntersectionPoints(this)[i] != null) {
                points.add(line.arrayOfIntersectionPoints(this)[i]);
            }
        }
        return points;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper left point
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets upper  point.
     *
     * @return the upper right point
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * Gets lower right point.
     *
     * @return the lower right point
     */
    public Point getLowerRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * Gets lower left point.
     *
     * @return the lower left point
     */
    public Point getLowerLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }


}
