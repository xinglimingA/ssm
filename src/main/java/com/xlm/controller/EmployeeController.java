package com.xlm.controller;

import com.github.pagehelper.PageInfo;
import com.xlm.common.ResponseMsg;
import com.xlm.domain.Employee;
import com.xlm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "page",defaultValue = "1") int page, Model model){

//        PageInfo<Employee> pageInfo = employeeService.list(page);
//        model.addAttribute("pageInfo",pageInfo);
        return "manager_empJ";
    }

    @RequestMapping(value = "/listJ",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg<PageInfo> listJ(@RequestParam(value = "page",defaultValue = "1") int page){
        PageInfo<Employee> pageInfo = employeeService.list(page);
        return ResponseMsg.createBySuccess(pageInfo);
    }

    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg addEmp(@Validated Employee employee, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> map = new HashMap<>();

            for(FieldError fieldError : bindingResult.getFieldErrors()){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ResponseMsg.createByError(map);
        }else{
            employeeService.addEmp(employee);
            return ResponseMsg.createBySuccess();
        }
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg<Employee> getEmp(@PathVariable String id){
        Employee employee = employeeService.getEmpById(id);

        return ResponseMsg.createBySuccess(employee);
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseMsg updateEmp(Employee employee){
        employeeService.updateEmp(employee);

        return ResponseMsg.createBySuccess();
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMsg deleteEmp(@PathVariable String id){
        if(id.contains("-")){
            employeeService.deleteEmpByIds(id);
        }else{
            employeeService.deleteEmpById(id);
        }
        return ResponseMsg.createBySuccess();
    }

    @RequestMapping(value = "check",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg check(Employee employee){
        //校验姓名格式
        if(!StringUtils.isEmpty(employee.getEmpName())){
            String pattern = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,6}$)";
            if(!employee.getEmpName().matches(pattern)){
                return ResponseMsg.createByErrorMessage("姓名要求2-6个中文字符或3-16个英文与数字的组合");
            }
        }
        if(employeeService.check(employee)){
            return ResponseMsg.createBySuccess();
        }else {
            return ResponseMsg.createByErrorMessage("姓名已存在");
        }
    }


}