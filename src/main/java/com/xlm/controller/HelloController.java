package com.xlm.controller;

import com.xlm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(Model model){
        System.out.println(helloService.hello());
        model.addAttribute("h","11111");
        return "hello";
    }
}