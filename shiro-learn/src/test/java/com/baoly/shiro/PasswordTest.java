package com.baoly.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class PasswordTest {
    /**
     * 测试密码加密
     */
    @Test
    public void test01() {
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println("md5Hash = " + md5Hash);
        Md5Hash md5Hash1 = new Md5Hash("123", "zhangsan", 1024);
        System.out.println("zhangsan md5Hash1 = " + md5Hash1);
        Md5Hash md5Hash2 = new Md5Hash("123", "lisi", 1024);
        System.out.println("lisi md5Hash2 = " + md5Hash2);
    }
}
