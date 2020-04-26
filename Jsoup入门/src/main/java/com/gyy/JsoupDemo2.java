package com.gyy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupDemo2 {
    /**
     * JSoup解析一个不完整的片段
     */

    public static void main(String[] args) {
        //完整的代码
        String html = "<div>阿狗打我</div>";
        Element body = Jsoup.parseBodyFragment(html).body();
        System.out.println(body);

    }
}
