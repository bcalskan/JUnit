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

public class Q4_AutomationExercise4 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page
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
    public void task4() {
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

        //6. Enter correct email address and password
        String email = "denemedd@gmail.com";
        String password = "password";
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue("Logged in as is not displayed", loggedInAs.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //10. Verify that user is navigated to login page
        WebElement signUp = driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        Assert.assertTrue("Sign up is not displayed", signUp.isDisplayed());

    }
}
