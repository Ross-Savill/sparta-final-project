package com.spartaglobal.finalweek.pages.traineePages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.spartaglobal.finalweek.base.TestBase.webDriver;

public class TraineesPage extends NavTemplate implements URLable {

    @FindBy(linkText = "Add Trainee") WebElement addTraineeButton;
    @FindBy(className = "accordion-button") WebElement courseFilterDropDownButton;
    public String filterAppliedURL;

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
            int rowNumber = 0;
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
        courseFilterDropDownButton.click();
        return courseStrings;
    }

    public void applyCourseFilter(String courseName) {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.elementToBeClickable(courseFilterDropDownButton));
        courseFilterDropDownButton.click();
        WebElement filterBody = webDriver.findElement(By.className("accordion-body"));
        List<WebElement> courseElements = filterBody.findElements(By.id("course"));
        for(WebElement courseElement : courseElements) {
            if(courseElement.getText().equals(courseName)) {
                courseElement.click();
                filterAppliedURL = webDriver.getCurrentUrl().replaceAll("%20","");
                break;
            }
        }
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

    public boolean isQualityGateStatusPassed(String qgStatus) {
        return qgStatus.equals("Passed");
    }

    public boolean isQualityGateStatusPending(String qgStatus) {
        return qgStatus.equals("Pending");
    }

    public boolean isQualityGateStatusFailed(String qgStatus) {
        return qgStatus.equals("Failed");
    }

    public boolean isQualityGateStatusFailedNeedsHelp(String qgStatus) {
        return qgStatus.equals("Failed-Needs Help");
    }

    public boolean isTraineePresent(String firstName, String lastName) {
        List<WebElement> allTraineeRows = getAllTraineesElements();
        for(int i = 0; i < allTraineeRows.size(); i++) {
            String firstNameInRow = allTraineeRows.get(i).findElement(By.id(i+"name")).getText();
            String lastNameInRow = allTraineeRows.get(i).findElement(By.id(i+"surname")).getText();
            if(firstName.equals(firstNameInRow) && lastName.equals(lastNameInRow)) {
                return true;
            }
        }
        return false;
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

    public boolean isTraineeQualityGateStatusValid(String rowID) {
        String[] qualityGateStatusOptions = {"Passed", "Pending", "Failed", "Failed-Needs Help"};
        for(String option : qualityGateStatusOptions) {
            if(getTraineeQualityGateStatus(rowID).equals(option)) {
                return true;
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

    public boolean areAllQualityGateStatusValid() {
        boolean allQualityGateStatusValid = true;
        List<WebElement> allTraineeRows = getAllTraineesElements();
        String[] qualityGateStatusOptions = {"Passed", "Pending", "Failed", "Failed-Needs Help"};
        for(WebElement row : allTraineeRows) {
            String qgs = row.findElement(By.id(allTraineeRows.indexOf(row)+"qgs")).getText();
            if(!Arrays.stream(qualityGateStatusOptions).anyMatch(qgs::equals)) {
                allQualityGateStatusValid = false;
                break;
            }
        }
        return allQualityGateStatusValid;
    }

    public boolean areAllFieldsPassedOnToEditTraineesPage() {
        String firstName = getTraineeFirstName("0row");
        String lastName = getTraineeLastName("0row");
        List<String> allCourseNames = getCoursesStrings();
        for (String courseName : allCourseNames) {
            applyCourseFilter(courseName);
            List<WebElement> allTraineeRows = getAllTraineesElements();
            if (allTraineeRows.get(0).getAttribute("class").equals("footable-empty")) {
                continue;
            } else {
                int rowNumber = 0;
                for (WebElement traineeRow : allTraineeRows) {
                    if (traineeRow.findElement(By.id(rowNumber + "name")).getText().equals(firstName)
                            && traineeRow.findElement(By.id(rowNumber + "surname")).getText().equals(lastName)) {
                        traineeRow.findElement(By.linkText("Edit")).click();
                        EditTraineesPage editTraineesPage = new EditTraineesPage();
                        PageFactory.initElements(webDriver, editTraineesPage);
                        Select editTraineesCourseDropdown = new Select(webDriver.findElement(By.id("edit-trainee-course-name")));
                        if (editTraineesCourseDropdown.getFirstSelectedOption().getText().equals(courseName) &&
                                editTraineesPage.firstNameTextBox.getAttribute("value").equals(firstName)
                                && editTraineesPage.lastNameTextBox.getAttribute("value").equals(lastName)) {
                            return true;
                        }
                    }
                    rowNumber++;
                }
            }
        }
        return false;
    }

    public boolean doesConfirmationBoxAppearOnDelete() {
        int rowNumber = 0;
        try {
            clickDeleteTrainee(rowNumber+"row");
            webDriver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean confirmDelete() {
        try {
            webDriver.switchTo().alert().accept();
            return true;

        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean cancelDelete() {
        try {
            webDriver.switchTo().alert().dismiss();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
