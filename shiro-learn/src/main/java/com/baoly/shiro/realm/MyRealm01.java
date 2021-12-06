package com.baoly.shiro.realm;

import com.baoly.shiro.bean.User;
import com.baoly.shiro.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AuthenticatingRealm 做登录的Realm
 */
@Component
public class MyRealm01 extends AuthenticatingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名去数据库查询用户信息并返回
     *
     * @param token 用户登录时输入的用户名和密码等信息
     * @return 数据库中存储的用户信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        //根据username 去数据库中查询用户信息
        User user = userMapper.selectUserName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        }
        return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
    }
}
