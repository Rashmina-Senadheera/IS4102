package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    static BrowserFactory browserFactory;

    ThreadLocal<WebDriver> tlWebDriver = ThreadLocal.withInitial(() -> {
        WebDriver driver;
        String browserType = System.getProperty("browser", "chrome");
        switch (browserType){
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            default:
                throw new RuntimeException("Browser is not defined");
        }
        driver.manage().window().maximize();
        return driver;
    });

    private BrowserFactory(){}

    public static BrowserFactory getBrowserFactory(){
        if(browserFactory == null){
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver(){
        return tlWebDriver.get();
    }

    public void quitDriver(){
        tlWebDriver.get().quit();
    }
}
