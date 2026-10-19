/*
 * TCSS 305 - Week 3 lecture demo: abstract classes.
 */

package edu.uw.tcss.shapes;

import java.util.Objects;

/**
 * What every Shape has in common: a name, and a description built from the
 * area and perimeter.
 *
 * <p>This class is abstract because it can't answer the question every Shape
 * must answer: what is your area? It has no idea whether it's a circle or a
 * rectangle. So it leaves area() and perimeter() to its subclasses and writes
 * everything else once, here.
 *
 * <p>What an abstract class can have, unlike an interface: instance fields
 * (myName), constructors, and private members. What it can't do: be
 * instantiated. new AbstractShape("blob") does not compile.
 *
 * <p>The Checkstyle rule AbstractClassName is why the name starts with
 * Abstract.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public abstract class AbstractShape implements Shape {

    /** The name of this shape, never null or blank. */
    private final String myName;

    /**
     * Stores and checks the name. Only a subclass constructor can call this,
     * through super(name).
     *
     * <p>Why have a constructor at all, if nobody can say new AbstractShape?
     * Because every Circle and Rectangle object contains this myName field,
     * and this is the one place that fills it in and checks it. Write the
     * check once here and every subclass gets it.
     *
     * <p>Why protected? Only subclasses ever call it. Public would suggest
     * that someone else could.
     *
     * @param name the name of the shape
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is blank
     */
    protected AbstractShape(final String name) {
        super();
        myName = Objects.requireNonNull(name, "name must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
    }

    // getName() is final: no subclass may change what a name is. Circle and
    // Rectangle can't touch myName either, because it's private to this class.
    // They reach it through this method, the same way StoreItem reaches
    // AbstractItem's name in A1c.
    @Override
    public final String getName() {
        return myName;
    }

    // describe() is a concrete method in an abstract class, and it calls
    // area() and perimeter(), which this class never writes. That compiles,
    // because Shape promises every Shape has them.
    //
    // At run time, this is a real Circle or Rectangle object, so the JVM runs
    // that class's area(). This is the memory model deck's dispatch slide: the
    // object picks the method, wherever the call is written.
    //
    // Demo: set a breakpoint on the return line, debug ShapeDemo, and step into
    // area(). You land in Circle, then in Rectangle.
    @Override
    public String describe() {
        return String.format("%s: area %.2f, perimeter %.2f", getName(), area(), perimeter());
    }

    // area() and perimeter() aren't mentioned here at all. Shape declares them,
    // AbstractShape doesn't write them, and that's allowed only because this
    // class is abstract. Delete the word abstract from the class header and
    // the compiler says AbstractShape must implement them.

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[name=" + myName + "]";
    }
}
