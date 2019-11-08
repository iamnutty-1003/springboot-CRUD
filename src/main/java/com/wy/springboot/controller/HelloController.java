package com.wy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

//    @ResponseBody
//    @RequestMapping("/hello")
//    public String hello(){
//        return "Hello World!";
//    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("xox1","LSN");
        return "success";
    }

    @RequestMapping({"/","/index"})
    public String login(){
        return "login";
    }
}
