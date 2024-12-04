package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The DrawableShape interface defines a contract for shapes that can be drawn
 * on a graphical context. Any class implementing this interface must provide
 * an implementation of the draw method, which takes a Graphics object as a parameter.
 * This allows shapes to visually render themselves within a GUI application.
 */

import java.awt.*;

public interface DrawableShape {
    /**
     * Renders the shape on the provided Graphics context.
     *
     * @param g The Graphics context used to draw the shape.
     */
    void draw(Graphics g);
}
