package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: SquareTest contains unit tests to validate the functionality
 * of the Square class, ensuring that area calculation and side handling
 * are correct.
 */

import main.InvalidEntryException;
import main.Square;

public class SquareTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateArea();
        boolean result2 = testGetSide();
        boolean result3 = testValidSide();
        boolean result4 = testInvalidSide();

        System.out.println("SquareTest results:");
        System.out.println("testCalculateArea: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testGetSide: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testValidSide: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testInvalidSide: " + (result4 ? "Passed" : "Failed"));
    }

    /**
     * Tests the calculateArea method.
     *
     * @return true if the area is calculated correctly.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 12 🧪");
        try {
            Square square = new Square(4);
            double expectedArea = 16; // side^2 where side = 4
            double actualArea = square.calculateArea();
            System.out.println("Expected: " + expectedArea + ", Actual: " + actualArea);
            return Math.abs(expectedArea - actualArea) < 0.0001;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the getSide method.
     *
     * @return true if the side length is returned correctly.
     */
    public static boolean testGetSide() {
        System.out.println("🧪 TEST 13 🧪");
        try {
            Square square = new Square(4);
            double expectedSide = 4.0;
            double actualSide = square.getSide();
            System.out.println("Expected: " + expectedSide + ", Actual: " + actualSide);
            return expectedSide == actualSide;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the constructor with a valid side length.
     *
     * @return true if the constructor works correctly with valid input.
     */
    public static boolean testValidSide() {
        System.out.println("🧪 TEST 14 🧪");
        try {
            Square square = new Square(5.0);
            double expectedSide = 5.0;
            double actualSide = square.getSide();
            System.out.println("Expected: " + expectedSide + ", Actual: " + actualSide);
            return expectedSide == actualSide;
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Tests the constructor with an invalid side length.
     *
     * @return true if the exception is correctly thrown for invalid input.
     */
    public static boolean testInvalidSide() {
        System.out.println("🧪 TEST 15 🧪");
        boolean result = false; // Initialize result to false
        try {
            double side = -3.0; // Invalid side length
            new Square(side);
            System.out.println("No exception thrown for invalid side length.");
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Side must be greater than 0");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
