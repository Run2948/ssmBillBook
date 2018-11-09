package com.borun.billbook.controller;

import com.borun.billbook.service.BUserService;
import com.borun.billbook.bean.BUser;
import com.borun.billbook.bean.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Qing on 2017/12/25.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private BUserService bUserService;

    @RequestMapping("/test")
    public String test() {
        return "upload";
    }

    /**
     * 文件上传功能
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty())
            return new BaseBean().fail();
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        int id=Integer.parseInt(fileName.split("_")[0]);
        System.out.println(id);
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);

        BUser user=bUserService.findUserById(id);
        user.setImage(fileName);
        bUserService.updateUser(user);

        return new BaseBean().success();
    }
}
