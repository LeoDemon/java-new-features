package tech.demonlee.lombok;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * @author Demon.Lee
 * @date 2023-04-13 10:28
 */
@Log4j2
public class ModelTest {

    @Test
    public void init_lombok_with_of() {
        // `of` for all args constructor
        var model1 = Model.of(111, "Jack", "F");

        // `of` for no args constructor
        var model2 = Model.of();

        // `builder` for generate instance
        var model3 = Model.builder().id(123).name("Jimmy").build();

        // `with` to modify filed for generating new instance
        var model4 = model3.withType("M").withId(112).withName("May");

        // `builder` to modify filed for generating new instance
        var model5 = model4.toBuilder().id(133).name("Tim Cook").type("F").build();

        log.info("model1: {}", model1);
        log.info("model2: {}", model2);
        log.info("model3: {}", model3);
        log.info("model4: {}", model4);
        log.info("model5: {}", model5);
    }
}
