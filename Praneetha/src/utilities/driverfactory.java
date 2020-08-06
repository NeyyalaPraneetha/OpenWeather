package utilities;

import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class driverfactory {
    WebDriver driver;

    public static WebDriver Open(String browertype) {
        //As of now i have made this work for only chrome, we can place other browsers as well by using If conditions or datatables
        browertype.contains("Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\mywork\\chromedriver.exe");
        return new ChromeDriver();

    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

}
