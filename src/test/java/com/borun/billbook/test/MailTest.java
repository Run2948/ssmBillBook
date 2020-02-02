package com.borun.billbook.test;

import com.borun.billbook.utils.MailUtils;
import org.junit.Test;

public class MailTest {

    @Test
    public void send() {
        MailUtils.send("375027533@qq.com", "ola记账系统", "恭喜注册成功，请激活！<a href='127.0.0.1:8080/RegMail/user/regconf.do?code=\" + code + \"'>激活帐号</a>");
    }
}
