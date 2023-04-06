package tech.demonlee.swexpr.modern;

import lombok.extern.log4j.Log4j2;

/**
 * @author Demon.Lee
 * @date 2023-04-06 08:52
 * @desc using enum to iterate all case
 */
@Log4j2
public class ColorSwitch {

    public static void main(String[] args) {
        showColorInfo(Color.BLUE);
        showColorInfo(Color.GREEN);
    }

    static void showColorInfo(Color color) {
        String colorInfo = switch (color) {
            case RED -> "I like red clothes...";
            case BLUE -> "Hey, Fighting Guys...";

            // if comment this line, will cause compile error:
            // `'switch' expression does not cover all possible input values`,
            // add `GREEN` case or add 'default' case for fixing it
            case GREEN -> "Spring, smells good...";
        };

        log.info("color: {} -> {}", color, colorInfo);
    }
}
