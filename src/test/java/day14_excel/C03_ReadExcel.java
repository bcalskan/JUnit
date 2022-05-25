package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        //input olarak verilen
        //satirno sütünno degerlerini parametre olarak alip
        //o celldeki datayi String olarak bana döndüren bir method olusturun
        int satirNo = 4;
        int sütunNo = 4;

        //dönen Stringin Cezayir oldugunu test edin
        String expectedData = "Cezayir";

        String actualData = dataGetir(satirNo - 1, sütunNo - 1); // cünkü excel index ile calisir
        Assert.assertTrue(actualData.equals(expectedData ));
    }

    public static String dataGetir(int satirIndex, int sütunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sütunIndex).toString();

        return istenenData;
    }
}
