package org.example.Until;

import java.io.File;
import java.util.ArrayList;

public class HelpCreateFile {

    public static void Method_CrateFile(String filenamesPath, String CreatePath){


        ReadUntil readUntil = new ReadUntil();
        ArrayList<String> bloggers = readUntil.Method_ReadbyLine(filenamesPath);

        for (String blogger_name : bloggers){

            String pathname  = blogger_name.replace(" ", "_").replace("-", "_").replace(".", "_");
            File file_One = new File(CreatePath+pathname+"\\");
            if (!file_One.exists()) {
                file_One.mkdirs();
            }

            File file_2 = new File(CreatePath+pathname+"\\"+"1_ArticleData\\");
            if (!file_2.exists()){
                file_2.mkdirs();
            }

        }

    }


    public static void Method_Creat_folder(String folderPath){
        File file = new File(folderPath);
        if (!file.exists()){
            boolean a = file.mkdirs();
            System.out.println("创建文件夹 :\t"+folderPath +"\t"+a);
        }
    }


//    public static void main(String[] args) {
//        String bloggerpath = "E:\\ZKZD2023\\大V项目\\知乎数据\\参数文件\\bloggers.txt";
//
//        String CreatePath = "E:\\ZKZD2023\\大V项目\\知乎数据\\Data\\";
//
//        Method_CrateFile(bloggerpath,CreatePath);
//    }
}
