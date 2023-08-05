package tech.demonlee.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @author Demon.Lee
 * @date 2023-08-05 16:40
 */
public class MethodTest {

    @Test
    public void should_access_method() throws ReflectiveOperationException {
        Person person = new Person("1003", "Miss.Lee", 30, 10000.0);
        Class<?> personClazz = person.getClass();

        Method taxMethod = personClazz.getMethod("tax", double.class);
        Method sqrtMethod = Math.class.getMethod("sqrt", double.class);

        double tax = (double) taxMethod.invoke(person, 0.05);
        // Math.sqrt is a static method: pass obj to null
        double calRet = (double) sqrtMethod.invoke(null, person.getSalary());

        Assertions.assertEquals(tax, 500.0);
        Assertions.assertEquals(calRet, 100.0);
    }
}
