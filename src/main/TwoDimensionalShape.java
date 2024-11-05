package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: TwoDimensionalShape serves as an abstract base class for shapes
 * with two dimensions, such as Circle, Square, etc. It overrides calculateVolume()
 * to return 0, as 2D shapes do not have a volume.
 */
public abstract class TwoDimensionalShape extends Shape {

    public TwoDimensionalShape() {
        super(2); // Two-dimensional shapes have 2 dimensions.
    }

    // Implement calculateVolume to return 0, as 2D shapes do not have volume.
    @Override
    public double calculateVolume() {
        return 0; // No volume for 2D shapes.
    }

    // Abstract method to calculate the area, to be implemented by subclasses.
    @Override
    public abstract double calculateArea();
}
