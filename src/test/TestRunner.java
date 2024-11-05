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
		//runBinaryTreeTest();
		//runTreeSyntaxExceptionTest();
		//runProject3Test();

		// Footer to indicate completion
		System.out.println("\nAll tests completed.");

	}

	/**
	 * Executes and reports on tests for the BinaryTreeTest class. It runs the
	 * following tests: testTreeConstruction, testInvalidTree,
	 * testExtraCharactersAtEnd, testIsBST, testIsBalanced, testHeight, and
	 * testBalancedTreeConstruction. The results of each test are displayed with
	 * execution times.
	 */
	//private static void runBinaryTreeTest() {
	//	System.out.println("|+-- BinaryTreeTest");

	//	// Execute and display results for Graduate specific tests
	//	boolean result1 = BinaryTreeTest.testTreeConstruction();
	//	boolean result2 = BinaryTreeTest.testInvalidTree();
	//	boolean result3 = BinaryTreeTest.testExtraCharactersAtEnd();
	//	boolean result4 = BinaryTreeTest.testIsBST();
	//	boolean result5 = BinaryTreeTest.testIsBalanced();
	//	boolean result6 = BinaryTreeTest.testHeight();
	//	boolean result7 = BinaryTreeTest.testBalancedTreeConstruction();

	//	// Report on each test's execution time and result
	//	System.out.println("|");

	//	// Calculate and display execution times
	//	displayResult("TEST 1: testTreeConstruction", result1);
	//	displayResult("TEST 2: testInvalidTree", result2);
	//	displayResult("TEST 3: testExtraCharactersAtEnd", result3);
	//	displayResult("TEST 4: testIsBST", result4);
	//	displayResult("TEST 5: testIsBalanced", result5);
	//	displayResult("TEST 6: testHeight", result6);
	//	displayResult("TEST 7: testBalancedTreeConstruction", result7);
	//	System.out.println("|");
	//}

	
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
