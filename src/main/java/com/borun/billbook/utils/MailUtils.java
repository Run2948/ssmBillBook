package com.borun.billbook.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件工具类
 */
public class MailUtils {

    /**
     * @param sendTo  邮件接收着地址
     * @param subject 邮件主题
     * @param body    邮件正文
     * @return true发送成功|false发送失败
     */
    public static boolean send(String sendTo, String subject, String body) {
        try {
            // 设置发件人
            final String from = "1965147142@qq.com";
            // 授权码
            final String code = "friicfebsholdagd";

            //设置邮件发送的服务器，这里为QQ邮件服务器
            final String host = "smtp.qq.com";
            //端口号 465或587
            final String port = "465";

            //获取系统属性
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.port", port);

            //SSL加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            //设置系统属性
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.connectiontimeout", "5000");

            /*
             *Session类定义了一个基本的邮件对话。
             */
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, code);
                }
            });
            session.setDebug(true);

            /*
             *Message对象用来储存实际发送的电子邮件信息
             */
            MimeMessage message = new MimeMessage(session);
            //防止邮件被当然垃圾邮件处理，披上Outlook的马甲
            message.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");
            //邮件发送者设置(发件地址，昵称)，收件人看到的昵称是这里设定的
            message.setFrom(new InternetAddress(from, "EasyBill"));
            //邮件接收者设置(发件地址，昵称)
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{
                    new InternetAddress(sendTo)
            });
            //设置邮件主题
            message.setSubject(subject);
            message.saveChanges();
            //设置邮件内容及编码格式：后一个参数可以不指定编码，如"text/plain"，但是将不能显示中文字符
            message.setContent(body, "text/plain;charset=UTF-8");

            //发送邮件消息
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}