package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Torus class represents a three-dimensional torus shape (a doughnut shape).
 * It inherits from ThreeDimensionalShape and provides specific implementations
 * for the calculateArea() and calculateVolume() methods based on the major and minor radii of the torus.
 */
import java.awt.*;

public class Torus extends ThreeDimensionalShape implements DrawableShape {

    private double majorRadius; // Distance from the center of the tube to the center of the torus
    private double minorRadius; // Radius of the tube

    // Constructor to initialize the major and minor radii of the torus
    public Torus(double majorRadius, double minorRadius) throws InvalidEntryException {
        if (majorRadius <= 0 || minorRadius <= 0) {
            throw new InvalidEntryException(
                "Major Radius and Minor Radius must be greater than 0."
            );
        }

        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    /**
     * Calculates the surface area of the torus.
     * Formula: 4 * π^2 * R * r
     * @return the surface area of the torus
     */
    @Override
    public double calculateArea() {
        return 4 * Math.PI * Math.PI * majorRadius * minorRadius;
    }

    /**
     * Calculates the volume of the torus.
     * Formula: 2 * π^2 * R * r^2
     * @return the volume of the torus
     */
    @Override
    public double calculateVolume() {
        return 2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2);
    }

    // Getter for majorRadius
    public double getMajorRadius() {
        return majorRadius;
    }

    // Setter for majorRadius
    public void setMajorRadius(double majorRadius) throws InvalidEntryException {
        if (majorRadius <= 0) {
            throw new InvalidEntryException("Major Radius must be greater than 0.");
        }
        this.majorRadius = majorRadius;
    }

    // Getter for minorRadius
    public double getMinorRadius() {
        return minorRadius;
    }

    // Setter for minorRadius
    public void setMinorRadius(double minorRadius) throws InvalidEntryException {
        if (minorRadius <= 0) {
            throw new InvalidEntryException("Minor Radius must be greater than 0.");
        }
        this.minorRadius = minorRadius;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Define color for the torus
        Color baseColor = Color.PINK;

        // Coordinates and radii
        int centerX = 400, centerY = 400;
        int outerRadius = (int) majorRadius;
        int innerRadius = (int) minorRadius;

        // Draw the outer oval with a gradient for 3D effect
        GradientPaint outerGradient = new GradientPaint(
            centerX - outerRadius,
            centerY - outerRadius,
            baseColor.brighter(),
            centerX + outerRadius,
            centerY + outerRadius,
            baseColor.darker()
        );
        g2d.setPaint(outerGradient);
        g2d.fillOval(
            centerX - outerRadius,
            centerY - outerRadius,
            2 * outerRadius,
            2 * outerRadius
        );

        // Fill the inner oval with white to simulate a hole in the doughnut
        g2d.setColor(Color.WHITE);
        g2d.fillOval(
            centerX - innerRadius,
            centerY - innerRadius,
            2 * innerRadius,
            2 * innerRadius
        );

        // Add an outline for the outer circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(
            centerX - outerRadius,
            centerY - outerRadius,
            2 * outerRadius,
            2 * outerRadius
        );

        // Add an outline for the inner circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(
            centerX - innerRadius,
            centerY - innerRadius,
            2 * innerRadius,
            2 * innerRadius
        );
    }
}
