# TCSS 305: Abstract Classes

Lecture project for TCSS 305 Programming Practicum, Week 3 (Autumn 2026), UW Tacoma.

- `src/edu/uw/tcss/shapes/Shape.java`: the interface the rest of the program uses.
- `src/edu/uw/tcss/shapes/AbstractShape.java`: the abstract class. It holds the private name, a
  protected constructor that checks it, and a concrete `describe()` that calls `area()`, a
  method this class never writes. The comments explain each choice.
- `src/edu/uw/tcss/shapes/Circle.java` and `Rectangle.java`: the two finished subclasses.
- `src/edu/uw/tcss/shapes/ShapeDemo.java`: prints each shape. Two commented-out lines are
  compile errors worth seeing: `new AbstractShape(...)`, and calling `getRadius()` through a
  `Shape` variable. Uncomment one at a time with Cmd+/ (Ctrl+/).
- `test/edu/uw/tcss/shapes/ShapeTest.java`: the starter for the tests written live in lecture.
  The circle area test is provided.
- `reference/Square.java`: the subclass written live in lecture, with the steps in its header.
- `reference/ShapeTestFinished.java`: where the tests end up. The folder is excluded from the
  build; to run it, copy it into `test/` and copy `Square.java` into `src/`.

Same shape as A1c: an interface (`Item`, here `Shape`), an abstract class holding what the
subclasses share (`AbstractItem`, here `AbstractShape`), and final subclasses.

Open the folder in IntelliJ IDEA with JDK 25. JUnit 6 is resolved from Maven by the module file.
