package com.ella.springbootfirstdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ella
 * @date 2018/8/21
 */
@RestController
@RequestMapping("/hello")
//@Controller
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${girl}")
    private String girl;

    @Autowired
    private PersonProperties personProperties;

    //@RequestMapping(value = "/getId", method = RequestMethod.GET)
    @GetMapping(value = "/getId")
    public String getId2(@RequestParam(value = "id", required = false, defaultValue = "28") Integer personId){
        return "id: " + personId;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getId(@PathVariable("id") Integer personId){
        return "id: " + personId;
    }

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot!";
    }

    @RequestMapping(value = "/sayName", method = RequestMethod.GET)
    public String sayName(){
        return "My name is " + name;
    }

    @RequestMapping(value = "/descGirl", method = RequestMethod.GET)
    public String descGirl(){
        return girl;
    }

    @RequestMapping(value = "/descPerson", method = RequestMethod.GET)
    public String descPerson(){
        return personProperties.getName() + "---" + personProperties.getAge();
    }

    @RequestMapping(value = "/sayElla", method = RequestMethod.GET)
    public String sayElla(){
        return "index";
    }
}
