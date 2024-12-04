package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: CircleTest contains unit tests to validate the functionality
 * of the Circle class, ensuring that area calculation and radius handling
 * are correct.
 */
import main.Circle;
import main.InvalidEntryException;

public class CircleTest {

    public static void main(String[] args) {
        boolean result1 = testValidRadius();
        boolean result2 = testInvalidRadius();
        boolean result3 = testCalculateArea();
        boolean result4 = testGetRadius();

        System.out.println("CircleTest results:");
        System.out.println("testValidRadius: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testInvalidRadius: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testGetRadius: " + (result4 ? "Passed" : "Failed"));
    }

    /**
     * Tests the constructor with a valid radius.
     *
     * @return true if the constructor correctly sets the radius without exceptions.
     */
    public static boolean testValidRadius() {
        System.out.println("🧪 TEST 8 🧪");
        boolean result = false; // Initialize result to false
        try {
            double radius = 10.0;
            Circle circle = new Circle(radius);
            result = circle.getRadius() == radius; // Validate the radius
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the constructor with an invalid radius.
     *
     * @return true if the exception is correctly thrown for invalid input.
     */
    public static boolean testInvalidRadius() {
        System.out.println("🧪 TEST 9 🧪");
        boolean result = false; // Initialize result to false
        try {
            double radius = -5.0; // Invalid radius
            new Circle(radius);
            System.out.println("No exception thrown for invalid radius.");
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Radius must be greater than 0");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateArea method.
     *
     * @return true if the area is calculated correctly.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 10 🧪");
        try {
            Circle circle = new Circle(5.0);
            double expectedArea = Math.PI * 25.0; // π * r^2 where r = 5
            double actualArea = circle.calculateArea();
            System.out.println("Expected: " + expectedArea + ", Actual: " + actualArea);
            return Math.abs(expectedArea - actualArea) < 0.0001;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the getRadius method.
     *
     * @return true if the radius is returned correctly.
     */
    public static boolean testGetRadius() {
        System.out.println("🧪 TEST 11 🧪");
        try {
            Circle circle = new Circle(5.0);
            double expectedRadius = 5.0;
            double actualRadius = circle.getRadius();
            System.out.println("Expected: " + expectedRadius + ", Actual: " + actualRadius);
            return expectedRadius == actualRadius;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }
}
