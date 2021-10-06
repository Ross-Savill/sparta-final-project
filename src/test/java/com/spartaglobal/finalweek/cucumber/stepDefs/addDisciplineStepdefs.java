package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.AddDisciplinePage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class addDisciplineStepdefs {
    private static final String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static final String password =PropertiesLoader.getProperties().getProperty("Password");
    
    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CourseInfoPage courseInfoPage;
    private AddDisciplinePage addDisciplinePage;

    @When("I am on the Add discipline page")
    public void iAmOnTheAddDisciplinePage() {
        TestBase.initialisation();

        loginPage = new LoginPage();
        schedulerPage = loginPage.login(userName,password);
        schedulerPage = new SchedulerPage();

        courseInfoPage = schedulerPage.goToCourseInfoPage();
        courseInfoPage = new CourseInfoPage();

        addDisciplinePage = courseInfoPage.clickAddDisciplineButton();
        addDisciplinePage = new AddDisciplinePage();
    }

    @And("Fill out the form with valid entries")
    public void fillOutTheFormWithValidEntries() {
        addDisciplinePage.enterDisciplineName("Ruby");
        addDisciplinePage.enterDuration(50);
    }

    @Then("I should be directed to the courseinfo page")
    public void iShouldBeDirectedToTheCourseinfoPage() {
        Assertions.assertTrue(addDisciplinePage.submitSuccessful());
    }

    @And("I should see the new discipline displayed")
    public void iShouldSeeTheNewDisciplineDisplayed() {
        Assertions.assertTrue(courseInfoPage.getDisciplineNames().contains("Ruby"));
    }

    @When("I do not fill out the form")
    public void iDoNotFillOutTheForm() {
        String emptyString =" ";
        addDisciplinePage.enterDisciplineName(emptyString);
    }

    @And("I click on the Submit button")
    public void iClickOnTheSubmitButton() {
        addDisciplinePage.submitSuccessful();
    }

    @Then("I should get a warning message")
    public void iShouldGetAWarningMessage() {
        String addDisciplinePageURL = PropertiesLoader.getProperties().getProperty("addDisciplinePageURL");
        Assertions.assertEquals(addDisciplinePageURL,addDisciplinePage.getURL());
    }

    @When("I fill in the Discipline name field")
    public void iFillInTheDisciplineNameField() {
        String validName ="JSON";
        addDisciplinePage.enterDisciplineName(validName);
    }

    @And("I try and submit the only Discipline Name")
    public void iTryAndSubmitTheOnlyDisciplineName() {
        addDisciplinePage.submitSuccessful();
    }

    @When("I fill in the duration field")
    public void iFillInTheDurationField() {
        int validInt = 50;
        addDisciplinePage.enterDuration(validInt);
    }

    @And("I try and submit duration")
    public void iTryAndSubmitDuration() {
        addDisciplinePage.submitSuccessful();
    }
}
