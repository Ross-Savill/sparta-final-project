package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class AddCourseTypePage implements URLable {
    CourseInfoPage courseInfoPage;

    @FindBy(id = "course-type-name") WebElement courseTypeName;
    @FindBy(xpath = "//*[@id=\"add-course-type-form\"]/div[2]/input") WebElement submitButton;

    public AddCourseTypePage() {
        PageFactory.initElements(webDriver, this);
        courseInfoPage = new CourseInfoPage();
    }

    public void enterCourseTypeName(String courseName) {
        courseTypeName.sendKeys(courseName);
    }

    public boolean isCourseTypeNameValid() {
        return courseTypeName.getAttribute("value").matches("[a-zA-Z0-9-& #+]*");
    }

    public boolean isCourseTypeNameEmpty() {
        return courseTypeName.getAttribute("value").isBlank();
    }

    public boolean isCourseTypeGenerated(String typeName) {
        List<String> courseNames = courseInfoPage.getCourseTypesNames();
        return courseNames.contains(typeName);
    }

    public boolean submitSuccessful(String typeName) {
        return (isCourseTypeGenerated(typeName) && (Objects.equals("http://localhost:8080/extraCourseInfoPage",webDriver.getCurrentUrl())));
    }

    public CourseInfoPage goToCourseInfoPage() {
        submitButton.click();
        return new CourseInfoPage();
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
