package com.baoly.shiro.controller;

import com.baoly.shiro.service.HelloService;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String hello() {
        String hello = null;
        try {
            hello = helloService.hello();
            return hello;
        } catch (AuthorizationException e) {
            return "权限不足";
        }

    }

    @GetMapping(value = "/admin")
    public String admin(HttpServletResponse response) {
        String admin = null;
        try {
            admin = helloService.admin();
        } catch (UnauthorizedException e) {
            try {
                response.setCharacterEncoding("utf-8");
                response.setHeader("content-Type", "text/html;charset=utf-8");
                response.getWriter().write("权限不足");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return admin;
    }

    @GetMapping(value = "/unauthorizedUrl", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String unauthorizedUrl() {
        return "权限不足";
    }
}
