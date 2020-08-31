import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationMessage {
    WebDriver browser;

    @Test
    public void notificationMessage(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/notification_message_rendered");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        browser.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        String message = browser.findElement(By.id("flash")).getText();
        Assert.assertEquals(message, "Action unsuccesful, please try again");

        browser.quit();

    }

}
