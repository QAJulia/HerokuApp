import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DynamicControls {

    WebDriver browser;

    public boolean checkboxExists(){
        int number = browser.findElements(By.id("checkbox")).size();
        return number > 0;
    }

    @Test
    public void dynamicControls(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/dynamic_controls");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(browser, 20);

        browser.findElement(By.id("checkbox"));
        browser.findElement(By.cssSelector("*[onclick='swapCheckbox()']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
        Assert.assertEquals(browser.findElement(By.id("message")).getText(), "It's gone!");
        Assert.assertFalse(checkboxExists());


        Assert.assertFalse(browser.findElement(By.cssSelector("input[type='text']")).isEnabled());
        browser.findElement(By.cssSelector("*[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(browser.findElement(By.cssSelector("input[type='text']")).isEnabled());

        browser.quit();
    }
}
