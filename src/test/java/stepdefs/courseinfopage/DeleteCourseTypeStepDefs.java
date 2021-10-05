package stepdefs.courseinfopage;

import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoAlertPresentException;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class DeleteCourseTypeStepDefs {
    private final CourseInfoPage courseInfoPage = new CourseInfoPage();

    @Given("there is a course type in the course types table")
    public void thereIsACourseTypeInTheCourseTypesTable() {
        if (courseInfoPage.getCourseTypesNames().isEmpty()) {
            System.out.println("No Course Types in List, please use default data");
            Assertions.fail();
        }
    }

    @When("I click the delete button for the course type on the course info page")
    public void iClickTheDeleteButtonForTheCourseTypeOnTheCourseInfoPage() {
        courseInfoPage.clickDeleteCourseTypeButton("Business");
    }


    @Then("The course type should no long be present in the course type table")
    public void theCourseTypeShouldNoLongBePresentInTheCourseTypeTable() {
        Assertions.assertTrue(courseInfoPage.isCourseTypeDeleted("Business"));
    }

    @Then("There should be a dialogue box confirming that you want to delete the course type and Nothing should be removed from the course type table")
    public void thereShouldBeADialogueBoxConfirmingThatYouWantToDeleteTheCourseTypeAndNothingShouldBeRemovedFromTheCourseTypeTable() {
        boolean hasDialogueBox = false;
        try {
            webDriver.switchTo().alert();
            hasDialogueBox = true;
        }
        catch (NoAlertPresentException ignored) {
        }
        Assertions.assertTrue(hasDialogueBox && !courseInfoPage.isDisciplineDeleted("Business"));
    }

    @Then("Nothing should be removed from the course type table")
    public void nothingShouldBeRemovedFromTheCourseTypeTable() {
        Assertions.assertFalse(courseInfoPage.isCourseTypeDeleted("Business"));
    }
}
