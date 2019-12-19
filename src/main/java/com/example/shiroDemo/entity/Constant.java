package com.example.shiroDemo.entity;

import org.springframework.beans.factory.annotation.Value;

public class Constant {
    private Constant() {
    }

    public static final String FTP_ADDRESS = "101.132.136.48";
    //    @Value("${ftp.port}")
    public static final int FTP_PORT = 21;
    //    @Value("${ftp.username}")
    public static final String FTP_USERNAME = "root";
    //    @Value("${ftp.password}")
    public static final String FTP_PASSWORD = "XXL852456aaa";
    //    @Value("${ftp.path}")
    public static final String FTP_PATH = "/data/img";
}
