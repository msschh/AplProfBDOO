package com.apbdoo.lab8.controllers;

import com.apbdoo.lab8.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndex(){
        return "home";
    }

    @RequestMapping("/showForm")
    public String showInputForm(Model model){
        model.addAttribute("hello",new Hello());
        return "formName";
    }


    @RequestMapping(value="/hello", method = RequestMethod.POST )
    @ResponseBody
    public String showHelloWord(@RequestParam(required = false) String name){

        return "Hello " + name;
    }




    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Hello hello) {
        return "result";
    }


    @GetMapping("/showLogInForm")
    public String showLogInForm(){
        return "login";
    }

}
