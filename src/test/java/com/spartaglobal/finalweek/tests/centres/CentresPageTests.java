package com.spartaglobal.finalweek.tests.centres;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.centresPages.AddLocationPage;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import com.spartaglobal.finalweek.pages.centresPages.EditLocationPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.spartaglobal.finalweek.base.TestBase.Properties;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CentresPageTests {

    private CentresPage centresPage;
    private final int buttonXOffset = 0;
    private final int buttonYOffset = 10;

    @BeforeEach
    public void setup() {
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();

        centresPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToCentresPage();
    }

    @Test
    @DisplayName("Test currently on centres page")
    void testCurrentlyOnCentresPage() {
        Assertions.assertTrue(centresPage.getURL().contains("centres"));
    }

    @Nested
    @DisplayName("Test getters")
    class getters {
        @Test
        @DisplayName("test All centres returns something")
        void testAllCentresCanBeGotten() {
            List<WebElement> centres = centresPage.getAllCentres();
            Assertions.assertNotNull(centres);
        }
        @Test
        @DisplayName("Test all centres returns a populated list")
        void testAllCentresReturnsAPopulatedList() {
            List<WebElement> centres = centresPage.getAllCentres();
            Assertions.assertFalse(centres.size() < 1);
        }
        @Test
        @DisplayName("Test get all location names returns something")
        void testAbleToGetAllLocationNames() {
            List<WebElement> names = centresPage.getAllLocationNames();
            Assertions.assertNotNull(names);
        }
        @Test
        @DisplayName("Test get all location names returns a populated list")
        void testGetAllLocationNamesReturnsAPopulatedList() {
            List<WebElement> names = centresPage.getAllLocationNames();
            //System.out.println(names);
            Assertions.assertFalse(names.size() < 1);
        }
        @ParameterizedTest
        @ValueSource(strings = {"Hoth", "Naboo"})
        @DisplayName("Test can get centres by location name")
        void testCanGetCentresByLocationName(String name) {
            Assertions.assertEquals(1, centresPage.getCentresByLocationName(name).size());
        }
        @ParameterizedTest
        @ValueSource(strings = {"Funkytown", "RockCity"})
        @DisplayName("Test getCentresByLocationName doesn't find invalid centres")
        void testInvalidCentresNotFound(String name) {
            Assertions.assertEquals(0, centresPage.getCentresByLocationName(name).size());
        }
        @ParameterizedTest
        @ValueSource(ints = {4, 5, 7})
        @DisplayName("Test can get locations with specific room numbers")
        void testCanGetLocationsWithSpecificRoomNumbers(int numberOfRooms) {
            Assertions.assertTrue(centresPage.getCentresByNumberOfRooms(numberOfRooms).size() > 0);
        }
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("Test getting locations by number of rooms that doesn't exist returns nothing")
        void testGettingLocationsByNumberOfRoomsThatDoesnTExistReturnsNothing(int numberOfRooms) {
            Assertions.assertEquals(0, centresPage.getCentresByNumberOfRooms(numberOfRooms).size());
        }
        @ParameterizedTest
        @CsvSource({"3,5", "5,9", "1,15"})
        @DisplayName("Test getting locations with range of room numbers returns something")
        void testGettingLocationsWithRangeOfRoomNumbers(int lowerBound, int higherBound) {
            Assertions.assertTrue(centresPage.getCentresByNumberOfRooms(lowerBound, higherBound).size() > 0);
        }
        @ParameterizedTest
        @CsvSource({"20,21","15,15","15,90"})
        @DisplayName("Test getting locations within range of room numbers that don't exist returns nothing")
        void testGettingLocationsWithinRangeOfRoomNumbersThatDonTExistReturnsNothing(int lowerBound, int higherBound) {
            Assertions.assertEquals(0, centresPage.getCentresByNumberOfRooms(lowerBound, higherBound).size());
        }
        @ParameterizedTest
        @CsvSource({"15,5"})
        @DisplayName("Test getCentresByNumberOfRooms works when higher bound is lower than lower bound")
        void testGetCentresByNumberOfRoomsWorksWhenHigherBoundIsLowerThanLowerBound(int lowerBound, int higherBound) {
            Assertions.assertTrue(centresPage.getCentresByNumberOfRooms(lowerBound, higherBound).size() > 0);
        }
        @ParameterizedTest
        @CsvSource({"-2,-35"})
        @DisplayName("Test getCentresByNumberOfRooms retruns ")
        void testGetCentresByNumberOfRoomsRetruns(int lowerBound, int higherBound) {
            Assertions.assertEquals(0, centresPage.getCentresByNumberOfRooms(lowerBound, higherBound).size());
        }
        @ParameterizedTest
        @ValueSource(strings = "Hoth, Naboo")
        @DisplayName("Test getNumberOfRooms returns number of rooms")
        void testGetNumberOfRoomsReturnsNumberOfRooms(String locationName) {
            Assertions.assertTrue(centresPage.getNumberOfRooms(locationName) >= 0);
        }
        @ParameterizedTest
        @ValueSource(strings = "Hoth, Naboo")
        @DisplayName("Test getNumberOfRooms returns 0 if room doesn't exist")
        void testGetNumberOfRoomsReturns0IfRoomDoesnTExist(String locationName) {
            Assertions.assertEquals(0, centresPage.getNumberOfRooms(locationName));
        }
        @Test
        @DisplayName("Test getNumberOfRooms returns an int value")
        void testGetNumberOfRoomsReturnsAnIntValue() {
            Assertions.assertTrue(centresPage.getNumberOfRooms("Hoth") > 0);
        }
        @Disabled
        @Test
        @DisplayName("Test getNumberOfRooms returns the number of rooms for the first centre found if there are duplicates")
        void testGetNumberOfRoomsReturnsTheNumberOfRoomsForTheFirstCentreFoundIfThereAreDuplicates() {
            //Assumptions.assumeFalse(centresPage.areAllCentresUnique());

        }
    }

    @Nested
    @DisplayName("Test buttons on page")
    class buttons {
        @Test
        @DisplayName("Test Add location button navigates to the AddLocationButtonPage")
        void testAddLocationButtonNavigatesToTheAddLocationButtonPage() {
            AddLocationPage addLocationPage = centresPage.clickAddCentreButton(buttonXOffset, buttonYOffset);
            Assertions.assertEquals("http://localhost:8080/addLocation", addLocationPage.getURL());
        }
        @Test
        @DisplayName("Test Add location link text navigates to the AddLocationButtonPage")
        void testAddLocationLinkTextNavigatesToTheAddLocationButtonPage() {
            AddLocationPage addLocationPage = centresPage.clickAddCentreButton();
            Assertions.assertEquals("http://localhost:8080/addLocation", addLocationPage.getURL());
        }
        @Test
        @DisplayName("Test edit button takes you to the edit location page")
        void testEditButtonTakesYouToTheEditLocationPage() {
            EditLocationPage editLocationPage = centresPage.clickEditCentreButton(buttonXOffset, buttonYOffset,"Hoth");
            Assertions.assertTrue(editLocationPage.getURL().contains("http://localhost:8080/editLocation/"));
        }
        @Test
        @DisplayName("Test edit location button takes you to the right edit location page")
        void testEditLocationButtonTakesYouToTheRightEditLocationPage() {
            List<WebElement> centres = centresPage.getCentresByLocationName("Hoth");
            WebElement hoth = centres.get(0);
            String expectedID = hoth.getAttribute("id");
            expectedID = expectedID.replaceAll("[\\D]", "");

            EditLocationPage editLocationPage = centresPage.clickEditCentreButton(buttonXOffset, buttonYOffset,"Hoth");

            Assertions.assertEquals("http://localhost:8080/editLocation/"+expectedID,
                   editLocationPage.getURL());
        }
        @Test
        @DisplayName("Test edit button hypertext takes you to the edit location page")
        void testEditButtonHypertextTakesYouToTheEditLocationPage() {
            EditLocationPage editLocationPage = centresPage.clickEditCentreButton("Hoth");
            Assertions.assertTrue(editLocationPage.getURL().contains("http://localhost:8080/editLocation/"));
        }
        @Test
        @DisplayName("Test edit location button hypertext takes you to the right edit location page")
        void testEditLocationButtonHypertextTakesYouToTheRightEditLocationPage() {
            //TODO: add method in framework to compact this
            List<WebElement> centres = centresPage.getCentresByLocationName("Hoth");
            WebElement hoth = centres.get(0);
            String centreTableId = hoth.getAttribute("id");
            centreTableId = centreTableId.replaceAll("[\\D]", "");
            int pageId = Integer.parseInt(centreTableId) + 1;

            EditLocationPage editLocationPage = centresPage.clickEditCentreButton("Hoth");

            Assertions.assertEquals("http://localhost:8080/editLocation/"+ pageId,
                    editLocationPage.getURL());
        }
    }

    //TODO: shout at developers
    @Nested
    @DisplayName("Deleting centres")
    class delete {
        private final String centreName = "Hoth";

        @Test
        @DisplayName("Test confirmation box appears on delete")
        void testConfirmationBoxAppears() {
            Assertions.assertTrue(centresPage.doesConfirmationBoxAppearOnDelete(centreName));
        }

        @Test
        @DisplayName("Test delete centre deletes something")
        void testDeleteCentreDeletesSomething() {
            //TODO: add something to delete
            Assertions.assertTrue(centresPage.isCentreDeleted(centreName));
        }
        @Test
        @DisplayName("Test delete centre hypertext deletes something")
        void testDeleteCentreHypertextDeletesSomething() {
            //TODO: add something to delete
            Assertions.assertTrue(centresPage.isCentreDeleted(centreName));
        }

        @Test
        @DisplayName("Test delete only happens when I click accept on the pop up")
        void testDeleteOnlyHappensWhenIClickAcceptOnThePopUp() {
            int numberOfCentresBefore = centresPage.getAllCentres().size();
            centresPage.clickDeleteCentreButton(centreName);

            int numberOfCentresAfter = centresPage.getAllCentres().size();
            Assertions.assertTrue(numberOfCentresAfter < numberOfCentresBefore);
        }
        @Test
        @DisplayName("Test delete does not happen if I dismiss the popup")
        void testDeleteDoesNotHappenIfIDismissThePopup() {
            //TODO: add helper method to compact

            CentresPage mockCentres = Mockito.mock(CentresPage.class);
            Mockito.when(mockCentres.cancelDelete()).thenReturn(true);

            int numberOfCentresBefore = centresPage.getAllCentres().size();
            centresPage.clickDeleteCentreButton(centreName);
            centresPage.cancelDelete();
            int numberOfCentresAfter = centresPage.getAllCentres().size();
            Assertions.assertEquals(numberOfCentresAfter, numberOfCentresBefore);
        }
    }

    @Test
    @DisplayName("Test editLocation transwers all information over")
    void testEditLocationTranswersAllInformationOver() {
        Assertions.assertTrue(centresPage.areAllFieldsPassedOnToEditCentrePage("Hoth"));
    }

    public boolean areAllCentresUnique() {



    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
