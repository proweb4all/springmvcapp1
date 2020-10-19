package ru.proweb4all.springmvcapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
//        System.out.println("Hello, " + name  + " " + surname + "!");
        model.addAttribute("message", "Hello, " + name  + " " + surname + "!");
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {
//        System.out.println("Goodbye, " + name  + " " + surname + "!");
        model.addAttribute("message", "Goodbye, " + name  + " " + surname + "!");
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(defaultValue = "1") Integer a,
                             @RequestParam(defaultValue = "1") Integer b,
                             @RequestParam(defaultValue = "???") String action,
                             Model model) {
//        System.out.println(a + " " + b + " " + action);
        double res;
        switch (action) {
            case "multiplication":
                res = a * b;
                break;
            case "addition":
                res = a + b;
                break;
            case "division":
                res = a / (double)b;
                break;
            case "substraction":
                res = a - b;
                break;
            default:
                res = -1;
        }
        model.addAttribute("result", "Result: " + a + " " + action + " " + b + " = " + res);
        return "first/calculator";
    }
}
