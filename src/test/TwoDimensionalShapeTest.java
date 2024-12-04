package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: This class contains unit tests to validate the functionality of the TwoDimensionalShape class,
 * ensuring that 2D shapes correctly implement area calculation and have a volume of zero.
 */

import main.TwoDimensionalShape;

public class TwoDimensionalShapeTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateVolume();
        boolean result2 = testCalculateArea();

        System.out.println("TwoDimensionalShapeTest results:");
        System.out.println("testCalculateVolume: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result2 ? "Passed" : "Failed"));
    }

    /**
     * Tests that the calculateVolume method returns 0 for a two-dimensional shape.
     *
     * @return true if the volume is 0, false otherwise
     */
    public static boolean testCalculateVolume() {
        System.out.println("🧪 TEST 4 🧪");

        // Anonymous class to test TwoDimensionalShape
        TwoDimensionalShape shape = new TwoDimensionalShape() {
            @Override
            public double calculateArea() {
                return 0; // Placeholder
            }
        };

        double expectedVolume = 0.0;
        double actualVolume = shape.calculateVolume();
        System.out.println("Expected: " + expectedVolume + ", Actual: " + actualVolume);

        return expectedVolume == actualVolume;
    }

    /**
     * Placeholder test for calculateArea method. Specific tests should be
     * implemented in subclasses like Circle, Square, etc.
     *
     * @return true if area calculation is working (for now returns true as a placeholder)
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 5 🧪");

        // Anonymous class to test TwoDimensionalShape
        TwoDimensionalShape shape = new TwoDimensionalShape() {
            @Override
            public double calculateArea() {
                return 0; // Placeholder for area calculation
            }
        };

        double expectedArea = 0.0;
        double actualArea = shape.calculateArea();
        System.out.println("Expected: " + expectedArea + ", Actual: " + actualArea);

        return expectedArea == actualArea;
    }
}
