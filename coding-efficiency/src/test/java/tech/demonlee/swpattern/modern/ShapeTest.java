package tech.demonlee.swpattern.modern;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.demonlee.swpattern.Shape;

/**
 * @author Demon.Lee
 * @date 2023-04-10 16:00
 */
@Log4j2
public class ShapeTest {

    private Shape nil;
    private Shape circle;
    private Shape square;

    @BeforeEach
    public void setup() {
        this.circle = new Shape.Circle(1.0);
        this.square = new Shape.Square(3);
    }

    @Test
    public void is_square_shape_for_v1() {
        Assertions.assertFalse(ShapeFactory.isSquare(nil));
        Assertions.assertFalse(ShapeFactory.isSquare(circle));
        Assertions.assertTrue(ShapeFactory.isSquare(square));
    }

    @Test
    public void is_square_shape_for_v2() {
        Assertions.assertFalse(ShapeFactory.isSquare(nil));
        Assertions.assertFalse(ShapeFactory.isSquare(circle));
        Assertions.assertTrue(ShapeFactory.isSquare(square));

        Shape rectangle1 = new Shape.Rectangle(10.0, 15.0);
        Shape rectangle2 = new Shape.Rectangle(10.0, 10.0);
        Assertions.assertFalse(ShapeFactory.isSquare(rectangle1));
        Assertions.assertTrue(ShapeFactory.isSquare(rectangle2));
    }
}
