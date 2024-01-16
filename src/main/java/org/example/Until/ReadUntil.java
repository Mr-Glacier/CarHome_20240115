package org.example.Until;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadUntil {
    //根据路径 读取文件 的 工具类  编码格式 GB2312
    public String Method_ReadFile(String path) {
        String Content = "";
        try {
            //这是第一种方式,但是不可以指定编码格式
//            //System.out.println(path);
//            File file = new File(path);
//            BufferedReader br = new BufferedReader(new FileInputStream(file),"UTF-8");
//            StringBuffer SB = new StringBuffer();
//            String text = "";
//            while ((text = br.readLine()) != null) {
//                SB.append(text + "\n");
//            }
//            br.close();
//            Content = SB.toString();

            InputStreamReader fReader = new InputStreamReader(Files.newInputStream(Paths.get(path)), "UTF-8");
            BufferedReader reader = new BufferedReader(fReader);
            String line;
            StringBuffer SB = new StringBuffer();
            while ((line = reader.readLine()) != null)
            {
                SB.append(line + "\n");
            }
            reader.close();
            Content = SB.toString();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return Content;
    }


//    按行进行读取
    public ArrayList<String> Method_ReadbyLine(String path){
        ArrayList<String> list = new ArrayList<>();
        try{

        InputStreamReader fReader = new InputStreamReader(Files.newInputStream(Paths.get(path)), "UTF-8");
        BufferedReader reader = new BufferedReader(fReader);
        String line;
        StringBuffer SB = new StringBuffer();
        while ((line = reader.readLine()) != null)
        {
            list.add(line.toString());
//            System.out.println(line);
        }
        reader.close();

    } catch (Exception ex) {
        System.out.println(ex.toString());
    }
        return list;
    }



    //获取文件夹下所有文件名字
    public List<String> getFileNames(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        List<String> fileNames = new ArrayList<>();
        return getFileNames(file, fileNames);
    }
    public List<String> getFileNames(File file, List<String> fileNames) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getFileNames(f, fileNames);
            } else {
                fileNames.add(f.getName());
            }
        }
        return fileNames;
    }


}
