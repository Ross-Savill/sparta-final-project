package com.spartaglobal.finalweek.pages.centresPages;

import com.spartaglobal.finalweek.interfaces.URLable;
import com.spartaglobal.finalweek.pages.NavTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CentresPage extends NavTemplate implements URLable {

    @FindBy(id = "locationTable")
    WebElement centreTable;

    private List<WebElement> centres;
    private List<WebElement> locationNames;
    private List<WebElement> numberOfRooms;

    public CentresPage(){
        PageFactory.initElements(webDriver, this);

        centres = centreTable.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        locationNames = new ArrayList<>();
        locationNames = this.getAllLocationNames();

        numberOfRooms = new ArrayList<>();
    }

    public List<WebElement> getAllCentres() {
        return this.centres;
    }

    public List<WebElement> getAllLocationNames() {

        for (WebElement centre:centres) {
            locationNames.add(
                    centre.findElement(By.id(Integer.toString(centres.indexOf(centre))+"location_name"))
            );
        }
        return locationNames;
    }

    public List<WebElement> getCentresByLocationName(String locationName) {
        List<WebElement> foundCentres = new ArrayList<>();

        for (WebElement centre:centres) {
            if(centre.findElement(By.id(Integer.toString(centres.indexOf(centre))+"location_name")).getText().equals(locationName)){
                foundCentres.add(centre);
            }
//            if(centre.getText().contains(locationName)) {
//                foundCentres.add(centre);
//            }
        }
        return foundCentres;
    }

    public List<WebElement> getCentresByNumberOfRooms(int roomNumber) {
        List<WebElement> foundCentres = new ArrayList<>();

        for (WebElement centre:centres) {
            if(centre.getText().contains(Integer.toString(roomNumber))) {
                foundCentres.add(centre);
            }
        }
        return  foundCentres;
    }

    @Override
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
