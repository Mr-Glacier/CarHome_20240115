package org.example.Until;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;


public class SaveUntil {
    // 存文件的 工具类
    public void Method_SaveFile(String path, String Content) {
        //这个是覆盖的存储方式
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path, false), 331074);//165537
            bufferedOutputStream.write(Content.getBytes(StandardCharsets.UTF_8));   //StandardCharsets.UTF_8
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }



    public void Method_SaveFile_True(String path, String Content) {
        //这个是叠加的存储方式
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path, true), 331074);//165537
            bufferedOutputStream.write(Content.getBytes(StandardCharsets.UTF_8));   //StandardCharsets.UTF_8  "GB2312"
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }



}
