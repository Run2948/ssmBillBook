package com.borun.billbook.bean;

public class VersionBean extends BaseBean {
    //app名称
    private String appName;
    // 是否有更新
    private Boolean hasUpdate;
    // 文件大小
    private Long apkSize;
    // 文件MD5值
    private String apkMd5;
    // 服务器版本号
    private int versionCode;
    //服务器版本名称
    private String versionName;
    //升级方式
    private int updateStatus;
    //app下载地址
    private String downloadUrl;
    //升级信息
    private String upgradeInfo;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Boolean getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(Boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public Long getApkSize() {
        return apkSize;
    }

    public void setApkSize(Long apkSize) {
        this.apkSize = apkSize;
    }

    public String getApkMd5() {
        return apkMd5;
    }

    public void setApkMd5(String apkMd5) {
        this.apkMd5 = apkMd5;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(int updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpgradeInfo() {
        return upgradeInfo;
    }

    public void setUpgradeInfo(String upgradeInfo) {
        this.upgradeInfo = upgradeInfo;
    }
}
