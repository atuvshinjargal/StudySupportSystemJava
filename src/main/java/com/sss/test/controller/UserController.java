package com.sss.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sss.test.form.LoginForm;
import com.sss.test.form.UserForm;
import com.sss.test.service.UserService;
import com.sss.test.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getMethodName(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "new_user";
    }

    @PostMapping("/user")
    public String postMethodName(UserForm userForm, Model model) {
        User newUser = new User(1, userForm.getLogin_id(), userForm.getName(), userForm.getPassword(),
                userForm.getRole());
        Integer result = userService.insertUser(newUser);
        model.addAttribute("errMsg", result);
        return "new_user";
    }

}
