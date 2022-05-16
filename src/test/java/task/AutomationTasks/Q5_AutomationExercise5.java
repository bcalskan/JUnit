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

public class Q5_AutomationExercise5 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'Signup' button
    //8. Verify error 'Email Address already exist!' is visible

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
    public void task5() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue("Homepage isn´t displayed.", homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue("New user sign up is not displayed", newUser.isDisplayed());

        //6. Enter name and already registered email address
        //denemedd@gmail.com
        //test
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("test");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("denemedd@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        //8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExist = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue("Already exist is not disabled.", alreadyExist.isDisplayed());

    }
}
