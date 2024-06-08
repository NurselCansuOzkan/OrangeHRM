package Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By LoginTitle = By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title");
    By LoginButton = By.cssSelector("button[type='submit']");
    By requiredMessageForUsername = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(3)");
    By requiredMessageForPassword = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(3)");
    By usernameField = By.cssSelector("input[placeholder='Username']");
    By passwordField = By.cssSelector("input[placeholder='Password']");
    By invalidCredentialsMessage = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    By dashboard = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

    public void verifyUserAtLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement title = driver.findElement(LoginTitle);
        String titleText = title.getText();
        assertEquals(titleText, "Login");
    }

    public void clickLoginButton() {
        elementHelper.click(LoginButton);
    }

    public void checkRequiredMessage() {
        elementHelper.checkVisible(requiredMessageForUsername);
        elementHelper.checkVisible(requiredMessageForPassword);
    }

    public void writeUsernameandPassword() {
        elementHelper.click(usernameField);
        elementHelper.sendKey(usernameField, "abcdef");
        elementHelper.click(passwordField);
        elementHelper.sendKey(passwordField, "123456");
    }

    public void checkInvalidCredentialsMessage() {
        WebElement errorMessage = driver.findElement(invalidCredentialsMessage);
        String errorMessageText = errorMessage.getText();
        assertEquals(errorMessageText, "Invalid credentials");

    }

    public void writeCorrectUsernameandPassword() {
        elementHelper.click(usernameField);;
        elementHelper.sendKey(usernameField, "Admin");
        elementHelper.click(passwordField);
        elementHelper.sendKey(passwordField, "admin123");
    }

    public void checkDashboard() {
        WebElement dashboardElement = driver.findElement(dashboard);
        String dashboardElementText = dashboardElement.getText();
        assertEquals(dashboardElementText, "Dashboard");
    }
}
