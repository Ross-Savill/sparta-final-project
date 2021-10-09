package com.spartaglobal.finalweek.tests.centres;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.centresPages.AddLocationPage;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddLocationPageTests {

    private CentresPage addCentresPage;
    private AddLocationPage addLocationPage;
    private String centresPageURL = PropertiesLoader.getProperties().getProperty("centresPageURL");

    @BeforeEach
    public void setup() {
        ResetData.resetData();
        TestBase.initialisation();
        LoginPage loginPage = new LoginPage();

        addCentresPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        ).goToCentresPage();
        addCentresPage.clickAddCentreButton();

        addLocationPage = new AddLocationPage();
    }

    @Nested
    @DisplayName("Testing getters and setters")
    class testingGettersAndSetters{


    @Test
    @DisplayName("Test typing a new location name and getting the value in the field")
    void testTypingNewLocationNameAndGettingValueInField() {
        String locationToAdd = "A new location";
        addLocationPage.enterLocationName(locationToAdd);
        Assertions.assertEquals(locationToAdd, addLocationPage.getLocationName());
    }

    @Test
    @DisplayName("Test entering a number of rooms and getting the value in the field")
    void testEnteringNumberOfRoomsAndGettingValueInField() {
        String numberOfRoomsToEnter = "6";
        addLocationPage.enterNumberOfRooms(numberOfRoomsToEnter);
        Assertions.assertEquals(numberOfRoomsToEnter, addLocationPage.getNumberOfRooms());
    }

}

    @Test
    @DisplayName("Test submit is successful")
    void testSubmitIsSuccessful(){
        Assertions.assertTrue(addLocationPage.isSubmitSuccessful("Do I get added?","10"));
    }

/*    @Nested
    @DisplayName("Test navigating to other pages")
    class navigateToOtherPages {*/
        @Test
        @DisplayName("Test navigating back to the centres page")
        void testNavigatingBackToCentresPage() {
            Assertions.assertEquals(centresPageURL, addLocationPage.goToCentresPage().getURL());
        }
   // }
    @Nested
    @DisplayName("Test fields are empty")
    class testFieldsAreEmpty {

       @Test
       @DisplayName("Test location name field is empty")
       void testLocationNameFieldIsEmpty(){
           Assertions.assertTrue(addLocationPage.isLocationNameEmpty());
       }

       @Test
       @DisplayName("Test rooms field is empty")
       void testRoomsFieldIsEmpty(){
           Assertions.assertTrue(addLocationPage.isNumberOfRoomsEmpty());
       }

       @Test
       @DisplayName("Test both fields are empty")
       void testBothFieldsAreEmpty(){
           Assertions.assertTrue(addLocationPage.areAllFieldsEmpty());
       }
   }

   @AfterEach
    void teardown(){webDriver.quit();}

}
