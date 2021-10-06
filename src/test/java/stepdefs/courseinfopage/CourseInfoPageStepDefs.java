package stepdefs.courseinfopage;

import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CourseInfoPageStepDefs {
    private CourseInfoPage courseInfoPage = new CourseInfoPage();
    private String courseTypeName;
    private List<String> courseTypeNamesList;
    private String disciplineName;
    private List<String> disciplineNamesList;
    @When("I want to find a specific course type")
    public void iWantToFindASpecificCourseType() {
        courseTypeName = "Business";
    }

    @And("I look at the course type table")
    public void iLookAtTheCourseTypeTable() {
        courseTypeNamesList = courseInfoPage.getCourseTypesNames();
    }

    @Then("I should see that course type in the table")
    public void iShouldSeeThatCourseTypeInTheTable() {
        Assertions.assertTrue(courseTypeNamesList.contains(courseTypeName));
    }

    @When("I want to find a specific discipline")
    public void iWantToFindASpecificDiscipline() {
        disciplineName = "Java";
    }

    @And("I look at the discipline table")
    public void iLookAtTheDisciplineTable() {
        disciplineNamesList = courseInfoPage.getDisciplineNames();
    }

    @Then("I should see that discipline in the table")
    public void iShouldSeeThatDisciplineInTheTable() {
        Assertions.assertTrue(disciplineNamesList.contains(disciplineName));
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
