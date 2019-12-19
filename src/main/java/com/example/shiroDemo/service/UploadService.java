package com.example.shiroDemo.service;

import com.example.shiroDemo.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadService {
    @Autowired
    private FtpUtil ftpUtil;

    /**
     * 上传文件
     *
     * @param file
     * @param request
     * @return
     */
    public Map<String, String> uploadFile(MultipartFile file, HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "upload success!");
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        fileName = fileName + suffixName;
        //上传的文件名也要加上后缀，不然服务器不知道文件格式
        InputStream inputStream = file.getInputStream();
        String filePath = null;
        //调用工具类上传
        boolean flag = ftpUtil.uploadFile(fileName, inputStream);
//        inputStream.close();
        return map;
    }
}
