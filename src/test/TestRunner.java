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

public class TestRunner {
	// ANSI escape codes for text colors
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_RED = "\u001B[31m";

	/**
	 * The main method serves as the entry point for the TestRunner. It prints a
	 * header, runs tests for GetSourceCode, Project1, and FileProcessor classes,
	 * and prints a footer indicating the completion of all tests.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		// Header for the test output
		System.out.println("-------------------------------------------------------");
		System.out.println(" T E S T S");
		System.out.println("-------------------------------------------------------");
		System.out.println("|");

		// Call test methods from different test classes
		runShapeTest();
		runTwoDimensionalShapeTest();
		runThreeDimensionalShapeTest();
		runCircleTest();
		runSquareTest();
		runTriangleTest();
		runRectangleTest();

		// Footer to indicate completion
		System.out.println("\nAll tests completed.");

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
		displayResult("TEST 1: testCalculateVolume", result1);
		displayResult("TEST 2: testCalculateArea", result2);


		System.out.println("|");
	}


	/**
	 * Executes and reports on tests for the ThreeDimensionalShapeTest class. It runs the
	 * following tests: testCalculateVolume, and
	 * testCalculateArea. The results of each test are displayed with
	 * execution times.
	 */
	private static void runThreeDimensionalShapeTest() {
		System.out.println("|+-- TwoDimensionalShapeTest");

		// Execute and display results for Graduate specific tests
		boolean result1 = ThreeDimensionalShapeTest.testCalculateVolume();
		boolean result2 = ThreeDimensionalShapeTest.testCalculateArea();
		
	

		// Report on each test's execution time and result
		System.out.println("|");

		// Calculate and display execution times
		displayResult("TEST 1: testCalculateVolume", result1);
		displayResult("TEST 2: testCalculateArea", result2);


		System.out.println("|");
	}

	/**
	 * Executes and reports on tests for the CircleTest class. It runs the
	 * following tests: testGetRadius, and
	 * testCalculateArea. The results of each test are displayed with
	 * execution times.
	 */
	private static void runCircleTest() {
		System.out.println("|+-- CircleTest");

		// Execute and display results for Graduate specific tests
		boolean result1 = CircleTest.testCalculateArea();
		boolean result2 = CircleTest.testGetRadius();
		
	

		// Report on each test's execution time and result
		System.out.println("|");

		// Calculate and display execution times
		displayResult("TEST 1: testCalculateArea", result1);
		displayResult("TEST 2: testGetRadius", result2);


		System.out.println("|");
	}

	/**
	 * Executes and reports on tests for the SquareTest class. It runs the
	 * following tests: testCalculateArea, and
	 * testGetSide. The results of each test are displayed with
	 * execution times.
	 */
	private static void runSquareTest() {
		System.out.println("|+-- SquareTest");

		// Execute and display results for Graduate specific tests
		boolean result1 = SquareTest.testCalculateArea();
		boolean result2 = SquareTest.testGetSide();
		
	

		// Report on each test's execution time and result
		System.out.println("|");

		// Calculate and display execution times
		displayResult("TEST 1: testCalculateArea", result1);
		displayResult("TEST 2: testGetSide", result2);


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
		
	

		// Report on each test's execution time and result
		System.out.println("|");

		// Calculate and display execution times
		displayResult("TEST 1: testCalculateArea", result1);
		displayResult("TEST 2: testGetBase", result2);
		displayResult("TEST 3: testGetHeight", result3);


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
		boolean result1 = RectangleTest.testCalculateArea();
		boolean result2 = RectangleTest.testGetLength();
		boolean result3 = RectangleTest.testGetWidth();
		
	

		// Report on each test's execution time and result
		System.out.println("|");

		// Calculate and display execution times
		displayResult("TEST 1: testCalculateArea", result1);
		displayResult("TEST 2: testGetLength", result2);
		displayResult("TEST 3: testGetWidth", result3);


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
