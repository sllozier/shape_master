package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Cylinder class represents a three-dimensional cylinder shape.
 * It inherits from ThreeDimensionalShape and provides specific implementations
 * for the calculateArea() and calculateVolume() methods based on the radius and height of the cylinder.
 */
import java.awt.*;

public class Cylinder extends ThreeDimensionalShape implements DrawableShape {

    private double radius;
    private double height;

    // Constructor to initialize the radius and height of the cylinder
    public Cylinder(double radius, double height) throws InvalidEntryException {
        if (radius <= 0 || height <= 0) {
            throw new InvalidEntryException("Radius and Height must be greater than 0.");
        }
        this.radius = radius;
        this.height = height;
    }

    /**
     * Calculates the surface area of the cylinder.
     * Formula: 2 * π * r * (r + h)
     * @return the surface area of the cylinder
     */
    @Override
    public double calculateArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    /**
     * Calculates the volume of the cylinder.
     * Formula: π * r^2 * h
     * @return the volume of the cylinder
     */
    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
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

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) throws InvalidEntryException {
        if (height <= 0) {
            throw new InvalidEntryException("Height must be greater than 0.");
        }
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Define custom green color
        Color customGreen = new Color(0, 128, 0);

        // Coordinates and dimensions
        int baseX = 250, baseY = 250;
        int diameter = (int) (2 * radius);
        int rectHeight = (int) height;

        // Draw the main body of the cylinder (rectangle with a gradient)
        GradientPaint bodyGradient = new GradientPaint(
            baseX,
            baseY,
            customGreen.brighter(),
            baseX + diameter,
            baseY + rectHeight,
            customGreen.darker()
        );
        g2d.setPaint(bodyGradient);
        g2d.fillRect(baseX, baseY, diameter, rectHeight);

        // Draw the top oval (lid) with a gradient for 3D effect
        GradientPaint topGradient = new GradientPaint(
            baseX,
            baseY,
            customGreen.brighter(),
            baseX + diameter,
            baseY + 20,
            customGreen.darker()
        );
        g2d.setPaint(topGradient);
        g2d.fillOval(baseX, baseY - 10, diameter, 20); // Adjust oval height to overlap slightly
        g2d.setColor(Color.BLACK);
        g2d.drawOval(baseX, baseY - 10, diameter, 20); // Outline for clarity

        // Draw the bottom oval (base)
        GradientPaint bottomGradient = new GradientPaint(
            baseX,
            baseY + rectHeight - 10,
            customGreen.darker(),
            baseX + diameter,
            baseY + rectHeight + 10,
            customGreen.brighter()
        );
        g2d.setPaint(bottomGradient);
        g2d.fillOval(baseX, baseY + rectHeight - 10, diameter, 20);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(baseX, baseY + rectHeight - 10, diameter, 20); // Outline for clarity
    }
}
