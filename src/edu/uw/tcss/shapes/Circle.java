/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 */

package edu.uw.tcss.shapes;

/**
 * A circle with a name and a radius.
 *
 * <p>Circle adds one field and writes the two methods AbstractShape left
 * open. Everything else (the name, describe(), toString()) it inherits.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public final class Circle extends AbstractShape {

    /** The radius, always positive. */
    private final double myRadius;

    /**
     * Creates a circle.
     *
     * @param name the name of the circle
     * @param radius the radius
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is blank or radius is not positive
     */
    public Circle(final String name, final double radius) {
        // super(name) runs AbstractShape's constructor, which fills in and
        // checks the name. One object, two constructors, the same this: the
        // Student slides in the memory model deck.
        //
        // The name is checked before the radius because super(...) has
        // traditionally had to come first. Java 25 lets a constructor check its
        // arguments before calling super, but you'll almost always see super
        // first.
        super(name);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive");
        }
        myRadius = radius;
    }

    /**
     * Returns the radius.
     *
     * @return the radius, always positive
     */
    public double getRadius() {
        return myRadius;
    }

    @Override
    public double area() {
        return Math.PI * myRadius * myRadius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * myRadius;
    }
}
