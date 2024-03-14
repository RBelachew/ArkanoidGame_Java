import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;


/**
 * the class  generates random pictures of 10 lines, drawn in black. The middle point in each line is indicated in blue,
 * while the intersection points between the lines are indicated in red.
 */
public class AbstractArtDrawing {
    private int width = 400;
    private int height = 400;

    /**
     * Generates random line.
     *
     * @return the line
     */
    public Line generateRandomLine() {
        // create a random-number generator
        Random rand = new Random();
        double x1 = (rand.nextDouble() * width);
        double y1 = (rand.nextDouble() * height);
        double x2 = (rand.nextDouble() * width);
        double y2 = (rand.nextDouble() * height);
        Line line = new Line(x1, y1, x2, y2);
        return line;
    }

    /**
     * Draws circles with a radius of 3.
     *
     * @param point the center point of circle
     * @param r     the radius of circle
     * @param color the color of circle
     * @param d     the drawSurface
     */
    public void drawCircles(Point point, int r, Color color, DrawSurface d) {
        d.setColor(color);
        d.fillCircle((int) point.getX(), (int) point.getY(), r);
    }

    /**
     * Draws random lines and returns array of these lines.
     *
     * @param d the drawSurface
     * @return array of random lines
     */
    public Line[] drawRandomLines(DrawSurface d) {
        Line[] arrayOfLines = new Line[10];
        //Generates random lines,draws them and their middle points
        for (int i = 0; i < arrayOfLines.length; i++) {
            arrayOfLines[i] = generateRandomLine();
            arrayOfLines[i].drawLine(d);
            Point middle = arrayOfLines[i].middle();
            drawCircles(middle, 3, Color.BLUE, d);
        }
        return arrayOfLines;
    }

    /**
     * Draw intersection points of lines.
     *
     * @param d            the drawSurface
     * @param arrayOfLines the array of lines
     */
    public void drawIntersectionsOfLines(DrawSurface d, Line[] arrayOfLines) {
        //Checks if there are intersection points between the lines and draws them
        for (int i = 1; i < arrayOfLines.length; i++) {
            for (int j = 0; j < i; j++) {
                Point intersection = arrayOfLines[i].intersectionWith(arrayOfLines[j]);
                if (intersection != null) {
                    drawCircles(intersection, 3, Color.RED, d);
                }
            }
        }

    }

    /**
     * The entry point of application-draws 10 black lines,their middle points in blue and
     * their intersection points in red.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        AbstractArtDrawing example = new AbstractArtDrawing();
        //Creates a screen, with a title and dimensions
        GUI gui = new GUI("Random Lines", example.width, example.height);
        DrawSurface d = gui.getDrawSurface();
        //Array of random lines (the lines and their middle points are filled)
        Line[] lines = example.drawRandomLines(d);
        //Draws the intersection points between the lines
        example.drawIntersectionsOfLines(d, lines);
        gui.show(d);
    }

}
