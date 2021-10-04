package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AddQualityGatePage extends NavTemplate implements URLable {

    @FindBy(id = "traineeId")
    WebElement traineeId;
    @FindBy(id = "qualityGateStatus")
    WebElement qualityGateStatus;
    @FindBy(id = "trainerId1")
    WebElement trainerOneId;
    @FindBy(id = "feedback1")
    WebElement trainerOneFeedback;
    @FindBy(id = "trainerId2")
    WebElement trainerTwoId;
    @FindBy(id = "feedback2")
    WebElement trainerTwoFeedback;
    @FindBy(id = "date")
    WebElement date;
    @FindBy(id = "btn-primary")
    WebElement submitButton;


    private Select qualityGateDropdown = new Select(qualityGateStatus);
    private Select trainer1 = new Select(trainerOneId);
    private Select trainer1feedback = new Select(trainerOneFeedback);
    private Select trainer2 = new Select(qualityGateStatus);
    private Select trainer2feedback = new Select(trainerTwoFeedback);
    private Select formDate = new Select(date);

    public AddQualityGatePage() {
        PageFactory.initElements(webDriver, this);
    }


    public void enterTraineeId(int Id) {
        traineeId.clear();
        traineeId.sendKeys(Integer.toString(Id));
    }

    public WebElement getTraineeIdElement() {
        return traineeId;
    }

    public int getTraineeId() {
        return Integer.parseInt(traineeId.getText());
    }

    public void setQualityGateStatus(String qualityGateStatusValue) {
        Select select = new Select(qualityGateStatus);
        select.selectByVisibleText(qualityGateStatusValue);
    }

    private void clickQualityGateDropDown() {
        qualityGateStatus.click();
    }

    public WebElement getQualityGateStatusElement() {
        return qualityGateStatus;
    }

    public String getQualityGateStatus() {
        return qualityGateStatus.getText();
    }

    public void setTrainerOneId(WebElement Id) {
        Select select = new Select(trainerOneId);
        select.selectByVisibleText(Id.getAttribute("name"));
    }

    public WebElement getTrainerOneId() {
        return trainerOneId;
    }

    public void enterTrainerOneFeedback(String traineeOneFeedback) {
        Select select = new Select(trainerOneId);
        select.selectByVisibleText(traineeOneFeedback);
    }

    public WebElement getTrainerOneFeedback() {
        return trainerOneFeedback;
    }

    public void setTrainerTwoId(WebElement Id) {
        Select select = new Select(trainerOneId);
        select.selectByVisibleText(Id.getAttribute("name"));

    }

    public void enterTrainerTwoFeedback(String traineeTwoFeedback) {
        Select select = new Select(trainerTwoId);
        select.selectByVisibleText(traineeTwoFeedback);
    }

    public WebElement getTrainerTwoFeedback() {
        return trainerTwoFeedback;
    }


    public WebElement getTrainerTwoId() {
        return trainerTwoId;
    }

    public void setDate(LocalDate date0) {

        WebElement setDate = date;
        setDate.sendKeys(Keys.chord("12/12/2040"));


    }

    public WebElement getDate() {
        return date;
    }

    public TraineesPage goToTraineesPage() {
        submitButton.click();

        return new TraineesPage();
    }

    public boolean isSubmitSuccessful() {


        qualityGateDropdown.getFirstSelectedOption().getText();
        trainer1.getFirstSelectedOption().getText();
        trainer1feedback.getFirstSelectedOption().getText();
        trainer2.getFirstSelectedOption().getText();
        trainer2feedback.getFirstSelectedOption().getText();
        formDate.getFirstSelectedOption().getText();

        TraineesPage traineesPage = new TraineesPage();
        System.out.println(traineesPage.getAllTraineesElements().get(0).getText());
        return false;

    }

    public boolean isTrainerOneFeedbackEmpty() {
        if (trainer1feedback.getFirstSelectedOption().getText().isBlank()) {
            return true;
        }
        return false;

    }

    public boolean isTrainerTwoFeedbackEmpty() {
        if (trainer2feedback.getFirstSelectedOption().getText().isBlank()) {
            return true;
        }
        return false;
    }

    private boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public boolean isDateValid() {
        return isValid(formDate.getFirstSelectedOption().getText());
    }

    public boolean isDateEmpty() {
        if (formDate.getFirstSelectedOption().getText().isBlank()) {

            return true;
        }
        return false;
    }

    public boolean areAllFieldsValid() {
        return isTrainerOneFeedbackEmpty()&&isTrainerTwoFeedbackEmpty()&&isDateValid()&&isDateEmpty();

    }

    public boolean areAllFieldsEmpty() {
        if (qualityGateDropdown.getFirstSelectedOption().getText().isBlank() &&
                trainer1.getFirstSelectedOption().getText().isBlank() &&
                trainer1feedback.getFirstSelectedOption().getText().isBlank() &&
                trainer2.getFirstSelectedOption().getText().isBlank() &&
                trainer2feedback.getFirstSelectedOption().getText().isBlank() &&
                formDate.getFirstSelectedOption().getText().isBlank()) {
            return true;
        }
        return false;
    }


    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
