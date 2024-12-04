package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * ThreeDimensionalShape serves as an abstract base class for shapes
 * with three dimensions, such as Sphere, Cube, Cone, etc.
 * It defines a common structure for 3D shapes and ensures that
 * area and volume calculations are implemented in subclasses.
 */
public abstract class ThreeDimensionalShape extends Shape {

    /**
     * Constructor for ThreeDimensionalShape.
     * Initializes the number of dimensions to 3.
     */
    public ThreeDimensionalShape() {
        super(3); // Three-dimensional shapes have 3 dimensions.
    }

    /**
     * Calculates the surface area of the 3D shape.
     * Subclasses must provide their own implementation of this method.
     *
     * @return The surface area of the shape as a double.
     */
    @Override
    public abstract double calculateArea();

    /**
     * Calculates the volume of the 3D shape.
     * Subclasses must provide their own implementation of this method.
     *
     * @return The volume of the shape as a double.
     */
    @Override
    public abstract double calculateVolume();
}
