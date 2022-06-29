package crm.api;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMWebDriver {
    private WebDriver driver;

    public CRMWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().setSize(new Dimension(746, 824));
    }

    public WebDriver getDriver() {
        return driver;
    }

}
