package test;
import main.Square;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: SquareTest contains unit tests to validate the functionality
 * of the Square class, ensuring that area calculation and side handling
 * are correct.
 */
public class SquareTest {

    public static void main(String[] args) {
        boolean result1 = testCalculateArea();
        boolean result2 = testGetSide();

        System.out.println("SquareTest results:");
        System.out.println("testCalculateArea: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testGetSide: " + (result2 ? "Passed" : "Failed"));
    }

    public static boolean testCalculateArea() {
		System.out.println("🧪 TEST 1 🧪");
        Square square = new Square(4);
        double expectedArea = 16; // side^2 where side = 4
        return square.calculateArea() == expectedArea;
    }

    public static boolean testGetSide() {
		System.out.println("🧪 TEST 2 🧪");
        Square square = new Square(4);
        return square.getSide() == 4;
    }
}
