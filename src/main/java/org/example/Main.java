package org.example;

import org.example.Controller.Controller_CarHome;
import org.example.Until.HelpCreateFile;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String main_path = "E:\\ZKZD2024\\汽车之家\\20240116\\";

        String brand_savePath = main_path + "brand\\";
        String model_savePath = main_path + "model\\";
        String version_savePath = main_path + "version\\";
        String Config_savePath = main_path + "Config\\";

        HelpCreateFile.Method_Creat_folder(brand_savePath);
        HelpCreateFile.Method_Creat_folder(model_savePath);
        HelpCreateFile.Method_Creat_folder(version_savePath);
        HelpCreateFile.Method_Creat_folder(Config_savePath);

        Controller_CarHome CC = new Controller_CarHome();
        String brand_url = "https://car.autohome.com.cn/AsLeftMenu/As_LeftListNew.ashx?typeId=1%20&brandId=0%20&fctId=0%20&seriesId=0";
        String brand_fileName = "brand_html.txt";

//        1.下载品牌页面
//        CC.Method_1_Down_brand(brand_savePath,brand_url,brand_fileName);

//        2.解析品牌
//        CC.Method_2_Analysis_brand(brand_savePath,brand_fileName);

        String modelurl = "https://car.autohome.com.cn/AsLeftMenu/As_LeftListNew.ashx?typeId=1%20&brandId=AAAA%20&fctId=0%20&seriesId=0";
        String model_fileName = "_model.txt";
//        3.下载厂商车型
        CC.Method_3_Down_model(model_savePath,modelurl,model_fileName);

    }
}