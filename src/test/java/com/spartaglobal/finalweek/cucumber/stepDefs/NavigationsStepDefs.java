package com.spartaglobal.finalweek.cucumber.stepDefs;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import io.cucumber.java.en.Given;

public class NavigationsStepDefs {

    NavTemplate page = new NavTemplate();
    LoginPage loginPage;

    @Given("I am working with dummy data")
    public void resetData() {
        ResetData.resetData();
    }

    @Given("I am starting the process")
    public void startProcess() {
        TestBase.initialisation();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        loginPage = new LoginPage();
        page = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        );
    }

    @Given("I go to the locations page")
    public void iClickOnTheLocationsPage() {
        page = page.goToCentresPage();
    }

    @Given("I go to the scheduler page")
    public void goToSchedulerPage() {
        page = page.goToSchedulerPage();
    }

    @Given("I go to the trainees page")
    public void goToTraineesPage() {
        page = page.goToTraineesPage();
    }

    @Given("I go to the trainers page")
    public void goToTrainersPage() {
        page = page.goToTrainersPage();
    }

    @Given("I go to the course page")
    public void goToCoursePage() {
        page = page.goToCoursesPage();
    }

    @Given("I go to the course info page")
    public void goToCourseInfoPage() {
        page = page.goToCourseInfoPage();
    }

    @Given("I go to the account page")
    public void goToAccountPage() {
        page = page.goToAccountPage();
    }

    @Given("I log out")
    public void logOut() {
        page = page.logOutOfSite();
    }
}
