package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    //excel dosyasindaki tüm verileri classimiza alip
    // bir java objesine store edelim
    //böylece her seferinde excele ulasip satir sütun vs.. ugrasmayalim

    //database yapisinda olan exceli
    //koyabilecegimiz en uygun Java objesi maptir

    @Test
    public void readExcelTest() throws IOException {
        Map<String, String> ülkelerMap = new HashMap<>();
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();


        for (int i = 0; i <= sonSatirIndexi; i++) {
            //key i. satirdaki 0 indexindeki datadir
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value i. satirdaki 1,2 ve 3. indexdeki datalarin birlesimidir
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ülkelerMap.put(key, value);
        }
        System.out.println(ülkelerMap);

        //Listede Ghana oldugunu test et

        Assert.assertTrue(ülkelerMap.keySet().contains("Ghana"));

    }
}
