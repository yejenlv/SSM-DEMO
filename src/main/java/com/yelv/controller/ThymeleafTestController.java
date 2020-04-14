package com.yelv.controller;

import com.yelv.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafTestController {
    @RequestMapping(value = "/thymeleaf", method= RequestMethod.GET)
    public  String  thymeleaf(Model model) {
        model.addAttribute("test", "hello world!");
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setAge(22);
        user.setUserName("zhangsan");
        users.add(user);
        user = new User();
        user.setId(2);
        user.setAge(22);
        user.setUserName("lisi");
        users.add(user);
        model.addAttribute("users", users);
        return "/demo";
    }
}
