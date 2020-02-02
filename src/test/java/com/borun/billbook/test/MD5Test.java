package com.borun.billbook.test;

import com.borun.billbook.utils.MDUtils;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class MD5Test {

    @Test
    public void encode() {
        try {
            System.out.println(MDUtils.encodeMD2ToStr("admin"));
            System.out.println(MDUtils.encodeMD2ToStr("user01"));
            System.out.println(MDUtils.encodeMD2ToStr("user02"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
