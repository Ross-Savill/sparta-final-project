package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CourseInfoPage extends NavTemplate implements URLable {

    @FindBy () WebElement courseTypeElements;
    @FindBy () WebElement disciplinesElements;
    @FindBy (id = "CourseTypePageLink") WebElement addCourseTypeButton;
    @FindBy (css = "#courseTypeTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement editCourseTypeButton;
    @FindBy (css = "#courseTypeTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement deleteCourseTypeButton;
    @FindBy (id = "disciplinePageLink") WebElement addDisciplineButton;
    @FindBy (css = "#disciplineTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement editDisciplineButton;
    @FindBy (css = "#disciplineTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement deleteDisciplineButton;


    public CourseInfoPage() {
        PageFactory.initElements(webDriver, this);
    }

//    public List<WebElement> getCourseTypeElements() {
//
//    }

//    public List<String> getCourseTypesNames() {
//
//    }

//    public WebElement getCourseTypeWebElement(String courseType) {
//
//    }

//    public int getCourseTypeCount() {
//
//    }

//    public List<WebElement> getDisciplinesElements() {
//
//    }

//    public List<String> getDisciplineNames() {
//
//    }

//    public int getDisciplineCount() {
//
//    }

//    public WebElement getDisciplineElement(int rowID) {
//
//    }

//    public String getDisciplineName(int rowID) {
//
//    }

//    public List<WebElement> getDisciplinesElementsWithDuration(int duration) {
//
//    }

//    public List<String> getDisciplinesNames(int duration) {
//
//    }

//    public List<WebElement> getDisciplinesElementsBetweenDurations(int lowestDuration, int highestDuration) {
//
//    }

//    public List<String> getDisciplineNamesBetweenDurations(int lowestDuration, int highestDuration) {
//
//    }

//    public AddDisciplinePage clickAddDisciplineButton() {
//
//    }

//    public AddCourseTypePage clickAddCourseTypeButton() {
//
//    }

//    public EditCourseTypePage clickEditCourseTypeButton(String courseTypeName) {
//
//    }

//    public EditDisciplinePage clickEditDisciplineButton(String disciplineName) {
//
//    }

//    public boolean clickDeleteCourseTypeButton (String courseTypeName) {
//
//    }

//    public boolean clickDeleteDisciplineButton(String disciplineName) {
//
//    }

//    public boolean areCourseTypesUnique() {
//
//    }

//    public boolean areDisciplinesUnique() {
//
//    }

//    public boolean isNameValidForCourseType(String courseTypeName) {
//
//    }

//    public boolean isDurationValidForDiscipline(int duration) {
//
//    }

//    public boolean isNameValidForDiscipline(String disciplineName) {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
