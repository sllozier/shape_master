package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The InvalidEntryException class is a custom exception used to handle cases
 * where invalid input is provided during the creation or modification of shapes.
 * It extends the Exception class and allows for customized error messages to
 * provide meaningful feedback to the user or developer.
 */
public class InvalidEntryException extends Exception {

    /**
     * Constructs a new InvalidEntryException with the specified error message.
     *
     * @param message A descriptive message detailing the reason for the exception.
     */
    public InvalidEntryException(String message) {
        super(message);
    }
}
