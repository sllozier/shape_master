package test;
import main.Circle;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: CircleTest contains unit tests to validate the functionality
 * of the Circle class, ensuring that area calculation and radius handling
 * are correct.
 */
public class CircleTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateArea();
        boolean result2 = testGetRadius();

        System.out.println("CircleTest results:");
        System.out.println("testCalculateArea: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testGetRadius: " + (result2 ? "Passed" : "Failed"));
    }

    public static boolean testCalculateArea() {
		System.out.println("🧪 TEST 1 🧪");
        Circle circle = new Circle(5);
        double expectedArea = Math.PI * 25; // π * r^2 where r = 5
        return Math.abs(circle.calculateArea() - expectedArea) < 0.0001;
    }

    public static boolean testGetRadius() {
		System.out.println("🧪 TEST 2 🧪");
        Circle circle = new Circle(5);
        return circle.getRadius() == 5;
    }
}
