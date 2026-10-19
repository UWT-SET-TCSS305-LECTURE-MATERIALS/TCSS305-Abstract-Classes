/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 */

package edu.uw.tcss.shapes;

import java.util.List;

/**
 * Prints a description of a few shapes.
 *
 * <p>The commented-out lines in main are compile errors worth seeing.
 * Uncomment one at a time (Cmd+/ or Ctrl+/), read the error, then comment it
 * out again.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public final class ShapeDemo {

    /** The radius of the wheel. */
    private static final double WHEEL_RADIUS = 1.5;

    /** The width of the door. */
    private static final double DOOR_WIDTH = 0.9;

    /** The height of the door. */
    private static final double DOOR_HEIGHT = 2.0;

    /** No instances: this class only holds main. */
    private ShapeDemo() {
        super();
    }

    /**
     * Prints a description of each shape.
     *
     * @param args not used
     */
    public static void main(final String[] args) {
        final List<Shape> shapes = List.of(
                new Circle("wheel", WHEEL_RADIUS),
                new Rectangle("door", DOOR_WIDTH, DOOR_HEIGHT));

        // One loop, one call, two different area() methods. The loop doesn't
        // know or care which kind of Shape it has.
        for (final Shape shape : shapes) {
            System.out.println(shape.describe());
            System.out.println("  " + shape);
        }

        // Error 1: AbstractShape is abstract; cannot be instantiated.
        // There's no area() to run, so Java won't let you make one.
//        final Shape blob = new AbstractShape("blob");

        // Error 2: cannot find symbol getRadius(). The object is a Circle, but
        // the list holds Shapes, and Shape has no getRadius(). The compiler goes
        // by the variable's type (the deck's last animation).
//        System.out.println(shapes.get(0).getRadius());

        // Not an error: test the type, and the pattern variable is a Circle.
        if (shapes.get(0) instanceof final Circle circle) {
            System.out.println("radius " + circle.getRadius());
        }
    }
}
