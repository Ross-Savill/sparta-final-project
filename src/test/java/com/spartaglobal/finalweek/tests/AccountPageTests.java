package com.spartaglobal.finalweek.tests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.AccountPage;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPageTests extends NavTemplate {

    private static String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static String password =PropertiesLoader.getProperties().getProperty("Password");
    private static String URL =PropertiesLoader.getProperties().getProperty("accountPageURL");

    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private AccountPage accountPage;
    private String password1;
    private String password2;
    private String emptyPassword;


    @BeforeEach
    public void setup() {
        ResetData.resetData();
        TestBase.initialisation();

        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        loginPage = new LoginPage();
        schedulerPage = loginPage.login(userName,password);

        schedulerPage = new SchedulerPage();


        accountPage = schedulerPage.goToAccountPage();
        accountPage = new AccountPage();

        password1 = "aPassword";
        password2 = "aDifferentPassword";
        emptyPassword = "";

    }

    @Test
    @DisplayName("Test able to confirm that values can be passed into the new password value text box")
    void testNewPasswordValue(){
        accountPage.enterNewPassword(password1);
        Assertions.assertEquals(password1, accountPage.getNewPasswordTextField());
    }

    @Test
    @DisplayName("Test able to confirm that values can be passed into the confirm value text box")
    void testConfirmPasswordValue(){
        accountPage.enterConfirmPassword(password1);
        Assertions.assertEquals(password1, accountPage.getConfirmPasswordTextField());
    }

    @Test
    @DisplayName("Test to see if Submit button is Clickable")
    void isSubmitButtonClickable(){
        assertTrue(accountPage.submitClickable());
    }

    @Test
    @DisplayName("Different passwords check.")
    void testErrorMessageIsDisplayed(){
        String differentPassword = "qwerty";
        assertTrue(accountPage.isErrorMessageDisplayed(password1,differentPassword));
    }

    @Test
    @DisplayName("Test if passwords Match.")
    void testIfPasswordsMatch(){
        accountPage.enterNewPassword(password1);
        accountPage.enterConfirmPassword(password1);

        assertTrue(accountPage.isMatchingPassword());
    }

    @Test
    @DisplayName("Test if passwords Match when passwords don't match.")
    void testIfPasswordsDontMatch(){
        accountPage.enterNewPassword(password1);
        accountPage.enterConfirmPassword(password2);

        Assertions.assertFalse(accountPage.isMatchingPassword());
    }

    @Test
    @DisplayName("Test if passwords are filled when values are passed in both fields.")
    void testIfPasswordsFieldsAreFilled(){
        accountPage.enterNewPassword(password1);
        accountPage.enterConfirmPassword(password1);

        assertTrue(accountPage.areBothFieldsFilled());
    }

    @Test
    @DisplayName("Test if passwords are not empty when nothing is passed into the confirm value text box")
    void testIfPasswordFieldIsEmpty(){
        accountPage.enterNewPassword(password1);
        accountPage.enterConfirmPassword(emptyPassword);

        Assertions.assertFalse(accountPage.areBothFieldsFilled());
    }

    @Test
    @DisplayName("Test if passwords are not empty when nothing is passed into the confirm value text box")
    void testIfConfirmPasswordFieldIsEmpty(){
        accountPage.enterNewPassword(emptyPassword);
        accountPage.enterConfirmPassword(password1);

        Assertions.assertFalse(accountPage.areBothFieldsFilled());
    }

    @Test
    @DisplayName("Test if passwords are filled when values are passed in both fields.")
    void isPasswordChangesSuccessful(){
        accountPage.enterNewPassword(password1);
        accountPage.enterConfirmPassword(password1);

        Assertions.assertTrue(accountPage.passwordChangedSuccessfully());
    }

    @Test
    @DisplayName("Test if URL is correct for the Account Page")
    void checkAccountPageURL(){
        accountPage.enterNewPassword(emptyPassword);
        accountPage.enterConfirmPassword(password1);

        Assertions.assertEquals(URL,accountPage.getURL());
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
