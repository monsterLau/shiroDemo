package com.example.shiroDemo.utils;

import com.example.shiroDemo.entity.Constant;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;
import sun.net.ftp.FtpClient;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;

@Component
public class FtpUtil {


    public boolean uploadFile(String fileName, InputStream inputStream) {
        boolean flag = false;
        FTPClient client = new FTPClient();
        client.setControlEncoding("UTF-8");
        int rely;
        try {
            // 连接FTP服务器
            client.connect(Constant.FTP_ADDRESS, Constant.FTP_PORT);
            // 登录
            client.login(Constant.FTP_USERNAME, Constant.FTP_PASSWORD);
            //连接成功会的到一个返回状态码
            rely = client.getReplyCode();
            System.out.println(rely);
            //设置文件类型
            client.setFileType(FTPClient.BINARY_FILE_TYPE);
            client.changeWorkingDirectory(Constant.FTP_PATH);
            //这里开始上传文件
            client.storeFile(fileName, inputStream);
            if (!FTPReply.isPositiveCompletion(rely)) {
                client.disconnect();
                System.out.println("连接失败");
                return flag;
            }
            System.out.println("连接成功！");

            inputStream.close();
            client.logout();
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client.isConnected()) {
                try {
                    client.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return flag;
    }
}
