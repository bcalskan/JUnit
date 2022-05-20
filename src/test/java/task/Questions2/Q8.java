package task.Questions2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class Q8 extends TestBaseClass {
    //● Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın.

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownMenu);
        //WebElement opt1 = driver.findElement(By.xpath("//*[text()='Option 1']"));
        //System.out.println(opt1.getText());

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        select.getFirstSelectedOption().getText();

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown options´i yazdırın
        List<WebElement> dropDownList = select.getAllSelectedOptions();
        for (WebElement each : dropDownList) {
            System.out.println(each.getText());
        }

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        int ddBoyut = dropDownList.size();
        System.out.println((ddBoyut == 4) ? true : false);


    }
}
