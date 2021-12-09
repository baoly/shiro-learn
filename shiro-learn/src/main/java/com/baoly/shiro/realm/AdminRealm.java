package com.baoly.shiro.realm;

import com.baoly.shiro.bean.User;
import com.baoly.shiro.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class AdminRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    /**
     * 权限认证的方法
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = principals.getPrimaryPrincipal().toString();
        /**
         * 查找用户权限
         */
        Set<String> roles = userMapper.selectRolesByUser(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录的方法
     *
     * @param token 用户输入的信息
     * @return AuthenticationInfo 登录认证信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        User user = userMapper.selectUserInfo(username);
        if (user != null) {
            return new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(username), getName());
        } else {
            throw new UnknownAccountException("用户名或密码不正确");
        }
    }
}
