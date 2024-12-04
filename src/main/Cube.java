package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Cube class represents a three-dimensional cube shape.
 * It inherits from ThreeDimensionalShape and provides specific implementations
 * for the calculateArea() and calculateVolume() methods based on the side length of the cube.
 */
import java.awt.*;

public class Cube extends ThreeDimensionalShape implements DrawableShape {

    private double side;

    // Constructor to initialize the side length of the cube
    public Cube(double side) throws InvalidEntryException {
        if (side <= 0) {
            throw new InvalidEntryException("Side must be greater than 0.");
        }
        this.side = side;
    }

    /**
     * Calculates the surface area of the cube.
     * Formula: 6 * side^2
     * @return the surface area of the cube
     */
    @Override
    public double calculateArea() {
        return 6 * Math.pow(side, 2);
    }

    /**
     * Calculates the volume of the cube.
     * Formula: side^3
     * @return the volume of the cube
     */
    @Override
    public double calculateVolume() {
        return Math.pow(side, 3);
    }

    // Getter for side
    public double getSide() {
        return side;
    }

    // Setter for side
    public void setSide(double side) throws InvalidEntryException {
        if (side <= 0) {
            throw new InvalidEntryException("Side must be greater than 0.");
        }
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        int baseX = 150, baseY = 150;
        int sideLength = (int) side;
        g.drawRect(baseX, baseY, sideLength, sideLength);
        g.drawRect(baseX + 20, baseY - 20, sideLength, sideLength);
        g.drawLine(baseX, baseY, baseX + 20, baseY - 20);
        g.drawLine(baseX + sideLength, baseY, baseX + 20 + sideLength, baseY - 20);
        g.drawLine(baseX, baseY + sideLength, baseX + 20, baseY - 20 + sideLength);
        g.drawLine(
            baseX + sideLength,
            baseY + sideLength,
            baseX + 20 + sideLength,
            baseY - 20 + sideLength
        );
    }
}
