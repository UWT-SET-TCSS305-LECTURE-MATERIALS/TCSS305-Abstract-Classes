/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 *
 * Starter for live coding. One test is written as a model; the rest are
 * written in lecture. The finished version is in reference/ShapeTestFinished.java.
 *
 * Tests to write live:
 *   testRectangleArea, testRectanglePerimeter
 *   testCircleRejectsNullName   (the check lives in AbstractShape, written once)
 *   testRectangleRejectsBlankName
 *   testCircleRejectsZeroRadius
 *   testDescribeUsesTheSubclassArea
 */

package edu.uw.tcss.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Circle} and {@link Rectangle}, and through them, the
 * parts of {@link AbstractShape} they share.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
class ShapeTest {

    /**
     * How close two doubles must be to count as equal. Arithmetic on doubles
     * rounds, so tests never compare them exactly. (Money avoids the problem
     * with BigDecimal, as in A1c.)
     */
    private static final double TOLERANCE = 1e-9;

    /** A radius shared by the tests below. */
    private static final double RADIUS = 2.0;

    /**
     * A circle's area is pi times the radius squared.
     */
    @Test
    void testCircleArea() {
        // Arrange: the variable's type is Shape, the object is a Circle.
        final Shape circle = new Circle("wheel", RADIUS);

        // Act
        final double area = circle.area();

        // Assert: the third argument is the tolerance.
        assertEquals(Math.PI * RADIUS * RADIUS, area, TOLERANCE,
                "A circle's area should be pi r squared");
    }
}
