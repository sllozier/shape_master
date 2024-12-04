package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: TriangleTest contains unit tests to validate the functionality
 * of the Triangle class, ensuring that area calculation, base, and height handling
 * are correct.
 */

import main.InvalidEntryException;
import main.Triangle;

public class TriangleTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateArea();
        boolean result2 = testGetBase();
        boolean result3 = testGetHeight();
        boolean result4 = testValidBaseHeight();
        boolean result5 = testInvalidBaseHeight();

        System.out.println("TriangleTest results:");
        System.out.println("testCalculateArea: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testGetBase: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testGetHeight: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testValidBaseHeight: " + (result4 ? "Passed" : "Failed"));
        System.out.println("testInvalidBaseHeight: " + (result5 ? "Passed" : "Failed"));
    }

    /**
     * Tests the calculateArea method.
     *
     * @return true if the area is calculated correctly.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 16 🧪");
        try {
            Triangle triangle = new Triangle(4, 5);
            double expectedArea = 0.5 * 4 * 5; // 0.5 * base * height
            double actualArea = triangle.calculateArea();
            System.out.println("Expected: " + expectedArea + ", Actual: " + actualArea);
            return Math.abs(expectedArea - actualArea) < 0.0001;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the getBase method.
     *
     * @return true if the base is returned correctly.
     */
    public static boolean testGetBase() {
        System.out.println("🧪 TEST 17 🧪");
        try {
            Triangle triangle = new Triangle(4, 5);
            double expectedBase = 4.0;
            double actualBase = triangle.getBase();
            System.out.println("Expected: " + expectedBase + ", Actual: " + actualBase);
            return expectedBase == actualBase;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the getHeight method.
     *
     * @return true if the height is returned correctly.
     */
    public static boolean testGetHeight() {
        System.out.println("🧪 TEST 18 🧪");
        try {
            Triangle triangle = new Triangle(4, 5);
            double expectedHeight = 5.0;
            double actualHeight = triangle.getHeight();
            System.out.println("Expected: " + expectedHeight + ", Actual: " + actualHeight);
            return expectedHeight == actualHeight;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the constructor with valid base and height.
     *
     * @return true if the constructor works correctly with valid input.
     */
    public static boolean testValidBaseHeight() {
        System.out.println("🧪 TEST 19 🧪");
        try {
            Triangle triangle = new Triangle(6, 8);
            double expectedBase = 6.0;
            double expectedHeight = 8.0;
            System.out.println(
                "Base: Expected: " + expectedBase + ", Actual: " + triangle.getBase()
            );
            System.out.println(
                "Height: Expected: " + expectedHeight + ", Actual: " + triangle.getHeight()
            );
            return triangle.getBase() == expectedBase && triangle.getHeight() == expectedHeight;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the constructor with invalid base or height.
     *
     * @return true if the exception is correctly thrown for invalid input.
     */
    public static boolean testInvalidBaseHeight() {
        System.out.println("🧪 TEST 20 🧪");
        boolean result = true; // Initialize to true and set to false on failure

        try {
            double invalidBase = -3;
            double validHeight = 5;
            new Triangle(invalidBase, validHeight); // Invalid base
            System.out.println("No exception thrown for invalid base.");
            result = false; // Set to false if no exception is thrown
        } catch (InvalidEntryException e) {
            if (!e.getMessage().contains("Base and Height must be greater than 0")) {
                result = false; // Set to false if the exception message does not match
            }
        }

        try {
            double validBase = 3;
            double invalidHeight = -5;
            new Triangle(validBase, invalidHeight); // Invalid height
            System.out.println("No exception thrown for invalid height.");
            result = false; // Set to false if no exception is thrown
        } catch (InvalidEntryException e) {
            if (!e.getMessage().contains("Base and Height must be greater than 0")) {
                result = false; // Set to false if the exception message does not match
            }
        }

        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
