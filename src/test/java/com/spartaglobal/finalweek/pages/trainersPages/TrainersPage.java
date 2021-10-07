package com.spartaglobal.finalweek.pages.trainersPages;

import com.spartaglobal.finalweek.base.TestBase;
import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TrainersPage extends NavTemplate implements URLable {


    @FindAll({@FindBy(tagName = "tr")})
    List<WebElement> allTrainers;


    private List<String> cellElementsString;
    private List<WebElement> cellElements;
    private List<WebElement> trElements;
    private List<String> trElementString;


    @FindBy(id = "TrainerPageLink")
    WebElement addTrainerButton;

    @FindBy(linkText = "Edit")
    WebElement editTrainerButton;

    @FindBy(linkText = "Delete")
    WebElement deleteTrainerButton;


    public TrainersPage() {
        PageFactory.initElements(webDriver, this);
    }


    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }


    private List<String> iterateThroughTableRows(String cellName) {
        cellElementsString = new ArrayList<>();
        for (int i = 0; i < allTrainers.size() - 1; i++) {
            String newId = i + cellName;
            cellElementsString.add(webDriver.findElement(By.id(newId)).getText());

        }
        return cellElementsString;

    }

    private List<WebElement> iterateThroughTableRowsReturnElements(String cellName) {
        cellElements = new ArrayList<>();

        for (int i = 0; i < allTrainers.size() - 1; i++) {
            String newId = i + cellName;
            cellElements.add(webDriver.findElement(By.id(newId)));
        }
        return cellElements;
    }

    private List<WebElement> allTableRows() {
        trElements = new ArrayList<>();

        for (WebElement we : allTrainers) {
            trElements.add(we);
        }
        return trElements;
    }


    public List<WebElement> getAllTrainersFirstNameElements() {
        return iterateThroughTableRowsReturnElements("trainer-firstname");
    }

    public List<WebElement> getAllTrainersLastNameElements() {
        return iterateThroughTableRowsReturnElements("trainer-lastname");
    }

    public List<WebElement> getAllTrainerElements() {
        return allTableRows();
    }

    public List<WebElement> getAllTrainerColourElements() {
        return iterateThroughTableRowsReturnElements("Hex");
    }

    public List<String> getAllTrainersFirstName() {
        return iterateThroughTableRows("trainer-firstname");

    }

    public List<String> getAllTrainersLastName() {
        return iterateThroughTableRows("trainer-lastname");
    }

    public List<String> getAllTrainerColour() {
        return iterateThroughTableRows("Hex");
    }

    public WebElement getTrainerFirstNameElement(int id) {
        return findElement(id, "trainer-firstname");
    }

    public WebElement getTrainerLastNameElement(int id) {
        return findElement(id, "trainer-lastname");
    }

    public WebElement getTrainerColourElement(int id) {
        return findElement(id, "Hex");
    }

    public String getTrainerFirstName(int rowID) {
        return findElement(rowID, "trainer-firstname").getText();
    }

    public String getTrainerLastName(int rowID) {
        return findElement(rowID, "trainer-lastname").getText();
    }

    public String getTrainerColour(int rowID) {
        return findElement(rowID, "Hex").getAttribute("style");
    }

    public AddTrainersPage clickAddTrainer() {
        addTrainerButton.click();
        return new AddTrainersPage();
    }

    public EditTrainersPage clickEditTrainer() {
        editTrainerButton.click();
        return new EditTrainersPage();
    }

    public void deleteTrainer() {
        deleteTrainerButton.click();
    }

    public boolean isTrainerDeleted() {
        return !iterateThroughTableRowsReturnElements("tr").contains(findElement(1, ""));
    }

    public boolean isTrainerFirstNameValid(int rowNo) {

        if (webDriver.findElement(By.id(rowNo + "trainer-firstname")).getText().matches("[A-Za-z0-9_-]+")) {
            return true;
        }
        return false;

    }

    public boolean isTrainerLastNameValid(int rowNo) {
        if (webDriver.findElement(By.id(rowNo + "trainer-lastname")).getText().matches("[A-Za-z0-9_-]+")) {
            return true;
        }
        return false;
    }

    public boolean areAllTrainersFirstNamesValid(String rowID) {

        for (String s : iterateThroughTableRows(rowID)) {
            if (s.matches("[A-Za-z0-9_-]+")) {
                return true;
            }
        }
        return false;

    }

    public boolean areAllTrainersLastNamesValid(String rowID) {
        for (String s : iterateThroughTableRows(rowID)) {
            if (s.matches("[A-Za-z0-9_-]+")) {
                return true;
            }
        }
        return false;
    }

    public boolean areAllColoursUnique() {
        getAllTrainerColour();

        Set<WebElement> uniqueList = new HashSet<>(iterateThroughTableRowsReturnElements("Hex"));
        return uniqueList.size() == cellElements.size();
    }

    public boolean areAllFieldsPassedOnToEditTrainersPage() {
        EditTrainersPage editTrainersPage;
        if (allTableRowsString().isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < allTableRowsString().size() - 1; i++) {
                String trainerName = getTrainerFirstName(i) + " " + getTrainerLastName(i);
                editTrainersPage = submitTrainerByRow(i+1);
                String editTrainerName = editTrainersPage.getFirstName() + " " + editTrainersPage.getLastName();
                if (!trainerName.equals(editTrainerName)) {

                    return false;
                }
                editTrainersPage.submitTrainer();
                WebElement scroll = webDriver.findElement(By.tagName("body"));
                for (int j = 0; j < i - 1; j++) {
                    scroll.sendKeys(Keys.ARROW_DOWN);
                    scroll.sendKeys(Keys.ARROW_DOWN);
                    scroll.sendKeys(Keys.ARROW_DOWN);
                }
            }
            return true;
        }
    }


    public int findByTrainerName(String firstname, String lastname) {
        for (int i = 0; i < allTableRowsString().size() - 1; i++) {
            if (allTableRowsString().get(i).contains(firstname + " " + lastname)) {
                return i;
            }
        }
        return -1;
    }

    private List<String> allTableRowsString() {
        trElementString = new ArrayList<>();
        for (WebElement we : allTrainers) {
            trElementString.add(we.getText().replace("Edit", "").replace("Delete", "").trim());
        }
        return trElementString;
    }

    public WebElement findElement(int number, String cellName) {
        return webDriver.findElement(By.id(number + cellName));
    }

    public WebElement findElementByRowId(int rowID) {
        return allTrainers.get(rowID);
    }

    public EditTrainersPage submitTrainerByRow(int rowID) {
        findElementByRowId(rowID).findElement(By.className("btn-primary")).click();

        return new EditTrainersPage();


    }

    public boolean doesConfirmationBoxAppearOnDelete() {
        try {
            deleteTrainer();
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


}
