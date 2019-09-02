package com.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
    /*
    @ResponseBody向页面发送文字，如果是对象还能转为json数据
     */
@RestController
/*
@RestController=@Controller+@ResponseBody
 */
public class HelloController {

   @RequestMapping("/hello")
    public  String hello()
   {
       return  "Hello,world!";
   }
}
