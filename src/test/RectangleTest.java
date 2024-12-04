package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: RectangleTest contains unit tests to validate the functionality
 * of the Rectangle class, ensuring that area calculation, length, and width handling
 * are correct.
 */

import main.InvalidEntryException;
import main.Rectangle;

public class RectangleTest {

    public static void main(String[] args) {
        boolean result1 = testValidDimensions();
        boolean result2 = testInvalidLength();
        boolean result3 = testInvalidWidth();
        boolean result4 = testCalculateArea();
        boolean result5 = testGetLength();
        boolean result6 = testGetWidth();

        System.out.println("RectangleTest results:");
        System.out.println("testValidDimensions: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testInvalidLength: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testInvalidWidth: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result4 ? "Passed" : "Failed"));
        System.out.println("testGetLength: " + (result5 ? "Passed" : "Failed"));
        System.out.println("testGetWidth: " + (result6 ? "Passed" : "Failed"));
    }

    /**
     * Tests valid dimensions for the Rectangle.
     *
     * @return true if the Rectangle is created successfully and calculates correctly.
     */
    public static boolean testValidDimensions() {
        System.out.println("🧪 TEST 21 🧪");
        boolean result = false; // Initialize as false
        try {
            Rectangle rectangle = new Rectangle(10.0, 5.0);
            double expectedArea = 10.0 * 5.0;
            double actualArea = rectangle.calculateArea();
            result = Math.abs(expectedArea - actualArea) < 0.01; // Set to true if calculation is correct
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests invalid length for the Rectangle.
     *
     * @return true if an exception is thrown for invalid length.
     */
    public static boolean testInvalidLength() {
        System.out.println("🧪 TEST 22 🧪");
        boolean result = false; // Initialize as false
        try {
            new Rectangle(-10.0, 5.0); // Invalid length
            System.out.println("No exception thrown for invalid length.");
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Length and width must both be greater than 0"); // Match actual message
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests invalid width for the Rectangle.
     *
     * @return true if an exception is thrown for invalid width.
     */
    public static boolean testInvalidWidth() {
        System.out.println("🧪 TEST 23 🧪");
        boolean result = false; // Initialize as false
        try {
            new Rectangle(10.0, -5.0); // Invalid width
            System.out.println("No exception thrown for invalid width.");
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Length and width must both be greater than 0"); // Validate exception message
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
        System.out.println("🧪 TEST 24 🧪");
        try {
            Rectangle rectangle = new Rectangle(4.0, 5.0);
            double expectedArea = 4.0 * 5.0; // length * width
            double actualArea = rectangle.calculateArea();
            System.out.println("Expected: " + expectedArea + ", Actual: " + actualArea);
            return Math.abs(expectedArea - actualArea) < 0.0001;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the getLength method.
     *
     * @return true if the length is returned correctly.
     */
    public static boolean testGetLength() {
        System.out.println("🧪 TEST 25 🧪");
        try {
            Rectangle rectangle = new Rectangle(4.0, 5.0);
            double expectedLength = 4.0;
            double actualLength = rectangle.getLength();
            System.out.println("Expected: " + expectedLength + ", Actual: " + actualLength);
            return expectedLength == actualLength;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the getWidth method.
     *
     * @return true if the width is returned correctly.
     */
    public static boolean testGetWidth() {
        System.out.println("🧪 TEST 26 🧪");
        try {
            Rectangle rectangle = new Rectangle(4.0, 5.0);
            double expectedWidth = 5.0;
            double actualWidth = rectangle.getWidth();
            System.out.println("Expected: " + expectedWidth + ", Actual: " + actualWidth);
            return expectedWidth == actualWidth;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }
}
