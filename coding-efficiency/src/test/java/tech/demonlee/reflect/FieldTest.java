package tech.demonlee.reflect;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author Demon.Lee
 * @date 2023-08-04 22:35
 */
@Log4j2
public class FieldTest {

    @Test
    public void should_access_person_field_failed() throws NoSuchFieldException {
        Person person = new Person("1001", "Jack.Ma", 35);
        Class<?> clz = person.getClass();
        Field f = clz.getDeclaredField("name");
        Exception ex = null;
        Object val = null;
        try {
            val = f.get(person);
        } catch (IllegalAccessException e) {
            ex = e;
        }
        Assertions.assertNotNull(ex);
    }

    @Test
    public void should_access_person_filed() throws NoSuchFieldException {
        Person person = new Person("1001", "Jack.Ma", 35);
        Class<?> clz = person.getClass();
        Field f = clz.getDeclaredField("name");
        f.setAccessible(true);

        Exception ex = null;
        Object val = null;
        try {
            val = f.get(person);
        } catch (IllegalAccessException e) {
            ex = e;
        }
        Assertions.assertNull(ex);
        Assertions.assertEquals(val, person.getName());
        log.info("val of filed name is: {}", val);

        String newName = "Pony.Ma";
        try {
            f.set(person, newName);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
        }
        Assertions.assertEquals(newName, person.getName());
        log.info("person is: {}", person);
    }

    /**
     * Double 包装类型不能通过 getDouble/setDouble 访问
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void should_failed_access_person_double_class_field() throws NoSuchFieldException {
        Person person = new Person("1002", "韩梅梅", 21);
        Class<?> clazz = person.getClass();
        Field f = clazz.getDeclaredField("salary");
        f.setAccessible(true);

        try {
            f.getDouble(person);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            log.error(e.getMessage());
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }

        double newSalary = 35000.0;
        try {
            f.setDouble(person, newSalary);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            log.error(e.getMessage());
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }
    }

    /**
     * double 基础类型可以通过 getDouble/setDouble 访问
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void should_access_person_double_field() throws NoSuchFieldException {
        Person person = new Person("1002", "韩梅梅", 21);
        Class<?> clazz = person.getClass();
        Field f = clazz.getDeclaredField("score");
        f.setAccessible(true);

        double score = 0.0;
        try {
            score = f.getDouble(person);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            log.error(e.getMessage());
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }
        log.info("score: {}", score);

        double newScore = 9.50;
        try {
            f.setDouble(person, newScore);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            log.error(e.getMessage());
        }
        Assertions.assertEquals(newScore, person.getScore());
        log.info("person is: {}", person);
    }
}
