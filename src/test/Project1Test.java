package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: Project1Test contains unit tests to validate the functionality of
 * core reusable methods in the Project1 class.
 */

import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.InvalidEntryException;
import main.Project1;

public class Project1Test {

    public static void main(String[] args) {
        boolean result1 = testUsingValidInputs();
        boolean result2 = testUsingInvalidInputs();
        boolean result3 = testAskToContinue();

        System.out.println("Project1Test results:");
        System.out.println("testUsingValidInputs: " + (result1 ? "Passed" : "Failed"));
        System.out.println("testUsingInvalidInputs: " + (result2 ? "Passed" : "Failed"));
        System.out.println("testAskToContinue: " + (result3 ? "Passed" : "Failed"));
    }

    /**
     * Tests the behavior of Project1 with valid inputs from a JSON file.
     * @return true if all sessions with valid inputs pass successfully, false otherwise.
     */
    public static boolean testUsingValidInputs() {
        System.out.println("🧪 TEST 27: Valid Inputs 🧪");
        boolean result = processJsonFileBySession("docs/validInputs.json", true);
        System.out.println("Expected: true, Actual: " + result);
        return result;
    }

    /**
     * Tests the behavior of Project1 with invalid inputs from a JSON file.
     * @return true if all sessions with invalid inputs fail as expected, false otherwise.
     */
    public static boolean testUsingInvalidInputs() {
        System.out.println("🧪 TEST 28: Invalid Inputs 🧪");
        boolean result = processJsonFileBySession("docs/invalidInputs.json", false);
        boolean passed = !result;
        System.out.println("Expected: false, Actual: " + result);
        return passed;
    }

    /**
     * Tests the askToContinue method in Project1.
     * Simulates user inputs and verifies the method's behavior.
     * @return true if the method behaves as expected, false otherwise.
     */
    public static boolean testAskToContinue() {
        System.out.println("🧪 TEST 29 🧪");

        // Create a PrintStream to capture standard output
        PrintStream originalOut = System.out; // Save the original System.out
        PrintStream dummyOut = new PrintStream(OutputStream.nullOutputStream()); // Dummy output stream

        try {
            // Read the JSON data from the file
            String jsonData = Files.readString(Path.of("docs/validInputs.json"));

            // Extract all sessions
            List<String> sessions = extractSessions(jsonData);

            // Temporarily redirect System.out to dummyOut
            System.setOut(dummyOut);

            // Iterate over each session
            for (int sessionIndex = 0; sessionIndex < sessions.size(); sessionIndex++) {
                String session = sessions.get(sessionIndex);

                // Extract actions for the current session
                List<String> actions = extractActions(session);

                // Iterate over actions within the session
                for (int actionIndex = 0; actionIndex < actions.size(); actionIndex++) {
                    String action = actions.get(actionIndex);

                    // Extract the "continue" value
                    String continueValue = extractStringValue(action, "continue");

                    // Expected and actual results
                    boolean expected = "Y".equalsIgnoreCase(continueValue);
                    boolean actual = Project1.askToContinue(new Scanner(continueValue));

                    // Restore original System.out for logging
                    System.setOut(originalOut);

                    // Log the expected and actual values
                    System.out.println("Expected: " + expected + ", Actual: " + actual);

                    // Temporarily suppress output again
                    System.setOut(dummyOut);

                    // Validate the result
                    if (expected != actual) {
                        System.setOut(originalOut); // Restore original System.out before returning
                        System.out.println(
                            "askToContinue failed in session %d, action %d. Expected: %b, Actual: %b%n" +
                            sessionIndex +
                            1 +
                            actionIndex +
                            1 +
                            expected +
                            actual
                        );
                        return false; // Test failed
                    }
                }
            }

            // All tests passed
            return true;
        } catch (Exception e) {
            System.setOut(originalOut); // Restore original System.out in case of an exception
            e.printStackTrace();
            return false;
        } finally {
            // Always restore original System.out
            System.setOut(originalOut);
        }
    }

    /**
     * Processes a JSON file containing test sessions.
     * @param filePath Path to the JSON file.
     * @param isValid Indicates whether the test data represents valid inputs.
     * @return true if all sessions are processed successfully, false otherwise.
     */
    private static boolean processJsonFileBySession(String filePath, boolean isValid) {
        try {
            String jsonData = Files.readString(Path.of(filePath));
            List<String> sessions = extractSessions(jsonData); // Extract all sessions

            boolean allSessionsPassed = true;
            for (int i = 0; i < sessions.size(); i++) {
                String session = sessions.get(i);
                boolean sessionPassed = processSession(session, isValid, i + 1);
                if (!sessionPassed) {
                    allSessionsPassed = false; // Mark as failed if any session fails
                }
            }
            return allSessionsPassed;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Processes a single session of test data.
     * @param session The JSON representation of the session.
     * @param isValid Indicates whether the test data represents valid inputs.
     * @param sessionIndex The index of the current session.
     * @return true if the session is processed successfully, false otherwise.
     */
    private static boolean processSession(String session, boolean isValid, int sessionIndex) {
        try {
            // Extract actions specific to the given session
            List<String> actions = extractActions(session);

            boolean sessionPassed = true;

            for (int j = 0; j < actions.size(); j++) {
                String action = actions.get(j);
                int actionType = extractIntValue(action, "actionType");
                String shapeType = extractStringValue(action, "shapeType");

                try {
                    simulateShapeCreation(actionType, action);

                    // For invalidInputs tests, not throwing an exception is a failure
                    if (!isValid) {
                        sessionPassed = false;
                    }
                } catch (InvalidEntryException e) {
                    // For validInputs tests, throwing an exception is a failure
                    if (isValid) {
                        sessionPassed = false;
                    }
                }

                // Break the loop early if the session has already failed
                if (!sessionPassed) {
                    break;
                }
            }

            return sessionPassed;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Simulates the creation of a shape based on the given action type.
     * @param actionType The type of shape to create.
     * @param action The JSON data representing the action.
     * @throws InvalidEntryException If invalid data is encountered.
     */
    private static void simulateShapeCreation(int actionType, String action)
        throws InvalidEntryException {
        switch (actionType) {
            case 1: // Circle
                double radius = extractDoubleValue(action, "radius");
                break;
            case 2: // Rectangle
                double length = extractDoubleValue(action, "length");
                double width = extractDoubleValue(action, "width");
                break;
            case 3: // Square
                double side = extractDoubleValue(action, "side");
                break;
            case 4: // Triangle
                double base = extractDoubleValue(action, "base");
                double height = extractDoubleValue(action, "height");
                break;
            case 5: // Sphere
                double sphereRadius = extractDoubleValue(action, "radius");
                break;
            case 6: // Cube
                double cubeSide = extractDoubleValue(action, "side");
                break;
            case 7: // Cone
                double coneRadius = extractDoubleValue(action, "radius");
                double coneHeight = extractDoubleValue(action, "height");
                break;
            case 8: // Cylinder
                double cylinderRadius = extractDoubleValue(action, "radius");
                double cylinderHeight = extractDoubleValue(action, "height");
                break;
            case 9: // Torus
                double majorRadius = extractDoubleValue(action, "majorRadius");
                double minorRadius = extractDoubleValue(action, "minorRadius");
                break;
            case 10: // Exit
                break;
            default:
                throw new InvalidEntryException("Invalid action type: " + actionType);
        }
    }

    /**
     * Extracts a list of sessions from the JSON data.
     * @param jsonData The JSON data as a string.
     * @return A list of session strings.
     */
    private static List<String> extractSessions(String jsonData) {
        List<String> sessions = new ArrayList<>();
        try {
            int start = jsonData.indexOf("\"sessions\": [") + "\"sessions\": [".length();
            int end = jsonData.lastIndexOf("]"); // Finds the last closing bracket for sessions
            String sessionArray = jsonData.substring(start, end).trim();

            // Parse sessionArray manually to extract complete session objects
            int braceCount = 0;
            StringBuilder currentSession = new StringBuilder();
            boolean insideSession = false;

            for (int i = 0; i < sessionArray.length(); i++) {
                char c = sessionArray.charAt(i);

                if (c == '{') {
                    braceCount++;
                    insideSession = true;
                } else if (c == '}') {
                    braceCount--;
                }

                if (insideSession) {
                    currentSession.append(c);
                }

                // When braceCount reaches zero, we have a complete session object
                if (braceCount == 0 && insideSession) {
                    sessions.add(currentSession.toString().trim());
                    currentSession.setLength(0); // Reset for the next session
                    insideSession = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessions;
    }

    /**
     * Extracts actions from a session.
     * @param session The JSON representation of the session.
     * @return A list of actions as strings.
     */
    private static List<String> extractActions(String session) {
        List<String> actions = new ArrayList<>();

        try {
            // Locate the "actions" array in the session JSON
            int start = session.indexOf("\"actions\": [") + "\"actions\": [".length();
            int end = session.lastIndexOf("]"); // Use lastIndexOf to capture the entire array

            if (start == -1 || end == -1 || end < start) {
                System.err.println("Error: Unable to locate actions array in session.");
                return actions;
            }

            // Extract the full actions array
            String actionArray = session.substring(start, end + 1).trim();

            // Split the array into individual actions
            for (String action : actionArray.split("\\},\\s*\\{")) {
                action = action.trim();

                // Ensure each action is properly formatted as JSON
                if (!action.startsWith("{")) {
                    action = "{" + action;
                }
                if (!action.endsWith("}")) {
                    action = action + "}";
                }

                actions.add(action); // Add the formatted action to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actions;
    }

    /**
     * Extracts a string value from a JSON string based on the key.
     * @param jsonData The JSON data as a string.
     * @param key The key to extract the value for.
     * @return The extracted string value.
     */
    private static String extractStringValue(String jsonData, String key) {
        // Locate the key in the JSON
        int keyIndex = jsonData.indexOf("\"" + key + "\": ");
        if (keyIndex == -1) {
            System.err.printf("Key \"%s\" not found in JSON data.%n", key);
            return ""; // Return empty if the key is not found
        }

        // Move the pointer past the key
        int start = keyIndex + key.length() + 4;

        // Check if the value starts with a quote (string value)
        if (jsonData.charAt(start) == '\"') {
            start++; // Move past the opening quote
            int end = jsonData.indexOf("\"", start); // Find the closing quote
            if (end == -1) {
                System.err.printf("Missing closing quote for key \"%s\".%n", key);
                return ""; // Return empty if closing quote is missing
            }
            String value = jsonData.substring(start, end).trim();
            return value;
        }

        // If not a string, look for a non-quoted value (e.g., number, boolean, or null)
        int end = jsonData.indexOf(",", start); // Look for the next comma
        if (end == -1) {
            end = jsonData.indexOf("}", start); // Look for the end of the object
        }
        if (end == -1) {
            System.err.printf("Unable to determine the end of value for key \"%s\".%n", key);
            return ""; // Return empty if no valid end is found
        }

        String value = jsonData.substring(start, end).trim();
        return value;
    }

    /**
     * Extracts an integer value from a JSON string based on the key.
     * @param jsonData The JSON data as a string.
     * @param key The key to extract the value for.
     * @return The extracted integer value.
     */
    private static int extractIntValue(String jsonData, String key) {
        int start = jsonData.indexOf("\"" + key + "\": ") + key.length() + 3;
        int end = jsonData.indexOf(",", start);
        return Integer.parseInt(jsonData.substring(start, end).trim());
    }

    /**
     * Extracts a double value from a JSON string based on the key.
     * @param jsonData The JSON data as a string.
     * @param key The key to extract the value for.
     * @return The extracted double value.
     */
    private static double extractDoubleValue(String jsonData, String key) {
        int start = jsonData.indexOf("\"" + key + "\": ") + key.length() + 3;

        // Find the first occurrence of either ',' or '}'
        int commaIndex = jsonData.indexOf(",", start);
        int braceIndex = jsonData.indexOf("}", start);

        // Determine the valid end index
        int end = (commaIndex != -1 && (braceIndex == -1 || commaIndex < braceIndex))
            ? commaIndex
            : braceIndex;

        // Extract and parse the value
        return Double.parseDouble(jsonData.substring(start, end).trim());
    }
}
