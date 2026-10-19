/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 *
 * Where ShapeTest ends up. This folder is excluded from the build. To run it,
 * copy this file into test/edu/uw/tcss/shapes/ (rename it or delete
 * ShapeTest.java first), and copy reference/Square.java into src/ too, because
 * the last two tests use it.
 */

package edu.uw.tcss.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Circle}, {@link Rectangle} and {@link Square}, and
 * through them, the parts of {@link AbstractShape} they share.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
class ShapeTestFinished {

    /** How close two doubles must be to count as equal. */
    private static final double TOLERANCE = 1e-9;

    /** A radius shared by the tests below. */
    private static final double RADIUS = 2.0;

    /** A width shared by the tests below. */
    private static final double WIDTH = 0.9;

    /** A height shared by the tests below. */
    private static final double HEIGHT = 2.0;

    /** A side length shared by the Square tests. */
    private static final double SIDE = 3.0;

    /** The message for both null-name tests. */
    private static final String NULL_NAME = "A null name should throw NullPointerException";

    /** A name shared by the tests below. */
    private static final String NAME = "door";

    /**
     * A circle's area is pi times the radius squared.
     */
    @Test
    void testCircleArea() {
        final Shape circle = new Circle("wheel", RADIUS);
        assertEquals(Math.PI * RADIUS * RADIUS, circle.area(), TOLERANCE,
                "A circle's area should be pi r squared");
    }

    /**
     * A rectangle's area is width times height.
     */
    @Test
    void testRectangleArea() {
        final Shape rectangle = new Rectangle(NAME, WIDTH, HEIGHT);
        assertEquals(WIDTH * HEIGHT, rectangle.area(), TOLERANCE,
                "A rectangle's area should be width times height");
    }

    /**
     * A rectangle's perimeter is twice the width plus twice the height.
     */
    @Test
    void testRectanglePerimeter() {
        final Shape rectangle = new Rectangle(NAME, WIDTH, HEIGHT);
        assertEquals(2 * (WIDTH + HEIGHT), rectangle.perimeter(), TOLERANCE,
                "A rectangle's perimeter should be 2(w + h)");
    }

    /**
     * Circle never checks its name. AbstractShape's constructor does, through
     * super(name), so the check covers every subclass at once.
     */
    @SuppressWarnings("DataFlowIssue")   // passing null is the point of this test
    @Test
    void testCircleRejectsNullName() {
        assertThrows(NullPointerException.class,
            () -> new Circle(null, RADIUS),
            NULL_NAME);
    }

    /**
     * The same check, through a different subclass.
     */
    @Test
    void testRectangleRejectsBlankName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Rectangle("  ", WIDTH, HEIGHT),
            "A blank name should throw IllegalArgumentException");
    }

    /**
     * A radius of 0 is not a circle. 0 is the boundary, so it's the value to test.
     */
    @Test
    void testCircleRejectsZeroRadius() {
        assertThrows(IllegalArgumentException.class,
            () -> new Circle("dot", 0),
            "A zero radius should throw IllegalArgumentException");
    }

    /**
     * describe() is written once, in AbstractShape, but the area in it comes
     * from the subclass.
     */
    @Test
    void testDescribeUsesTheSubclassArea() {
        final Shape rectangle = new Rectangle(NAME, WIDTH, HEIGHT);
        assertEquals("door: area 1.80, perimeter 5.80", rectangle.describe(),
                "describe() should use Rectangle's area and perimeter");
    }

    /**
     * Square, written live in lecture: area is side squared.
     */
    @Test
    void testSquareArea() {
        final Shape square = new Square("tile", SIDE);
        assertEquals(SIDE * SIDE, square.area(), TOLERANCE,
                "A square's area should be side squared");
    }

    /**
     * Square gets the name check for free, too.
     */
    @SuppressWarnings("DataFlowIssue")   // passing null is the point of this test
    @Test
    void testSquareRejectsNullName() {
        assertThrows(NullPointerException.class,
            () -> new Square(null, SIDE),
            NULL_NAME);
    }
}
