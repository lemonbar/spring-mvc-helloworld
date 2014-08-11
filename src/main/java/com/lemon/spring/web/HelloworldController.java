package com.lemon.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 305032265 on 14-8-10.
 */
@Controller
public class HelloworldController {

    @RequestMapping("/helloWorld/{userName}")
    @ResponseBody
    public String helloWorld(@PathVariable String userName, Model model) {
//        model.addAttribute("message", "Hello World!");
        return "hello world! I am " + userName;
    }

    ///hello/lemon;q=2;/age/23;r=5
    @RequestMapping(value = "/hello/{userName}/age/{age}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String helloMatrix(@PathVariable String userName,
                              @MatrixVariable(value = "q", pathVar = "userName") String q,
                              @PathVariable String age,
                              @MatrixVariable(value = "r", pathVar = "age") String q1) {
        return "I am " + userName + "; age is " + age + "; matrix q value is " + q + "r value is" + q1;
    }

    @RequestMapping(value="/parameter")
    @ResponseBody
    public String parameterTest(@RequestParam(value = "petId",required = false,defaultValue = "0") int petId, ModelMap model){
        return "parameter petId value is " + petId;
    }

    @RequestMapping(value="/requestString")
    @ResponseBody
    public String requestString(@RequestBody String body){
        return "request body is " + body;
    }

    @RequestMapping("/exp/{symbolicName:[a-z-]}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]}")
    @ResponseBody
    public String helloWorldWithExpression(@PathVariable String version, @PathVariable String extension) {
        return "name is " + "\n" + "version is " + version + "\n" + "extension is " + extension + "\n";
    }
}
