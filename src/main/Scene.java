package main;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 335 - 7380
 * Project: Project 1
 * Date: November 5th, 2024
 * Description:
 * The Scene class serves as a container for managing a collection of drawable shapes.
 * It allows adding shapes to the collection and provides access to retrieve all stored shapes.
 * This class acts as a simple data structure to manage shapes in a graphical context.
 */

import java.util.ArrayList;

public class Scene {

    // A list to hold all drawable shapes in the scene
    private final ArrayList<DrawableShape> shapes = new ArrayList<>();

    /**
     * Adds a drawable shape to the scene.
     *
     * @param shape The DrawableShape object to be added to the scene.
     */
    public void addShape(DrawableShape shape) {
        shapes.add(shape);
    }

    /**
     * Retrieves the list of all shapes in the scene.
     *
     * @return An ArrayList containing all DrawableShape objects in the scene.
     */
    public ArrayList<DrawableShape> getShapes() {
        return shapes;
    }
}
