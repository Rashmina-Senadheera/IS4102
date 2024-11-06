package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class DarazHomePage extends BaseUrl{

    @FindBy(xpath = "//span[text()='SHOP ALL PRODUCTS']")
    private WebElement allProductsButton;

    @FindBy(xpath = "//input[@id='q']")
    private WebElement searchBox;

    public DarazHomePage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    public AllProductsPage clickOnAllProducts(){
        allProductsButton.click();
        return PageFactory.initElements(driver, AllProductsPage.class);
    }

    public Object searchPage(String searchText){
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);
        if (Objects.equals(searchText, "wallet")){
            return PageFactory.initElements(driver, WalletPage.class);
        }
        if(Objects.equals(searchText, "phones")){
            return PageFactory.initElements(driver, PhonePage.class);
        }
        else{
            return null;
        }
    }

}
