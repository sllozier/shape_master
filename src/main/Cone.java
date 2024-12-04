package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: The Cone class represents a three-dimensional cone shape.
 * It inherits from ThreeDimensionalShape and provides specific implementations
 * for the calculateArea() and calculateVolume() methods based on the radius and height of the cone.
 */
import java.awt.*;

public class Cone extends ThreeDimensionalShape implements DrawableShape {

    private double radius;
    private double height;

    // Constructor to initialize the radius and height of the cone
    public Cone(double radius, double height) throws InvalidEntryException {
        if (radius <= 0 || height <= 0) {
            throw new InvalidEntryException("Radius and Height must be greater than 0.");
        }
        this.radius = radius;
        this.height = height;
    }

    /**
     * Calculates the surface area of the cone.
     * Formula: π * r * (r + l), where l is the slant height.
     * Slant height (l): √(r^2 + h^2)
     * @return the surface area of the cone
     */
    @Override
    public double calculateArea() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    /**
     * Calculates the volume of the cone.
     * Formula: (1/3) * π * r^2 * h
     * @return the volume of the cone
     */
    @Override
    public double calculateVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
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

        // Set custom orange color for the cone
        Color coneColor = new Color(255, 140, 0); // RGB for custom orange
        g2d.setColor(coneColor);

        // Coordinates for the triangle (cone body)
        int baseX = 200, baseY = 300;
        int[] xPoints = { baseX, baseX - 50, baseX + 50 };
        int[] yPoints = { baseY - (int) height, baseY, baseY };

        // Draw the triangle
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Draw the oval (cone base)
        int ovalWidth = 100; // Width of the oval
        int ovalHeight = 20; // Height of the oval
        int ovalX = baseX - ovalWidth / 2;
        int ovalY = baseY - ovalHeight / 2; // Adjust to align with the bottom of the triangle

        // Add a gradient for the oval
        GradientPaint gradient = new GradientPaint(
            ovalX,
            ovalY,
            coneColor.brighter(),
            ovalX + ovalWidth,
            ovalY + ovalHeight,
            coneColor.darker()
        );
        g2d.setPaint(gradient);
        g2d.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(ovalX, ovalY, ovalWidth, ovalHeight); // Outline for clarity
    }
}
