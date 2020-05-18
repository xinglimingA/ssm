package com.xlm.service;

import com.xlm.dao.DepartmentDao;
import com.xlm.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;



    public List<Department> list(){
        return departmentDao.getAllDepartments();
    }
}