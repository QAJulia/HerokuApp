import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Tables {

    WebDriver browser;

    @Test
    public void tables(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/tables");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Assert.assertEquals(browser.findElement(By.xpath("*//table[1]//tr[1]//td[3]")).getText(), "jsmith@gmail.com");
        Assert.assertEquals(browser.findElement(By.xpath("*//table[1]//tr[3]//td[1]")).getText(), "Doe");
        Assert.assertEquals(browser.findElement(By.xpath("*//table[1]//tr[4]//td[5]")).getText(), "http://www.timconway.com");
        Assert.assertEquals(browser.findElement(By.xpath("*//table[2]//tr[2]//td[2]")).getText(), "Frank");
        Assert.assertEquals(browser.findElement(By.xpath("*//table[2]//tr[3]//td[4]")).getText(), "$100.00");
        Assert.assertEquals(browser.findElement(By.xpath("*//table[2]//tr[1]//td[1]")).getText(), "Smith");

        browser.quit();
    }
}
