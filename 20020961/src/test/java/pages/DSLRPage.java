package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class DSLRPage extends BaseUrl{
    public DSLRPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//ul[@class='breadcrumb']/li[last()]")
    private WebElement lastBreadcrumbItem;

    @FindBy(xpath = "//input[contains(@placeholder, 'Max')]")
    private WebElement maxPrice;

    @FindBy(xpath = "//span[contains(@class, 'ant-btn-icon')]")
    private WebElement priceButton;

    @FindBy(xpath = "//span[contains(@class, 'ooOxS')]")
    private List<WebElement> filteredPrices;


    public Boolean lastBreadCrumbDSLR() {
        return lastBreadcrumbItem.getText().equals("DSLR");
    }

    public void enterMaxPrice(String maxPriceValue){
        maxPrice.clear();
        maxPrice.sendKeys(maxPriceValue);
    }
    public void clickPriceButton(){
        priceButton.click();
    }

    public List<Integer> getPriceList() {
        return filteredPrices.stream()
                .map(WebElement::getText)
                .map(text -> text.replace("Rs. ", "").replace(",", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Boolean checkPricesWithMax(int maxPrice, List<Integer> priceList){
        try{
            for (int price: priceList){
                Assert.assertTrue(price <= maxPrice, "Price " + price + " exceeds the maximum allowed value " + maxPrice);
            }
            return true;
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
