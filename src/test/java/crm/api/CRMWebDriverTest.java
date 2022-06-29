package crm.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class CRMWebDriverTest {

    private CRMWebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = new CRMWebDriver();
    }

    @DisplayName("Authorization to the https://www.saucedemo.com")
    @Test
    public void authorizationTest() {
        log.info("Authorization test has been started...");
        driver.getDriver().findElement(By.xpath("//input[@id=\"user-name\"]")).click();
        driver.getDriver().findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.getDriver().findElement(By.xpath("//input[@id=\"password\"]")).click();
        driver.getDriver().findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.getDriver().findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        String title1 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle1 = "PRODUCTS";
        assertEquals(expectedTitle1, title1);
        log.info("Authorization test is completed successfully");
    }

    @DisplayName("Ordering items on the https://www.saucedemo.com")
    @Test
    public void orderingItemsTest() {
        log.info("Items ordering test has been started...");
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        String title2 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle2 = "YOUR CART";
        assertEquals(expectedTitle2, title2);
        driver.getDriver().findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"continue-shopping\"]")).click();
        String title3 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle3 = "PRODUCTS";
        assertEquals(expectedTitle3, title3);
        driver.getDriver().findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
        String title4 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle4 = "YOUR CART";
        assertEquals(expectedTitle4, title4);
        driver.getDriver().findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        String title5 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle5 = "CHECKOUT: YOUR INFORMATION";
        assertEquals(expectedTitle5, title5);
        driver.getDriver().findElement(By.xpath("//*[@id=\"first-name\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Vika");
        driver.getDriver().findElement(By.xpath("//*[@id=\"last-name\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Chyhrynets");
        driver.getDriver().findElement(By.xpath("//*[@id=\"postal-code\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("15-500");
        driver.getDriver().findElement(By.xpath("//*[@id=\"continue\"]")).click();
        String title6 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle6 = "CHECKOUT: OVERVIEW";
        assertEquals(expectedTitle6, title6);
        driver.getDriver().findElement(By.xpath("//*[@id=\"finish\"]")).click();
        String title7 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle7 = "CHECKOUT: COMPLETE!";
        assertEquals(expectedTitle7, title7);
        driver.getDriver().findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        String title8 = driver.getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).
                getText();
        String expectedTitle8 = "PRODUCTS";
        assertEquals(expectedTitle8, title8);
        driver.getDriver().findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]")).click();
        driver.getDriver().findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
        log.info("Items ordering test is completed successfully");
    }

    @AfterAll
    public void closeChromeTab() {
        driver.getDriver().close();
    }

}
