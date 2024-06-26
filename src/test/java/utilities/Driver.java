package utilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;


import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver() {
    } // MAKING DRIVER INSTANCE PRIVATE SO IT CAN'T BE REACHABLE FROM OUTSIDE THE
    // CLASS
    private static WebDriver driver; // DRIVER IS STATIC SO IT IS RUN BEFORE ANYTHING ELSE
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }


}

