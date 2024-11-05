package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: ThreeDimensionalShape serves as an abstract base class for shapes
 * with three dimensions, such as Sphere, Cube, etc.
 */
public abstract class ThreeDimensionalShape extends Shape {

    public ThreeDimensionalShape() {
        super(3); // Three-dimensional shapes have 3 dimensions.
    }

    // Both area and volume must be implemented by 3D shapes
    @Override
    public abstract double calculateArea();

    @Override
    public abstract double calculateVolume();
}
