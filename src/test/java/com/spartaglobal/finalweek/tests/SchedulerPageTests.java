package com.spartaglobal.finalweek.tests;
import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;


public class SchedulerPageTests {
    LoginPage loginPage;
    SchedulerPage schedulerPage;



    @BeforeEach
    public void setup() {
        TestBase.initialisation();

        loginPage = new LoginPage();

        schedulerPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        );
        PageFactory.initElements(webDriver, schedulerPage);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @DisplayName("Test first Course Name is displayed")
    @Test
    public void getCourseElement()  {
        Assertions.assertTrue(schedulerPage.getCourse());
    }

    @DisplayName(" Test first course Trainer  is displayed ")
    @Test
    public void testFirstCourseTrainerNamegetText() {
        Assertions.assertEquals(schedulerPage.getTrainer(), "JarJar Binks");
    }

        @DisplayName("Test able to get Couse text ")
    @Test
    public void testAbleToGetCourseText()  {
        Assertions.assertTrue(schedulerPage.getCourse());
    }

    @DisplayName("Test able to get Course Location text ")
    @Test
    public void testAbleToGetCourseLocationText()  {
        Assertions.assertEquals(schedulerPage.getCourseLocation(),"Coruscant");
    }

    @DisplayName("Test First Course is Clickable ")
    @Test
    public void testFirstCourseisClickable() {

        Assertions.assertTrue(schedulerPage.isClickablefirstGetCourse());
    }
    @DisplayName(" Test first course  with all fields is displayed or not")
    @Test
    public void testFirstCourseWithAllFieldsIsDisplayed() {
        Assertions.assertTrue(schedulerPage.isFirstCourseDisplayed());
    }



    @DisplayName("Test able to get Dicipline text ")
    @Test
    public void testAbleToGetDicipline()  {
        Assertions.assertEquals("Discipline DevOps",schedulerPage.getDicipline());
    }

    @DisplayName("Test able to get Course Type text")
    @Test
    public void testAbleTogetCourseTypeText() {
        Assertions.assertEquals(schedulerPage.getCourseType(),"Course Type Business");
    }

    @DisplayName("Test able to get StartOfCourse text")
    @Test
    public void testAbleTogetStartOfCourseText() {
        Assertions.assertEquals(schedulerPage.getStartOfCourse(),"Start of Course 26-04-21");
    }
    @DisplayName("Test able to get Duration text ")
    @Test
    public void testAbleTogetDurationText() {

        Assertions.assertEquals(schedulerPage.getDuration(),"Duration 12");
    }



    @DisplayName("Test able to get EndOfCouse text ")
    @Test
    public void testAbleTogetEndOfCouseText() {
        Assertions.assertEquals(schedulerPage.getEndOfCouse(),"End of Course 16-07-21");
    }

    @DisplayName("Test able to get Bond text ")
    @Test
    public void testAbleTogetBondText() {

        Assertions.assertEquals(schedulerPage.getBond(),"Bond 16-10-21");
    }

    @DisplayName("Test able to get Trainees In Course text ")
    @Test
    public void testAbleTogetTraineesInCourseText() {
        Assertions.assertEquals(schedulerPage.getTraineesInCourse(),"Trainees in Course 11");
    }




    @Test
    @DisplayName("Test able to get Courses ")
    void testAbleToGetCourses() throws InterruptedException {
       Assertions.assertTrue(  schedulerPage.isTrainingCourseTrainerCourseLocationContains("Engineering 51","Mike Wazowski","Naboo"));
    }
}