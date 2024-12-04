package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: TorusTest contains unit tests to validate the functionality
 * of the Torus class, ensuring that area and volume calculations, as well as
 * radius handling, are accurate.
 */

import main.InvalidEntryException;
import main.Torus;

public class TorusTest {

    public static void main(String[] args) {
        boolean result1 = testValidRadii();
        boolean result2 = testInvalidMajorRadius();
        boolean result3 = testInvalidMinorRadius();
        boolean result4 = testCalculateArea();
        boolean result5 = testCalculateVolume();
        boolean result6 = testGetMajorRadius();
        boolean result7 = testGetMinorRadius();
        boolean result8 = testSetMajorRadius();
        boolean result9 = testSetMinorRadius();

        System.out.println("TorusTest results:");
        System.out.println("testValidRadii: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testInvalidMajorRadius: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testInvalidMinorRadius: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result4 ? "Passed" : "Failed"));
        System.out.println("testCalculateVolume: " + (result5 ? "Passed" : "Failed"));
        System.out.println("testGetMajorRadius: " + (result6 ? "Passed" : "Failed"));
        System.out.println("testGetMinorRadius: " + (result7 ? "Passed" : "Failed"));
        System.out.println("testSetMajorRadius: " + (result8 ? "Passed" : "Failed"));
        System.out.println("testSetMinorRadius: " + (result9 ? "Passed" : "Failed"));
    }

    /**
     * Tests creating a Torus with valid radii.
     * Verifies that the major and minor radii are set correctly.
     *
     * @return true if the radii are correctly set and returned.
     */
    public static boolean testValidRadii() {
        System.out.println("🧪 TEST 60: Valid Radii 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            result = (torus.getMajorRadius() == 5 && torus.getMinorRadius() == 2);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests creating a Torus with an invalid major radius.
     * Verifies that an exception is thrown when the major radius is negative or zero.
     *
     * @return true if the correct exception is thrown.
     */
    public static boolean testInvalidMajorRadius() {
        System.out.println("🧪 TEST 61: Invalid Major Radius 🧪");
        boolean result = false;
        try {
            new Torus(-5, 2);
        } catch (InvalidEntryException e) {
            result = e
                .getMessage()
                .contains("Major Radius and Minor Radius must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests creating a Torus with an invalid minor radius.
     * Verifies that an exception is thrown when the minor radius is negative or zero.
     *
     * @return true if the correct exception is thrown.
     */
    public static boolean testInvalidMinorRadius() {
        System.out.println("🧪 TEST 62: Invalid Minor Radius 🧪");
        boolean result = false;
        try {
            new Torus(5, -2);
        } catch (InvalidEntryException e) {
            result = e
                .getMessage()
                .contains("Major Radius and Minor Radius must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateArea method of the Torus class.
     * Verifies that the area is calculated correctly using the formula 4π²Rr.
     *
     * @return true if the calculated area matches the expected value.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 63: Calculate Area 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            double expected = 4 * Math.PI * Math.PI * 5 * 2; // 4 * π^2 * R * r
            double actual = torus.calculateArea();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateVolume method of the Torus class.
     * Verifies that the volume is calculated correctly using the formula 2π²Rr².
     *
     * @return true if the calculated volume matches the expected value.
     */
    public static boolean testCalculateVolume() {
        System.out.println("🧪 TEST 64: Calculate Volume 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            double expected = 2 * Math.PI * Math.PI * 5 * Math.pow(2, 2); // 2 * π^2 * R * r^2
            double actual = torus.calculateVolume();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getMajorRadius method of the Torus class.
     * Verifies that the major radius is returned correctly.
     *
     * @return true if the returned major radius matches the expected value.
     */
    public static boolean testGetMajorRadius() {
        System.out.println("🧪 TEST 65: Get Major Radius 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            result = (torus.getMajorRadius() == 5.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getMinorRadius method of the Torus class.
     * Verifies that the minor radius is returned correctly.
     *
     * @return true if the returned minor radius matches the expected value.
     */
    public static boolean testGetMinorRadius() {
        System.out.println("🧪 TEST 66: Get Minor Radius 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            result = (torus.getMinorRadius() == 2.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setMajorRadius method of the Torus class.
     * Verifies that the major radius is updated correctly and no exceptions are thrown.
     *
     * @return true if the major radius is correctly updated.
     */
    public static boolean testSetMajorRadius() {
        System.out.println("🧪 TEST 67: Set Major Radius 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            torus.setMajorRadius(7);
            result = (torus.getMajorRadius() == 7.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setMinorRadius method of the Torus class.
     * Verifies that the minor radius is updated correctly and no exceptions are thrown.
     *
     * @return true if the minor radius is correctly updated.
     */
    public static boolean testSetMinorRadius() {
        System.out.println("🧪 TEST 68: Set Minor Radius 🧪");
        boolean result = false;
        try {
            Torus torus = new Torus(5, 2);
            torus.setMinorRadius(3);
            result = (torus.getMinorRadius() == 3.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
