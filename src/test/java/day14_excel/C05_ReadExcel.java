package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void ReadExcelTesti() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //Sayfa2 ye gidip satir sayisinin 29,
        // kullanilan satir sayisinin 13 oldugunu test edin
        int sonSatirIndexi = workbook.getSheet("Sayfa2").getLastRowNum(); // --> 28 --> +1 --> 29
        int expectedSatirSayisi = 29;
        Assert.assertEquals(expectedSatirSayisi, sonSatirIndexi + 1);

        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows(); //-> kullanilan satir sayisini verir
        int expectedKullanilanSatirSayisi = 13;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);

    }
}
