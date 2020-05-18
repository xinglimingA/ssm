package com.xlm.dao;

import com.xlm.domain.Department;
import com.xlm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeDaoTest {

   @Autowired
   EmployeeDao employeeDao;


    @Test
    public void textAddEmployee(){
        Employee employee = new Employee();
        Department department = new Department();
        department.setId("1");
        employee.setDepartment(department);
        employee.setEmpAge("25");
        employee.setEmpName("王小丫");
        employee.setEmpSex("0");
        employee.setEmpTel("13001020304");

        employeeDao.addEmployee(employee);
    }

    @Test
    public void textAddEmployeeSelective(){
        Employee employee = new Employee();
        Department department = new Department();
        department.setId("2");
        employee.setDepartment(department);
        employee.setEmpAge("18");
        employee.setEmpName("王大锤");
        employee.setEmpSex("1");

        employeeDao.addEmployeeSelective(employee);
    }

    @Test
    public void textUpdateEmployee(){
        Employee employee = new Employee();
        Department department = new Department();
        department.setId("2");
        employee.setId("3");
        employee.setDepartment(department);
        employee.setEmpAge("18");
        employee.setEmpName("王大锤");
        employee.setEmpSex("1");
        employee.setEmpTel("18803020805");

        employeeDao.updateEmployee(employee);
    }

    @Test
    public void textUpdateEmployeeSelective(){
        Employee employee = new Employee();
        employee.setId("3");

        employee.setEmpAge("15");

        employeeDao.updateEmployeeSelective(employee);
    }

    @Test
    public void textGetEmployeeById(){
        System.out.print(employeeDao.getEmployeeById("1"));
    }

    @Test
    public void textGetEmployeeByDeptId(){
        System.out.print(employeeDao.getEmployeeByDeptId("2"));
    }

    @Test
    public void textGetAllEmployees(){
        System.out.print(employeeDao.getAllEmployees());
    }

    @Test
    public void textDeleteEmployee(){
        employeeDao.deleteEmployee("4");
    }
}