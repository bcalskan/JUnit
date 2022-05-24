package task.Questıons3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q_Ödev1 extends TestBase {
    @Test
    public void test01() {
        //Bir Class olusturun D19_WebtablesHomework
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan department isimlerini yazdirin
        System.out.println("\nTask2\n");
        List<WebElement> headerList = driver.findElements(By.xpath("//div[@class='rt-tr']//div[@role='columnheader']"));
        int departmentIndex = 0;
        for (int i = 0; i < headerList.size(); i++) {
            if (headerList.get(i).getText().equals("Department")) {
                departmentIndex = i;
            }
        }

        List<WebElement> departmentList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[" + (departmentIndex + 1) + "]"));
        for (WebElement each : departmentList) {
            if (!each.getText().equals(" ")) {
                System.out.println(each.getText());
            }
        }

        //  3. 3. sutunun basligini yazdirin
        System.out.println("\nTask3\n");
        System.out.println(headerList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("\nTask4\n");
        List<WebElement> tabloList = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        for (WebElement each : tabloList) {
            System.out.println(each.getText());
        }

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("\nTask5\n");
        List<WebElement> cellList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println(cellList.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("\nTask6\n");
        List<WebElement> satirList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println(satirList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("\nTask7\n");
        System.out.println(headerList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("\nTask8\n");
        //div[@class='rt-tr-group']//div[3] --> 3.kolonun altindakiler
        System.out.println("\n*****1.YÖNTEM*****\n");
        List<WebElement> ücüncüKolonList = driver.findElements(By.xpath("//div[@role='row']//div[3]"));
        for (WebElement each : ücüncüKolonList) {
            if (!each.getText().equals(" ")) {
                System.out.println(each.getText());
            }
        }

        System.out.println("\n*****2.YÖNTEM*****\n");
        List<WebElement> ücüncüKolonList2 = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[3]"));
        for (WebElement each : ücüncüKolonList2) {
            if (!each.getText().equals(" ")) {
                System.out.println(each.getText());
            }
        }

        //  9. Tabloda "First Name"i Kierra olan kisinin Salary'sini yazdirin
        //   ((//div[@class='rt-tr-group'])["+i+"]//div[1])//div[1])).getText().equals("Kierra"))
        System.out.println("\nTask9\n");
        for (int i = 1; i <= headerList.size(); i++) {
            if (driver.findElement(By.xpath("((//div[@class='rt-tr-group'])[" + i + "]//div[1])//div[1]")).getText().equals("Kierra")) {
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[5]")).getText());
            }
        }

        //  10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println("\nTask10\n");
        kaybedenlerKulübü();

    }

    private void kaybedenlerKulübü() {
        int satir = 3;
        int sütun = 5;
        WebElement girilenSayilarinDatasi = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + satir + "]//div[" + sütun + "]"));
        System.out.println(girilenSayilarinDatasi.getText());
    }
}
