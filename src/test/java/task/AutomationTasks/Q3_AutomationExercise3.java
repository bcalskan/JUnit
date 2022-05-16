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

public class Q3_AutomationExercise3 {
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
    public void task3() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue("Homepage isn´t displayed.", homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginTo = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue("LoginTo isn´t displayed.", loginTo.isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("incorrectmail@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("incorrectpassword");


        //7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrectTest = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue("'Your email or password is incorrect' is not visible", incorrectTest.isDisplayed());
    }


}
