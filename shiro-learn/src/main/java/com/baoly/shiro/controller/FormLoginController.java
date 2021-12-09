package com.baoly.shiro.controller;

import com.baoly.shiro.result.Result;
import com.baoly.shiro.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormLoginController {
    @PostMapping("/formLogin")
    public String login(String username, String password, HttpServletRequest request) {
        String rememberMe = request.getParameter("rememberMe");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (StringUtils.isNotEmpty(rememberMe)) {
            token.setRememberMe(true);
        }
        try {
            SecurityUtils.getSubject().login(token);
            return "success";
        } catch (AuthenticationException e) {
            request.setAttribute("error", e.getMessage());
            return "index";
        }
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    @ResponseBody
    public Result logout() {
        String currentTime = DateUtil.getCurrentTime();
        try {
            SecurityUtils.getSubject().logout();
            return Result.ok("注销成功", currentTime);
        } catch (Exception e) {
            return Result.error("注销失败", currentTime);
        }

    }
}
