package com.gyy;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupDemo3 {
    /**
     * JSoup解析一个在线网站
     */

    public static void main(String[] args) throws IOException {
        //完整的代码
//        Connection connect = Jsoup.connect("https://y567.gitee.io");

        //还有一种增强连接的方法（可以伪装的更好）
        Document document = Jsoup.connect("http://y567.gitee.io/")
                .data("query", "Java")
                .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Mobile Safari/537.36")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
        System.out.println("解析自己的博客:");
        System.out.println(document);
    }
}
