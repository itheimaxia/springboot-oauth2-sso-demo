package com.brianxia.orderservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author brianxia
 * @version 1.0
 * @date 2020/11/22 16:23
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "redirect:index.html";
    }
}
