package com.brianxia.productservice.controller;

import com.brianxia.productservice.util.JWTHelper;
import com.brianxia.productservice.util.JwtUtil;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    //测试token
    @GetMapping("/test")
    public void test() throws Exception {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
        String token = details.getTokenValue();
        if (StringUtils.isNotBlank(token)) {
            Claims claims = JWTHelper.parseJWT(token, "testaaaa");
        }
    }

}
