package com.xlm.domain;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Department {
    private String id;
    private String deptName;
    private List<Employee> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Depatement{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }
}