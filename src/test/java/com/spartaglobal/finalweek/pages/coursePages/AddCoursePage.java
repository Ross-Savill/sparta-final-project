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
    private ArrayList<WebElement> trainerStartWeeks = new ArrayList<>();
    private WebElement trainerStartWeek;
    private ArrayList<WebElement> trainerEndWeeks = new ArrayList<>();
    private WebElement trainerEndWeek;
    private @FindBy (id = "inputButton")
    WebElement submitButton;

    private final int MAX_NUMBER_TRAINERS = 10;
    private final int MIN_NUMBER_TRAINERS = 1;
    private final int MAX_TRAINER_START_END_WEEK = 52;
    private final int MIN_TRAINER_START_END_WEEK = 1;

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
        for(int i = 0; i < Integer.parseInt(getNumberOfTrainers()); i++){
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

    public ArrayList<WebElement> getTrainerStartWeekElements(){
        for(int i = 0; i < Integer.parseInt(getNumberOfTrainers()); i++){
            String trainerStartWeekString = "trainer_start_week"+i;
            trainerStartWeek = webDriver.findElement(By.id(trainerStartWeekString));
            trainerStartWeeks.add(trainerStartWeek);
        }
        return trainerStartWeeks;
    }

    public WebElement getTrainerStartWeekElement(int row){
        return getTrainerStartWeekElements().get(row-1);
    }

    public ArrayList<WebElement> getTrainerEndWeekElements(){
        for(int i = 0; i < Integer.parseInt(getNumberOfTrainers()); i++){
            String trainerEndWeekString = "trainer_end_week"+i;
            trainerEndWeek = webDriver.findElement(By.id(trainerEndWeekString));
            trainerEndWeeks.add(trainerEndWeek);
        }
        return trainerEndWeeks;
    }

    public WebElement getTrainerEndWeekElement(int row){
        return getTrainerEndWeekElements().get(row-1);
    }

    public String getCourseName(){
        return getCourseNameElement().getAttribute("value");
    }

    public String getNumberOfTrainers(){
        return getNumberOfTrainersElement().getAttribute("value");
    }

    public String getTrainerID(int row){
        return getTrainerIDElement(row).getText();
    }

    public String getTrainerStartWeek(int row){
        return getTrainerStartWeekElement(row).getAttribute("value");
    }

    public String getTrainerEndWeek(int row){
        return getTrainerEndWeekElement(row).getAttribute("value");
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

    public void enterTrainerStartWeek(int row ,int startWeek){
        getTrainerStartWeekElement(row).clear();
        getTrainerStartWeekElement(row).sendKeys(Integer.toString(startWeek));
    }

    public void enterTrainerEndWeek(int row ,int endWeek){
        getTrainerEndWeekElement(row).clear();
        getTrainerEndWeekElement(row).sendKeys(Integer.toString(endWeek));
    }

    public boolean isCourseNameEmpty(){
        return getCourseName().isEmpty();
    }

    public boolean isCourseNameBlank(){
        return getCourseName().isBlank();
    }

    public boolean isTrainerStartWeekEmpty(int row){
        return getTrainerStartWeek(row).isEmpty();
    }

    public boolean isTrainerEndWeekEmpty(int row){
        return getTrainerEndWeek(row).isEmpty();
    }

    public boolean isNumberOfTrainersValid(){
        return Integer.parseInt(getNumberOfTrainers())>MAX_NUMBER_TRAINERS||
                Integer.parseInt(getNumberOfTrainers())<MIN_NUMBER_TRAINERS?false:true;
    }

    public boolean isTrainerStartWeekValid(int row){
        return Integer.parseInt(getTrainerStartWeek(row))>MAX_TRAINER_START_END_WEEK||
                Integer.parseInt(getTrainerStartWeek(row))<MIN_TRAINER_START_END_WEEK?false:true;
    }

    public boolean isTrainerEndWeekValid(int row){
        return Integer.parseInt(getTrainerEndWeek(row))>MAX_TRAINER_START_END_WEEK||
                Integer.parseInt(getTrainerEndWeek(row))<MIN_TRAINER_START_END_WEEK?false:true;
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
