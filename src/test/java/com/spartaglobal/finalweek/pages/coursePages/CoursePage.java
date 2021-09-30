package com.spartaglobal.finalweek.pages.coursePages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class CoursePage implements URLable {

    @FindBy(id = "courseList")
    WebElement courseList;

    private List<WebElement> allCourses;
    private List<WebElement> allCourseNames;
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
    @FindBy(linkText = "Edit")
    WebElement editCourseButton;

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

        return null;
    }

    public List<WebElement> getCoursesByTrainer(String trainerName){

        return null;
    }

    public AddCoursePage clickAddCourseButton(){
        addCourseButton.click();
        return new AddCoursePage();
    }

    public EditCoursesPage clickEditCourseButton(){
        editCourseButton.click();
        return new EditCoursesPage();
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
