package stepdefs;

import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CourseStepDefs {

    CoursePage coursePage = new CoursePage();

    @After("@transfer")
    public void tearDown(){
        webDriver.quit();
    }

    @Then("Course information from the correct course in row one should be transferred to the edit course page")
    public void courseInformationFromTheCorrectCourseShouldBeTransferredToTheEditCoursePage() {
        Assertions.assertTrue(coursePage.areAllFieldsPassedOntoEditCoursePage());
    }
}
