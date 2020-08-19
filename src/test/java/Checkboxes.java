import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Checkboxes {

    WebDriver browser;

    @Test
    public void checkboxes() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Assert.assertFalse(browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected());
        browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected());
        Assert.assertTrue(browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected());
        browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        Assert.assertFalse(browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected());

        browser.quit();
    }
}
