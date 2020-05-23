package com.gyy.task;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类是用来获取所有需要爬取的数据的链接的
 */
public class Urls {

    public static List<String> getUrls() {
        ArrayList<String> lists = new ArrayList<String>();
        //1.创建文件流
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\GitHub\\JDC\\Jsoup之唯品会\\src\\main\\java\\com\\gyy\\task\\EMZ---2019年7月到12月竞品信息.xlsx");

            //2.创建一个工作簿，将来用来存放excel表数据(因为文件是xlsx结尾所以得用XSSFWorkbook来读取)
            Workbook workbook = new XSSFWorkbook(in);

            //3.读取数据,返回一个工作表
            Sheet sheet = workbook.getSheetAt(0);

            //4.利用工作表的方法读取数据
            for (int i = 1; i <= 1635; i++) {
                //一共这么多数据
                Row row = sheet.getRow(i);
                Cell url = row.getCell(0);
                lists.add(url.toString());
                System.out.println(url);
            }

            //5.记得关闭流
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lists;
    }

}
