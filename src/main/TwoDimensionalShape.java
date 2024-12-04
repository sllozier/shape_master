package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * TwoDimensionalShape serves as an abstract base class for shapes
 * with two dimensions, such as Circle, Square, etc.
 * It overrides calculateVolume() to return 0, as 2D shapes do not have a volume.
 */
public abstract class TwoDimensionalShape extends Shape {

    /**
     * Constructor for TwoDimensionalShape.
     * Initializes the shape with a fixed number of dimensions (2).
     */
    public TwoDimensionalShape() {
        super(2); // Two-dimensional shapes have 2 dimensions.
    }

    /**
     * Calculates the volume of the shape.
     * As two-dimensional shapes do not have volume, this method returns 0.
     *
     * @return 0.0, indicating no volume for 2D shapes.
     */
    @Override
    public double calculateVolume() {
        return 0; // No volume for 2D shapes.
    }

    /**
     * Abstract method to calculate the area of the shape.
     * This method must be implemented by subclasses to define how the area is calculated.
     *
     * @return The calculated area as a double.
     */
    @Override
    public abstract double calculateArea();
}
