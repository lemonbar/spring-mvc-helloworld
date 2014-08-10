package com.lemon.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 305032265 on 14-8-10.
 */
@Controller
public class HelloworldController {

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
//        model.addAttribute("message", "Hello World!");
        return "hello world! I am lemon.";
    }
}
