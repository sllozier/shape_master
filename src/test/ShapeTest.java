package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: ShapeTest.java contains unit tests to validate the functionality
 * of the Shape class, ensuring the proper setting of dimensions and abstract methods.
 */
import main.Shape;

public class ShapeTest {

    public static void main(String[] args) {
        boolean result1 = testGetNumberOfDimensions();
        boolean result2 = testCalculateAreaAbstract();
        boolean result3 = testCalculateVolumeAbstract();

        System.out.println("ShapeTest results:");
        System.out.println("testGetNumberOfDimensions: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testCalculateAreaAbstract: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testCalculateVolumeAbstract: " + (result3 ? "Passed" : "Failed"));
    }

    /**
     * Tests the getNumberOfDimensions method.
     *
     * @return true if the dimensions are correctly retrieved, false otherwise.
     */
    public static boolean testGetNumberOfDimensions() {
        System.out.println("🧪 TEST 1 🧪");
        Shape shape = new Shape(2) {
            public double calculateArea() {
                return 0;
            }

            public double calculateVolume() {
                return 0;
            }
        };
        int expected = 2;
        int actual = shape.getNumberOfDimensions();
        System.out.println("Expected: " + expected + ", Actual: " + actual);
        return actual == expected;
    }

    /**
     * Tests that calculateArea is abstract and can be overridden.
     *
     * @return true if the method works as expected, false otherwise.
     */
    public static boolean testCalculateAreaAbstract() {
        System.out.println("🧪 TEST 2 🧪");
        try {
            Shape shape = new Shape(2) {
                public double calculateArea() {
                    return 50.0;
                }

                public double calculateVolume() {
                    return 0;
                }
            };
            double expected = 50.0;
            double actual = shape.calculateArea();
            System.out.println("Expected: " + expected + ", Actual: " + actual);
            return actual == expected;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Tests that calculateVolume is abstract and can be overridden.
     *
     * @return true if the method works as expected, false otherwise.
     */
    public static boolean testCalculateVolumeAbstract() {
        System.out.println("🧪 TEST 3 🧪");
        try {
            Shape shape = new Shape(3) {
                public double calculateArea() {
                    return 0;
                }

                public double calculateVolume() {
                    return 150.0;
                }
            };
            double expected = 150.0;
            double actual = shape.calculateVolume();
            System.out.println("Expected: " + expected + ", Actual: " + actual);
            return actual == expected;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
