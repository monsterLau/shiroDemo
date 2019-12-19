package com.example.shiroDemo;

import org.junit.jupiter.api.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.http.client.BufferingClientHttpRequestFactory;

import java.io.*;

public class FileInputStreamTest {
    @Test
    public void testFileInputStream() throws Exception {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello.txt");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        fileInputStream.close();
    }

    @Test
    public void testFileImg() throws Exception {
        File file = new File("屏幕截图(1).png");
        File file2 = new File("屏幕截图.png");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file2);
        byte[] buffer = new byte[5];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fis.close();
        fos.close();
    }

    @Test
    public void testCopyFile() throws Exception {
        this.copyFile("C:\\Users\\admin\\Pictures\\Screenshots\\屏幕截图(1).png", "D:\\testCopy.png");
    }

    /**
     * 复制文件方法
     *
     * @param filePath
     * @param destPath
     * @throws Exception
     */
    public void copyFile(String filePath, String destPath) throws Exception {
        File file = new File(filePath);
        File file2 = new File(destPath);

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file2);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buffer = new byte[5];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        bis.close();

    }
}
