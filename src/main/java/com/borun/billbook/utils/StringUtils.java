package com.borun.billbook.utils;

import java.util.Random;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 二进制转十进制
     *
     * @param buff
     * @return
     */
    public static String byte2hex(byte[] buff) {
        if ((buff == null) || (buff.length <= 0)) {
            return "";
        }

        String tmpStr = null;
        StringBuilder hexStr = new StringBuilder();

        for (byte b : buff) {
            tmpStr = Integer.toHexString(b & 0xFF);
            if (tmpStr.length() == 1) {
                hexStr.append("0");
            }
            hexStr.append(tmpStr);
        }
        return hexStr.toString().toLowerCase();
    }

    public static String byte2Hex(byte[] buff) {
        if ((buff == null) || (buff.length <= 0)) {
            return "";
        }
        String result = "";
        String tmpStr = "";
        for (byte b : buff) {
            tmpStr = Integer.toHexString(b & 0xFF);
            if (tmpStr.length() == 1)
                result = String.format("%s0%s", result, tmpStr);
            else {
                result = result + tmpStr;
            }
        }
        return result.toUpperCase();
    }

    /**
     * 将金额字符串为null时转换成0.00
     *
     * @param str
     * @return
     */
    public static String null2Zero(String str) {
        if (str == null)
            str = "0.00";
        return str;
    }

    /**
     * 随机返回颜色Color十六进制字符串
     *
     * @return
     */
    public static String randomColor() {
        //红色
        String red;
        //绿色
        String green;
        //蓝色
        String blue;
        //生成随机对象
        Random random = new Random();
        //生成红色颜色代码
        red = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成绿色颜色代码
        green = Integer.toHexString(random.nextInt(256)).toUpperCase();
        //生成蓝色颜色代码
        blue = Integer.toHexString(random.nextInt(256)).toUpperCase();

        //判断红色代码的位数
        red = red.length() == 1 ? "0" + red : red;
        //判断绿色代码的位数
        green = green.length() == 1 ? "0" + green : green;
        //判断蓝色代码的位数
        blue = blue.length() == 1 ? "0" + blue : blue;
        //生成十六进制颜色值
        return "#" + red + green + blue;
    }
}

