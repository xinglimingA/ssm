package com.xlm.dao;

import com.xlm.domain.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeDao {
    void addEmployee(Employee department);
    void addEmployeeSelective(Employee department);
    void updateEmployee(Employee department);
    void updateEmployeeSelective(Employee department);
    void deleteEmployee(String id);
    void deleteEmployees(String[] ids);
    Employee getEmployeeById(String id);
    List<Employee> getEmployeeByDeptId(String deptId);
    List<Employee> getAllEmployees();
    Integer countByExample(Employee employee);
}