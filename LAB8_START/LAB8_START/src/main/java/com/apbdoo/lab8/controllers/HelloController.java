package com.apbdoo.lab8.controllers;
import com.apbdoo.lab8.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping(value="/hello/{name}", method = RequestMethod.GET )
    @ResponseBody
    public String showHelloWord(@PathVariable String name){
        return "hello " + name;
    }

    @RequestMapping("/showForm")
    public String showInputForm(Model model){
        model.addAttribute("hello",new Hello());
        return "formName";
    }
}
