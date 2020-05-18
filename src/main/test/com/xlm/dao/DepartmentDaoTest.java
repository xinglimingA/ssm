package com.xlm.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlm.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentDaoTest {

    @Autowired
    DepartmentDao departmentDao;


    @Test
    public void testAddDepartment(){
        Department department = new Department();
        department.setDeptName("生产部");

        departmentDao.addDepartment(department);
    }

    @Test
    public void testAddDepartmentSelective(){
        Department department = new Department();
        department.setDeptName("设计部");

        departmentDao.addDepartmentSelective(department);
    }

    @Test
    public void testUpdateDepartment(){
        Department department = new Department();
        department.setDeptName("维修部");
        department.setId("3");

        departmentDao.updateDepartment(department);
    }

    @Test
    public void testUpdateDepartmentSelective(){
        Department department = new Department();
        department.setDeptName("机动部");
        department.setId("4");

        departmentDao.updateDepartmentSelective(department);
    }

    @Test
    public void testdGetDepartmentById(){
        System.out.println(departmentDao.getDepartmentById("3"));
    }

    @Test
    public void testdDeleteDepartment(){
        departmentDao.deleteDepartment("5");
    }


    @Test
    public void testdGetDepartmentByIdWithEmp(){
        System.out.println(departmentDao.getDepartmentByIdWithEmp("2"));
    }

    @Test
    public void testdGetAllDepartments(){
        System.out.println(departmentDao.getAllDepartments());
    }

    @Test
    public void testdgetAllDepartmentsWithEmp(){
        PageHelper.startPage(2,10);
        List<Department> list = departmentDao.getAllDepartmentsWithEmp();
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        //连续显示的页码
        pageInfo.setNavigatePages(5);
        System.out.println(pageInfo);
    }
}