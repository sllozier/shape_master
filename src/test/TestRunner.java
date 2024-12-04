package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: TestRunner.java is a utility class designed to systematically
 * execute and report on a series of unit tests covering the functionality of
 * the [enter class names] classes. It
 * assesses various aspects of each class, providing a structured and automated
 * approach to validating the system's correctness and robustness.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class TestRunner extends Application {

    // ANSI escape codes for text colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    /**
     * Launches the JavaFX application to run the tests.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the JavaFX stage and runs all test suites, displaying their
     * results.
     * It overrides the JavaFX Application's start method.
     *
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Suppress standard error
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(new ByteArrayOutputStream()));
        // Header for the test output
        System.out.println("-------------------------------------------------------");
        System.out.println(" T E S T S");
        System.out.println("-------------------------------------------------------");
        System.out.println("|");

        // Restore standard error
        System.setErr(originalErr);

        // Call test methods from different test classes
        runShapeTest();
        runTwoDimensionalShapeTest();
        runThreeDimensionalShapeTest();
        runCircleTest();
        runSquareTest();
        runTriangleTest();
        runRectangleTest();
        runProject1Test();
        runConeTest();
        runCubeTest();
        runCylinderTest();
        runSphereTest();
        runTorusTest();

        // Footer to indicate completion
        System.out.println("\nAll tests completed.");
        // Close the JavaFX application
        primaryStage.close();
        // Terminate the JavaFX application thread
        Platform.exit();
    }

    /**
     * Executes and reports on tests for the ShapeTest class. It runs the
     * following tests: testGetNumberOfDimensions, testCalculateAreaAbstract, and
     * testCalculateVolumeAbstract. The results of each test are displayed with
     * execution times.
     */
    private static void runShapeTest() {
        System.out.println("|+-- ShapeTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = ShapeTest.testGetNumberOfDimensions();
        boolean result2 = ShapeTest.testCalculateAreaAbstract();
        boolean result3 = ShapeTest.testCalculateVolumeAbstract();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 1: testGetNumberOfDimensions", result1);
        displayResult("TEST 2: testCalculateAreaAbstract", result2);
        displayResult("TEST 3: testCalculateVolumeAbstract", result3);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the TwoDimensionalShapeTest class. It runs the
     * following tests: testCalculateVolume, and
     * testCalculateArea. The results of each test are displayed with
     * execution times.
     */
    private static void runTwoDimensionalShapeTest() {
        System.out.println("|+-- TwoDimensionalShapeTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = TwoDimensionalShapeTest.testCalculateVolume();
        boolean result2 = TwoDimensionalShapeTest.testCalculateArea();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 4: testCalculateVolume", result1);
        displayResult("TEST 5: testCalculateArea", result2);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the ThreeDimensionalShapeTest class. It runs the
     * following tests: testCalculateVolume, and
     * testCalculateArea. The results of each test are displayed with
     * execution times.
     */
    private static void runThreeDimensionalShapeTest() {
        System.out.println("|+-- ThreeDimensionalShapeTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = ThreeDimensionalShapeTest.testCalculateArea();
        boolean result2 = ThreeDimensionalShapeTest.testCalculateVolume();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 6: testCalculateVolume", result1);
        displayResult("TEST 7: testCalculateArea", result2);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the CircleTest class. It runs the
     * following tests: testValidRadius, testInvalidRadius, testGetRadius, and
     * testCalculateArea. The results of each test are displayed with
     * execution times.
     */
    private static void runCircleTest() {
        System.out.println("|+-- CircleTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = CircleTest.testValidRadius();
        boolean result2 = CircleTest.testInvalidRadius();
        boolean result3 = CircleTest.testCalculateArea();
        boolean result4 = CircleTest.testGetRadius();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 8: testValidRadius", result1);
        displayResult("TEST 9: testInvalidRadius", result2);
        displayResult("TEST 10: testCalculateArea", result3);
        displayResult("TEST 11: testGetRadius", result4);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the SquareTest class. It runs the
     * following tests: testCalculateArea,
     * testGetSide, testValidSide, and testInvalidSide. The results of each test are displayed with
     * execution times.
     */
    private static void runSquareTest() {
        System.out.println("|+-- SquareTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = SquareTest.testCalculateArea();
        boolean result2 = SquareTest.testGetSide();
        boolean result3 = SquareTest.testValidSide();
        boolean result4 = SquareTest.testInvalidSide();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 12: testCalculateArea", result1);
        displayResult("TEST 13: testGetSide", result2);
        displayResult("TEST 14: testCalculateArea", result3);
        displayResult("TEST 15: testGetSide", result4);
        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the TriangleTest class. It runs the
     * following tests: testCalculateArea, testGetBase, and
     * testGetHeight. The results of each test are displayed with
     * execution times.
     */
    private static void runTriangleTest() {
        System.out.println("|+-- TriangleTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = TriangleTest.testCalculateArea();
        boolean result2 = TriangleTest.testGetBase();
        boolean result3 = TriangleTest.testGetHeight();
        boolean result4 = TriangleTest.testValidBaseHeight();
        boolean result5 = TriangleTest.testInvalidBaseHeight();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 16: testCalculateArea", result1);
        displayResult("TEST 17: testGetBase", result2);
        displayResult("TEST 18: testGetHeight", result3);
        displayResult("TEST 19: testValidBaseHeight", result4);
        displayResult("TEST 20: testInvalidBaseHeight", result5);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the RectangleTest class. It runs the
     * following tests: testCalculateArea, testGetLength, and
     * testGetWidth. The results of each test are displayed with
     * execution times.
     */
    private static void runRectangleTest() {
        System.out.println("|+-- RectangleTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = RectangleTest.testValidDimensions();
        boolean result2 = RectangleTest.testInvalidLength();
        boolean result3 = RectangleTest.testInvalidWidth();
        boolean result4 = RectangleTest.testCalculateArea();
        boolean result5 = RectangleTest.testGetLength();
        boolean result6 = RectangleTest.testGetWidth();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 21: testValidDimensions", result1);
        displayResult("TEST 22: testInvalidLength", result2);
        displayResult("TEST 23: testInvalidWidth", result3);
        displayResult("TEST 24: testCalculateArea", result4);
        displayResult("TEST 25: testGetLength", result5);
        displayResult("TEST 26: testGetWidth", result6);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the Project1 class. It runs the
     * following tests: testGetValidIntegerInput, testGetValidDoubleInput, and
     * testAskToContinue. The results of each test are displayed with
     * execution times.
     */
    private static void runProject1Test() {
        System.out.println("|+-- Project1Test");

        // Execute and display results for Graduate specific tests
        boolean result1 = Project1Test.testUsingValidInputs();
        boolean result2 = Project1Test.testUsingInvalidInputs();
        boolean result3 = Project1Test.testAskToContinue();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 27: testUsingValidInputs", result1);
        displayResult("TEST 28: testUsingInvalidInputs", result2);
        displayResult("TEST 29: testAskToContinue", result3);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the Cone class. It runs the
     * following tests: testValidDimensions, testInvalidRadius, testInvalidHeight,
     * testCalculateArea, testCalculateVolume, testGetRadius, testGetHeight,
     * testSetRadius and testSetHeight. The results of each test are displayed with
     * execution times.
     */
    private static void runConeTest() {
        System.out.println("|+-- ConeTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = ConeTest.testValidDimensions();
        boolean result2 = ConeTest.testInvalidRadius();
        boolean result3 = ConeTest.testInvalidHeight();
        boolean result4 = ConeTest.testCalculateArea();
        boolean result5 = ConeTest.testCalculateVolume();
        boolean result6 = ConeTest.testGetRadius();
        boolean result7 = ConeTest.testGetHeight();
        boolean result8 = ConeTest.testSetRadius();
        boolean result9 = ConeTest.testSetHeight();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 30: testValidDimensions", result1);
        displayResult("TEST 31: testInvalidRadius", result2);
        displayResult("TEST 32: testInvalidHeight", result3);
        displayResult("TEST 33: testCalculateArea", result4);
        displayResult("TEST 34: testCalculateVolume", result5);
        displayResult("TEST 35: testGetRadius", result6);
        displayResult("TEST 36: testGetHeight", result7);
        displayResult("TEST 37: testSetRadius", result8);
        displayResult("TEST 38: testSetHeight", result9);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the Cube class. It runs the
     * following tests: testValidSide, testInvalidSide,testCalculateArea,
     * testCalculateVolume, testGetSide,and testSetSide. The results of
     * each test are displayed with execution times.
     */
    private static void runCubeTest() {
        System.out.println("|+-- CubeTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = CubeTest.testValidSide();
        boolean result2 = CubeTest.testInvalidSide();
        boolean result3 = CubeTest.testCalculateArea();
        boolean result4 = CubeTest.testCalculateVolume();
        boolean result5 = CubeTest.testGetSide();
        boolean result6 = CubeTest.testSetSide();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 39: testValidSide", result1);
        displayResult("TEST 40: testInvalidSide", result2);
        displayResult("TEST 41: testCalculateArea", result3);
        displayResult("TEST 42: testCalculateVolume", result4);
        displayResult("TEST 43: testGetSide", result5);
        displayResult("TEST 44: testSetSide", result6);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the Cylinder class. It runs the
     * following tests: testValidDimensions, testInvalidRadius, testInvalidHeight,
     * testCalculateArea, testCalculateVolume, testGetRadius, testGetHeight,
     * testSetRadius and testSetHeight. The results of each test are displayed with
     * execution times.
     */
    private static void runCylinderTest() {
        System.out.println("|+-- CylinderTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = CylinderTest.testValidDimensions();
        boolean result2 = CylinderTest.testInvalidRadius();
        boolean result3 = CylinderTest.testInvalidHeight();
        boolean result4 = CylinderTest.testCalculateArea();
        boolean result5 = CylinderTest.testCalculateVolume();
        boolean result6 = CylinderTest.testGetRadius();
        boolean result7 = CylinderTest.testGetHeight();
        boolean result8 = CylinderTest.testSetRadius();
        boolean result9 = CylinderTest.testSetHeight();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 45: testValidDimensions", result1);
        displayResult("TEST 46: testInvalidRadius", result2);
        displayResult("TEST 47: testInvalidHeight", result3);
        displayResult("TEST 48: testCalculateArea", result4);
        displayResult("TEST 49: testCalculateVolume", result5);
        displayResult("TEST 50: testGetRadius", result6);
        displayResult("TEST 51: testGetHeight", result7);
        displayResult("TEST 52: testSetRadius", result8);
        displayResult("TEST 53: testSetHeight", result9);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the Sphere class. It runs the
     * following tests: testValidRadius, testInvalidRadius,testCalculateArea,
     * testCalculateVolume, testGetRadius,and testSetRadius. The results of
     * each test are displayed with execution times.
     */
    private static void runSphereTest() {
        System.out.println("|+-- SphereTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = SphereTest.testValidRadius();
        boolean result2 = SphereTest.testInvalidRadius();
        boolean result3 = SphereTest.testCalculateArea();
        boolean result4 = SphereTest.testCalculateVolume();
        boolean result5 = SphereTest.testGetRadius();
        boolean result6 = SphereTest.testSetRadius();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 54: testValidRadius", result1);
        displayResult("TEST 55: testInvalidRadius", result2);
        displayResult("TEST 56: testCalculateArea", result3);
        displayResult("TEST 57: testCalculateVolume", result4);
        displayResult("TEST 58: testGetRadius", result5);
        displayResult("TEST 59: testSetRadius", result6);

        System.out.println("|");
    }

    /**
     * Executes and reports on tests for the Torus class. It runs the
     * following tests: testValidRadii, testInvalidMajorRadius, testInvalidMinorRadius,
     * testCalculateArea, testCalculateVolume, testGetMajorRadius, testGetMinorRadius,
     * testSetMajorRadius and testSetMinorRadius. The results of each test are displayed with
     * execution times.
     */
    private static void runTorusTest() {
        System.out.println("|+-- TorusTest");

        // Execute and display results for Graduate specific tests
        boolean result1 = TorusTest.testValidRadii();
        boolean result2 = TorusTest.testInvalidMajorRadius();
        boolean result3 = TorusTest.testInvalidMinorRadius();
        boolean result4 = TorusTest.testCalculateArea();
        boolean result5 = TorusTest.testCalculateVolume();
        boolean result6 = TorusTest.testGetMajorRadius();
        boolean result7 = TorusTest.testGetMinorRadius();
        boolean result8 = TorusTest.testSetMajorRadius();
        boolean result9 = TorusTest.testSetMinorRadius();

        // Report on each test's execution time and result
        System.out.println("|");

        // Calculate and display execution times
        displayResult("TEST 60: testValidRadii", result1);
        displayResult("TEST 61: testInvalidMajorRadius", result2);
        displayResult("TEST 62: testInvalidMinorRadius", result3);
        displayResult("TEST 63: testCalculateArea", result4);
        displayResult("TEST 64: testCalculateVolume", result5);
        displayResult("TEST 65: testGetMajorRadius", result6);
        displayResult("TEST 66: testGetMinorRadius", result7);
        displayResult("TEST 67: testSetMajorRadius", result8);
        displayResult("TEST 68: testSetMinorRadius", result9);

        System.out.println("|");
    }

    /**
     * Displays the result of a test in a formatted manner, including the test name
     * and whether it passed or failed.
     *
     * @param testName The name of the test.
     * @param result   The result of the test (true if passed, false if failed).
     */
    private static void displayResult(String testName, boolean result) {
        String resultString = (result ? ANSI_GREEN + "[OK]" : ANSI_RED + "[FAILED]") + ANSI_RESET;
        System.out.printf("| +-- %s: %s\n", testName, resultString);
    }
}
