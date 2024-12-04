package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Sphere class represents a three-dimensional sphere shape.
 * It inherits from ThreeDimensionalShape and provides specific implementations
 * for the calculateArea() and calculateVolume() methods based on the radius of the sphere.
 */
import java.awt.*;

public class Sphere extends ThreeDimensionalShape implements DrawableShape {

    private double radius;

    // Constructor to initialize the radius of the sphere
    public Sphere(double radius) throws InvalidEntryException {
        if (radius <= 0) {
            throw new InvalidEntryException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    /**
     * Calculates the surface area of the sphere.
     * Formula: 4 * π * r^2
     * @return the surface area of the sphere
     */
    @Override
    public double calculateArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculates the volume of the sphere.
     * Formula: (4/3) * π * r^3
     * @return the volume of the sphere
     */
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) throws InvalidEntryException {
        if (radius <= 0) {
            throw new InvalidEntryException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set up gradient for the sphere
        int centerX = 200;
        int centerY = 200;
        int diameter = (int) (2 * radius);

        // Create a radial gradient to simulate the sphere's lighting
        GradientPaint gradient = new GradientPaint(
            centerX,
            centerY,
            new Color(198, 115, 255), // Lighter center color
            centerX + diameter / 2,
            centerY + diameter / 2,
            new Color(95, 0, 160), // Darker edge color
            true // Cyclic gradient
        );

        g2d.setPaint(gradient);
        g2d.fillOval(centerX - (int) radius, centerY - (int) radius, diameter, diameter);

        // Draw the outline
        g2d.setColor(new Color(128, 0, 128));
        g2d.drawOval(centerX - (int) radius, centerY - (int) radius, diameter, diameter);
    }
}
