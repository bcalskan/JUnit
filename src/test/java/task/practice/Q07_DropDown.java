package task.practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Q07_DropDown extends TestBase {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6


    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        //-->Task1 Find Dropdown on Multi Selection
        WebElement ddmMultiSelection = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        Select select = new Select(ddmMultiSelection);

        //-->Task2 Find  all Dropdown Elements on page
        List<WebElement> ddmMenüs = driver.findElements(By.xpath("//input[@class='comboTreeInputBox']"));
        System.out.println(ddmMenüs);
        //-->Task3 printout DropDown Elements' number
        System.out.println(ddmMenüs.size());

        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6




    }
}
