package task.Questıons3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

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
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


    @Test
    public void test01() {

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> headerList = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        int departmentIndex = 0;
        for (int i = 0; i < headerList.size(); i++) {
            if (headerList.get(i).equals("Department")) {
                departmentIndex = i;
            }
        }
        //div[@class='rt-th rt-resizable-header -cursor-pointer']
        WebElement department = driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])["+(departmentIndex+1)+"]"));
        System.out.println(department.getText());

        //  3. sutunun basligini yazdirin

        //  4. Tablodaki tum datalari yazdirin

        //  5. Tabloda kac cell (data) oldugunu yazdirin

        //  6. Tablodaki satir sayisini yazdirin

        //  7. Tablodaki sutun sayisini yazdirin

        //  8. Tablodaki 3.kolonu yazdirin

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        //  10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }
}
