package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class ModifyCoursePage extends NavTemplate implements URLable {
    protected @FindBy(id = "course_name")
    WebElement courseName;
    protected @FindBy (className = "input-number")
    WebElement numberOfTrainers;
    protected final ArrayList<WebElement> trainerIDs = new ArrayList<>();
    protected final ArrayList<WebElement> trainerStartWeeks = new ArrayList<>();
    protected final ArrayList<WebElement> trainerEndWeeks = new ArrayList<>();
    protected @FindBy (id = "discipline_id")
    WebElement discipline;
    protected @FindBy (id = "type_id")
    WebElement courseType;
    protected @FindBy (id = "location_id")
    WebElement location;
    protected @FindBy(id = "start_date")
    WebElement startDate;

    protected final int MAX_TRAINER_START_END_WEEK = 52;
    protected final int MIN_TRAINER_START_END_WEEK = 1;

    public ModifyCoursePage(){
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
            WebElement trainerId = webDriver.findElement(By.id(trainerIDString));
            trainerIDs.add(trainerId);
        }
        return trainerIDs;
    }

    public WebElement getTrainerIDElement(int row){
        return getTrainerIDElements().get(row-1);
    }

    public ArrayList<WebElement> getTrainerStartWeekElements(){
        for(int i = 0; i < Integer.parseInt(getNumberOfTrainers()); i++){
            String trainerStartWeekString = "trainer_start_week"+i;
            WebElement trainerStartWeek = webDriver.findElement(By.id(trainerStartWeekString));
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
            WebElement trainerEndWeek = webDriver.findElement(By.id(trainerEndWeekString));
            trainerEndWeeks.add(trainerEndWeek);
        }
        return trainerEndWeeks;
    }

    public WebElement getTrainerEndWeekElement(int row){
        return getTrainerEndWeekElements().get(row-1);
    }

    public WebElement getDisciplineElement(){
        return this.discipline;
    }

    public WebElement getCourseTypeElement(){
        return this.courseType;
    }

    public WebElement getLocationElement(){
        return this.location;
    }

    public WebElement getStartDateElement(){
        return this.startDate;
    }

    public String getCourseName(){
        return getCourseNameElement().getAttribute("value");
    }

    public String getNumberOfTrainers(){
        return getNumberOfTrainersElement().getAttribute("value");
    }

    public String getTrainerID(int row){
        Select selector = new Select(getTrainerIDElement(row));
        return selector.getFirstSelectedOption().getText();
    }

    public String[] getAllTrainerIDStrings(){
        return getTrainerIDElement(1)
            .getText()
            .replaceAll("  ", "")
            .replaceAll("\n", ",")
            .split(",");
    }

    public String getTrainerStartWeek(int row){
        return getTrainerStartWeekElement(row).getAttribute("value");
    }

    public String getTrainerEndWeek(int row){
        return getTrainerEndWeekElement(row).getAttribute("value");
    }

    public String getDiscipline(){
        Select selector = new Select(getDisciplineElement());
        return selector.getFirstSelectedOption().getText();
    }

    public String[] getAllDisciplines(){
        return getDisciplineElement()
            .getText()
            .replaceAll("  ", "")
            .replaceAll("\n", ",")
            .split(",");
    }

    public String getCourseType(){
        Select selector = new Select(getCourseTypeElement());
        return selector.getFirstSelectedOption().getText();
    }

    public String[] getAllCourseTypes(){
        return getCourseTypeElement()
            .getText()
            .replaceAll("  ", "")
            .replaceAll("\n", ",")
            .split(",");
    }

    public String getLocation(){
        Select selector = new Select(getLocationElement());
        return selector.getFirstSelectedOption().getText();
    }

    public String[] getAllLocations(){
        return getLocationElement()
            .getText()
            .replaceAll("  ", "")
            .replaceAll("\n", ",")
            .split(",");
    }

    public String getStartDate(){
        return getStartDateElement().getAttribute("value");
    }

    public String getMaxOrMinValueReachedAlertMessage(){
        Alert alert = new WebDriverWait(webDriver, 1)
                .until(ExpectedConditions.alertIsPresent());
        return  alert.getText();
    }

    public void enterCourseName(String courseName){
        getCourseNameElement().click();
        getCourseNameElement().sendKeys(courseName);
    }

    public void enterNumberOfTrainers(int numTrainers){
        numberOfTrainers.sendKeys(Keys.BACK_SPACE+Integer.toString(numTrainers));
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

    public void enterStartDate(LocalDate date) {
        int day =  date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        String dayString = Integer.toString(day);
        String monthString = Integer.toString(month);
        if(day < 10){
            dayString = String.format("%02d", day);
        }

        if(month < 10){
            monthString = String.format("%02d", month);
        }

        startDate.sendKeys(dayString, monthString, Integer.toString(year));
    }

    public void selectDiscipline(String discipline){
        Select selector = new Select(getDisciplineElement());
        selector.selectByVisibleText(discipline);
    }

    public void selectCourseType(String courseType){
        Select selector = new Select(getCourseTypeElement());
        selector.selectByVisibleText(courseType);
    }

    public void selectLocation(String location){
        Select selector = new Select(getLocationElement());
        selector.selectByVisibleText(location);
    }

    public void enterAllFields(CoursePageObject coursePageObject){
        enterCourseName(coursePageObject.getCourseName());
        enterNumberOfTrainers(coursePageObject.getNumberOfTrainers());
        selectTrainerID(coursePageObject.getRow(), coursePageObject.getTrainerID());
        enterTrainerStartWeek(coursePageObject.getRow(), coursePageObject.getTrainerStartWeek());
        enterTrainerEndWeek(coursePageObject.getRow(), coursePageObject.getTrainerEndWeek());
        selectDiscipline(coursePageObject.getDiscipline());
        selectCourseType(coursePageObject.getTypeOfCourse());
        selectLocation(coursePageObject.getLocation());
        enterStartDate(coursePageObject.getStartDate());
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

    public boolean isStartDateEmpty(){
        return getStartDate().isEmpty();
    }

    public boolean isNumberOfTrainersValid(){
        int MAX_NUMBER_TRAINERS = 10;
        int MIN_NUMBER_TRAINERS = 1;
        return Integer.parseInt(getNumberOfTrainers()) <= MAX_NUMBER_TRAINERS &&
                Integer.parseInt(getNumberOfTrainers()) >= MIN_NUMBER_TRAINERS;
    }

    public boolean isTrainerStartWeekValid(int row){
        return Integer.parseInt(getTrainerStartWeek(row)) <= MAX_TRAINER_START_END_WEEK &&
                Integer.parseInt(getTrainerStartWeek(row)) >= MIN_TRAINER_START_END_WEEK;
    }

    public boolean isTrainerEndWeekValid(int row){
        return Integer.parseInt(getTrainerEndWeek(row)) <= MAX_TRAINER_START_END_WEEK &&
                Integer.parseInt(getTrainerEndWeek(row)) >= MIN_TRAINER_START_END_WEEK;
    }

    public boolean isMaxOrMinValueReachedAlertDisplayed(){
        Alert alert = new WebDriverWait(webDriver, 1)
                .until(ExpectedConditions.alertIsPresent());
        return  alert.getText().equals("Sorry, the maximum value was reached")||
                alert.getText().equals("Sorry, the minimum value was reached");
    }

    //TODO(1): Grab required attribute value?, or other ways to grab message "Please fill in this field."
    /*public String getEmptyErrorMessage(){
        return getCourseNameElement().getAttribute("required");
    }*/
}
