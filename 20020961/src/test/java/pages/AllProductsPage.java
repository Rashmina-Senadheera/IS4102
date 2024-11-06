package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage extends BaseUrl {
    public AllProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(), 'Categories')]")
    private WebElement categoriesDropDown;

    @FindBy(xpath = "//span[contains(text(), 'Electronic Devices')]")
    private WebElement electronicsDevices;

    @FindBy(xpath = "//span[contains(text(), 'Cameras')]")
    private WebElement camerasCategory;

    @FindBy(xpath = "//span[contains(text(), 'DSLR')]")
    private WebElement DSLRCamera;

    Actions actions = new Actions(driver);

    public void hoverCategories(){
        actions.moveToElement(categoriesDropDown).perform();
    }

    public void hoverOnElectronicDevices(){
        actions.moveToElement(electronicsDevices).perform();
    }

    public void hoverOnCameras(){
        actions.moveToElement(camerasCategory).perform();
    }

    public DSLRPage clickOnDSLR(){
        DSLRCamera.click();
        return PageFactory.initElements(driver, DSLRPage.class);
    }

}
