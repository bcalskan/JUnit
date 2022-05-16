package task.AutomationTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q9_AutomationExercise9 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible

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
        //driver.close();
    }

    @Test
    public void task9() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue("Homepage isn´t displayed.", homePage.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue("ALL PRODUCTS test FAILED", driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());

        //6. Enter product name in search input and click search button
        String productName = "Blue Top";
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(productName);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue("Searched products is not visible", driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed());

        //8. Verify all the products related to search are visible

    }
}
