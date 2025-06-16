package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private final By logoutButton = By.xpath("//li[@class='Account_listItem__35dAP']//button[text()='Выход']");


    private final By accountDescriptionText = By.xpath("//p[@class='Account_text__fZAIn text text_type_main-default']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public By getLogoutButton() {
        return logoutButton;
    }

    @Step("Ожидание видимости кнопки Выход")
    public WebElement waitForLogoutButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getLogoutButton()));
    }
    @Step("Проверка текста кнопки Выход")
    public boolean isLogoutButtonDisplayed() {
        WebElement logoutButton = waitForLogoutButton();
        return logoutButton.getText().equals("Выход");
    }


    public By getAccountDescriptionText() {
        return accountDescriptionText;
    }

    @Step("Ожидание видимости текста 'В этом разделе вы можете изменить свои персональные данные'")
    public WebElement waitForAccountDescriptionText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getAccountDescriptionText()));
    }

    @Step("Проверка текста 'В этом разделе вы можете изменить свои персональные данные'")
    public boolean isAccountDescriptionTextDisplayed() {
        WebElement accountDescriptionText = waitForAccountDescriptionText();
        return accountDescriptionText.getText().equals("В этом разделе вы можете изменить свои персональные данные");
    }


    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}