import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AddRemoveElements {

    WebDriver browser;

    @Test
    public void addRemoveElements() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        browser.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        browser.findElement(By.xpath("//*[@id=\"elements\"]/button[2]")).click();
        Assert.assertEquals(browser.findElements(By.className("added-manually")).size(), 1);

        browser.quit();
    }
}
