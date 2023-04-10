package tech.demonlee.swpattern.former;

import tech.demonlee.swpattern.Shape;

/**
 * @author Demon.Lee
 * @date 2023-04-10 15:57
 * @desc forget to modify the {@link ShapeFactory#isSquare(Shape)} for the new Shape {@link Shape.Rectangle}
 */
public class ShapeFactory {

    public static boolean isSquare(Shape shape) {
        return (shape instanceof Shape.Square);
    }
}
