package com.borun.billbook.controller;

import com.borun.billbook.bean.BUser;
import com.borun.billbook.bean.BaseBean;
import com.borun.billbook.bean.VersionBean;
import com.borun.billbook.service.BUserService;
import com.borun.billbook.utils.JsonUtils;
import com.borun.billbook.utils.MDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
        int id = Integer.parseInt(fileName.split("_")[0]);
        System.out.println(id);
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);

        BUser user = bUserService.findUserById(id);
        user.setImage(fileName);
        bUserService.updateUser(user);

        return new BaseBean().success();
    }

    /**
     * 返回apk上传页面
     *
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    /**
     * 上传apk更新文件
     *
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean form(@RequestParam("file") MultipartFile file, VersionBean version) throws IOException {
        if (file.isEmpty())
            return new BaseBean().fail("上传文件不能为空");
        if (!file.getOriginalFilename().toLowerCase().endsWith(".apk"))
            return new BaseBean().fail("文件格式不正确");
        version.setHasUpdate(false);
        version.setApkMd5(MDUtils.getFileMD5(file.getBytes()));
        version.setApkSize(file.getSize());
        String relativePath = "/upload/upgrade";
        String path = request.getSession().getServletContext().getRealPath(relativePath);
        String fileName = String.format("%s.apk", UUID.randomUUID().toString());
        File dir = new File(path, fileName);
        if (!dir.exists()) dir.mkdirs();
        version.setDownloadUrl(String.format("%s/%s", relativePath, fileName));
        try {
            //MultipartFile自带的解析方法
            file.transferTo(dir);
            version.success();
            JsonUtils.writeJsonFile(version, String.format("%s/%s", path, "app.json"));
        } catch (IOException e) {
            e.printStackTrace();
            version.fail();
        }
        return version;
    }

    /**
     * 检查更新功能
     *
     * @return
     */
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    @ResponseBody
    public BaseBean upgrade(@RequestParam("appKey") String appKey, @RequestParam("versionCode") Integer versionCode) {
        if (!"com.borun.easybill".equals(appKey)) return new BaseBean().fail("非法请求！");
        String filePath = request.getSession().getServletContext().getRealPath("/upload/upgrade");
        File file = new File(filePath, "app.json");
        if (!file.exists()) JsonUtils.writeJsonFile("{\n" +
                "  \"status\" : 100,\n" +
                "  \"message\" : \"处理成功！\",\n" +
                "  \"appName\" : \"简易记账\",\n" +
                "  \"hasUpdate\" : false,\n" +
                "  \"apkSize\" : 6217372,\n" +
                "  \"apkMd5\" : \"a6c7ee01ff07984075639a3fc61eb6bc\",\n" +
                "  \"versionCode\" : 4,\n" +
                "  \"versionName\" : \"6.04.1\",\n" +
                "  \"updateStatus\" : 1,\n" +
                "  \"downloadUrl\" : \"/upload/upgrade/49b596ad-cc91-44f7-85be-b8d04e4580ba.apk\",\n" +
                "  \"upgradeInfo\" : \"1.修复了无法在线同步的问题。\\r\\n2.添加了自动检查更新的功能。\\r\\n3.简化了业务逻辑。\\r\\n4.添加了接口的安全验证。\\r\\n " +
                "                               \"\n" +
                "}", file.getPath());
        VersionBean versionBean = JsonUtils.readJsonFile(file.getPath(), VersionBean.class);
        versionBean.setHasUpdate(versionBean.getVersionCode() > versionCode);
        versionBean.success();
        return versionBean;
    }

    @RequestMapping(value = "/path", method = RequestMethod.GET)
    @ResponseBody
    public BaseBean path() {
        String filePath = request.getSession().getServletContext().getRealPath("/upload/upgrade");
        return new BaseBean().fail(filePath);
    }
}
