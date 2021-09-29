package com.spartaglobal.finalweek.base;

import com.spartaglobal.finalweek.util.PropertiesLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static PropertiesLoader Properties;
    public static WebDriver webDriver;

    public static void initialisation(){
        String browserName = PropertiesLoader.getProperties().getProperty("BrowserName");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        String URL = PropertiesLoader.getProperties().getProperty("URL");
        webDriver.get(URL);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
