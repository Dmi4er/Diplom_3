import config.BrowserFactory;
import config.TestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.Assert.*;

public class TabScrollTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;

    @Before
    public void setUp() {

        driver = BrowserFactory.getWebDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize(); // Максимизировать окно браузера
        driver.get(TestConfig.BASE_URI);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testBunsSectionVisibility() throws InterruptedException {
        mainPage.waitForSaucesTab();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        assertEquals("Не сработал переход к разделу Булки", "Булки", mainPage.getTabText());
    }

    @Test
    public void testSaucesSectionVisibility() throws InterruptedException {
        mainPage.waitForSaucesTab();
        mainPage.clickSaucesTab();
        assertEquals("Не сработал переход к разделу Соусы", "Соусы", mainPage.getTabText());
    }

    @Test
    public void testFillingsSectionVisibility() throws InterruptedException {
        mainPage.waitForFillingsTab();
        mainPage.clickFillingsTab();
        assertEquals("Не сработал переход к разделу Начинки", "Начинки", mainPage.getTabText());
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}