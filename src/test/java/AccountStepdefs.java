import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.AccountPage;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.TimeUnit;

public class AccountStepdefs {

    private static String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static String password =PropertiesLoader.getProperties().getProperty("Password");
    private static String URL =PropertiesLoader.getProperties().getProperty("accountPageURL");

    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private AccountPage accountPage;
    private String password1 ="aPassword";
    private String password2 = "anotherPassword";
    private String emptyPassword;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        TestBase.initialisation();
        loginPage = new LoginPage();
        schedulerPage = loginPage.login(userName,password);
        schedulerPage = new SchedulerPage();
    }

    @And("I click change password")
    public void iClickChangePassword() {
        accountPage = schedulerPage.goToAccountPage();
        accountPage = new AccountPage();
    }

    @When("I input the new password password in ‘New Password’ field")
    public void iInputTheNewPasswordPasswordInNewPasswordField() {
        accountPage.enterNewPassword(password1);
    }

    @And("I input the exact same password in ‘Confirm Password’field")
    public void iInputTheExactSamePasswordInConfirmPasswordField() {
        accountPage.enterConfirmPassword(password1);
    }

    @Then("my password is updated.")
    public void myPasswordIsUpdated() {
        Assertions.assertFalse(accountPage.passwordChangedSuccessfully());
    }

    @When("I input the new password in ‘New Password’ field")
    public void iInputTheNewPasswordInNewPasswordField() {
        accountPage.enterNewPassword(password1);
    }

    @And("I input a different password in ‘Confirm Password’field")
    public void iInputADifferentPasswordInConfirmPasswordField() {
        accountPage.enterConfirmPassword(password2);
    }

    @Then("the password isn’t updated.")
    public void thePasswordIsnTUpdated() {
        Assertions.assertTrue(accountPage.passwordChangedSuccessfully());
    }
}
