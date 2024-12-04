package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The Square class represents a two-dimensional square shape.
 * It inherits from TwoDimensionalShape and provides a specific implementation
 * of the calculateArea() method based on the side length of the square.
 * The class also implements the DrawableShape interface for visual rendering.
 */
import java.awt.*;

public class Square extends TwoDimensionalShape implements DrawableShape {

    // The length of one side of the square
    private double side;

    /**
     * Constructor to initialize the square with a specific side length.
     *
     * @param side The length of the square's side.
     * @throws InvalidEntryException If the side length is less than or equal to 0.
     */
    public Square(double side) throws InvalidEntryException {
        if (side <= 0) {
            throw new InvalidEntryException("Side must be greater than 0.");
        }
        this.side = side;
    }

    /**
     * Calculates the area of the square.
     *
     * @return The area of the square as a double.
     */
    @Override
    public double calculateArea() {
        return side * side;
    }

    /**
     * Retrieves the side length of the square.
     *
     * @return The length of the square's side.
     */
    public double getSide() {
        return side;
    }

    /**
     * Updates the side length of the square.
     *
     * @param side The new side length of the square.
     * @throws InvalidEntryException If the new side length is less than or equal to 0.
     */
    public void setSide(double side) throws InvalidEntryException {
        if (side <= 0) {
            throw new InvalidEntryException("Side must be greater than 0.");
        }
        this.side = side;
    }

    /**
     * Draws the square on the provided Graphics context.
     *
     * @param g The Graphics object used for rendering the square.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN); // Set the color of the square
        g.drawRect(300, 300, (int) side, (int) side); // Draw the square at position (300, 300)
    }
}
