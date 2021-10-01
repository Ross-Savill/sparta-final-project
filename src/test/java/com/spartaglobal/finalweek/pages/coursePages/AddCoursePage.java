package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddCoursePage implements URLable {
    private @FindBy (id = "course_name")
    WebElement courseName;
    private @FindBy (className = "input-number")
    WebElement numberOfTrainers;
    private @FindBy (xpath = "//*[@id=\"add_course_form\"]/div[2]/span[2]/button")
    WebElement numberOfTrainersIncrement;
    private @FindBy (xpath = "//*[@id=\"add_course_form\"]/div[2]/span[1]/button")
    WebElement numberOfTrainersDecrement;
    private ArrayList<WebElement> trainerIDs = new ArrayList<>();
    private WebElement trainerId;
    private @FindBy (id = "inputButton")
    WebElement submitButton;

    private final int MAX_NUMBER_TRAINERS = 10;
    private final int MIN_NUMBER_TRAINERS = 1;

    public AddCoursePage() {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public WebElement getCourseNameElement(){
        return this.courseName;
    }

    public WebElement getNumberOfTrainersElement(){
        return this.numberOfTrainers;
    }

    public ArrayList<WebElement> getTrainerIDElements(){
        for(int i = 0; i < getNumberOfTrainers(); i++){
            String trainerIDString = "trainer_id"+i;
            trainerId = webDriver.findElement(By.id(trainerIDString));
            trainerIDs.add(trainerId);
        }
        return trainerIDs;
    }

    public WebElement getTrainerIDElement(int row){
        Select selector = new Select(getTrainerIDElements().get(row-1));
        return selector.getFirstSelectedOption();
    }

    public String getCourseName(){
        return getCourseNameElement().getAttribute("value");
    }

    public int getNumberOfTrainers(){
        return Integer.parseInt(getNumberOfTrainersElement().getAttribute("value"));
    }

    public String getTrainerID(int row){
        return getTrainerIDElement(row).getText();
    }

    public void enterCourseName(String courseName){
        getCourseNameElement().click();
        getCourseNameElement().sendKeys(courseName);
    }

    public void enterNumberOfTrainers(int numTrainers){
        numberOfTrainers.sendKeys(Keys.BACK_SPACE+Integer.toString(numTrainers));
    }

    public void incrementNumberOfTrainers(){
        numberOfTrainersIncrement.click();
    }

    public void decrementNumberOfTrainers(){
        numberOfTrainersDecrement.click();
    }

    public void selectTrainerID(int row, String trainerID){
        Select selector = new Select(getTrainerIDElements().get(row-1));
        selector.selectByVisibleText(trainerID);
    }

    public boolean isCourseNameEmpty(){
        return getCourseName().isEmpty();
    }

    public boolean isCourseNameBlank(){
        return getCourseName().isBlank();
    }

    public boolean isNumberOfTrainersValid(int numTrainers){
        return numTrainers>MAX_NUMBER_TRAINERS||numTrainers<MIN_NUMBER_TRAINERS?false:true;
    }

    public boolean isAlertDisplayed(){
        Alert alert = new WebDriverWait(webDriver, 1)
                .until(ExpectedConditions.alertIsPresent());
        return  alert.getText().equals("Sorry, the maximum value was reached")||
                alert.getText().equals("Sorry, the minimum value was reached");
    }

    //TODO(1): Grab required attribute value?, or other ways to grab message "Please fill in this field."
    /*public String getEmptyErrorMessage(){
        return getCourseNameElement().getAttribute("required");
    }*/

    public void clickSubmit(){
        submitButton.click();
    }
}
