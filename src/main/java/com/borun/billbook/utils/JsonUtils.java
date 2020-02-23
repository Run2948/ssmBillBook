package com.borun.billbook.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class JsonUtils {
    
    private static ObjectMapper mapper = new ObjectMapper();

    // 将对象序列化成字符串
    public static String toJSONString(Object obj) throws IOException {
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createGenerator(sw);
        mapper.writerWithDefaultPrettyPrinter().writeValue(gen, obj);
        gen.close();
        return sw.toString();
    }

    // 将字符串转化成对象
    public static <T> T parseObject(String jsonStr, Class<T> objClass)
            throws JsonParseException, JsonMappingException, IOException {
        return mapper.readValue(jsonStr, objClass);
    }

    /**
     * 读取json文件
     */
    public static String readJsonFile(String path) {
        String laststrJson = "";
        BufferedReader reader;
        try {
            File file = new File(path);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                laststrJson = laststrJson + tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laststrJson;
    }

    /**
     * 读取json文件
     */
    public static <T> T readJsonFile(String path, Class<T> objClass) {
        String jsonString = readJsonFile(path);
        try {
            return parseObject(jsonString, objClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入json文件
     */
    public static void writeJsonFile(String newJsonString, String path) {
        try {
            File file = new File(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
                    StandardCharsets.UTF_8));
            bw.write(newJsonString);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入json文件
     */
    public static void writeJsonFile(Object newJsonObject, String path) {
        try {
            String newJsonString = toJSONString(newJsonObject);
            writeJsonFile(newJsonString, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
