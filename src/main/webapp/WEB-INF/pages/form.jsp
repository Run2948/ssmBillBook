<%--
  Created by IntelliJ IDEA.
  User: Qing
  Date: 2020/1/25
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>App更新上传页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <%--    <script src="https://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>--%>
    <%--    <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>--%>
</head>
<body>
<h1></h1>
<div class="container">
    <div class="row">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h1 class="panel-title">App更新信息</h1>
            </div>
            <div class="panel-body">
                <form action="${pageContext.request.contextPath}/file/form" method="POST" class="form-horizontal"
                      enctype="multipart/form-data" role="form">
                    <div class="form-group">
                        <label for="appName" class="col-sm-2 control-label">App名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="appName" id="appName" placeholder="请输入App名称"
                                   value="简易记账" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="versionCode" class="col-sm-2 control-label">App版本号</label>
                        <div class="col-sm-10">
                            <input type="number" min="1" max="1000" step="1" class="form-control" name="versionCode"
                                   id="versionCode" placeholder="请输入App版本号" value="4" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="versionName" class="col-sm-2 control-label">App版本名称</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <div class="input-group-addon">V2</div>
                                <input type="text" class="form-control" id="versionName" name="versionName"
                                       placeholder="请输入App版本名称" value="6.04.1" required/>
                            </div>
                            <input type="hidden" name="downloadUrl" value="" placeholder="请输入apk下载地址"/>
                            <input type="hidden" name="apkSize" value="" placeholder="请输入apk文件大小KB"/>
                            <input type="hidden" name="apkMd5" value="" placeholder="请输入apk的md5值"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="appFile" class="col-sm-2 control-label">Apk文件</label>
                        <div class="col-sm-10">
                            <input type="file" name="file" id="appFile" placeholder="请上传Apk文件" value="" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">更新方式</label>
                        <div class="col-sm-10">
                            <label for="lastForce0" class="radio-inline">
                                <input type="radio" name="updateStatus" id="lastForce0" placeholder="请选择更新方式"
                                       value="0"/> 暂不更新
                            </label>
                            <label for="lastForce1" class="radio-inline">
                                <input type="radio" name="updateStatus" id="lastForce1" placeholder="请选择更新方式" value="1"
                                       checked/> 用户更新
                            </label>
                            <label for="lastForce2" class="radio-inline">
                                <input type="radio" name="updateStatus" id="lastForce2" placeholder="请选择更新方式"
                                       value="2"/> 强制更新
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upgradeInfo" class="col-sm-2 control-label">升级信息</label>
                        <div class="col-sm-10">
                                <textarea class="form-control" name="upgradeInfo" id="upgradeInfo" rows="5"
                                          placeholder="版本的更新的描述" required>
1.修复了无法在线同步的问题。
2.添加了自动检查更新的功能。
3.简化了业务逻辑。
4.添加了接口的安全验证。
                                </textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary">提交</button>
                            <button type="reset" class="btn btn-default">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
