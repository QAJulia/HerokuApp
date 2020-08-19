import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hovers {

    WebDriver browser;

    @Test
    public void hovers(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.get("http://the-internet.herokuapp.com/hovers");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Actions actions = new Actions(browser);
        actions.moveToElement(browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).build().perform();
        Assert.assertEquals(browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText(),"name: user1");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        String notFound = browser.findElement(By.xpath("/html/body/h1")).getText();
        Assert.assertEquals(notFound,"Not Found");
        browser.navigate().back();

        actions.moveToElement(browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"))).build().perform();
        Assert.assertEquals(browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText(),"name: user2");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        Assert.assertEquals(notFound,"Not Found");
        browser.navigate().back();

        actions.moveToElement(browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"))).build().perform();
        Assert.assertEquals(browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText(),"name: user3");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        Assert.assertEquals(notFound,"Not Found");
        browser.navigate().back();

        browser.quit();

    }
}
