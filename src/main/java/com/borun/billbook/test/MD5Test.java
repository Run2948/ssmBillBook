package com.borun.billbook.test;

import com.borun.billbook.utils.MDUtils;

import java.security.NoSuchAlgorithmException;

public class MD5Test {

    public static void main(String[] args) {
        try {
            System.out.println(MDUtils.encodeMD2ToStr("admin"));
            System.out.println(MDUtils.encodeMD2ToStr("user01"));
            System.out.println(MDUtils.encodeMD2ToStr("user02"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
