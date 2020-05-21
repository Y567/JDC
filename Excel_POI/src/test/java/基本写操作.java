import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class 基本写操作 {

    private static final String PATH = "D:\\GitHub\\JDC\\Excel_POI\\src\\test\\java";

    public static void main(String[] args) throws IOException {
        //1.创建一个工作簿
        Workbook workbook = new XSSFWorkbook();

        //2.创建一个工作表
        Sheet sheet = workbook.createSheet();

        //3.创建一行,它是从0开始的
        Row row = sheet.createRow(0);

        //4.创建一个单元格,与上面的哪个就组成了一个单元格
        Cell cellHead1 = row.createCell(0);
        Cell cellHead2 = row.createCell(1);

        cellHead1.setCellValue("名字");
        cellHead2.setCellValue("年龄");

        //5.将内容写出到文件中
        FileOutputStream fout = new FileOutputStream(PATH + "poi操作excel07版.xlsx");
        workbook.write(fout);
        fout.close();

    }
}
