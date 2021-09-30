package com.spartaglobal.finalweek.tests.centresTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.centresPages.EditLocationPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class EditLocationPageTests {

    private EditLocationPage editLocationPage;
    private final String centreName = "Hoth";
    private final String centreUrl = "http://localhost:8080/centres";

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();
        editLocationPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToCentresPage().clickEditCentreButton(centreName);
    }

    @Nested
    @DisplayName("Test getters")
    class getters {
        @Nested
        @DisplayName("Test getLocation")
        class getLocation {
            @Test
            @DisplayName("Test getLocation isn't empty or null by default")
            void testGetLocationIsnTEmptyByDefault() {
                Assertions.assertFalse(Matchers.emptyOrNullString().matches(editLocationPage.getLocationName()));
            }
        }
    }

    @Nested
    @DisplayName("Test setters")
    class setters {
        @Nested
        @DisplayName("Test enterLocationName")
        class enterLocationName {

            @ParameterizedTest
            @ValueSource(strings = {"Hoth", "Test"})
            @DisplayName("Test acceptable inputs are valid")
            void testAcceptableInputsAreValid(String locationName) {
                editLocationPage.enterLocationName(locationName);
            }

            @Test
            @DisplayName("Test null and empty input invalid")
            void testNullInputInvalid() {
                editLocationPage.enterLocationName(null);
                editLocationPage.enterLocationName("");
            }
        }
    }

    @Nested
    @DisplayName("Test Buttons")
    class buttons {
        private final int xOffset = 0;
        private final int yOffset = 10;

        @Nested
        @DisplayName("Test Update button")
        class updateButton {
            @Test
            @DisplayName("Test update button works")
            void testUpdateButtonWorks() {
                Assertions.assertEquals(centreUrl, editLocationPage.goToCentresPage(xOffset, yOffset).getURL());
            }
            @Test
            @DisplayName("Test update button hypertext works")
            void testUpdateButtonHypertextWorks() {
                Assertions.assertEquals(centreUrl, editLocationPage.goToCentresPage().getURL());
            }
        }
        @Nested
        @DisplayName("Test delete button")
        class deleteButton {

        }
    }

    @Nested
    @DisplayName("Test processes")
    class processes {

        @Nested
        @DisplayName("Test update process")
        class updateProcess {
            @Test
            @DisplayName("Test update button goes to CentresPage on success")
            void testUpdateButtonGoesToCentresPageOnSuccess() {
                editLocationPage.goToCentresPage();
                Assertions.assertEquals(centreUrl, webDriver.getCurrentUrl());
            }
            @Test
            @DisplayName("Test updated LocationName is on centres page")
            void testUpdatedLocationNameIsOnCentresPage() {
                editLocationPage.enterLocationName("ChangedName");
                editLocationPage.goToCentresPage();
                Assertions.assertTrue(editLocationPage.hasUpdatedFieldsTransferred());
            }
            @Test
            @DisplayName("Test updated rooms is on centres page")
            void testUpdatedRoomsIsOnCentresPage() {
                editLocationPage.enterNumOfRooms(10);
                editLocationPage.goToCentresPage();
                Assertions.assertTrue(editLocationPage.hasUpdatedFieldsTransferred());
            }
            @Test
            @DisplayName("Test updated fields are on centres page")
            void testUpdatedFieldsAreOnCentresPage() {
                editLocationPage.enterLocationName("ChangedName");
                editLocationPage.goToCentresPage();
                Assertions.assertTrue(editLocationPage.hasUpdatedFieldsTransferred());
            }
        }
        @Nested
        @DisplayName("Test Delete Process")
        class deleteProcess {

        }
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

}
