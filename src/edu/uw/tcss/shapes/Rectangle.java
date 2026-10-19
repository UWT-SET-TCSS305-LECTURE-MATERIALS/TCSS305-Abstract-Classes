/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 */

package edu.uw.tcss.shapes;

/**
 * A rectangle with a name, a width and a height.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public final class Rectangle extends AbstractShape {

    /** The width, always positive. */
    private final double myWidth;

    /** The height, always positive. */
    private final double myHeight;

    /**
     * Creates a rectangle.
     *
     * @param name the name of the rectangle
     * @param width the width
     * @param height the height
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is blank, or width or height is
     *         not positive
     */
    public Rectangle(final String name, final double width, final double height) {
        super(name);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be positive");
        }
        myWidth = width;
        myHeight = height;
    }

    /**
     * Returns the width.
     *
     * @return the width, always positive
     */
    public double getWidth() {
        return myWidth;
    }

    /**
     * Returns the height.
     *
     * @return the height, always positive
     */
    public double getHeight() {
        return myHeight;
    }

    @Override
    public double area() {
        return myWidth * myHeight;
    }

    @Override
    public double perimeter() {
        return 2 * (myWidth + myHeight);
    }
}
