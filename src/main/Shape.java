package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The Shape class serves as the base class for all shapes in the application.
 * It provides a common structure that includes the number of dimensions, which
 * will be defined by subclasses. Subclasses must implement the abstract methods
 * for calculating area and volume.
 */
public abstract class Shape {

    // The number of dimensions of the shape (e.g., 2D or 3D)
    protected int numberOfDimensions;

    /**
     * Constructor to initialize a shape with a specific number of dimensions.
     *
     * @param numberOfDimensions The number of dimensions for the shape (e.g., 2 for 2D, 3 for 3D).
     */
    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    /**
     * Retrieves the number of dimensions of the shape.
     *
     * @return The number of dimensions of the shape.
     */
    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }

    /**
     * Abstract method to calculate the area of the shape.
     * Subclasses must provide an implementation of this method.
     *
     * @return The area of the shape as a double.
     */
    public abstract double calculateArea();

    /**
     * Abstract method to calculate the volume of the shape.
     * Subclasses must provide an implementation of this method.
     *
     * @return The volume of the shape as a double.
     */
    public abstract double calculateVolume();
}
