package task.Questions2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseClass;

public class Q6 extends TestBaseClass {
    //1. Bir Class olusturalim YanlisEmailTesti
    //2. http://automationpractice.com/index.php sayfasina gidelim
    //3. Sign in butonuna basalim
    //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bas
    //5. “Invalid email address” uyarisi ciktigini test edelim

    @Test
    public void test01() {
        //2. http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //3. Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bas
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("denemegmail.com" + Keys.ENTER);

        //5. “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }
}
