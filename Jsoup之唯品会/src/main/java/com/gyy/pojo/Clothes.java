package com.gyy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

public class Clothes {
    //衣服的名字
    @ExcelProperty("商品名称")
    private String name;
    //衣服的编号
    @ExcelProperty("商品编号")
    private String id;
    //衣服的价格
    @ExcelProperty("价格")
    private String price;
    //衣服的材质
    @ExcelProperty("材质")
    private String quality;
    //衣服的面料
    @ExcelProperty("面料")
    private String fabric;
    //选购热点
    @ExcelProperty("选购热点")
    private String hot;
    //风格
    @ExcelProperty("风格")
    private String style;
    //上市时间
    @ExcelProperty("上市时间")
    private String time;
    //衣服的链接
    @ExcelProperty("衣服链接")
    private String url;
    //衣服的详细参数
    @ExcelProperty("详细参数")
    private String detail;

    public Clothes() {
    }

    public Clothes(String name, String id, String price, String quality, String fabric, String hot, String style, String time, String url, String detail) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quality = quality;
        this.fabric = fabric;
        this.hot = hot;
        this.style = style;
        this.time = time;
        this.url = url;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
