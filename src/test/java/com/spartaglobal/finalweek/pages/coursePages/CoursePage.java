package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CoursePage implements URLable {

    @FindBy(id = "courseList")
    WebElement courseList;

    private List<WebElement> allCourses;
    private List<WebElement> allCourseNames;
    private List<WebElement> findCourseName;
    private List<WebElement> allDisciplines;
    private List<WebElement> allCourseTypes;
    private List<WebElement> allLocations;
    private List<WebElement> allStartDates;
    private List<WebElement> allTrainers;

    public CoursePage() {

        PageFactory.initElements(webDriver, this);

        allCourses = courseList.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        allCourseNames = new ArrayList<>();
        allCourseNames = this.getAllCoursesNames();

    }

    @FindBy(className = "btn-primary")
    WebElement addCourseButton;
    @FindBy(id = "CoursePageLink")
    WebElement addCourseHyperlink;

    WebElement editCourseButton;
    WebElement editCourseHyperlink;

    WebElement deleteCourseButton;
    WebElement deleteCourseHyperlink;

    public List<WebElement> getAllCourses(){
        return this.allCourses;
    }

    public List<WebElement> getAllCoursesNames(){
        for(WebElement courseName: allCourses){
            allCourseNames.add(
                    courseName.findElement(By.id(Integer.toString(allCourses.indexOf(courseName))+"course"))
            );
        }
        if(allCourseNames.size() > allCourses.size()){
            List<WebElement> refinedList = allCourseNames.subList(0, allCourses.size());
            return refinedList;
        }

        return allCourseNames;
    }

    public List<WebElement> getCoursesByCourseName(String courseName){
        findCourseName = new ArrayList<>();
        for (WebElement course : allCourses) {
            if (course.findElement(By.id(Integer.toString(allCourses.indexOf(course)) + "course"))
                    .getText().equals(courseName)) {
                findCourseName.add(course);
            }
        }
        return findCourseName;
    }

    public int getCourseIndexByCourseName(String courseName){
        findCourseName = new ArrayList<>();
        int count = 0;
        for (WebElement course : allCourses) {
            if (course.findElement(By.id(Integer.toString(allCourses.indexOf(course)) + "course"))
                    .getText().equals(courseName)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public List<WebElement> getCoursesByDiscipline(String disciplineName){
        allDisciplines = new ArrayList<>();
        for (WebElement course : allCourses) {
            if (course.findElement(By.id(Integer.toString(allCourses.indexOf(course)) + "discipline"))
                    .getText().equals(disciplineName)) {
                allDisciplines.add(course);
            }
        }
        return allDisciplines;
    }

    public List<WebElement> getCoursesByCourseType(String courseType){
        allCourseTypes = new ArrayList<>();
        for (WebElement course : allCourses) {
            if (course.findElement(By.id(Integer.toString(allCourses.indexOf(course)) + "course_type"))
                    .getText().equals(courseType)) {
                allCourseTypes.add(course);
            }
        }
        return allCourseTypes;
    }

    public List<WebElement> getCoursesByLocation(String location){
        allLocations = new ArrayList<>();
        for (WebElement course : allCourses) {
            if (course.findElement(By.id(Integer.toString(allCourses.indexOf(course)) + "location"))
                    .getText().equals(location)) {
                allLocations.add(course);
            }
        }
        return allLocations;
    }

    public List<WebElement> getCoursesByTrainer(String trainerName){
        allTrainers = new ArrayList<>();
        for (WebElement course : allCourses) {
            if (course.findElement(By.id(Integer.toString(allCourses.indexOf(course)) + "trainer_name"))
                    .getText().equals(trainerName)) {
                allTrainers.add(course);
            }
        }
        return allTrainers;
    }

    public AddCoursePage clickAddCourseButton(){
        addCourseButton.click();
        return new AddCoursePage();
    }

    public AddCoursePage clickAddCourseHyperlink(){
        addCourseHyperlink.click();
        return new AddCoursePage();
    }

    public EditCoursesPage clickEditCourseButton(String courseName) throws InterruptedException {
        By editButtonMethod = By.className("btn");
        getEditButton(courseName, editButtonMethod).click();
        return new EditCoursesPage();
    }

    public EditCoursesPage clickEditCourseHyperlink(String courseName) throws InterruptedException {
        By editHyperlinkMethod = By.linkText("Edit");
        getEditButton(courseName, editHyperlinkMethod).click();
        return new EditCoursesPage();
    }

    private WebElement getEditButton(String courseName, By method) throws InterruptedException {
        if(getCourseIndexByCourseName(courseName) < 5){
            WebElement editButton;
            editButton = getCoursesByCourseName(courseName).get(0).findElement(method); //By.linkText("Edit") | By.className("btn")
            scroll(method, By.id((getCourseIndexByCourseName(courseName)) + "row"));
            return editButton;
        }
        else {
            scroll(By.linkText("Edit"), By.id((getCourseIndexByCourseName(courseName)) + "row"));
            WebElement editButton;
            editButton = getCoursesByCourseName(courseName).get(0).findElement(By.linkText("Edit"));
            return editButton;
        }
    }

    private void scroll(By by, By index) throws InterruptedException {
        WebElement element = webDriver.findElement(index).findElement(by);
        int elementPosition = element.getLocation().getY();
        String js = String.format("window.scrollTo(0, %s)", elementPosition);
        ((JavascriptExecutor)webDriver).executeScript(js);
        TimeUnit.SECONDS.sleep(1);
    }

    public boolean areCourseNamesUnique(){
        Set<WebElement> uniqueList = new HashSet<WebElement>(allCourseNames);
        return uniqueList.size() == allCourseNames.size();
    }

    public void deleteCourse(String courseName){
        getDeleteButton(courseName).click();
    }

    private WebElement getDeleteButton(String courseName){
        deleteCourseButton = getCoursesByCourseName(courseName).get(0).findElement(By.linkText("Delete"));
        return deleteCourseButton;
    }

    public boolean isCourseDeleted(String courseName){
        try {
            for (WebElement courseIndex : allCourseNames) {
                if (courseIndex.getText().equals(courseName)) {
                    return false;
                }
            }
        } catch (StaleElementReferenceException e){
        }
        return true;
    }

    public boolean doesConfirmationBoxAppearOnDelete(String courseName) {
        try{
            deleteCourse(courseName);
            webDriver.switchTo().alert().accept();
            return true;

        } catch (NoAlertPresentException e){
            return false;
        }
    }

    public boolean confirmDelete() {
        try{
            webDriver.switchTo().alert().accept();
            return true;

        } catch (NoAlertPresentException e){
            return false;
        }
    }

    public boolean cancelDelete() {
        try {
            webDriver.switchTo().alert().dismiss();
            return true;
        } catch (NoAlertPresentException e){
            return false;
        }
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
