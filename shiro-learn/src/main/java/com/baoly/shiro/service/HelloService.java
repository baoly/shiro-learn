package com.baoly.shiro.service;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    /**
     * 登录之后就能查看
     *
     * @return
     */
    @RequiresAuthentication
    public String hello() {
        return "hello";
    }

    @RequiresRoles(value = {"user", "admin"}, logical = Logical.AND)
    public String admin() {
        return "admin";
    }
}
