package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMultitone {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static WebDriver webDriver;
    private static PropertiesReader propertiesReader = new PropertiesReader();

    public static void setDriver() {
        driver.set(getDriver());
    }

    public static void closeMultiDriver() {
        driver.get().close();
        driver.remove();
    }

    public static void setProperties() {
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
    }

    public static WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.get(propertiesReader.getURL());
        }
        return webDriver;
    }


    public static WebDriver getMultiDriver() {
        return driver.get();
    }
}
