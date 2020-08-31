import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Inputs {

    WebDriver browser;

    @Test
    public void inputs() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement input = browser.findElement(By.tagName("input"));
        input.sendKeys("18");
        String text = input.getAttribute("value");
        Assert.assertEquals(text, "18");
        input.sendKeys(Keys.ARROW_DOWN);
        text = input.getAttribute("value");
        Assert.assertEquals(text, "17");
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        text = input.getAttribute("value");
        Assert.assertEquals(text, "19");
        input.clear();
        text = input.getAttribute("value");
        Assert.assertEquals(text, "");

        browser.quit();
    }
}
