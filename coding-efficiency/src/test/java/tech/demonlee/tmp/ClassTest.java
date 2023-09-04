package tech.demonlee.tmp;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Demon.Lee
 * @date 2023-08-18 14:58
 */
@Log4j2
public class ClassTest {

    @Test
    public void testClassName() {
        displayClassName(this.getClass());
        displayClassName(int.class);
        displayClassName(Integer.class);
        displayClassName(List.class);
        displayClassName(String[].class);
    }

    private void displayClassName(Class<?> clazz) {
        log.info("name: " + clazz.getName());
        log.info("simple name: " + clazz.getSimpleName());
        log.info("canonical name: " + clazz.getCanonicalName());
        log.info("type name: " + clazz.getTypeName());
        log.info("package name: " + clazz.getPackageName());
        log.info("----------------------");
    }

    @Test
    public void compareClass() {
        log.info("int.class == Integer.TYPE? {}", int.class == Integer.TYPE);
        log.info("int.class == Integer.class? {}", int.class == Integer.class);
        log.info("long.class == Long.TYPE? {}", long.class == Long.TYPE);
        log.info("long.class == Long.class? {}", long.class == Long.class);
    }
}
