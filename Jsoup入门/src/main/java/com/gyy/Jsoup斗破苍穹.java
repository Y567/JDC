package com.gyy;

import com.gyy.domain.Chapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jsoup斗破苍穹 {
    public static void main(String[] args) throws IOException {
        //获取首页
        Document document = Jsoup.connect("http://www.tycqxs.com/57_57672/").get();

//        System.out.println(document.body());

        //先获得每个小说的章节
        Element list = document.getElementById("list");
//        System.out.println(list);

        //获得每个dd
        Elements list_dd = list.getElementsByTag("dd");
        List<Chapter> novel = new ArrayList<Chapter>();

        for (Element element : list_dd) {
            Element a = element.getElementsByTag("a").first();
            //获取标题
            String title = a.text();
            //获取绝对路径
            String url = a.attr("abs:href");
//            System.out.println(title+" "+url);

            novel.add(new Chapter(title,url));
        }

        //爬取每个章节的标题以及详情页url
        for (Chapter chapter : novel) {
            try {
                //获取每个章节的具体内容
                Element body = Jsoup.connect(chapter.getUrl()).get().body();
                //正文
                String content = body.getElementById("content").text();
                //创建文件将内容写入
                File file = new File("C:\\Users\\可乐yue\\Desktop\\斗破苍穹\\"+chapter.getTitle()+".txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.append(content);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                continue;
            }
        }
    }
}
