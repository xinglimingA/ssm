package com.xlm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlm.dao.EmployeeDao;
import com.xlm.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    //单个页面显示的记录条数
    private final static int pageSize = 3;
    //连续的页面数量
    private final static int pageNavi = 5;
    @Autowired
    private EmployeeDao employeeDao;



    public PageInfo<Employee> list(int page){

        PageHelper.startPage(page,pageSize);
        List<Employee> list = employeeDao.getAllEmployees();

        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        pageInfo.setNavigatePages(pageNavi);

        return pageInfo;
    }


    public void addEmp(Employee employee){
        employeeDao.addEmployeeSelective(employee);
    }

    public boolean check(Employee employee){
        return employeeDao.countByExample(employee) == 0;
    }

    public Employee getEmpById(String id){
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmp(Employee employee){
        employeeDao.updateEmployeeSelective(employee);
    }

    public void deleteEmpById(String id) {
        employeeDao.deleteEmployee(id);
    }

    public void deleteEmpByIds(String ids) {
        String[] id = ids.split("-");
        employeeDao.deleteEmployees(id);
    }
}