package com.ejemplo.support;

import com.ejemplo.model.Employee;
import com.ejemplo.model.Skill;

public class TestDataFactory {

    public static Employee manager1() {
        return new Employee(1, "Laura", "Martin", "2018-02-12", null, 5);
    }

    public static Employee employee1() {
        return new Employee(2, "Carlos", "Sanchez", "2020-04-01", 1, 2);
    }

    public static Employee employee2() {
        return new Employee(3, "Ana", "Lopez", "2021-06-10", 1, 2);
    }

    public static Employee employee3OtroRol() {
        return new Employee(4, "Mario", "Ruiz", "2022-01-20", 1, 3);
    }

    public static Skill skillJava() {
        return new Skill(1, "Java", 1);
    }

    public static Skill skillSql() {
        return new Skill(2, "SQL", 2);
    }

    public static Skill skillDocker() {
        return new Skill(3, "Docker", 3);
    }
}
