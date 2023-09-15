package tech.demonlee.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Demon.Lee
 * @date 2023-09-13 22:19
 */
public interface Foo {

    public static final Logger log = LogManager.getLogger(Foo.class);

    public static final String name = "abc";

    public void filter();

    // since Java 9
    private static String getName() {
        return name;
    }

    // since Java 8
    public static String getName1() {
        return name;
    }

    // since Java 8
    public default String getName2() {
        return getName();
    }

    public static void main(String[] args) {
        log.info("name1：" + Foo.getName1());

        Foo foo = () -> System.out.println("this is a filter...");
        // compile error: Static method may be invoked on containing interface class only
        // System.out.println("name: " + foo.getName1());
        log.info("name2: " + foo.getName2());
    }
}
