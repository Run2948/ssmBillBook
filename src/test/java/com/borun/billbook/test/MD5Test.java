package com.borun.billbook.test;

import com.borun.billbook.utils.MDUtils;
import org.junit.Test;

public class MD5Test {

    @Test
    public void encode() {
        System.out.println(MDUtils.getMD2("admin"));
        System.out.println(MDUtils.getMD2("user01"));
        System.out.println(MDUtils.getMD2("user02"));
    }
}
