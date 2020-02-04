package com.borun.billbook.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @user: Qing
 * @date: 2020/02/04 19:34
 */
public class MDUtils {

    protected static MessageDigest md5 = null;
    protected static MessageDigest md2 = null;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            System.err.println(MDUtils.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            nsaex.printStackTrace();
        }
        try {
            md2 = MessageDigest.getInstance("MD2");
        } catch (NoSuchAlgorithmException nsaex) {
            System.err.println(MDUtils.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            nsaex.printStackTrace();
        }
    }

    /**
     * 生成字符串的md5校验值
     *
     * @param s
     * @return
     */
    public static String getMD5(String s) {
        return encodeMD5(s.getBytes());
    }

    /**
     * 生成文件的md5校验值
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String getFileMD5(String filePath) throws IOException {
        File file = new File(filePath);
        return getFileMD5(file);
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileMD5(File file) throws IOException {
        InputStream fis = new FileInputStream(file);
        return getFileMD5(fis);
    }

    /**
     * 生成文件的md5校验值
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String getFileMD5(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = inputStream.read(buffer)) > 0) {
            md5.update(buffer, 0, numRead);
        }
        inputStream.close();
        return StringUtils.byte2hex(md5.digest());
    }

    /**
     * 生成文件的md5校验值
     *
     * @param bytes
     * @return
     */
    public static String getFileMD5(byte[] bytes) {
        return encodeMD5(bytes);
    }

    /**
     * 生成字符串的md2校验值
     *
     * @param s
     * @return
     */
    public static String getMD2(String s) {
        return encodeMD2(s.getBytes());
    }

    private static String encodeMD5(byte[] bytes) {
        md5.update(bytes);
        return StringUtils.byte2hex(md5.digest());
    }

    private static String encodeMD2(byte[] bytes) {
        md2.update(bytes);
        return StringUtils.byte2Hex(md2.digest());
    }
}
