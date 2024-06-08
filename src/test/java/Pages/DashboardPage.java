package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class DashboardPage {

    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By MyInfoButton = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(1) > span:nth-child(2)");
    By FirstNameField = By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input");
    By MiddleNameField = By.cssSelector("input[placeholder='Middle Name']");
    By LastNameField = By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input");
    By SaveButton = By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div.oxd-form-actions > button");
    By NameAndSurnameTitle = By.cssSelector(".oxd-userdropdown-name");

    public void clickToMyInfo() {
        elementHelper.click(MyInfoButton);
    }

    public void changeNameandSurname() {
        //WebElement Username = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input"));
        //Username.sendKeys(Keys.COMMAND+"a");
        //Username.sendKeys(Keys.DELETE);


        elementHelper.findElement(FirstNameField);
        elementHelper.sendKey(FirstNameField, Keys.COMMAND + "a");
        elementHelper.sendKey(FirstNameField, Keys.DELETE+"");
        elementHelper.sendKey(FirstNameField, "Nursel");

        elementHelper.findElement(LastNameField);
        elementHelper.sendKey(LastNameField, Keys.COMMAND+"a");
        elementHelper.sendKey(LastNameField, Keys.DELETE+"");
        elementHelper.sendKey(LastNameField, "Özkan");

    }

    public void clickToSave() {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        elementHelper.click(SaveButton);
    }

    public void checkNewNameandNewSurname() {
        elementHelper.click(MyInfoButton);
        WebElement NewNameandSurname = elementHelper.findElement(NameAndSurnameTitle);
        String NewNameandSurnameText =NewNameandSurname.getText();

        assertEquals(NewNameandSurnameText, "Nursel Özkan");


    }
}
