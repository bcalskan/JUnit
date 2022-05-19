package task.Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q7_BeforeAfterTest {

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass calisti");
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass calisti");
        driver.close();
    }

    @Before
    public void before(){
        System.out.println("Before calisti");
    }

    @After
    public void after(){
        System.out.println("After calisti");
    }

    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        System.out.println("Test1 calisti");
    }

    @Test
    public void test2(){
        driver.get("https://www.facebook.com");
        System.out.println("Test2 calisti");
    }

}
