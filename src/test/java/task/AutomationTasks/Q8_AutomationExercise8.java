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

public class Q8_AutomationExercise8 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
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
        driver.close();
    }

    @Test
    public void task8() {
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

        //6. The products list is visible
        Assert.assertTrue("The products list test FAILED", driver.findElement(By.xpath("//*[text()='Category']")).isDisplayed());

        //7. Click on 'View Product' of first product
        Assert.assertTrue("View Product test FAILED",driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).isDisplayed());

        //8. User is landed to product detail page
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue("Name test FAILED",driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed());
        Assert.assertTrue("Category test FAILED",driver.findElement(By.xpath("//*[text()='Category: Women > Tops']")).isDisplayed());
        Assert.assertTrue("Availability test FAILED",driver.findElement(By.xpath("//*[text()='Availability:']")).isDisplayed());
        Assert.assertTrue("Condition test FAILED",driver.findElement(By.xpath("//*[text()=' New']")).isDisplayed());
        Assert.assertTrue("Brand test FAILED",driver.findElement(By.xpath("//*[text()=' Polo']")).isDisplayed());

    }
}
