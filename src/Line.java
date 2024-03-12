//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * A line (actually a line-segment) connects two points -- a start point and an end point. Lines have lengths,
 * and may intersect with other lines.It can also tell if it is the same as another line segment.
 */
public class Line {
    private Point start;
    private Point end;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    /**
     * Instantiates a new Line.
     *
     * @param start the start point
     * @param end   the end point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.x1 = start.getX();
        this.x2 = end.getX();
        this.y1 = start.getY();
        this.y2 = end.getY();
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 a x value of the start point of line
     * @param y1 a y value of the start point of line
     * @param x2 a x value of the end point of line
     * @param y2 a y value of the end point of line
     */
    public Line(double x1, double y1, double x2, double y2) {

        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Return the length of the line.
     *
     * @return the the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Draw line.
     *
     * @param d the drawsurface
     */
    public void drawLine(DrawSurface d) {
        d.setColor(Color.black);
        d.drawLine((int) this.x1, (int) this.y1, (int) this.x2, (int) this.y2);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        //formula of midpoint between two points
        double xMiddle = (this.start.getX() + this.end.getX()) / 2;
        double yMiddle = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(xMiddle, yMiddle);
        return middle;
    }

    /**
     * Returns the start point of the line.
     *
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Calculates incline of line.
     *
     * @param start1 the start point
     * @param end1   the end point
     * @return the incline of line
     */
    public double getIncline(Point start1, Point end1) {
        double incline = (start1.getY() - end1.getY()) / (start1.getX() - end1.getX());
        return incline;
    }

    /**
     * Returns general intersection point of two lines.
     *
     * @param other the other line
     * @return the intersection point
     */
    public Point generalIntersection(Line other) {
        //Incline of line 1
        double incline1 = getIncline(this.start, this.end);
        //Incline of line 2
        double incline2 = getIncline(other.start, other.end);

        if (incline1 == incline2) {
            if (this.start.equals(other.start) || this.start.equals(other.end)) {
                return this.start;
            }
            if (this.end.equals(other.start) || this.end.equals(other.end)) {
                return this.end;
            }
            return null;
        }
        if (Double.isInfinite(incline1) || Double.isNaN(incline1)) {
            double x = this.start.getX();
            double bOfLine2 = other.start.getY() - incline2 * other.start.getX();
            double yOfIntersection = incline2 * x + bOfLine2;
            return new Point(x, yOfIntersection);
        }
        if (Double.isInfinite(incline2) || Double.isNaN(incline2)) {
            double x = other.start.getX();
            double bOfLine1 = this.start.getY() - incline1 * this.start.getX();
            double yOfIntersection = incline1 * x + bOfLine1;
            return new Point(x, yOfIntersection);
        }

        //y=ax+b >>> b=y-ax  (Line1)
        double bOfLine1 = this.start.getY() - incline1 * this.start.getX();
        //y=ax+b >>> b=y-ax  (Line2)
        double bOfLine2 = other.start.getY() - incline2 * other.start.getX();
        //x=(b2-b1)/(a1-a2)
        double xOfIntersection = (bOfLine2 - bOfLine1) / (incline1 - incline2);
        //y=ax+b
        double yOfIntersection = incline1 * xOfIntersection + bOfLine1;
        Point intersectionWith = new Point(xOfIntersection, yOfIntersection);
        return intersectionWith;

    }

    /**
     * Returns true if the lines intersect at the interval, false otherwise.
     *
     * @param other the other line
     * @return a boolean value - true if the lines intersect at the interval, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //Checking if there is a intersection point and its interval of x and y values
        if (generalIntersection(other) != null) {
            //Checking the interval of x value of the intersection point on this line
            if (((generalIntersection(other).getX() >= this.x1) && (generalIntersection(other).getX() <= this.x2))
                    || ((generalIntersection(other).getX() <= this.x1)
                    && (generalIntersection(other).getX() >= this.x2))) {

                //Checking the interval of y value of the intersection point on this line
                if (((generalIntersection(other).getY() >= this.y1) && (generalIntersection(other).getY() <= this.y2))
                        || ((generalIntersection(other).getY() <= this.y1)
                                && (generalIntersection(other).getY() >= this.y2))) {
                    //Checking the interval of x value of the intersection point on other line
                    if (((generalIntersection(other).getX() >= other.x1)
                            && (generalIntersection(other).getX() <= other.x2))
                            || ((generalIntersection(other).getX() <= other.x1)
                            && (generalIntersection(other).getX() >= other.x2))) {

                        //Checking the interval of y value of the intersection point on other line
                        if (((generalIntersection(other).getY() >= other.y1)
                                && (generalIntersection(other).getY() <= other.y2))
                                || ((generalIntersection(other).getY() <= other.y1)
                                        && (generalIntersection(other).getY() >= other.y2))) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    /**
     * Returns the intersection point if the lines intersect at the interval,and null otherwise.
     *
     * @param other the other line
     * @return the intersection point at the interval
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            return this.generalIntersection(other);
        }
        return null;
    }

    /**
     * Equals -- return true if the lines are equal, false otherwise.
     *
     * @param other the other line
     * @return a boolean value-true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if ((this.start.equals(other.start) && this.end.equals(other.end))) {
            return true;
        }
        return false;
    }


    /**
     * Gets rectangle and returns array of intersection points with line.
     *
     * @param rect the rectangle
     * @return the array of intersection points
     */
    public Point[] arrayOfIntersectionPoints(Rectangle rect) {
        Point[] intersectionPoints = new Point[4];
        //The upper line of the rectangle
        Line upperLine = new Line(rect.getUpperLeft(), rect.getUpperRight());
        //The lower line of the rectangle
        Line lowerLine = new Line(rect.getLowerLeft(), rect.getLowerRight());
        //The left line of the rectangle
        Line leftLine = new Line(rect.getUpperLeft(), rect.getLowerLeft());
        //The right line of the rectangle
        Line rightLine = new Line(rect.getUpperRight(), rect.getLowerRight());
        //An Assignment of the intersection points of line and the rectangle edges into an array
        intersectionPoints[0] = this.intersectionWith(upperLine);
        intersectionPoints[1] = this.intersectionWith(lowerLine);
        intersectionPoints[2] = this.intersectionWith(leftLine);
        intersectionPoints[3] = this.intersectionWith(rightLine);

        return intersectionPoints;
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise,return the closest intersection to start of line.
     *
     * @param rect the rectangle
     * @return the closest intersection to start of line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        Point[] intersectionPoints = new Point[4];
        double distanceFromEnd = -1;
        Point closestIntersection = null;
        intersectionPoints = arrayOfIntersectionPoints(rect);
        //Checks which intersection point is the closest to start of line/the farthest to end of line
        for (int i = 0; i < intersectionPoints.length; i++) {
            if (intersectionPoints[i] != null) {
                //Checks which intersection point is the farthest to end of line
                if (intersectionPoints[i].distance(this.end) > distanceFromEnd) {
                    distanceFromEnd = intersectionPoints[i].distance(this.end);
                    closestIntersection = intersectionPoints[i];
                }
            }
        }
        return closestIntersection;

    }

    /**
     * Returns closest intersection point from list of points to start of line.
     *
     * @param listOfPoints the list of points
     * @return the closest point
     */
    public Point closestIntersectionPointFromListToLine(List<Point> listOfPoints) {
        double distance = 1000000;
        Point closestPoint = null;
        //Calculates the distance of the each point to start of line and checks which point with the shortest distance
        for (Point p: listOfPoints) {
            if (p.distance(this.start) < distance) {
                distance = p.distance(this.start);
                closestPoint = p;
            }
        }
        return closestPoint;
    }



}