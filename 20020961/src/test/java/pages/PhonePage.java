package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class PhonePage extends BaseUrl {
    public PhonePage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//span[contains(@class, 'ooOxS')]")
    private List<WebElement> filteredPrices;

    @FindBy(xpath = "//input[contains(@placeholder, 'Max')]")
    private WebElement maxPrice;

    @FindBy(xpath = "//input[contains(@placeholder, 'Min')]")
    private WebElement minPrice;

    @FindBy(xpath = "//span[contains(@class, 'ant-btn-icon')]")
    private WebElement priceButton;

    public void enterMinMaxPrice(String min, String max){
        minPrice.clear();
        maxPrice.clear();
        minPrice.sendKeys(min);
        maxPrice.sendKeys(max);
    }

    public void clickPriceButton(){
        priceButton.click();
    }

    public List<Integer> getPriceList() {
        return filteredPrices.stream()
                .map(WebElement::getText)
                .map(text -> text.replace("Rs. ", "").replace(",", ""))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public Boolean checkPricesMinMax(int minPrice, int maxPrice, List<Integer> priceList){
        try{
            for(int price: priceList){
                Assert.assertTrue(price >= minPrice && price <= maxPrice, "Price " + price + "is not in the selected Range");
            }
            return true;
        }catch (AssertionError e){
            System.out.print(e.getMessage());
            return false;
        }
    }
}
