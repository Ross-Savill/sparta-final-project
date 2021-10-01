package com.spartaglobal.finalweek.tests.centresTests;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
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
    private CentresPage centresPage;
    private final String centreName = "Hoth";
    private final int centreNumOfRooms = 5;
    private final String centreUrl = "http://localhost:8080/centres";

    @BeforeEach
    void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();
        centresPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToCentresPage();
        editLocationPage = centresPage.clickEditCentreButton(centreName);
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
            @Test
            @DisplayName("Test delete button works")
            void testDeleteButtonWorks() {
                Assertions.assertEquals(centreUrl, editLocationPage.clickDeleteButton(xOffset, yOffset).getURL());
            }
            @Test
            @DisplayName("Test delete button hypertext works")
            void testDeleteButtonHypertextWorks() {
                Assertions.assertEquals(centreUrl, editLocationPage.clickDeleteButton().getURL());
            }

            @AfterEach
            void tearDown() {
                //TODO: ree-add removed centres
            }
        }
    }

    @Nested
    @DisplayName("Test processes")
    class processes {

        @Nested
        @DisplayName("Test update process")
        class updateProcess {

            String updatedName = "ChangedName";
            int updatedNumOfRooms = 10;

            @Test
            @DisplayName("Test update button goes to CentresPage on success")
            void testUpdateButtonGoesToCentresPageOnSuccess() {
                centresPage = editLocationPage.goToCentresPage();
                Assertions.assertEquals(centreUrl, centresPage.getURL());
            }
            @Test
            @DisplayName("Test updated LocationName is on centres page")
            void testUpdatedLocationNameIsOnCentresPage() {
                editLocationPage.enterLocationName("ChangedName");
                centresPage = editLocationPage.goToCentresPage();
                Assertions.assertTrue(editLocationPage.isUpdateSuccessful(updatedName, centreNumOfRooms));
            }
            @Test
            @DisplayName("Test updated rooms is on centres page")
            void testUpdatedRoomsIsOnCentresPage() {
                editLocationPage.enterNumOfRooms(10);
                centresPage = editLocationPage.goToCentresPage();
                Assertions.assertTrue(editLocationPage.isUpdateSuccessful(centreName, updatedNumOfRooms));
            }
            @Test
            @DisplayName("Test updated fields are on centres page")
            void testUpdatedFieldsAreOnCentresPage() {
                editLocationPage.enterNumOfRooms(10);
                editLocationPage.enterLocationName("ChangedName");
                centresPage = editLocationPage.goToCentresPage();
                Assertions.assertTrue(editLocationPage.isUpdateSuccessful(updatedName,updatedNumOfRooms));
            }

            @AfterEach
            void tearDown() {
                if(centresPage.getCentresByLocationName(updatedName).size() > 0) {
                    editLocationPage = centresPage.clickEditCentreButton(updatedName);
                } else {
                    editLocationPage = centresPage.clickEditCentreButton(centreName);
                }

                editLocationPage.enterLocationName("Hoth");
                editLocationPage.enterNumOfRooms(5);
                editLocationPage.goToCentresPage();
            }

        }
        @Nested
        @DisplayName("Test Delete Process")
        class deleteProcess {
            @Test
            @DisplayName("Test centre is removed on CentresPage if deleted on EditLocationPage")
            void testCentreIsRemovedOnCentresPageIfDeletedOnEditLocationPage() {
                centresPage = editLocationPage.clickDeleteButton();
                Assertions.assertTrue(editLocationPage.isDeleteSuccessful(centreName, centreNumOfRooms));
            }

            @AfterEach
            void tearDown() {
                //TODO: Add removed centres
            }
        }
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

}
