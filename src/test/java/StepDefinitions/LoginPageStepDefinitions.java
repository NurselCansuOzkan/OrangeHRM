package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LoginPageStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("User at login page")
    public void userAtLoginPage() {
        loginPage.verifyUserAtLoginPage();
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Check Required message about Username and Password")
    public void checkRequiredMessageAboutUsernameAndPassword() {
        loginPage.checkRequiredMessage();
    }

    @When("Write username and password")
    public void writeUsernameAndPassword() {
        loginPage.writeUsernameandPassword();
    }

    @Then("Check Invalid credentials message about login")
    public void checkInvalidCredentialsMessageAboutLogin() {
        loginPage.checkInvalidCredentialsMessage();
    }

    @When("Write correct username and password")
    public void writeCorrectUsernameAndPassword() {
        loginPage.writeCorrectUsernameandPassword();
    }

    @Then("Check Successful login")
    public void checkSuccessfulLogin() {
        loginPage.checkDashboard();
    }


}
