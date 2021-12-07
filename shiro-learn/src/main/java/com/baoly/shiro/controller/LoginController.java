package com.baoly.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping(value = "/doLogin", produces = "text/html;charset=utf-8")
    public String doLogin(String username, String password) {
        /**
         * @password 原来的密码
         * @username 盐字段
         * 1024 迭代次数
         */
//        password = new Md5Hash(password, username, 1024).toString();
        /**
         * 改为配置之后
         */
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            return "登录失败:" + e.getMessage();
        }
        return "登录成功";
    }
}
