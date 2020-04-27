package com.gyy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.annotation.Resources;
import java.io.File;
import java.io.IOException;

public class Jsoup从文件中解析 {

    public static void main(String[] args) throws IOException {
        String path = "/test.html";
        File file = new File(path);
        Document document = Jsoup.parse(Resources.class.getResourceAsStream(path), "UTF-8", "");

        System.out.println(document.body());

    }
}
