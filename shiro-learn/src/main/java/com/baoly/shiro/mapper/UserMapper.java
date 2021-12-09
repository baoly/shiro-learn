package com.baoly.shiro.mapper;

import com.baoly.shiro.bean.User;

import java.util.Set;

public interface UserMapper {
    User selectUserInfo(String username);

    Set<String> selectRolesByUser(String username);
}
