package test;
import main.Triangle;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: TriangleTest contains unit tests to validate the functionality
 * of the Triangle class, ensuring that area calculation, base, and height handling
 * are correct.
 */
public class TriangleTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateArea();
        boolean result2 = testGetBase();
        boolean result3 = testGetHeight();

        System.out.println("TriangleTest results:");
        System.out.println("testCalculateArea: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testGetBase: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testGetHeight: " + (result3 ? "Passed" : "Failed"));
    }

    public static boolean testCalculateArea() {
		System.out.println("🧪 TEST 1 🧪");
        Triangle triangle = new Triangle(4, 5);
        double expectedArea = 0.5 * 4 * 5; // 0.5 * base * height
        return triangle.calculateArea() == expectedArea;
    }

    public static boolean testGetBase() {
		System.out.println("🧪 TEST 2 🧪");
        Triangle triangle = new Triangle(4, 5);
        return triangle.getBase() == 4;
    }

    public static boolean testGetHeight() {
		System.out.println("🧪 TEST 3 🧪");
        Triangle triangle = new Triangle(4, 5);
        return triangle.getHeight() == 5;
    }
}
