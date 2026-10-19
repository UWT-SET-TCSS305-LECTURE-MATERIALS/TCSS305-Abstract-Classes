/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 */

package edu.uw.tcss.shapes;

/**
 * A flat shape with a name, an area and a perimeter.
 *
 * <p>This is the type the rest of the program uses. ShapeDemo keeps a
 * List of Shape, never a List of Circle or of AbstractShape. Same pattern as
 * A1c: Item is the interface, AbstractItem holds what the items share.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public interface Shape {

    /**
     * Returns the name of this shape.
     *
     * @return the name, never null or blank
     */
    String getName();

    /**
     * Returns the area of this shape.
     *
     * @return the area, always positive
     */
    double area();

    /**
     * Returns the distance around this shape.
     *
     * @return the perimeter, always positive
     */
    double perimeter();

    /**
     * Returns a one-line description for a person to read, such as
     * "wheel: area 7.07, perimeter 9.42".
     *
     * @return the description
     */
    String describe();
}
