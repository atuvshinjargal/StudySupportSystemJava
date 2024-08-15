package com.sss.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sss.test.form.LoginForm;
import com.sss.test.service.UserService;
import com.sss.test.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        System.out.println("test1111");
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginForm(LoginForm loginForm, Model model) {
        User user = userService.authentication(loginForm.getLogin_id(), loginForm.getPassword());
        System.out.println(loginForm.getLogin_id());
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/menu";
        } else {
            model.addAttribute("errMsg", "Invalid login Id or Password");
            return "login";
        }
    }

    @GetMapping("/menu")
    public String getMethodName(Model model) {
        return "menu";
    }
}
