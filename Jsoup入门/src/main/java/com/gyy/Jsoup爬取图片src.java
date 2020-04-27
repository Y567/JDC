package com.gyy;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Jsoup爬取图片src {

    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://699pic.com/tupian-500144148.html");
        connect.userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Mobile Safari/537.36");
        connect.timeout(30000);
        Document doc = connect.post();
        Element body = doc.body();
//        System.out.println(body);

        Elements imgs = body.getElementsByTag("img");
        for (Element img : imgs) {
            System.out.println(img.attr("alt")+" "+img.attr("src"));
        }


    }
}
