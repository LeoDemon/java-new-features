package tech.demonlee.swpattern.modern;

import tech.demonlee.swpattern.Shape;

/**
 * @author Demon.Lee
 * @date 2023-04-10 15:57
 * @desc if forget to modify the {@link ShapeFactory#isSquare(Shape)} for the new Shape {@link Shape.Rectangle},
 * the switch pattern will occur a compile error: 'switch' expression does not cover all possible input values
 */
public class ShapeFactory {

    public static boolean isSquare(Shape shape) {
        /*
         * Patterns in switch are not supported at language level '17':
         * set language level to 17 (Preview)
         */
        return switch (shape) {
            case Shape.Square s -> true;
            case null, Shape.Circle c -> false;
            case Shape.Rectangle r -> r.length() == r.width();
        };
    }
}
