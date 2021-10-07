package stepdefs;
import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.LoginPage;
import com.spartaglobal.finalweek.pages.SchedulerPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditDisciplinePage;
import com.spartaglobal.finalweek.util.PropertiesLoader;
import com.spartaglobal.finalweek.util.dbmanager.ResetData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class EditDisciplineStepdefs {

    private static final String userName = PropertiesLoader.getProperties().getProperty("Username");
    private static final String password = PropertiesLoader.getProperties().getProperty("Password");

    private LoginPage loginPage;
    private SchedulerPage schedulerPage;
    private CourseInfoPage courseInfoPage;
    private EditDisciplinePage editDisciplinePage;
    private static final String discipline = "Java";

    @Given("I am on the course info page")
    public void iAmOnTheCourseInfoPage() {
        TestBase.initialisation();
        loginPage = new LoginPage();
        schedulerPage = loginPage.login(userName,password);
        courseInfoPage = schedulerPage.goToCourseInfoPage();
    }

    @When("I click on the ‘Edit button  within the Discipline Table")
    public void iClickOnTheEditButtonWithinTheDisciplineTable() {
        editDisciplinePage = courseInfoPage.clickEditDisciplineButton(discipline);
    }

    @Then("I should be directed to the Edit Discipline form")
    public void iShouldBeDirectedToTheEditDisciplineForm() {
        Assertions.assertEquals("http://localhost:8080/editDiscipline/1", editDisciplinePage.getURL());
    }

}
