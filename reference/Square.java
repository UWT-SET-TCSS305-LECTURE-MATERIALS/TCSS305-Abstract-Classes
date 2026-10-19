/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 *
 * Where the live-coded Square ends up. Written in lecture in this order:
 *
 *   1. public final class Square extends AbstractShape { }
 *      Two errors at once. There is no no-argument constructor in
 *      AbstractShape, so Square needs a constructor that calls super(name).
 *      And Square is not abstract, so it must write area() and perimeter().
 *   2. Add the constructor. One error left.
 *   3. Alt+Enter (Option+Return) on the class name, then Implement methods.
 *      Fill them in. It compiles, and describe() and the name check come free.
 *   4. Question: why not Square extends Rectangle? (Rectangle is final here.
 *      With immutable shapes, a square really is a rectangle, so it could
 *      work. With setWidth() and setHeight() it breaks: set the width of a
 *      "Rectangle" and the height changes too.)
 */

package edu.uw.tcss.shapes;

/**
 * A square with a name and a side length.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public final class Square extends AbstractShape {

    /** A square has four sides. */
    private static final int SIDES = 4;

    /** The side length, always positive. */
    private final double mySide;

    /**
     * Creates a square.
     *
     * @param name the name of the square
     * @param side the side length
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is blank or side is not positive
     */
    public Square(final String name, final double side) {
        super(name);
        if (side <= 0) {
            throw new IllegalArgumentException("side must be positive");
        }
        mySide = side;
    }

    @Override
    public double area() {
        return mySide * mySide;
    }

    @Override
    public double perimeter() {
        return SIDES * mySide;
    }
}
