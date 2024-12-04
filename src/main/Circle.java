package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Circle class represents a two-dimensional circle shape.
 * It inherits from TwoDimensionalShape and provides a specific implementation
 * of the calculateArea() method based on the radius of the circle.
 */
import java.awt.*;

public class Circle extends TwoDimensionalShape implements DrawableShape {

    private double radius;

    /**
     * Constructs a Circle with a specified radius.
     *
     * @param radius The radius of the circle. Must be greater than 0.
     * @throws InvalidEntryException if the radius is less than or equal to 0.
     */
    public Circle(double radius) throws InvalidEntryException {
        if (radius <= 0) {
            throw new InvalidEntryException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return The area of the circle, calculated as π * radius^2.
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Retrieves the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius The new radius for the circle. Must be greater than 0.
     * @throws InvalidEntryException if the radius is less than or equal to 0.
     */
    public void setRadius(double radius) throws InvalidEntryException {
        if (radius <= 0) {
            throw new InvalidEntryException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    /**
     * Draws the circle on the provided Graphics context.
     * The circle is drawn in blue and centered on the drawing panel.
     *
     * @param g The Graphics context to draw the circle on.
     */
    @Override
    public void draw(Graphics g) {
        int diameter = (int) (2 * radius);
        int x = 400 - diameter / 2; // Center the circle horizontally
        int y = 300 - diameter / 2; // Center the circle vertically
        g.setColor(Color.BLUE); // Set color for the circle
        g.drawOval(x, y, diameter, diameter); // Draw the circle
    }
}
