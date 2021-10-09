package com.spartaglobal.finalweek.pages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.pages.centresPages.CentresPage;
import com.spartaglobal.finalweek.pages.courseInfoPages.CourseInfoPage;
import com.spartaglobal.finalweek.pages.coursePages.CoursePage;
import com.spartaglobal.finalweek.pages.traineePages.TraineesPage;
import com.spartaglobal.finalweek.pages.trainersPages.TrainersPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavTemplate extends TestBase {
    @FindBy(id = "spartaLogo")
    WebElement spartaLogo;
    @FindBy(id = "homePageLink")
    WebElement homePageLink;
    @FindBy(id = "traineePageLink")
    WebElement traineePageLink;
    @FindBy(id = "trainerPageLink")
    WebElement trainerPageLink;
    @FindBy(id = "coursePageLink")
    WebElement coursePageLink;
    @FindBy(id = "extraCourseInfoPageLink")
    WebElement courseInfoPageLink;
    @FindBy(id = "centrePageLink")
    WebElement centrePageLink;
    @FindBy(id = "aboutPageLink")
    WebElement accountPageLink;
    @FindBy(id = "logoutLink")
    WebElement logoutLink;

    private SchedulerPage schedulerPage;

    public NavTemplate() {
        PageFactory.initElements(webDriver, this);
    }

    public SchedulerPage logoToSchedulerPage(){
        spartaLogo.click();
        return new SchedulerPage();
    }

    public SchedulerPage goToSchedulerPage(){
        homePageLink.click();
        return new SchedulerPage();
    }

    public TraineesPage goToTraineesPage(){
        traineePageLink.click();
        return new TraineesPage();
    }

    public TrainersPage goToTrainersPage(){
        trainerPageLink.click();
        return new TrainersPage();
    }

    public CoursePage goToCoursesPage(){
        coursePageLink.click();
        return new CoursePage();
    }

    public CourseInfoPage goToCourseInfoPage(){
        courseInfoPageLink.click();
        return new CourseInfoPage();
    }

    public CentresPage goToCentresPage(){
        centrePageLink.click();
        return new CentresPage();
    }

    public AccountPage goToAccountPage(){
        accountPageLink.click();
        return new AccountPage();
    }

    public LoginPage logOutOfSite(){
        logoutLink.click();
        return new LoginPage();
    }
}
