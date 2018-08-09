package com.bigdata.userlabel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller   //注意这里必须为Controller
public class HelloController {


    @RequestMapping("/model")
    public String page3(Model model){
        model.addAttribute("name","seawater");
        return "hello";
    }
}