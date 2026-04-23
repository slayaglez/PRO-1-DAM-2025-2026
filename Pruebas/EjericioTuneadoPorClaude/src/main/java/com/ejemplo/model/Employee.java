package com.ejemplo.model;

import java.util.Objects;

public class Employee {

    private Integer id;
    private String name;
    private String surname;
    private String startDate;
    private Integer reportsTo;
    private Integer rolId;

    public Employee() {
    }

    public Employee(Integer id, String name, String surname, String startDate, Integer reportsTo, Integer rolId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.startDate = startDate;
        this.reportsTo = reportsTo;
        this.rolId = rolId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public Integer getReportsTo() { return reportsTo; }
    public void setReportsTo(Integer reportsTo) { this.reportsTo = reportsTo; }
    public Integer getRolId() { return rolId; }
    public void setRolId(Integer rolId) { this.rolId = rolId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", startDate='" + startDate + '\'' +
                ", reportsTo=" + reportsTo +
                ", rolId=" + rolId +
                '}';
    }
}
