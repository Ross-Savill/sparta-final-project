package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import com.spartaglobal.finalweek.pages.courseInfoPages.EditCourseTypePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class TraineesPage implements URLable {

    @FindBy(id = "traineePageLink") WebElement addTraineeButton;
    @FindBy(id = "accordion-button") WebElement courseFilterDropDownButton;
    @FindBy(id = "course") List<WebElement> coursesWithinFilter;
    @FindBy(css = "#\30 row > td:nth-child(4) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement editTraineeButton;
    @FindBy(css = "#\\30 row > td:nth-child(5) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement deleteTraineeButton;
    @FindBy(css = "#\\30 row > td:nth-child(6) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement addQualityGateButton;
    @FindBy() WebElement qualityGateHistory; // Not sure how/what to grab here

    public TraineesPage() {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getAllTraineesElements() {
        WebElement traineesTable;
        WebElement tableBody;
        List<WebElement> allTraineeRows;
        traineesTable = webDriver.findElement(By.id("traineeTable"));
        tableBody = traineesTable.findElement(By.tagName("tbody"));
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tr")));
        allTraineeRows = tableBody.findElements(By.tagName("tr"));
        return allTraineeRows;
    }

    public List<WebElement> getAllTraineesFirstNameElements() {
        List<WebElement> allFirstNameElements = new ArrayList<>();
        List<WebElement> allTraineeRows = getAllTraineesElements();

        for(int i = 0; i < allTraineeRows.size(); i++) {
            WebElement firstNameElement = allTraineeRows.get(i).findElement(By.id(i+"name"));
            allFirstNameElements.add(firstNameElement);
        }
        return allFirstNameElements;
    }

    public List<WebElement> getAllTraineesLastNameElements() {
        List<WebElement> allLastNameElements = new ArrayList<>();
        List<WebElement> allTraineeRows = getAllTraineesElements();

        for(int i = 0; i < allTraineeRows.size(); i++) {
            WebElement lastNameElement = allTraineeRows.get(i).findElement(By.id(i+"surname"));
            allLastNameElements.add(lastNameElement);
        }
        return allLastNameElements;
    }

    public List<WebElement> getAllTraineesQualityGateStatusElements() {
        List<WebElement> allQualityGateStatusElements = new ArrayList<>();
        List<WebElement> allTraineeRows = getAllTraineesElements();

        for(int i = 0; i < allTraineeRows.size(); i++) {
            WebElement qualityGateStatusElement = allTraineeRows.get(i).findElement(By.id(i+"qgs"));
            allQualityGateStatusElements.add(qualityGateStatusElement);
        }
        return allQualityGateStatusElements;
    }

    public List<String> getAllTraineesFirstNames() {
        List<String> allFirstNameStrings = new ArrayList<>();
        List<WebElement> allTraineeRows = getAllTraineesElements();

        for(int i = 0; i < allTraineeRows.size(); i++) {
            WebElement firstNameString = allTraineeRows.get(i).findElement(By.id(i+"name"));
            allFirstNameStrings.add(firstNameString.getText());
        }
        System.out.println(allFirstNameStrings);
        return allFirstNameStrings;
    }

    public List<String> getAllTraineesLastNames() {
        List<String> allLastNameStrings = new ArrayList<>();
        List<WebElement> allTraineeRows = getAllTraineesElements();

        for(int i = 0; i < allTraineeRows.size(); i++) {
            WebElement firstNameString = allTraineeRows.get(i).findElement(By.id(i+"surname"));
            allLastNameStrings.add(firstNameString.getText());
        }
        return allLastNameStrings;
    }

    public List<String> getAllTraineesQualityGateStatusStrings() {
        List<String> allQualityGateStrings = new ArrayList<>();
        List<WebElement> allTraineeRows = getAllTraineesElements();

        for(int i = 0; i < allTraineeRows.size(); i++) {
            WebElement qualityGateString = allTraineeRows.get(i).findElement(By.id(i+"qgs"));
            allQualityGateStrings.add(qualityGateString.getText());
        }
        return allQualityGateStrings;
    }

    public WebElement getTraineeElement(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row;
            }
        }
        return null;
    }

    public WebElement getTraineeFirstNameElement(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row.findElement(By.id(allTraineeRows.indexOf(row)+"name"));
            }
        }
        return null;
    }

    public WebElement getTraineeLastNameElement(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row.findElement(By.id(allTraineeRows.indexOf(row)+"surname"));
            }
        }
        return null;
    }

    public WebElement getTraineeQualityGateStatusElement(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row.findElement(By.id(allTraineeRows.indexOf(row)+"qgs"));
            }
        }
        return null;
    }

    public String getTraineeFirstName(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row.findElement(By.id(allTraineeRows.indexOf(row)+"name")).getText();
            }
        }
        return null;
    }

    public String getTraineeLastName(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row.findElement(By.id(allTraineeRows.indexOf(row)+"surname")).getText();
            }
        }
        return null;
    }

    public String getTraineeQualityGateStatus(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                return row.findElement(By.id(allTraineeRows.indexOf(row)+"qgs")).getText();
            }
        }
        return null;
    }

    public List<WebElement> getQualityGateHistoryDetailsElements(String rowID) {

        WebElement traineesTable;
        WebElement tableBody;
        List<WebElement> allTraineeRows;
        traineesTable = webDriver.findElement(By.id("traineeTable"));
        tableBody = traineesTable.findElement(By.tagName("tbody"));
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tr")));
        allTraineeRows = tableBody.findElements(By.tagName("tr"));

        WebElement qualityGateTable;
        List<WebElement> totalTableDataElements;
        List<WebElement> qualityGateData = new ArrayList<>();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                row.findElement(By.tagName("td")).click();
                qualityGateTable = tableBody.findElement(By.className("footable-details"));
                totalTableDataElements = qualityGateTable.findElements(By.tagName("td"));
                for(WebElement element : totalTableDataElements) {
                    if(element.getText() != null) {
                        System.out.println("STARTING HERE " + element.getText());
                    }
                }
            }
        }
        return null;
    }

//    public String getQualityGateHistoryDetails(int rowID) {
//
//    }

//    public List<WebElement> getCoursesElements() {
//
//    }

//    public List<String> getCoursesWithinFilter() {
//
//    }

//    public void applyCourseFilter(String courseName) {
//
//    }

//    public AddTraineesPage clickAddTrainee() {
//
//    }

//    public EditTraineesPage clickEditTrainee(int rowID) {
//
//    }

//    public void clickDeleteTrainee(int rowID) {
//
//    }

//    public AddQualityGatePage clickAddQualityGate(int rowID) {
//
//    }

//    public boolean isQualityGateStatusPassed() {
//
//    }

//    public boolean isQualityGateStatusPending() {
//
//    }

//    public boolean isQualityGateStatusFailed() {
//
//    }

//    public boolean isQualityGateStatusFailedNeedsHelp() {
//
//    }

//    public boolean isTraineeFirstNameValid() {
//
//    }

//    public boolean isTraineeLastNameValid() {
//
//    }

//    public boolean areAllTraineesFirstNamesValid() {
//
//    }

//    public boolean areAllTraineesLastNamesValid() {
//
//    }

//    public boolean isTraineeQualityGateStatusValid() {
//
//    }

//    public boolean areCoursesUnique() {
//
//    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
