package test;
import main.Rectangle;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: RectangleTest contains unit tests to validate the functionality
 * of the Rectangle class, ensuring that area calculation, length, and width handling
 * are correct.
 */
public class RectangleTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateArea();
        boolean result2 = testGetLength();
        boolean result3 = testGetWidth();

        System.out.println("RectangleTest results:");
        System.out.println("testCalculateArea: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testGetLength: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testGetWidth: " + (result3 ? "Passed" : "Failed"));
    }

    public static boolean testCalculateArea() {
		System.out.println("🧪 TEST 1 🧪");
        Rectangle rectangle = new Rectangle(4, 5);
        double expectedArea = 4 * 5; // length * width
        return rectangle.calculateArea() == expectedArea;
    }

    public static boolean testGetLength() {
		System.out.println("🧪 TEST 2 🧪");
        Rectangle rectangle = new Rectangle(4, 5);
        return rectangle.getLength() == 4;
    }

    public static boolean testGetWidth() {
		System.out.println("🧪 TEST 3 🧪");
        Rectangle rectangle = new Rectangle(4, 5);
        return rectangle.getWidth() == 5;
    }
}
