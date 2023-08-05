package tech.demonlee.reflect;

import lombok.Getter;
import lombok.ToString;

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
}
