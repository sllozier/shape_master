package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The Triangle class represents a two-dimensional triangle shape.
 * It inherits from TwoDimensionalShape and provides a specific implementation
 * of the calculateArea() method based on the base and height of the triangle.
 * This class also includes methods to get and set the base and height.
 */

import java.awt.*;

public class Triangle extends TwoDimensionalShape implements DrawableShape {

    private double base;
    private double height;

    /**
     * Constructor for Triangle.
     * Initializes the triangle with the specified base and height.
     *
     * @param base   The base of the triangle.
     * @param height The height of the triangle.
     * @throws InvalidEntryException If base or height is less than or equal to 0.
     */
    public Triangle(double base, double height) throws InvalidEntryException {
        if (base <= 0 || height <= 0) {
            throw new InvalidEntryException("Base and Height must be greater than 0.");
        }

        this.base = base;
        this.height = height;
    }

    /**
     * Calculates the area of the triangle.
     * Formula: (1/2) * base * height
     *
     * @return The area of the triangle as a double.
     */
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    /**
     * Gets the base of the triangle.
     *
     * @return The base of the triangle as a double.
     */
    public double getBase() {
        return base;
    }

    /**
     * Sets the base of the triangle.
     *
     * @param base The new base of the triangle.
     * @throws InvalidEntryException If the base is less than or equal to 0.
     */
    public void setBase(double base) throws InvalidEntryException {
        if (base <= 0) {
            throw new InvalidEntryException("Base must be greater than 0.");
        }
        this.base = base;
    }

    /**
     * Gets the height of the triangle.
     *
     * @return The height of the triangle as a double.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the triangle.
     *
     * @param height The new height of the triangle.
     * @throws InvalidEntryException If the height is less than or equal to 0.
     */
    public void setHeight(double height) throws InvalidEntryException {
        if (height <= 0) {
            throw new InvalidEntryException("Height must be greater than 0.");
        }
        this.height = height;
    }

    /**
     * Draws the triangle on a graphics context.
     * The triangle is drawn as a filled polygon based on its base and height.
     *
     * @param g The Graphics object used to draw the triangle.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.MAGENTA);
        int[] xPoints = { 200, 200 + (int) base / 2, 200 - (int) base / 2 };
        int[] yPoints = { 200, 200 + (int) height, 200 + (int) height };
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
