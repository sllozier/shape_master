package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description: Project1.java contains the main method and serves as the entry
 * point for the ShapeMaster application. It allows users to interactively create
 * shapes, calculate their area or volume, and exit the program with a summary.
 */

import java.util.Scanner;

public class Project1 {

    // Fetch the project state from system properties, defaulting to "prod"
    private static final String projectState = System.getProperty("projectState", "prod");

    public static void main(String[] args) {
        System.out.println("Running in " + projectState + " mode.");
        Scanner scanner = new Scanner(System.in);
        boolean continueSession = true;

        // Create the DrawingPanel and display it
        DrawingPanel drawingPanel = new DrawingPanel();
        DrawingPanel.createAndShowGUI(drawingPanel);

        System.out.println("********* Welcome to the Java OO Shapes Program **********");

        while (continueSession) {
            System.out.println("\nSelect from the menu below:");
            System.out.println("1. Construct a Circle");
            System.out.println("2. Construct a Rectangle");
            System.out.println("3. Construct a Square");
            System.out.println("4. Construct a Triangle");
            System.out.println("5. Construct a Sphere");
            System.out.println("6. Construct a Cube");
            System.out.println("7. Construct a Cone");
            System.out.println("8. Construct a Cylinder");
            System.out.println("9. Construct a Torus");
            System.out.println("10. Exit the program");

            int choice = getValidIntegerInput(scanner, "Enter your choice (1-10): ", 1, 10);

            if (choice == 10) {
                continueSession = false;
                System.out.println("Thanks for using the program. Goodbye!");

                if ("prod".equalsIgnoreCase(projectState)) {
                    System.exit(0);
                } else {
                    System.out.println("Skipping System.exit as the project is in test mode.");
                }
            }

            handleShapeCreation(choice, scanner, drawingPanel);

            // Ask the user if they want to continue
            continueSession = askToContinue(scanner);
        }

        scanner.close();
    }

    /**
     * Handles the creation of a shape based on the user's choice and adds it to the DrawingPanel.
     *
     * @param choice       The menu option selected by the user.
     * @param scanner      The scanner to read user input.
     * @param drawingPanel The panel where the shapes will be drawn.
     */
    private static void handleShapeCreation(
        int choice,
        Scanner scanner,
        DrawingPanel drawingPanel
    ) {
        try {
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the radius of the Circle: ");
                    double radius = getValidDoubleInput(
                        scanner,
                        "Radius must be > 0. Enter radius: "
                    );
                    Circle circle = new Circle(radius);
                    System.out.printf("The area of the Circle is %.2f\n", circle.calculateArea());
                    drawingPanel.addShape(circle);
                }
                case 2 -> {
                    System.out.print("Enter the length of the Rectangle: ");
                    double length = getValidDoubleInput(
                        scanner,
                        "Length must be > 0. Enter length: "
                    );
                    System.out.print("Enter the width of the Rectangle: ");
                    double width = getValidDoubleInput(scanner, "Width must be > 0. Enter width: ");
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.printf(
                        "The area of the Rectangle is %.2f\n",
                        rectangle.calculateArea()
                    );
                    drawingPanel.addShape(rectangle);
                }
                case 3 -> {
                    System.out.print("Enter the side length of the Square: ");
                    double side = getValidDoubleInput(
                        scanner,
                        "Side length must be > 0. Enter side: "
                    );
                    Square square = new Square(side);
                    System.out.printf("The area of the Square is %.2f\n", square.calculateArea());
                    drawingPanel.addShape(square);
                }
                case 4 -> {
                    System.out.print("Enter the base of the Triangle: ");
                    double base = getValidDoubleInput(scanner, "Base must be > 0. Enter base: ");
                    System.out.print("Enter the height of the Triangle: ");
                    double height = getValidDoubleInput(
                        scanner,
                        "Height must be > 0. Enter height: "
                    );
                    Triangle triangle = new Triangle(base, height);
                    System.out.printf(
                        "The area of the Triangle is %.2f\n",
                        triangle.calculateArea()
                    );
                    drawingPanel.addShape(triangle);
                }
                case 5 -> {
                    System.out.print("Enter the radius of the Sphere: ");
                    double radius = getValidDoubleInput(
                        scanner,
                        "Radius must be > 0. Enter radius: "
                    );
                    Sphere sphere = new Sphere(radius);
                    System.out.printf(
                        "The volume of the Sphere is %.2f\n",
                        sphere.calculateVolume()
                    );
                    drawingPanel.addShape(sphere);
                }
                case 6 -> {
                    System.out.print("Enter the side length of the Cube: ");
                    double side = getValidDoubleInput(
                        scanner,
                        "Side length must be > 0. Enter side: "
                    );
                    Cube cube = new Cube(side);
                    System.out.printf("The volume of the Cube is %.2f\n", cube.calculateVolume());
                    drawingPanel.addShape(cube);
                }
                case 7 -> {
                    System.out.print("Enter the radius of the Cone: ");
                    double radius = getValidDoubleInput(
                        scanner,
                        "Radius must be > 0. Enter radius: "
                    );
                    System.out.print("Enter the height of the Cone: ");
                    double height = getValidDoubleInput(
                        scanner,
                        "Height must be > 0. Enter height: "
                    );
                    Cone cone = new Cone(radius, height);
                    System.out.printf("The volume of the Cone is %.2f\n", cone.calculateVolume());
                    drawingPanel.addShape(cone);
                }
                case 8 -> {
                    System.out.print("Enter the radius of the Cylinder: ");
                    double radius = getValidDoubleInput(
                        scanner,
                        "Radius must be > 0. Enter radius: "
                    );
                    System.out.print("Enter the height of the Cylinder: ");
                    double height = getValidDoubleInput(
                        scanner,
                        "Height must be > 0. Enter height: "
                    );
                    Cylinder cylinder = new Cylinder(radius, height);
                    System.out.printf(
                        "The volume of the Cylinder is %.2f\n",
                        cylinder.calculateVolume()
                    );
                    drawingPanel.addShape(cylinder);
                }
                case 9 -> {
                    System.out.print("Enter the major radius of the Torus: ");
                    double majorRadius = getValidDoubleInput(
                        scanner,
                        "Major radius must be > 0. Enter major radius: "
                    );
                    System.out.print("Enter the minor radius of the Torus: ");
                    double minorRadius = getValidDoubleInput(
                        scanner,
                        "Minor radius must be > 0 and < Major radius. Enter minor radius: "
                    );
                    Torus torus = new Torus(majorRadius, minorRadius);
                    System.out.printf("The volume of the Torus is %.2f\n", torus.calculateVolume());
                    drawingPanel.addShape(torus);
                }
            }
        } catch (InvalidEntryException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    /**
     * Prompts the user for a valid integer input within a range.
     */
    public static int getValidIntegerInput(Scanner scanner, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d.\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    /**
     * Prompts the user for a valid double input greater than 0.
     */
    public static double getValidDoubleInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double input = Double.parseDouble(scanner.nextLine());
                if (input > 0) {
                    return input;
                }
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    /**
     * Prompts the user if they want to continue the session.
     */
    public static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Would you like to continue? (Y or N): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                System.out.println("Thanks for using the program. Goodbye!");
                if ("prod".equalsIgnoreCase(projectState)) {
                    System.exit(0);
                } else {
                    System.out.println("Skipping System.exit as the project is in test mode.");
                }
                return false; // To satisfy the compiler in case of test mode
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }
}
