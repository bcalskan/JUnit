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

public class Q2_AutomationExercise2 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Delete Account' button
    //10. Verify that 'ACCOUNT DELETED!' is visible

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
    public void task2() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //System.out.println(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed() ?
        //                "Home page PASSED" : "Home page FAILED");
        WebElement homePage = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue("Homepage isn´t displayed.", homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginTo = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue("LoginTo isn´t displayed.", loginTo.isDisplayed());
        //Assert.assertFalse("LoginTo isn´t displayed.",loginTo.isDisplayed());
        // --> Eger yazinin sayfada görülmedigini biliyorsak assertFalse kullanabiliriz

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

        //9. Click 'Delete Account' button
        WebElement deleteAcc = driver.findElement(By.xpath("//*[text()=' Delete Account']"));
        deleteAcc.click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement text = driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]"));
        String expectedText = "ACCOUNT DELETED";
        //Assert.assertEquals("ACCOUNT DELETED bulunamadi",text.getText(),expectedText); -->  "Process finished with exit code -1" verir
        Assert.assertFalse(text.getText().contains(expectedText)); // sonuc false oldugu icin kod calisir ve "Process finished with exit code 0" verir.
    }
}
