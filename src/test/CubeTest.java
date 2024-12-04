package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: This test file verifies the functionality of the Cube class,
 * including its constructor, calculations for area and volume, getter and setter methods,
 * and proper handling of invalid input.
 */

import main.Cube;
import main.InvalidEntryException;

public class CubeTest {

    public static void main(String[] args) {
        boolean result1 = testValidSide();
        boolean result2 = testInvalidSide();
        boolean result3 = testCalculateArea();
        boolean result4 = testCalculateVolume();
        boolean result5 = testGetSide();
        boolean result6 = testSetSide();

        System.out.println("CubeTest results:");
        System.out.println("testValidSide: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testInvalidSide: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testCalculateVolume: " + (result4 ? "Passed" : "Failed"));
        System.out.println("testGetSide: " + (result5 ? "Passed" : "Failed"));
        System.out.println("testSetSide: " + (result6 ? "Passed" : "Failed"));
    }

    /**
     * Tests the creation of a Cube object with a valid side length.
     * @return true if the side length is correctly set, false otherwise.
     */
    public static boolean testValidSide() {
        System.out.println("🧪 TEST 39: Valid Side 🧪");
        boolean result = false;
        try {
            Cube cube = new Cube(5);
            result = (cube.getSide() == 5);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the creation of a Cube object with an invalid side length.
     * @return true if an exception is thrown, false otherwise.
     */
    public static boolean testInvalidSide() {
        System.out.println("🧪 TEST 40: Invalid Side 🧪");
        boolean result = false;
        try {
            new Cube(-5);
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Side must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateArea method of the Cube class.
     * @return true if the calculated area is correct, false otherwise.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 41: Calculate Area 🧪");
        boolean result = false;
        try {
            Cube cube = new Cube(3);
            double expected = 6 * Math.pow(3, 2); // 6 * side^2
            double actual = cube.calculateArea();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateVolume method of the Cube class.
     * @return true if the calculated volume is correct, false otherwise.
     */
    public static boolean testCalculateVolume() {
        System.out.println("🧪 TEST 42: Calculate Volume 🧪");
        boolean result = false;
        try {
            Cube cube = new Cube(3);
            double expected = Math.pow(3, 3); // side^3
            double actual = cube.calculateVolume();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getSide method of the Cube class.
     * @return true if the side length is correctly retrieved, false otherwise.
     */
    public static boolean testGetSide() {
        System.out.println("🧪 TEST 43: Get Side 🧪");
        boolean result = false;
        try {
            Cube cube = new Cube(5);
            result = (cube.getSide() == 5.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setSide method of the Cube class.
     * @return true if the side length is correctly updated, false otherwise.
     */
    public static boolean testSetSide() {
        System.out.println("🧪 TEST 44: Set Side 🧪");
        boolean result = false;
        try {
            Cube cube = new Cube(5);
            cube.setSide(8);
            result = (cube.getSide() == 8.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
