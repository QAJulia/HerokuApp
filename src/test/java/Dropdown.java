import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Dropdown {

    WebDriver browser;

    @Test
    public void dropdown() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/dropdown");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Select select = new Select(browser.findElement(By.id("dropdown")));
        select.selectByValue("1");
        String text1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Option 1");
        select.selectByValue("2");
        String text2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "Option 2");

        browser.quit();
    }
}
