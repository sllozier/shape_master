package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The DrawingPanel class is a custom JPanel that serves as a canvas for rendering
 * DrawableShape objects. It maintains a collection of shapes and provides methods
 * for adding shapes to the panel and repainting the canvas. Additionally, it
 * includes a utility method to create and display the panel within a JFrame.
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPanel extends JPanel {

    private final ArrayList<DrawableShape> shapes = new ArrayList<>();

    /**
     * Adds a new shape to the panel and triggers a repaint to display it.
     *
     * @param shape The DrawableShape to be added to the panel.
     */
    public void addShape(DrawableShape shape) {
        shapes.add(shape);
        repaint(); // Repaint the panel to display the new shape
    }

    /**
     * Paints the shapes onto the panel. This method is called automatically by
     * the Swing framework whenever the panel needs to be rendered.
     *
     * @param g The Graphics context used to draw the shapes.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel before redrawing
        for (DrawableShape shape : shapes) {
            shape.draw(g); // Draw each shape in the list
        }
    }

    /**
     * Creates a JFrame to display the DrawingPanel and configures its properties.
     *
     * @param panel The DrawingPanel to be added to the JFrame.
     */
    public static void createAndShowGUI(DrawingPanel panel) {
        JFrame frame = new JFrame("Shape Visualizer"); // Create the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close behavior
        frame.setSize(800, 600); // Set the window size
        frame.add(panel); // Add the panel to the frame
        frame.setVisible(true); // Make the frame visible
    }
}
