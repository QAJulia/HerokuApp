import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Typos {

    WebDriver browser;

    @Test
    public void typos(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/typos");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String text = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(browser.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText(), text);

        browser.quit();
    }
}
