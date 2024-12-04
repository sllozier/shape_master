package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: This test file verifies the functionality of the Cone class,
 * including its constructor, calculations for area and volume, getter and setter methods,
 * and proper handling of invalid input.
 */

import main.Cone;
import main.InvalidEntryException;

public class ConeTest {

    public static void main(String[] args) {
        boolean result1 = testValidDimensions();
        boolean result2 = testInvalidRadius();
        boolean result3 = testInvalidHeight();
        boolean result4 = testCalculateArea();
        boolean result5 = testCalculateVolume();
        boolean result6 = testGetRadius();
        boolean result7 = testGetHeight();
        boolean result8 = testSetRadius();
        boolean result9 = testSetHeight();

        System.out.println("ConeTest results:");
        System.out.println("testValidDimensions: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testInvalidRadius: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testInvalidHeight: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result4 ? "Passed" : "Failed"));
        System.out.println("testCalculateVolume: " + (result5 ? "Passed" : "Failed"));
        System.out.println("testGetRadius: " + (result6 ? "Passed" : "Failed"));
        System.out.println("testGetHeight: " + (result7 ? "Passed" : "Failed"));
        System.out.println("testSetRadius: " + (result8 ? "Passed" : "Failed"));
        System.out.println("testSetHeight: " + (result9 ? "Passed" : "Failed"));
    }

    /**
     * Tests the creation of a Cone object with valid dimensions.
     * @return true if the radius and height are correctly set, false otherwise.
     */
    public static boolean testValidDimensions() {
        System.out.println("🧪 TEST 30: Valid Dimensions 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(5, 10);
            result = (cone.getRadius() == 5 && cone.getHeight() == 10);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the creation of a Cone object with an invalid radius.
     * @return true if an exception is thrown, false otherwise.
     */
    public static boolean testInvalidRadius() {
        System.out.println("🧪 TEST 31: Invalid Radius 🧪");
        boolean result = false;
        try {
            new Cone(-5, 10);
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Radius and Height must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the creation of a Cone object with an invalid height.
     * @return true if an exception is thrown, false otherwise.
     */
    public static boolean testInvalidHeight() {
        System.out.println("🧪 TEST 32: Invalid Height 🧪");
        boolean result = false;
        try {
            new Cone(5, -10);
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Radius and Height must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateArea method of the Cone class.
     * @return true if the calculated area is correct, false otherwise.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 33: Calculate Area 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(3, 4); // Slant height = 5
            double expected = Math.PI * 3 * (3 + 5);
            double actual = cone.calculateArea();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateVolume method of the Cone class.
     * @return true if the calculated volume is correct, false otherwise.
     */
    public static boolean testCalculateVolume() {
        System.out.println("🧪 TEST 34: Calculate Volume 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(3, 4);
            double expected = (1.0 / 3) * Math.PI * 3 * 3 * 4;
            double actual = cone.calculateVolume();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getRadius method of the Cone class.
     * @return true if the radius is correctly retrieved, false otherwise.
     */
    public static boolean testGetRadius() {
        System.out.println("🧪 TEST 35: Get Radius 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(5, 10);
            result = (cone.getRadius() == 5.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getHeight method of the Cone class.
     * @return true if the height is correctly retrieved, false otherwise.
     */
    public static boolean testGetHeight() {
        System.out.println("🧪 TEST 36: Get Height 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(5, 10);
            result = (cone.getHeight() == 10.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setRadius method of the Cone class.
     * @return true if the radius is correctly updated, false otherwise.
     */
    public static boolean testSetRadius() {
        System.out.println("🧪 TEST 37: Set Radius 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(5, 10);
            cone.setRadius(8);
            result = (cone.getRadius() == 8.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setHeight method of the Cone class.
     * @return true if the height is correctly updated, false otherwise.
     */
    public static boolean testSetHeight() {
        System.out.println("🧪 TEST 38: Set Height 🧪");
        boolean result = false;
        try {
            Cone cone = new Cone(5, 10);
            cone.setHeight(12);
            result = (cone.getHeight() == 12.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
