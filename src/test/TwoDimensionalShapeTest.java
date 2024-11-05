package test;
import main.TwoDimensionalShape;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: This class contains unit tests to validate the functionality of the TwoDimensionalShape class,
 * ensuring that 2D shapes correctly implement area calculation and have a volume of zero.
 */
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
        System.out.println("🧪 TEST 1 🧪");

        // Anonymous class to test TwoDimensionalShape
        TwoDimensionalShape shape = new TwoDimensionalShape() {
            @Override
            public double calculateArea() {
                return 0; // Placeholder
            }
        };

        double expectedVolume = 0.0;
        double actualVolume = shape.calculateVolume();
        System.out.println("Expected volume: " + expectedVolume);
        System.out.println("Actual volume: " + actualVolume);

        return expectedVolume == actualVolume;
    }

    /**
     * Placeholder test for calculateArea method. Specific tests should be
     * implemented in subclasses like Circle, Square, etc.
     *
     * @return true if area calculation is working (for now returns true as a placeholder)
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 2 🧪");

        // Anonymous class to test TwoDimensionalShape
        TwoDimensionalShape shape = new TwoDimensionalShape() {
            @Override
            public double calculateArea() {
                return 0; // Placeholder for area calculation
            }
        };

        double expectedArea = 0.0;
        double actualArea = shape.calculateArea();
        System.out.println("Expected area: " + expectedArea);
        System.out.println("Actual area: " + actualArea);

        return expectedArea == actualArea;
    }
}
