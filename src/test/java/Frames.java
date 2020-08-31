import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Frames {

    WebDriver browser;

    @Test
    public void iFrame(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/iframe");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(browser, 20);

        browser.switchTo().frame(browser.findElement(By.id("mce_0_ifr")));
        Assert.assertEquals(browser.findElement(By.id("tinymce")).getText(), "Your content goes here.");

        browser.switchTo().defaultContent();
        browser.quit();
    }
}
