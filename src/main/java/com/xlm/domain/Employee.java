package com.xlm.domain;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;

@Component
public class Employee {

    private String id;
    @Pattern(regexp = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,6}$)",message = "姓名要求2-6个中文字符或3-16个英文与数字的组合")
    private String empName;
    @Pattern(regexp = "^[1-9][0-9]{0,2}$",message = "请输入150以内的数字")
    private String empAge;
    private String empSex;
    @Pattern(regexp = "(^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})$)|(^((0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$)",message = "联系方式格式有误")
    private String empTel;
    private Department department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", empName='" + empName + '\'' +
                ", empAge='" + empAge + '\'' +
                ", empSex='" + empSex + '\'' +
                ", empTel='" + empTel + '\'' +
                ", department=" + department +
                '}';
    }
}