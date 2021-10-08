package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.pages.AccountPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class SchedulerStepDefs {
    private final SchedulerPage schedulerPage = new SchedulerPage();
    private final AccountPage accountPage = new AccountPage();

    @Then("I should see all the scheduled courses that are on the scheduler page")
    public void iShouldSeeAllTheScheduledCoursesThatAreOnTheSchedulerPage(){
        Assertions.assertEquals("http://localhost:8080/", schedulerPage.getURL());
    }

    @Then("I should NOT see all the scheduled courses that are on the scheduler page")
    public void iShouldNotSeeAllTheScheduledCoursesThatAreOnTheSchedulerPage(){
        Assertions.assertNotEquals("http://localhost:8080/", accountPage.getURL());
    }

    @Then("The schedule page should load with the visual representation with the correct data")
    public void theSchedulePageShouldLoadWithTheVisualRepresentationWithTheCorrectData(){
        Assertions.assertTrue(schedulerPage.isClickablefirstGetCourse() && schedulerPage.isFirstCourseDisplayed());
    }

    @After("@scheduler")
    public void tearDown(){
        webDriver.quit();
    }
}
