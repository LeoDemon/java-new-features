package tech.demonlee.swpattern;

/**
 * @author Demon.Lee
 * @date 2023-04-10 08:06
 */
public sealed interface Shape permits Shape.Circle, Shape.Square, Shape.Rectangle {

    /**
     * @param radius
     * @since 1.0
     */
    record Circle(double radius) implements Shape {
    }

    /**
     * @param side
     * @since 2.0
     */
    record Square(double side) implements Shape {
    }

    /**
     * @param length
     * @param width
     * @since 2.0
     */
    record Rectangle(double length, double width) implements Shape {
    }
}
