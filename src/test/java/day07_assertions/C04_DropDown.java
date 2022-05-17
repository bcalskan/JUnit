package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDown {
    /*
    amazona git
    dropdown´dan books sec
    Java arat
    arama sonuclarinin Java icerdigini test edelim
     */
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void after() {
        //driver.quit();
    }

    @Test
    public void amazon() throws InterruptedException {
        driver.get("https://www.amazon.com");
        //DropDown´dan bir option secmek icin 3 adim vardir

        //1- dropdown locate edilir
        WebElement dropDownMenü = driver.findElement(By.xpath(" //select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        //2- bir select objesi olusturup
        //parametre olarak bir önceki adimda locate edecegimiz ddm´yu girelim
        Select select = new Select(dropDownMenü);

        //3-Dropdown´da var olan optionlardan istedigimiz bir taneyi secelim
        select.selectByVisibleText("Automotive");
        //select.selectByIndex(); --> yukaridan asagi 0´dan baslayarak index ile
        //select.selectByValue("");

        //Java arat
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Java" + Keys.ENTER);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
        Thread.sleep(5000);
    }
}
