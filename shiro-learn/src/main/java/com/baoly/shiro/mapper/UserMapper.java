package com.baoly.shiro.mapper;

import com.baoly.shiro.bean.User;

public interface UserMapper {
    User selectUserName(String username);
}
