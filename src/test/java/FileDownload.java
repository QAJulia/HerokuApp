import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class FileDownload {

    WebDriver browser;

    @Test
    public void fileDownload(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        browser = new OperaDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        HashMap<String, Object> operaPrefs = new HashMap<String, Object>();
        operaPrefs.put("profile.default_content_settings.popups", 0);
        OperaOptions options = new OperaOptions();
        options.setExperimentalOption("prefs", operaPrefs);
        browser = new OperaDriver(options);
        browser.get("http://the-internet.herokuapp.com/download");
        browser.findElement(By.xpath("//a[contains(text(),'logo.png')]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File logo = new File("C:\\Users\\Evgeniy\\Downloads\\logo.png");
        Assert.assertTrue(logo.isFile(), "Downloaded document is not found");
        logo.deleteOnExit();

        browser.quit();
    }
}
