package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BaseUrl {
    protected WebDriver driver = null;

    public BaseUrl(WebDriver driver) {this.driver = driver;}
    public DarazHomePage loadUrl(String url){
        driver.get(url);
        return PageFactory.initElements(driver, DarazHomePage.class);
    }
    public void scrollPage(int x, int y){
        new Actions(driver).scrollByAmount(x, y).perform();
    }

}
