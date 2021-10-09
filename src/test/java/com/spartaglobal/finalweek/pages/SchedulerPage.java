package com.spartaglobal.finalweek.pages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.tests.NavTemplateTests;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.spartaglobal.finalweek.base.TestBase.webDriver;


public class SchedulerPage extends NavTemplate implements URLable {

    @FindBy(how = How.CLASS_NAME , using="td.sticky-col footable-first-visible")
    public List<WebElement> trainingCourseNames;
    @FindBy(how = How.CSS , using="table.table tr")
    public List<WebElement> trainingCourses;
    @FindBy(xpath = "(//td[normalize-space()='Jedi Training'])[1]")
    WebElement FirstcourseName;

    @FindBy(xpath = "//td[contains(text(),'JarJar Binks')]")
    WebElement FirstTrainerName;
    @FindBy(xpath = "//td[contains(text(),'Coruscant')]")
    WebElement FirstCouseLocationName;
    @FindBy(how = How.XPATH , using="//tr[@class='footable-detail-row']//td//tr")
    public List<WebElement> FirstScheduleTrainingTable;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[1]")
    WebElement discipline;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[2]")
    WebElement courseType;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[3]")
    WebElement courseStart;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[4]")
    WebElement courseDuration;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[5]")
    WebElement courseEnd;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[6]")
    WebElement bond;
    @FindBy(xpath = "//tr[@class='footable-detail-row']//td//tr[7]")
    WebElement traineesInCourse;

    public SchedulerPage() {

        PageFactory.initElements(webDriver, this);

    }

    public boolean getCourse() {
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);
                if (FirstcourseName.isDisplayed()) {
                    return true;
                }
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return false;
    }


    public String getTrainer(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                return FirstTrainerName.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return "";
    }
    public String getCourseLocation(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                return FirstCouseLocationName.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return "";
    }
    public void firstGetCourseClick(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                FirstcourseName.click();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }

    }

    public boolean isClickablefirstGetCourse(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                return FirstcourseName.isEnabled();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return false;
    }


    public boolean isFirstCourseDisplayed(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                firstGetCourseClick();
                if (discipline.isDisplayed() &&
                        courseType.isDisplayed() &&
                        courseStart.isDisplayed() &&
                        courseDuration.isDisplayed() &&
                        courseEnd.isDisplayed() &&
                        bond.isDisplayed() &&
                        traineesInCourse.isDisplayed()) {
                    return true;
                } else
                    return false;
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return false;
    }

    public String getDicipline() {

        boolean staleElement = true;

        while (staleElement) {
            try {
                staleElement = false;
                firstGetCourseClick();

                Thread.sleep(3000);
                return discipline.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;

            }
        }

        return "";
    }
    public String getCourseType(){
        boolean staleElement = true;

        while(staleElement){

            try{
                staleElement = false;
                firstGetCourseClick();
                Thread.sleep(2000);
                return courseType.getText();
            } catch(StaleElementReferenceException | InterruptedException e){
                staleElement = true;
            }
        }

        return "";

    }
    public String getStartOfCourse(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                firstGetCourseClick();

                return courseStart.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return "";
    }
    public String getDuration(){
        boolean staleElement = true;

        while(staleElement){

            try{
                staleElement = false;
                firstGetCourseClick();
                Thread.sleep(2000);
                return courseDuration.getText();

            } catch(StaleElementReferenceException | InterruptedException e){
                staleElement = true;
            }
        }
    return "";

    }
    public String getEndOfCouse(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                firstGetCourseClick();

                return courseEnd.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
      return "";
    }
    public String getBond(){

        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                firstGetCourseClick();

                return bond.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return "";
    }
    public String getTraineesInCourse(){
        boolean staleElement = true;
        while (staleElement) {
            try {
                staleElement = false;
                Thread.sleep(2000);

                firstGetCourseClick();

                return traineesInCourse.getText();
            } catch (StaleElementReferenceException | InterruptedException e) {
                staleElement = true;
            }
        }
        return "";
    }

    public  boolean isTrainingCourseTrainerCourseLocationContains(String TrainingCourse,String Trainer,String CourseLocation) throws InterruptedException {

        int count = 0;
        for (WebElement trainingCourse : trainingCourses) {
            Thread.sleep(2000);
            String str = "";
            if (count > 0) {
                str = trainingCourse.getText();
                if (str.contains(TrainingCourse) && str.contains(Trainer) && str.contains(CourseLocation))
                    return true;
            }
            count++;
        }
        return false;
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}


