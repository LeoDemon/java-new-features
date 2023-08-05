package tech.demonlee.reflect;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Demon.Lee
 * @date 2023-08-04 22:34
 */
@Getter
@ToString
public class Person {

    private String id;

    private String name;

    private Integer age;

    private Double salary;

    private double score;

    public Person() {
    }

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String id, String name, Integer age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public double tax(double taxRate) {
        if (Objects.isNull(salary)) {
            return 0.0;
        }
        return taxRate * salary;
    }
}
