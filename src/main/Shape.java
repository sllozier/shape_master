package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Shape class serves as the base class for all shapes in the application.
 * It provides a common structure that includes the number of dimensions, which will
 * be defined by subclasses.
 */
public abstract class Shape {
    protected int numberOfDimensions;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculateArea();
    public abstract double calculateVolume();
}
