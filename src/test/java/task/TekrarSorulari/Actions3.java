package task.TekrarSorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseImplicitly;

public class Actions3 extends TestBaseImplicitly {

    @Test
    public void name() {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String dropped = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expectedText = "Dropped!";
        Assert.assertTrue(dropped.equals(expectedText));
    }
}
