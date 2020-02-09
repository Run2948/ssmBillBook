package com.borun.billbook.test;

import com.borun.billbook.utils.MailUtils;
import org.junit.Test;

import java.util.UUID;

public class MailTest {

    @Test
    public void send() {
        MailUtils.send("3160410046@qq.com", "简易记账系统", "恭喜注册成功，请激活！<a href='127.0.0.1:8080/RegMail/user/regconf.do?code=" + UUID.randomUUID().toString() + "'>激活帐号</a>");
    }
}
