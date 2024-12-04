package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: SphereTest contains unit tests to validate the functionality
 * of the Sphere class, ensuring that area and volume calculations, as well as
 * radius handling, are accurate.
 */

import main.InvalidEntryException;
import main.Sphere;

public class SphereTest {

    public static void main(String[] args) {
        boolean result1 = testValidRadius();
        boolean result2 = testInvalidRadius();
        boolean result3 = testCalculateArea();
        boolean result4 = testCalculateVolume();
        boolean result5 = testGetRadius();
        boolean result6 = testSetRadius();

        System.out.println("SphereTest results:");
        System.out.println("testValidRadius: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testInvalidRadius: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testCalculateArea: " + (result3 ? "Passed" : "Failed"));
        System.out.println("testCalculateVolume: " + (result4 ? "Passed" : "Failed"));
        System.out.println("testGetRadius: " + (result5 ? "Passed" : "Failed"));
        System.out.println("testSetRadius: " + (result6 ? "Passed" : "Failed"));
    }

    /**
     * Tests creating a Sphere with a valid radius.
     * Verifies that the radius is set correctly.
     *
     * @return true if the radius is correctly set and returned.
     */
    public static boolean testValidRadius() {
        System.out.println("🧪 TEST 54: Valid Radius 🧪");
        boolean result = false;
        try {
            Sphere sphere = new Sphere(5);
            result = (sphere.getRadius() == 5);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests creating a Sphere with an invalid radius.
     * Verifies that an exception is thrown when the radius is negative or zero.
     *
     * @return true if the correct exception is thrown.
     */
    public static boolean testInvalidRadius() {
        System.out.println("🧪 TEST 55: Invalid Radius 🧪");
        boolean result = false;
        try {
            new Sphere(-5); // Invalid radius
        } catch (InvalidEntryException e) {
            result = e.getMessage().contains("Radius must be greater than 0.");
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateArea method of the Sphere class.
     * Verifies that the area is calculated correctly using the formula 4πr².
     *
     * @return true if the calculated area matches the expected value.
     */
    public static boolean testCalculateArea() {
        System.out.println("🧪 TEST 56: Calculate Area 🧪");
        boolean result = false;
        try {
            Sphere sphere = new Sphere(3);
            double expected = 4 * Math.PI * Math.pow(3, 2); // 4 * π * r^2
            double actual = sphere.calculateArea();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the calculateVolume method of the Sphere class.
     * Verifies that the volume is calculated correctly using the formula (4/3)πr³.
     *
     * @return true if the calculated volume matches the expected value.
     */
    public static boolean testCalculateVolume() {
        System.out.println("🧪 TEST 57: Calculate Volume 🧪");
        boolean result = false;
        try {
            Sphere sphere = new Sphere(3);
            double expected = (4.0 / 3.0) * Math.PI * Math.pow(3, 3); // (4/3) * π * r^3
            double actual = sphere.calculateVolume();
            result = Math.abs(expected - actual) < 0.01; // Allow a small tolerance
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the getRadius method of the Sphere class.
     * Verifies that the radius is returned correctly.
     *
     * @return true if the returned radius matches the expected value.
     */
    public static boolean testGetRadius() {
        System.out.println("🧪 TEST 58: Get Radius 🧪");
        boolean result = false;
        try {
            Sphere sphere = new Sphere(5);
            result = (sphere.getRadius() == 5.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the setRadius method of the Sphere class.
     * Verifies that the radius is updated correctly and no exceptions are thrown.
     *
     * @return true if the radius is correctly updated.
     */
    public static boolean testSetRadius() {
        System.out.println("🧪 TEST 59: Set Radius 🧪");
        boolean result = false;
        try {
            Sphere sphere = new Sphere(5);
            sphere.setRadius(8);
            result = (sphere.getRadius() == 8.0);
        } catch (InvalidEntryException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }
}
