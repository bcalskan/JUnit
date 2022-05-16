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

public class Q6_AutomationExercise6 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

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
    public void task5() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue("Homepage isn´t displayed.", homePage.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue("Get in touch is not visible.", getInTouch.isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Tech");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Tech@gmail.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Subject");
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Subject message");

        //7. Upload file
        //driver.findElement(By.xpath("//input[@type='file']")).click();

        //8. Click 'Submit' button
        //driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Click OK button

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        //11. Click 'Home' button and verify that landed to home page successfully

    }
}
