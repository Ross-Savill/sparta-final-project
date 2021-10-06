package stepdefs.courseinfopage;

import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class DeleteDisciplineStepDefs {
    private final CourseInfoPage courseInfoPage = new CourseInfoPage();

    @Given("there is a discipline in the discipline table")
    public void thereIsADisciplineInTheDisciplineTable() {
        if (courseInfoPage.getDisciplineNames().isEmpty()) {
            System.out.println("No Disciplines in List, please use default data");
            Assertions.fail();
        }
    }

    @When("I click the delete button for the discipline on the course info page")
    public void iClickTheDeleteButtonForTheDisciplineOnTheCourseInfoPage() {
        courseInfoPage.clickDeleteDisciplineButton("Java");
    }

    @And("Nothing should be removed from the discipline table")
    public void nothingShouldBeRemovedFromTheDisciplineTable() {
        Assertions.assertFalse(courseInfoPage.isDisciplineDeleted("Java"));
    }

    @When("I click NO on the dialogue box")
    public void iClickNOOnTheDialogueBox() {
        webDriver.findElement(new By.ByLinkText("No")).click();
    }

    @When("I click YES on the dialogue box")
    public void iClickYESOnTheDialogueBox() {
        webDriver.findElement(new By.ByLinkText("Yes")).click();
    }

    @Then("The discipline should no long be present in the discipline table")
    public void theDisciplineShouldNoLongBePresentInTheDisciplineTable() {
        Assertions.assertTrue(courseInfoPage.isDisciplineDeleted("Java"));
    }

    @Then("There should be a dialogue box confirming that you want to delete the discipline and Nothing should be removed from the discipline table")
    public void thereShouldBeADialogueBoxConfirmingThatYouWantToDeleteTheDisciplineAndNothingShouldBeRemovedFromTheDisciplineTable() {
        boolean hasDialogueBox = false;
        try {
            webDriver.switchTo().alert();
            hasDialogueBox = true;
        }
        catch (NoAlertPresentException ignored) {
        }
        Assertions.assertTrue(hasDialogueBox && !courseInfoPage.isDisciplineDeleted("Java"));
    }
}
