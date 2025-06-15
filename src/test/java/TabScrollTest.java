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

import static org.junit.Assert.assertTrue;

public class TabScrollTest {
    private static final Logger logger = LoggerFactory.getLogger(TabScrollTest.class);

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
    public void testBunsSectionVisibility() {

        mainPage.clickSaucesTab();
        mainPage.waitForBunsTab();
        mainPage.clickBunsTab();
        mainPage.waitForBunsHeader();
        assertTrue(mainPage.isBunsHeaderDisplayed());


        mainPage.waitForBunsIngredient();
        assertTrue(mainPage.isBunsIngredientDisplayed());

        assertTrue(mainPage.isElementInViewport(mainPage.waitForBunsIngredient()));
    }

    @Test
    public void testSaucesSectionVisibility() {

        mainPage.waitForFillingsTab();
        mainPage.clickFillingsTab();
        mainPage.waitForSaucesTab();
        mainPage.clickSaucesTab();
        mainPage.waitForSaucesHeader();
        assertTrue(mainPage.isSaucesHeaderDisplayed());

        mainPage.waitForSaucesIngredient();
        assertTrue(mainPage.isSaucesIngredientDisplayed());

        assertTrue(mainPage.isElementInViewport(mainPage.waitForSaucesIngredient()));
    }

    @Test
    public void testFillingsSectionVisibility() {

        mainPage.waitForSaucesTab();
        mainPage.clickSaucesTab();
        mainPage.waitForFillingsTab();
        mainPage.clickFillingsTab();


        mainPage.waitForFillingsHeader();
        mainPage.isFillingsHeaderDisplayed();

        mainPage.waitForFillingsIngredient();
        assertTrue(mainPage.isFillingsIngredientDisplayed());

        mainPage.scrollToElement(mainPage.waitForFillingsIngredient());

        assertTrue(mainPage.isElementInViewport(mainPage.waitForFillingsIngredient()));
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}