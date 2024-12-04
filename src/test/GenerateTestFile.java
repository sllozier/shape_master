package test;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: GenerateTestFile.java generates .json files containing valid and
 * invalid test cases for testing the functionality of the Project 1 application.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateTestFile {

    /**
     * Generates a JSON file with valid test data.
     * Each session includes up to 3 valid shapes created with random parameters.
     *
     * @param fileName The name of the file to write the test data.
     */
    public static void generateValidInputsFile(String fileName) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            Random random = new Random();

            fileWriter.write("{\n  \"sessions\": [\n");

            // Generate 5 user sessions
            for (int i = 0; i < 5; i++) {
                fileWriter.write("    {\n");
                fileWriter.write("      \"sessionId\": \"session-" + (i + 1) + "\",\n");
                fileWriter.write("      \"actions\": [\n");

                int numberOfShapes = random.nextInt(3) + 1; // Up to 3 shapes
                for (int j = 0; j < numberOfShapes; j++) {
                    int shapeChoice = random.nextInt(9) + 1; // Shape options (1-9)
                    fileWriter.write("        {\n");
                    fileWriter.write("          \"actionType\": " + shapeChoice + ",\n");

                    // Map the shapeChoice to shapeType name
                    String shapeType;
                    switch (shapeChoice) {
                        case 1 -> shapeType = "Circle";
                        case 2 -> shapeType = "Rectangle";
                        case 3 -> shapeType = "Square";
                        case 4 -> shapeType = "Triangle";
                        case 5 -> shapeType = "Sphere";
                        case 6 -> shapeType = "Cube";
                        case 7 -> shapeType = "Cone";
                        case 8 -> shapeType = "Cylinder";
                        case 9 -> shapeType = "Torus";
                        default -> throw new IllegalStateException(
                            "Unexpected value: " + shapeChoice
                        );
                    }
                    fileWriter.write("          \"shapeType\": \"" + shapeType + "\",\n");
                    fileWriter.write("          \"parameters\": {\n");

                    // Add parameters based on shape type
                    switch (shapeChoice) {
                        case 1, 5 -> fileWriter.write(
                            // Circle, Sphere
                            "            \"radius\": " + generateRandomDouble(random) + "\n"
                        );
                        case 2 -> { // Rectangle
                            fileWriter.write(
                                "            \"length\": " + generateRandomDouble(random) + ",\n"
                            );
                            fileWriter.write(
                                "            \"width\": " + generateRandomDouble(random) + "\n"
                            );
                        }
                        case 3, 6 -> fileWriter.write(
                            // Square, Cube
                            "            \"side\": " + generateRandomDouble(random) + "\n"
                        );
                        case 4 -> { // Triangle
                            fileWriter.write(
                                "            \"base\": " + generateRandomDouble(random) + ",\n"
                            );
                            fileWriter.write(
                                "            \"height\": " + generateRandomDouble(random) + "\n"
                            );
                        }
                        case 7, 8 -> { // Cone, Cylinder
                            fileWriter.write(
                                "            \"radius\": " + generateRandomDouble(random) + ",\n"
                            );
                            fileWriter.write(
                                "            \"height\": " + generateRandomDouble(random) + "\n"
                            );
                        }
                        case 9 -> { // Torus
                            fileWriter.write(
                                "            \"majorRadius\": " +
                                generateRandomDouble(random) +
                                ",\n"
                            );
                            fileWriter.write(
                                "            \"minorRadius\": " +
                                generateRandomDouble(random) +
                                "\n"
                            );
                        }
                    }

                    fileWriter.write("          },\n");
                    fileWriter.write("          \"continue\": \"Y\"\n");
                    fileWriter.write("        }");

                    if (j < numberOfShapes - 1) {
                        fileWriter.write(",\n");
                    }
                }

                // Add "Exit" action at the end of each session
                if (numberOfShapes > 0) {
                    fileWriter.write(",\n");
                }
                fileWriter.write("        {\n");
                fileWriter.write("          \"actionType\": 10,\n");
                fileWriter.write("          \"shapeType\": \"Exit\",\n");
                fileWriter.write("          \"parameters\": {},\n");
                fileWriter.write("          \"continue\": \"N\"\n");
                fileWriter.write("        }\n");

                fileWriter.write("      ]\n");
                fileWriter.write("    }");

                if (i < 4) { // Add a comma except for the last session
                    fileWriter.write(",\n");
                }
            }

            fileWriter.write("\n  ]\n}");
        } catch (IOException e) {
            System.err.println("Failed to write valid test data to file: " + fileName);
            e.printStackTrace();
        } finally {
            closeFileWriter(fileWriter);
        }
    }

    /**
     * Generates a JSON file with invalid test data.
     * Each session includes at least one invalid input and additional valid inputs.
     *
     * @param fileName The name of the file to write the test data.
     */
    public static void generateInvalidInputsFile(String fileName) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            Random random = new Random();

            fileWriter.write("{\n  \"sessions\": [\n");

            for (int i = 0; i < 5; i++) {
                fileWriter.write("    {\n");
                fileWriter.write("      \"sessionId\": \"session-" + (i + 1) + "\",\n");
                fileWriter.write("      \"actions\": [\n");

                // Generate 1-2 valid shapes
                int validShapes = random.nextInt(2) + 1;
                for (int j = 0; j < validShapes; j++) {
                    int shapeChoice = random.nextInt(9) + 1; // Shape options (1-9)
                    fileWriter.write("        {\n");
                    fileWriter.write("          \"actionType\": " + shapeChoice + ",\n");

                    // Map shapeChoice to shapeType
                    String shapeType =
                        switch (shapeChoice) {
                            case 1 -> "Circle";
                            case 2 -> "Rectangle";
                            case 3 -> "Square";
                            case 4 -> "Triangle";
                            case 5 -> "Sphere";
                            case 6 -> "Cube";
                            case 7 -> "Cone";
                            case 8 -> "Cylinder";
                            case 9 -> "Torus";
                            default -> throw new IllegalStateException(
                                "Unexpected value: " + shapeChoice
                            );
                        };
                    fileWriter.write("          \"shapeType\": \"" + shapeType + "\",\n");
                    fileWriter.write("          \"parameters\": {\n");

                    // Add valid parameters based on shape type
                    switch (shapeChoice) {
                        case 1, 5 -> fileWriter.write(
                            "            \"radius\": " + generateRandomDouble(random) + "\n"
                        );
                        case 2 -> { // Rectangle
                            fileWriter.write(
                                "            \"length\": " + generateRandomDouble(random) + ",\n"
                            );
                            fileWriter.write(
                                "            \"width\": " + generateRandomDouble(random) + "\n"
                            );
                        }
                        case 3, 6 -> fileWriter.write(
                            "            \"side\": " + generateRandomDouble(random) + "\n"
                        );
                        case 4 -> { // Triangle
                            fileWriter.write(
                                "            \"base\": " + generateRandomDouble(random) + ",\n"
                            );
                            fileWriter.write(
                                "            \"height\": " + generateRandomDouble(random) + "\n"
                            );
                        }
                        case 7, 8 -> { // Cone, Cylinder
                            fileWriter.write(
                                "            \"radius\": " + generateRandomDouble(random) + ",\n"
                            );
                            fileWriter.write(
                                "            \"height\": " + generateRandomDouble(random) + "\n"
                            );
                        }
                        case 9 -> { // Torus
                            fileWriter.write(
                                "            \"majorRadius\": " +
                                generateRandomDouble(random) +
                                ",\n"
                            );
                            fileWriter.write(
                                "            \"minorRadius\": " +
                                generateRandomDouble(random) +
                                "\n"
                            );
                        }
                    }

                    fileWriter.write("          },\n");
                    fileWriter.write("          \"continue\": \"Y\"\n");
                    fileWriter.write("        },\n");
                }

                // Add invalid input
                boolean isInvalidActionType = random.nextBoolean(); // Randomly decide invalid type
                if (isInvalidActionType) {
                    // Invalid actionType
                    fileWriter.write("        {\n");
                    fileWriter.write("          \"actionType\": 99,\n"); // Invalid action type
                    fileWriter.write("          \"shapeType\": \"InvalidShape\",\n");
                    fileWriter.write("          \"parameters\": {},\n");
                    fileWriter.write("          \"continue\": \"Y\"\n");
                    fileWriter.write("        },\n");
                } else {
                    // Invalid parameter
                    int shapeChoice = random.nextInt(9) + 1; // Shape options (1-9)
                    String shapeType =
                        switch (shapeChoice) {
                            case 1 -> "Circle";
                            case 2 -> "Rectangle";
                            case 3 -> "Square";
                            case 4 -> "Triangle";
                            case 5 -> "Sphere";
                            case 6 -> "Cube";
                            case 7 -> "Cone";
                            case 8 -> "Cylinder";
                            case 9 -> "Torus";
                            default -> throw new IllegalStateException(
                                "Unexpected value: " + shapeChoice
                            );
                        };

                    fileWriter.write("        {\n");
                    fileWriter.write("          \"actionType\": " + shapeChoice + ",\n");
                    fileWriter.write("          \"shapeType\": \"" + shapeType + "\",\n");
                    fileWriter.write("          \"parameters\": {\n");

                    // Add invalid parameters based on shape type
                    switch (shapeChoice) {
                        case 1, 5 -> fileWriter.write("            \"radius\": -1.0\n"); // Invalid radius
                        case 2 -> { // Rectangle
                            fileWriter.write("            \"length\": -1.0,\n"); // Invalid length
                            fileWriter.write("            \"width\": 120.0\n");
                        }
                        case 3, 6 -> fileWriter.write("            \"side\": -1.0\n"); // Invalid side
                        case 4 -> { // Triangle
                            fileWriter.write("            \"base\": 50.0,\n");
                            fileWriter.write("            \"height\": -1.0\n"); // Invalid height
                        }
                        case 7, 8 -> { // Cone, Cylinder
                            fileWriter.write("            \"radius\": -1.0,\n"); // Invalid radius
                            fileWriter.write("            \"height\": 50.0\n");
                        }
                        case 9 -> { // Torus
                            fileWriter.write("            \"majorRadius\": 100.0,\n");
                            fileWriter.write("            \"minorRadius\": -1.0\n"); // Invalid minor radius
                        }
                    }

                    fileWriter.write("          },\n");
                    fileWriter.write("          \"continue\": \"Y\"\n");
                    fileWriter.write("        },\n");
                }

                // Add "Exit" action
                fileWriter.write("        {\n");
                fileWriter.write("          \"actionType\": 10,\n");
                fileWriter.write("          \"shapeType\": \"Exit\",\n");
                fileWriter.write("          \"parameters\": {}\n");
                fileWriter.write("        }\n");

                fileWriter.write("      ]\n");
                fileWriter.write("    }");

                if (i < 4) { // Add a comma except for the last session
                    fileWriter.write(",\n");
                }
            }

            fileWriter.write("\n  ]\n}");
        } catch (IOException e) {
            System.err.println("Failed to write invalid test data to file: " + fileName);
            e.printStackTrace();
        } finally {
            closeFileWriter(fileWriter);
        }
    }

    /**
     * Closes the FileWriter resource.
     *
     * @param fileWriter The FileWriter to close.
     */
    private static void closeFileWriter(FileWriter fileWriter) {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Failed to close the file writer.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Generates a random double value between 1 and 150.
     *
     * @param random The Random object for generating random numbers.
     * @return A random double value > 0 and < 150.
     */
    private static double generateRandomDouble(Random random) {
        return 1 + random.nextDouble() * 149;
    }

    public static void main(String[] args) {
        String basePath = new java.io.File("").getAbsolutePath();
        String targetDirPath = basePath + java.io.File.separator + "docs";

        java.io.File targetDir = new java.io.File(targetDirPath);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        String validFilePath = targetDirPath + java.io.File.separator + "validInputs.json";
        String invalidFilePath = targetDirPath + java.io.File.separator + "invalidInputs.json";

        generateValidInputsFile(validFilePath);
        generateInvalidInputsFile(invalidFilePath);
    }
}
