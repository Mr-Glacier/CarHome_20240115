package org.example.Controller;

import org.example.Dao.DaoFather;
import org.example.Entity.Bean_brand;
import org.example.Until.ReadUntil;
import org.example.Until.SaveUntil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

public class Controller_CarHome {

    private SaveUntil saveUntil = new SaveUntil();
    private ReadUntil readUntil = new ReadUntil();


    public String Method_DownHTML(String main_url){
        try{
            Document document = Jsoup.parse(new URL(main_url).openStream(),"GBK",main_url);
            Thread.sleep(550);
            return document.toString();
        }catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }


    public void Method_1_Down_brand(String savePath,String main_url,String fileName){
        String content = Method_DownHTML(main_url);
        if (!content.equals("Error")){
            saveUntil.Method_SaveFile(savePath+fileName, content);
            System.out.println("");
        }
    }

    public void Method_2_Analysis_brand(String savePath,String fileName){

        String content = readUntil.Method_ReadFile(savePath+fileName);
        DaoFather dao_brand = new DaoFather(0,0);

        Document document = Jsoup.parse(content);
        Elements Item_brands = document.select("ul").select("li");
        System.out.println(Item_brands.size());

        for (Element Item : Item_brands){

            String brand_id = Item.attr("id");
            String brand_url = "https://car.autohome.com.cn"+Item.select("a").attr("href");

            String brand_name = Item.select("a").text().replace(Item.select("a").select("em").text(), "");
            String model_size = Item.select("a").select("em").text().replace("(", "").replace(")", "");
            System.out.println(brand_id+"\n"+brand_url+"\n"+brand_name+"\n"+model_size);
            System.out.println("==================================================================");

            Bean_brand brand = new Bean_brand();
            brand.setC_brand_url(brand_url);
            brand.setC_brand_id(brand_id);
            brand.setC_number(model_size);
            brand.setC_brand_name(brand_name);
            brand.setC_DownState("否");
            brand.setC_DownTime("--");

            dao_brand.Method_Insert(brand);
        }
    }

    public void Method_3_Down_model(String savePath,String main_url,String fileName){
        DaoFather dao_brand = new DaoFather(0,0);
        ArrayList<Object> BeanLsit = dao_brand.Method_Find();
        for (Object bean:BeanLsit){
            Bean_brand brand = (Bean_brand) bean;
            String brand_id = brand.getC_brand_id().replace("b", "");
            String DownState = brand.getC_DownState();
            int C_ID  = brand.getC_ID();

            if (DownState.equals("否")){
                String content = Method_DownHTML(main_url.replace("AAAA", brand_id));
                if (!content.equals("Error")){
                    saveUntil.Method_SaveFile(savePath+brand_id+fileName, content);
                    dao_brand.Method_ChangeState(C_ID);
                }
            }
        }
    }
}
