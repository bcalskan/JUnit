package task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Scanner;

public class Q10_PracticeJUnit_Q3 {
    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */

    static WebDriver driver;

    @BeforeClass
    public static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }

    @AfterClass
    public static void after() {
        //driver.quit();
    }

    @Test
    public void createButtons() throws InterruptedException {

        //click on the "Add Element" button 100 times
        for (int i = 0; i < 100; i++) {
            driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        }
        Thread.sleep(3000);

    }

    //write a function that takes a number, and clicks the "Delete" button

    @Test
    public void deleteButtonsAndValidate() {
        // given number of times, and then validates that given number of
        // buttons was deleted
        //int sayi = 5;
        driver.findElement(By.xpath("(//*[text()='Delete'])[5]")).click();
        //WebElement kontrol = driver.findElement(By.xpath("(//*[text()='Delete'])[100]"));

//        if (kontrol.isEnabled()) {
//            System.out.println("Silinmedi");
//        } else System.out.println("Silindi");


    }


}

