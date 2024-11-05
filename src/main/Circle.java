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
public class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
