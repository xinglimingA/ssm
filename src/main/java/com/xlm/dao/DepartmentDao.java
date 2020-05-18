package com.xlm.dao;

import com.xlm.domain.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentDao {
    void addDepartment(Department department);
    void addDepartmentSelective(Department department);
    void updateDepartment(Department department);
    void updateDepartmentSelective(Department department);
    void deleteDepartment(String id);
    Department getDepartmentById(String id);
    Department getDepartmentByIdWithEmp(String id);
    List<Department> getAllDepartments();
    List<Department> getAllDepartmentsWithEmp();
}