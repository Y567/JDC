package com.gyy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupDemo1 {
    /**
     * JSoup解析和遍历一个HTML文档
     */

    public static void main(String[] args) {
        //完整的代码
        String html = "<html><body><div>阿狗打我</div></body></html>";
        String html2 = "<p>Lorem <p>Ipsum parses to <p>Lorem</p> <p>Ipsum</p>";
        String html3 = "<html><body><td>Table data</td></body></html>";
        Document document = Jsoup.parse(html);
        Element body = document.body();
        System.out.println("标准的HTML文档解析:");
        System.out.println(body);
        System.out.println("================");
        System.out.println("没有闭合的HTML文档:");
        System.out.println(Jsoup.parse(html2).body());
        System.out.println("================");
        System.out.println("隐式标签的HTML文档：");
        System.out.println(Jsoup.parse(html3).body());
    }
}
