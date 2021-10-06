package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
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
    @FindBy(id = "qualitygateStatus")
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
    @FindBy(className = "btn-primary")
    WebElement submitButton;


    private Select qualityGateDropdown = new Select(qualityGateStatus);
    private Select trainer1 = new Select(trainerOneId);
    private Select trainer2 = new Select(qualityGateStatus);

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

        return Integer.parseInt(traineeId.getAttribute("value"));
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
        return qualityGateStatus.getAttribute("value");
    }

    public void setTrainerOneId(WebElement Id) {
        Select select = new Select(trainerOneId);
        select.selectByVisibleText(Id.getAttribute("name"));
    }

    public WebElement getTrainerOneId() {
        return trainer1.getFirstSelectedOption();

    }

    public void enterTrainerOneFeedback(String traineeOneFeedbackString) {
        trainerOneFeedback.sendKeys(Keys.chord(traineeOneFeedbackString));
    }

    public WebElement getTrainerOneFeedback() {
        return trainerOneFeedback;
    }

    public void setTrainerTwoId(WebElement Id) {
        Select select = new Select(trainerOneId);
        select.selectByVisibleText(Id.getAttribute("name"));

    }

    public void enterTrainerTwoFeedback(String traineeTwoFeedbackString) {
        trainerTwoFeedback.sendKeys(Keys.chord(traineeTwoFeedbackString));
    }

    public WebElement getTrainerTwoFeedback() {
        return trainerTwoFeedback;
    }


    public WebElement getTrainerTwoId() {
        return trainer2.getFirstSelectedOption();
    }

    public void setDate(LocalDate inputDate) {
        int day = inputDate.getDayOfMonth();
        int month = inputDate.getMonthValue();
        int year = inputDate.getYear();
        String dayString = Integer.toString(day);
        String monthString = Integer.toString(month);
        if (day < 10) {
            dayString = String.format("%02d", day);
        }

        if (month < 10) {
            monthString = String.format("%02d", month);
        }

        date.sendKeys(dayString, monthString, Integer.toString(year));
    }

    public WebElement getDate() {
        return date;
    }

    public TraineesPage goToTraineesPage() {
        submitButton.click();

        return new TraineesPage();
    }

    public boolean isSubmitSuccessful() {

        getTrainerOneFeedback();
        getTrainerTwoFeedback();
        enterTrainerOneFeedback("feedback1");
        enterTrainerTwoFeedback("feedback2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        submitButton.click();
        TraineesPage traineesPage = new TraineesPage();

        WebElement scroll = webDriver.findElement(By.tagName("body"));
        scroll.sendKeys(Keys.ARROW_DOWN);
        scroll.sendKeys(Keys.ARROW_DOWN);
        scroll.sendKeys(Keys.ARROW_DOWN);
//        traineesPage.getq("1");
        webDriver.findElement(By.id(1 + "name")).click();

        if (traineesPage.getQualityGateHistoryDetails("1").get(0).contains(getTrainerOneFeedback().getText()) &&
                traineesPage.getQualityGateHistoryDetails("1").get(0).contains(getTrainerTwoFeedback().getText())) {
            return true;
        }
        return false;

    }

    public boolean isTrainerOneFeedbackEmpty() {
        if (trainerOneFeedback.getText().isBlank()) {
            return true;
        }
        return false;

    }

    public boolean isTrainerTwoFeedbackEmpty() {
        if (trainerTwoFeedback.getText().isBlank()) {
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
        return isValid(date.getText());
    }

    public boolean isDateEmpty() {
        if (date.getText().isBlank()) {
            return true;
        }
        return false;
    }

    public boolean areAllFieldsValid() {
        return isTrainerOneFeedbackEmpty() && isTrainerTwoFeedbackEmpty() && isDateValid() && isDateEmpty();

    }

    public boolean areAllFieldsEmpty() {
        if (qualityGateDropdown.getFirstSelectedOption().getText().isBlank() &&
                trainer1.getFirstSelectedOption().getText().isBlank() &&
                trainerOneFeedback.getText().isBlank() &&
                trainer2.getFirstSelectedOption().getText().isBlank() &&
                trainerTwoFeedback.getText().isBlank() &&
                date.getText().isBlank()) {
            return true;
        }
        return false;
    }


    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
