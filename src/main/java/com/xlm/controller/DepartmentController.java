package com.xlm.controller;

import com.xlm.common.ResponseMsg;
import com.xlm.domain.Department;
import com.xlm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseMsg<List<Department>> list(){
        return ResponseMsg.createBySuccess(departmentService.list());
    }
}