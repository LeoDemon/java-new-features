package tech.demonlee.tmp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Demon.Lee
 * @date 2023-06-12 11:23
 */
@Log4j2
public class CollectionTest {

    @Test
    public void shallow_copy_for_string_list() {
        List<String> aaa = new ArrayList<>();
        aaa.add("a1");
        aaa.add("a2");
        aaa.add("a3");

        List<String> bbb = new ArrayList<>(aaa);
        bbb.add("b1");
        bbb.remove("a2");

        log.info("aaa: {}", aaa);
        log.info("bbb: {}", bbb);

        Assertions.assertTrue(aaa.contains("a2"));
        Assertions.assertFalse(aaa.contains("b1"));
    }

    @Test
    public void shallow_copy_for_string_obj_list() {
        Person jack = Person.of("1", "Jack", 55);
        Person jim = Person.of("2", "Jim", 25);
        Person hanmei = Person.of("5", "HanMei", 32);

        List<Person> aaa = new ArrayList<>();
        aaa.add(jack);
        aaa.add(jim);
        aaa.add(Person.of("3", "Jenny", 30));

        List<Person> bbb = new ArrayList<>(aaa);
        bbb.add(hanmei);
        bbb.remove(jim);

        log.info("aaa: {}", aaa);
        log.info("bbb: {}", bbb);

        Assertions.assertTrue(aaa.contains(jim));
        Assertions.assertFalse(aaa.contains(hanmei));

        log.info("-----------------------");
        jim.age = 20;
        hanmei.age = 31;
        log.info("aaa: {}", aaa);
        log.info("bbb: {}", bbb);
    }

    @Getter
    @ToString
    @NoArgsConstructor(staticName = "of")
    @AllArgsConstructor(staticName = "of")
    static class Person {
        String id;
        String name;
        Integer age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return Objects.equals(id, person.id);
        }

        @Override
        public int hashCode() {
            return Objects.nonNull(id) ? id.hashCode() : 0;
        }
    }
}
