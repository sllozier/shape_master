package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: This test file verifies the functionality of the Cylinder class,
 * including its constructor, calculations for area and volume, getter and setter methods,
 * and proper handling of invalid input.
 */

import main.Cylinder;
import main.InvalidEntryException;

public class CylinderTest {

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

        System.out.println("CylinderTest results:");
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
     * Tests the creation of a Cylinder object with valid dimensions.
     * @return true if the radius and height are correctly set, false otherwise.
     */
    public static boolean testValidDimensions() {
        System.out.println("🧪 TEST 45: Valid Dimensions 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(5, 10);
            result = (cylinder.getRadius() == 5 && cylinder.getHeight() == 10);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the creation of a Cylinder object with an invalid radius.
     * @return true if an exception is thrown, false otherwise.
     */
    public static boolean testInvalidRadius() {
        System.out.println("🧪 TEST 46: Invalid Radius 🧪");
        boolean result = false;
        try {
            new Cylinder(-5, 10);
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Radius and Height must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the creation of a Cylinder object with an invalid height.
     * @return true if an exception is thrown, false otherwise.
     */
    public static boolean testInvalidHeight() {
        System.out.println("🧪 TEST 47: Invalid Height 🧪");
        boolean result = false;
        try {
            new Cylinder(5, -10);
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Radius and Height must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateArea method of the Cylinder class.
     * @return true if the calculated area is correct, false otherwise.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 48: Calculate Area 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(3, 4);
            double expected = 2 * Math.PI * 3 * (3 + 4); // 2 * π * r * (r + h)
            double actual = cylinder.calculateArea();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateVolume method of the Cylinder class.
     * @return true if the calculated volume is correct, false otherwise.
     */
    public static boolean testCalculateVolume() {
        System.out.println("🧪 TEST 49: Calculate Volume 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(3, 4);
            double expected = Math.PI * Math.pow(3, 2) * 4; // π * r^2 * h
            double actual = cylinder.calculateVolume();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getRadius method of the Cylinder class.
     * @return true if the radius is correctly retrieved, false otherwise.
     */
    public static boolean testGetRadius() {
        System.out.println("🧪 TEST 50: Get Radius 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(5, 10);
            result = (cylinder.getRadius() == 5.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getHeight method of the Cylinder class.
     * @return true if the height is correctly retrieved, false otherwise.
     */
    public static boolean testGetHeight() {
        System.out.println("🧪 TEST 51: Get Height 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(5, 10);
            result = (cylinder.getHeight() == 10.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setRadius method of the Cylinder class.
     * @return true if the radius is correctly updated, false otherwise.
     */
    public static boolean testSetRadius() {
        System.out.println("🧪 TEST 52: Set Radius 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(5, 10);
            cylinder.setRadius(8);
            result = (cylinder.getRadius() == 8.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setHeight method of the Cylinder class.
     * @return true if the height is correctly updated, false otherwise.
     */
    public static boolean testSetHeight() {
        System.out.println("🧪 TEST 53: Set Height 🧪");
        boolean result = false;
        try {
            Cylinder cylinder = new Cylinder(5, 10);
            cylinder.setHeight(12);
            result = (cylinder.getHeight() == 12.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
