package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Rectangle class represents a two-dimensional rectangle shape.
 * It inherits from TwoDimensionalShape and provides a specific implementation
 * of the calculateArea() method based on the length and width of the rectangle.
 */
import java.awt.*;

public class Rectangle extends TwoDimensionalShape implements DrawableShape {

    private double length;
    private double width;

    /**
     * Constructs a Rectangle with the specified length and width.
     *
     * @param length The length of the rectangle. Must be greater than 0.
     * @param width The width of the rectangle. Must be greater than 0.
     * @throws InvalidEntryException if either length or width is less than or equal to 0.
     */
    public Rectangle(double length, double width) throws InvalidEntryException {
        if (length <= 0 || width <= 0) {
            throw new InvalidEntryException("Length and width must both be greater than 0.");
        }
        this.length = length;
        this.width = width;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return The area of the rectangle, calculated as length * width.
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    /**
     * Retrieves the length of the rectangle.
     *
     * @return The length of the rectangle.
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the rectangle.
     *
     * @param length The new length for the rectangle. Must be greater than 0.
     * @throws InvalidEntryException if the length is less than or equal to 0.
     */
    public void setLength(double length) throws InvalidEntryException {
        if (length <= 0) {
            throw new InvalidEntryException("Length must be greater than 0.");
        }
        this.length = length;
    }

    /**
     * Retrieves the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width The new width for the rectangle. Must be greater than 0.
     * @throws InvalidEntryException if the width is less than or equal to 0.
     */
    public void setWidth(double width) throws InvalidEntryException {
        if (width <= 0) {
            throw new InvalidEntryException("Width must be greater than 0.");
        }
        this.width = width;
    }

    /**
     * Draws the rectangle on the provided Graphics context.
     * The rectangle is drawn in red and positioned at (100, 100) on the drawing panel.
     *
     * @param g The Graphics context to draw the rectangle on.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(100, 100, (int) length, (int) width);
    }
}
