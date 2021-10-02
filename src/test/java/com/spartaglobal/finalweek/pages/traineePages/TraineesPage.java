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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class TraineesPage implements URLable {

    @FindBy(id = "traineePageLink") WebElement addTraineeButton;
    @FindBy(className = "accordion-button") WebElement courseFilterDropDownButton;
    @FindBy(id = "course") List<WebElement> coursesWithinFilter;
    @FindBy(css = "#\30 row > td:nth-child(4) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement editTraineeButton;
    @FindBy(css = "#\\30 row > td:nth-child(5) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement deleteTraineeButton;
    @FindBy(css = "#\\30 row > td:nth-child(6) > div:nth-child(1) > button:nth-child(1) > a:nth-child(1)") WebElement addQualityGateButton;

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
                    if(!element.getText().isEmpty()) {
                        qualityGateData.add(element);
                    }
                }
            }
        }
        return qualityGateData;
    }

    public List<String> getQualityGateHistoryDetails(String rowID) {
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
        List<String> qualityGateDataStrings = new ArrayList<>();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                row.findElement(By.tagName("td")).click();
                qualityGateTable = tableBody.findElement(By.className("footable-details"));
                totalTableDataElements = qualityGateTable.findElements(By.tagName("td"));
                for(WebElement element : totalTableDataElements) {
                    if(!element.getText().isEmpty()) {
                        qualityGateDataStrings.add(element.getText());
                    }
                }
            }
        }
        return qualityGateDataStrings;
    }

    public List<WebElement> getCoursesElements() {
        courseFilterDropDownButton.click();
        WebElement filterBody = webDriver.findElement(By.className("accordion-body"));
        return filterBody.findElements(By.id("course"));
    }

    public List<String> getCoursesStrings() {
        List<String> courseStrings = new ArrayList<>();
        courseFilterDropDownButton.click();
        WebElement filterBody = webDriver.findElement(By.className("accordion-body"));
        List<WebElement> courseElements = filterBody.findElements(By.id("course"));
        for(WebElement courseElement : courseElements) {
            courseStrings.add(courseElement.getText());
        }
        return courseStrings;
    }

    public void applyCourseFilter(String courseName) {
        courseFilterDropDownButton.click();
        WebElement filterBody = webDriver.findElement(By.className("accordion-body"));
        List<WebElement> courseElements = filterBody.findElements(By.id("course"));
        for(WebElement courseElement : courseElements) {
            if(courseElement.getText().equals(courseName)) {
                courseElement.click();
            }
        }
    }

    public AddTraineesPage clickAddTrainee() {
        addTraineeButton.click();
        return new AddTraineesPage();
    }

    public EditTraineesPage clickEditTrainee(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                row.findElement(By.linkText("Edit")).click();
                return new EditTraineesPage();
            }
        }
        return null;
    }

    public void clickDeleteTrainee(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                row.findElement(By.linkText("Delete")).click();
                break;
            }
        }
    }

    public AddQualityGatePage clickAddQualityGate(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                row.findElement(By.linkText("Add")).click();
                return new AddQualityGatePage();
            }
        }
        return null;
    }

    public boolean isQualityGateStatusPassed(String rowID) {
        return getTraineeQualityGateStatus(rowID).equals("Passed");
    }

    public boolean isQualityGateStatusPending(String rowID) {
        return getTraineeQualityGateStatus(rowID).equals("Pending");
    }

    public boolean isQualityGateStatusFailed(String rowID) {
        return getTraineeQualityGateStatus(rowID).equals("Failed");
    }

    public boolean isQualityGateStatusFailedNeedsHelp(String rowID) {
        return getTraineeQualityGateStatus(rowID).equals("Failed-Needs Help");
    }

    public boolean isTraineeFirstNameValid(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                Pattern regex = Pattern.compile("^[a-zA-Z0-9'-,.]+$");
                String name = row.findElement(By.id(allTraineeRows.indexOf(row)+"name")).getText();
                return regex.matcher(name).find();
            }
        }
        return false;
    }

    public boolean isTraineeLastNameValid(String rowID) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(WebElement row : allTraineeRows) {
            if(row.getAttribute("id").equals(rowID)) {
                Pattern regex = Pattern.compile("^[a-zA-Z0-9'-,.]+$");
                String name = row.findElement(By.id(allTraineeRows.indexOf(row)+"surname")).getText();
                return regex.matcher(name).find();
            }
        }
        return false;
    }

    public boolean areAllTraineesFirstNamesValid() {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        Pattern regex = Pattern.compile("^[a-zA-Z0-9',.-]+$");
        for(WebElement row : allTraineeRows) {
            String name = row.findElement(By.id(allTraineeRows.indexOf(row)+"name")).getText();
            if(!regex.matcher(name).find()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllTraineesLastNamesValid() {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        Pattern regex = Pattern.compile("^[a-zA-Z0-9',.-]+$");
        for(WebElement row : allTraineeRows) {
            String name = row.findElement(By.id(allTraineeRows.indexOf(row)+"surname")).getText();
            if(!regex.matcher(name).find()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTraineeQualityGateStatusValid(String rowID) {
        String[] qualityGateStatusOptions = {"Passed", "Pending", "Failed", "Failed-Needs Help"};
        for(String option : qualityGateStatusOptions) {
            if(getTraineeQualityGateStatus(rowID).equals(option)) {
                return true;
            }
        }
        return false;
    }

    public boolean areCoursesUnique() {
        List<String> allCourses = getCoursesStrings();
        for(int i = 0; i < allCourses.size() - 1; i++) {
            for(int j = 0; j < allCourses.size() - 1; j++) {
                if(i != j && allCourses.get(i).equals(allCourses.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
