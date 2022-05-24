package task.Questıons3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_Ödev extends TestBase {
    //Bir Class olusturun D19_WebtablesHomework
    //  1. “https://demoqa.com/webtables” sayfasina gidin
    //  2. Headers da bulunan department isimlerini yazdirin
    //  3. sutunun basligini yazdirin
    //  4. Tablodaki tum datalari yazdirin
    //  5. Tabloda kac cell (data) oldugunu yazdirin
    //  6. Tablodaki satir sayisini yazdirin
    //  7. Tablodaki sutun sayisini yazdirin
    //  8. Tablodaki 3.kolonu yazdirin
    //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //  10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


    @Test
    public void test01() {

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan department isimlerini yazdirin
        //List<WebElement> cellList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        List<WebElement> cellList = driver.findElements(By.xpath("(//div[@class='rt-tr-group']//div[@class='rt-td'])"));
//        for (WebElement each : cellList
//        ) {
//            System.out.println(each.getText());
//        }

        //  3. sutunun basligini yazdirin
        System.out.println("\nTask3\n");
        int istenilenSütun = 3;
        List<WebElement> headerListesi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println(headerListesi.get(istenilenSütun - 1).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("\nTask4\n");
        for (WebElement each : cellList) {
            System.out.println(each.getText());
        }

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("\nTask5\n");
        System.out.println(cellList.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("\nTask6\n");
        List<WebElement> rowList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satir sayisi : " + rowList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("\nTask7\n");
        System.out.println("Sütun sayisi : " + headerListesi.size());

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("\nTask8\n");
        List<WebElement> ücüncüKolonList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[3]"));
        for (WebElement each : ücüncüKolonList) {
            System.out.println(each.getText());
        }

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin


        //  10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


    }
}


//List<WebElement> headerListesi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
//        for (WebElement each : headerListesi) {
//            System.out.println(each.getText());
//        }
//        System.out.println(headerListesi.get(3).getText());
//
//        int departmentIndex = 0;
//        for (int i = 0; i < headerListesi.size(); i++) {
//            if (headerListesi.get(i).getText().equals("Department")) {
//                departmentIndex = i;
//            }
//        }
//        WebElement department = driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[" + (departmentIndex + 1) + "]"));
//        System.out.println(department.getText());

//String insurance = "Insurance";
//        String compliance = "Compliance";
//        String legal = "Legal";
//        int insuranceIndex = 0;
//        int complianceIndex = 0;
//        int legalIndex = 0;
//        for (int i = 0; i < cellList.size(); i++) {
//            if (cellList.get(i).getText().equals(insurance)) {
//                insuranceIndex = i;
//            } else if (cellList.get(i).getText().equals(compliance)) {
//                complianceIndex = i;
//            } else {
//                legalIndex = i;
//            }
//        }
//
//        WebElement insuranceElement = driver.findElement(By.xpath("(//div[@class='rt-td'])[" + (insuranceIndex + 1) + "]"));
//        WebElement complianceElement = driver.findElement(By.xpath("(//div[@class='rt-td'])[" + (complianceIndex + 1) + "]"));
//        WebElement legalElement = driver.findElement(By.xpath("(//div[@class='rt-td'])[" + (legalIndex + 1) + "]"));
//        List<String> departmentList = new ArrayList<String>((Arrays.asList(insuranceElement.getText(), complianceElement.getText(), legalElement.getText())));
//        for (String each : departmentList) {
//            System.out.println(each);
//
//        }
