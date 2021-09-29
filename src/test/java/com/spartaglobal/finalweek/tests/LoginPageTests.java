package com.spartaglobal.finalweek.tests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.hamcrest.*;
import org.openqa.selenium.NoSuchElementException;

public class LoginPageTests extends NavTemplate {

    private LoginPage loginPage;
    private static String username;
    private static String password;

    @BeforeAll
    public static void setupAll() {
        username = PropertiesLoader.getProperties().getProperty("Username");
        password = PropertiesLoader.getProperties().getProperty("Password");
    }

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        loginPage = new LoginPage();
    }

    @Nested
    @DisplayName("Test Retrieving elements from page")
    class getElements {
        @Test
        @DisplayName("Test able to get username text field")
        void testAbleToGetUsernameTextField() {
            Assertions.assertNotNull(loginPage.getUsernameElement());
        }
        @Test
        @DisplayName("Test able to get password text field")
        void testAbleToGetPasswordTextField() {
            Assertions.assertNotNull(loginPage.getPasswordElement());
        }
    }

    @Nested
    @DisplayName("Test Retrieving values from page elements")
    class getValues {
        @Test
        @DisplayName("Test able to get username text field value")
        void testAbleToGetUsernameTextFieldValue() {
            loginPage.enterUsername(username);
            Assertions.assertFalse(Matchers.emptyOrNullString().matches(loginPage.getUsername()));
        }
        @Test
        @DisplayName("Test able to get password text field value")
        void testAbleToGetPasswordTextFieldValue() {
            loginPage.enterPassword(password);
            Assertions.assertFalse(Matchers.emptyOrNullString().matches(loginPage.getPassword()));
        }
    }

    @Nested
    @DisplayName("Test entering elements works")
    public class enterElements {
        @Test
        @DisplayName("Test fields are empty by default")
        void testFieldsAreEmptyByDefault() {
            Assertions.assertTrue(loginPage.areAllFieldsEmpty());
        }
        @Test
        @DisplayName("Test enter password enters the password")
        void testEnterPasswordEntersThePassword() {
            loginPage.enterPassword(password);
            Assertions.assertFalse(loginPage.isPasswordFieldEmpty());
        }
        @Test
        @DisplayName("Test enter username enters the username")
        void testEnterUsernameEntersTheUsername() {
            loginPage.enterUsername(username);
            Assertions.assertFalse(loginPage.isUsernameFieldEmpty());
        }
        @Test
        @DisplayName("Test enterAllFields method enters both username and password")
        void testEnterAllFieldsEntersAllFields() {
            loginPage.enterAllFields(username, password);
            Assertions.assertFalse(loginPage.areAllFieldsEmpty());
        }
        @Test
        @DisplayName("Test login method works")
        void testLoginMethodWorks() {
            Assertions.assertNotNull(loginPage.login(username, password));
        }
        @Test
        @DisplayName("Test login button navigates to a new page")
        void testLoginButtonNavigatesToANewPage() {
            loginPage.login(username, password);
            Assertions.assertTrue(loginPage.isLoginSuccessful());
        }
    }

    @Nested
    @DisplayName("Test error message for incorrect login")
    class errorMsg {
        @Test
        @DisplayName("Test message doesn't show by default")
        void testMessageDoesnTShowByDefault() {
            Assertions.assertThrows(NoSuchElementException.class, () -> loginPage.getErrorMessage());
        }
        @Test
        @DisplayName("Test message shows up when no details are entered")
        void testMessageShowsUpWhenNoDetailsAreEntered() {
            loginPage.goToSchedulerPage();
            Assertions.assertNotNull(loginPage.getErrorMessage());
        }
        @Test
        @DisplayName("Test message shows up if only username field is filled")
        void testMessageShowsUpIfOnlyUsernameFieldIsFilled() {
            loginPage.enterUsername(username);
            loginPage.goToSchedulerPage();
            Assertions.assertNotNull(loginPage.getErrorMessage());
        }
        @Test
        @DisplayName("Test message shows up if only password field is filled")
        void testMessageShowsUpIfOnlyPasswordFieldIsFilled() {
            loginPage.enterPassword(password);
            loginPage.goToSchedulerPage();
            Assertions.assertNotNull(loginPage.getErrorMessage());
        }
        @Test
        @DisplayName("Test message shows up for invalid username")
        void testMessageShowsUpForInvalidUsername() {
            loginPage.login("invalid", password);
            Assertions.assertNotNull(loginPage.getErrorMessage());
        }
        @Test
        @DisplayName("Test message shows up for invalid password")
        void testMessageShowsUpForInvalidPassword() {
            loginPage.login(username, "invalid");
            Assertions.assertNotNull(loginPage.getErrorMessage());
        }
        @Test
        @DisplayName("Test message shows up for both invalid fields")
        void testMessageShowsUpForBothInvalidFields() {
            loginPage.login("invalid", "invalid");
            Assertions.assertNotNull(loginPage.getErrorMessage());
        }
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
