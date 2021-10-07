package com.spartaglobal.finalweek.pages.courseInfoPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CourseInfoPage extends NavTemplate implements URLable {

    @FindBy (id = "courseTypeTable") List<WebElement> courseTypeElements;
    @FindBy (id = "disciplineTable") List<WebElement> disciplinesElements;
    @FindBy (id = "CourseTypePageLink") WebElement addCourseTypeButton;
    @FindBy (id = "disciplinePageLink") WebElement addDisciplineButton;

    private String sentCourseType = "";
    private String sentDiscipline = "";
    private int sentDuration = 0;

    public CourseInfoPage() {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getCourseTypeElements() {
        return courseTypeElements;
    }

    public List<String> getCourseTypesNames() {
        List<String> courseTypesNames = new ArrayList<>();
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "coursetype");
                courseTypesNames.add(webDriver.findElement(new By.ById(searchID)).getText());
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }

        return courseTypesNames;
    }

    public WebElement getCourseTypeWebElement(String courseType) {
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "coursetype");
                WebElement rowName = webDriver.findElement(new By.ById(searchID));
                if(rowName.getText().equals(courseType)) {
                    return webDriver.findElement(new By.ById("courseTypeTable")).findElement(new By.ById(currentRow + "row"));
                }
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }
        return null;
    }

    public String getCourseTypeName(int rowID) {
        try {
            String searchID = (rowID + "coursetype");
            return(webDriver.findElement(new By.ById(searchID)).getText());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int getCourseTypeCount() {
        return getCourseTypesNames().size();
    }

    public List<WebElement> getDisciplinesElements() {
        return disciplinesElements;
    }

    public List<String> getDisciplineNames() {
        List<String> disciplineNames = new ArrayList<>();
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "discipline");
                disciplineNames.add(webDriver.findElement(new By.ById(searchID)).getText());
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }

        return disciplineNames;
    }

    public int getDisciplineCount() {
        return getDisciplineNames().size();
    }

    public WebElement getDisciplineElement(int rowID) {
        try {
            return(webDriver.findElement(new By.ById("disciplineTable"))).findElement(new By.ById(rowID + "row"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public WebElement getDisciplineElement(String disciplineName) {
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "discipline");
                WebElement rowName = webDriver.findElement(new By.ById(searchID));
                if(rowName.getText().equals(disciplineName)) {
                    return webDriver.findElement(new By.ById("disciplineTable")).findElement(new By.ById(currentRow + "row"));
                }
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }
        return null;
    }

    public String getDisciplineName(int rowID) {
        return getDisciplineNames().get(rowID);
    }

    public List<WebElement> getDisciplinesElementsWithDuration(int duration) {
        List<WebElement> disciplineElements = new ArrayList<>();
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "duration");
                int currentRowDuration = Integer.parseInt(webDriver.findElement(new By.ById(searchID)).getText().replaceAll("[^0-9]", ""));
                if (currentRowDuration == duration) {
                    disciplineElements.add(webDriver.findElement(new By.ById(currentRow + "row")));
                }
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }
        return disciplineElements;
    }

    public List<String> getDisciplinesNamesWithDuration(int duration) {
        List<String> disciplineNames = new ArrayList<>();
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "duration");
                int currentRowDuration = Integer.parseInt(webDriver.findElement(new By.ById(searchID)).getText().replaceAll("[^0-9]", ""));
                if (currentRowDuration == duration) {
                    disciplineNames.add(webDriver.findElement(new By.ById(currentRow + "discipline")).getText());
                }
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }
        return disciplineNames;
    }

    public List<WebElement> getDisciplinesElementsBetweenDurations(int lowestDuration, int highestDuration) {
        List<WebElement> disciplineElements = new ArrayList<>();
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "duration");
                int currentRowDuration = Integer.parseInt(webDriver.findElement(new By.ById(searchID)).getText().replaceAll("[^0-9]", ""));
                if (currentRowDuration > lowestDuration && currentRowDuration < highestDuration) {
                    disciplineElements.add(webDriver.findElement(new By.ById(currentRow + "row")));
                }
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }
        return disciplineElements;
    }

    public List<String> getDisciplineNamesBetweenDurations(int lowestDuration, int highestDuration) {
        List<String> disciplineNames = new ArrayList<>();
        boolean notNull = true;
        int currentRow = 0;

        while(notNull) {
            try {
                String searchID = (currentRow + "duration");
                int currentRowDuration = Integer.parseInt(webDriver.findElement(new By.ById(searchID)).getText().replaceAll("[^0-9]", ""));
                if (currentRowDuration > lowestDuration && currentRowDuration < highestDuration) {
                    disciplineNames.add(webDriver.findElement(new By.ById(currentRow + "discipline")).getText());
                }
                currentRow++;
            } catch (NoSuchElementException e) {
                notNull = false;
            }
        }
        return disciplineNames;
    }

    public AddDisciplinePage clickAddDisciplineButton() {
        addDisciplineButton.click();
        return new AddDisciplinePage();
    }

    public AddCourseTypePage clickAddCourseTypeButton() {
        addCourseTypeButton.click();
        return new AddCourseTypePage();
    }

    public EditCourseTypePage clickEditCourseTypeButton(String courseTypeName) {
        sentCourseType = courseTypeName;
        WebElement row = getCourseTypeWebElement(courseTypeName);
        row.findElement(new By.ByLinkText("Edit")).click();
        return new EditCourseTypePage();
    }

    public EditDisciplinePage clickEditDisciplineButton(String disciplineName) {
        sentDiscipline = disciplineName;
        sentDuration = Integer.parseInt(getDisciplineElement(0).findElement(new By.ById("0duration")).getText().replaceAll("[^0-9]", ""));

        WebElement row = getDisciplineElement(disciplineName);
        WebElement editButton = row.findElement(new By.ByLinkText("Edit"));
        scrollDown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        editButton.click();

        return new EditDisciplinePage();
    }

    public void clickDeleteCourseTypeButton (String courseTypeName) {
        WebElement row = getCourseTypeWebElement(courseTypeName);
        row.findElement(new By.ByLinkText("Delete")).click();
    }

    public boolean isCourseTypeDeleted(String courseTypeName) {
        //Method actually only checks if a courseType is not present,
        //however may be useful in conjunction with testing the delete button
        return !getCourseTypesNames().contains(courseTypeName);
    }

    public void clickDeleteDisciplineButton(String disciplineName) {
        WebElement row = getDisciplineElement(disciplineName);
        scrollDown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        row.findElement(new By.ByLinkText("Delete")).click();
    }

    public boolean isDisciplineDeleted(String disciplineName) {
        //Method actually only checks if a courseType is not present,
        //however may be useful in conjunction with testing the delete button
        return !getDisciplineNames().contains(disciplineName);
    }

    public boolean areCourseTypesUnique() {
        Set<String> nameSet = new HashSet<>(getCourseTypesNames());
        return nameSet.size() >= getCourseTypesNames().size();
    }

    public boolean areDisciplinesUnique() {
        Set<String> nameSet = new HashSet<>(getDisciplineNames());
        return nameSet.size() >= getDisciplineNames().size();
    }

    public boolean isNameValidForCourseType(String courseTypeName) {
        return courseTypeName.matches("[a-zA-Z0-9-& #+]*");
    }

    public boolean isDurationValidForDiscipline(int duration) {
        return (duration > 0);
    }

    public boolean isNameValidForDiscipline(String disciplineName) {
        return disciplineName.matches("[a-zA-Z0-9-& #+]*");
    }

    public boolean areAllFieldsPassedOnToEditCourseTypePage() {
        EditCourseTypePage editCourseTypePage = new EditCourseTypePage();
        boolean passedOn;
        if (sentCourseType == null || sentCourseType.isBlank()) {
            passedOn = false;
        } else {
            passedOn = sentCourseType.equals(editCourseTypePage.getCourseTypeName().getAttribute("value"));
        }
        return passedOn;
    }

    public boolean areAllFieldsPassedOnToEditDisciplinePage() {
        boolean passedOn;
        if ((sentDiscipline == null || sentDiscipline.isBlank()) && (sentDuration == 0)) {
            passedOn = false;
        } else {
            passedOn = ((sentDiscipline.equals(webDriver.findElement(new By.ById("discipline-name")).getAttribute("value")) && (sentDuration == Integer.parseInt(webDriver.findElement(new By.ById("discipline-duration")).getAttribute("value")))));
        }
        return passedOn;
    }

    private void scrollDown() {
        WebElement scroll = webDriver.findElement(By.tagName("body"));
        int scrollDownPage=6;
        for (int i = 0; i < scrollDownPage; i++) {
            scroll.sendKeys(Keys.ARROW_DOWN);
        }
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
