package com.gyy.task;

import com.alibaba.excel.EasyExcel;
import com.gyy.pojo.Clothes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 这个类是根据获得的url进行爬取并获取数据的
 */
public class GetInfo {

    public static final String PATH="D:\\GitHub\\JDC\\Jsoup之唯品会\\src\\main\\java\\com\\gyy\\task\\EMZ---2019年7月到12月竞品信息(爬取).xlsx";

    public static void main(String[] args) throws IOException {

        //创建一个对象，用来存放爬取下来的数据
        List<Clothes> lists = new ArrayList<>();

        //1.0得到链接
        List<String> urls = Urls.getUrls();

        //2.0模拟爬虫进行爬取
        for (String url: urls) {
            Document document = Jsoup.connect(url).header("Sec-Fetch-Mode", "navigate").header("Accept-Encoding", "gzip, deflate, br").get();

            //3.0获得信息
            Clothes clothes = new Clothes();
            Elements names = document.select("p.pib-title-detail");
            //3.0.1获取衣服的链接
            clothes.setUrl(url);
            //3.0.2获取衣服的名字
            String name = names.text();
            clothes.setName(name);
            //3.0.3获取衣服的价格
            Elements prices = document.select("em.J-price");
            String price = prices.text();
            clothes.setPrice(price);
//        System.out.println(prices.html());
            String detail = document.select("tbody.J_dc_table").text();
            String[] strings = detail.split(" ");
            //3.0.4遍历一遍数组，将数据添加到hashMap中
            HashMap<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < strings.length-1;i++){
                if(strings[i].contains("：")){
                    if(!strings[i].equals("洗涤说明：")){
                        map.put(strings[i].replace("：",""),strings[i+1]);
                    }
                }
            }
            //3.0.5设置属性咯
            clothes.setQuality(map.getOrDefault("材质",""));
            clothes.setFabric(map.getOrDefault("面料",""));
            clothes.setHot(map.getOrDefault("选购热点",""));
            clothes.setId(map.getOrDefault("商品编号",""));
            clothes.setStyle(map.getOrDefault("风格",""));
            clothes.setTime(map.getOrDefault("上市时间",""));
            clothes.setDetail(detail);

            //加入到列表中
            lists.add(clothes);
        }

        //写入excel表,需要传入一个list集合，这一句话就写完了
        EasyExcel.write(PATH,Clothes.class).sheet("衣服").doWrite(lists);
    }
}
