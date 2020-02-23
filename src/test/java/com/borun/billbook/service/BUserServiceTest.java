package com.borun.billbook.service;

import com.borun.billbook.bean.BUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class BUserServiceTest {

    @Autowired
    private BUserService userService;

    @Test
    public void findUserById() {
        BUser user = userService.findUserById(1);
        System.out.println(user.getUsername());
    }

}