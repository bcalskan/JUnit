package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

    }
}
