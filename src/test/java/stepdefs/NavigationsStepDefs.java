package stepdefs;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.AccountPage;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.centresPages.AddLocationPage;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import com.spartaglobal.finalweek.pages.centresPages.EditLocationPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NavigationsStepDefs {

    NavTemplate page;
    LoginPage loginPage;
    SchedulerPage schedulerPage;
    CentresPage centresPage;
    TraineesPage traineesPage;
    TrainersPage trainersPage;
    CoursePage coursePage;
    CourseInfoPage courseInfoPage;
    AccountPage accountPage;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        TestBase.initialisation();
        loginPage = new LoginPage();
        schedulerPage = loginPage.login(
                PropertiesLoader.getProperties().getProperty("Username"),
                PropertiesLoader.getProperties().getProperty("Password")
        );
    }

    @Given("I go to the locations page")
    public void iClickOnTheLocationsPage() {
        centresPage = page.goToCentresPage();
    }

    @Given("I go to the scheduler page")
    public void goToSchedulerPage() {
        schedulerPage = page.goToSchedulerPage();
    }

    @Given("I go to the trainees page")
    public void goToTraineesPage() {
        traineesPage = page.goToTraineesPage();
    }

    @Given("I go to the trainers page")
    public void goToTrainersPage() {
        trainersPage = page.goToTrainersPage();
    }

    @Given("I go to the course page")
    public void goToCoursePage() {
        coursePage = page.goToCoursesPage();
    }

    @Given("I go to the course info page")
    public void goToCourseInfoPage() {
        courseInfoPage = page.goToCourseInfoPage();
    }

    @Given("I go to the account page")
    public void goToAccountPage() {
        accountPage = page.goToAccountPage();
    }

    @Given("I log out")
    public void logOut() {
        loginPage = page.logOutOfSite();
    }
}
