package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WalletPage extends BaseUrl {
    public WalletPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//span[contains(text(), 'LouisWill')]")
    private WebElement louisWillBrand;

    @FindBy(xpath = "//span[@class='ant-select-selection-item']")
    private WebElement sortBySpan;

    @FindBy(xpath = "//div[contains(text(), 'Price low to high')]")
    private WebElement priceLowToHigh;

    @FindBy(xpath = "//span[contains(@class, 'ooOxS')]")
    private List<WebElement> filteredPrices;

    public void clickOnLouisWillBrand(){
        louisWillBrand.click();
    }

    public void clickOnSort(){
        sortBySpan.click();
    }

    public void clickOnPriceLowToHigh(){
        priceLowToHigh.click();
    }

    public List<Integer> getPriceList() {
        return filteredPrices.stream()
                .map(WebElement::getText)
                .map(text -> text.replace("Rs. ", "").replace(",", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Boolean checkPriceSortLowToHigh(List<Integer> priceList){
        try {
            for (int i = 0; i < priceList.size() - 1; i++) {
                // Assert that each price is less than or equal to the next price
                Assert.assertTrue(priceList.get(i) <= priceList.get(i + 1),
                        "Price at index " + i + " (" + priceList.get(i) + ") is greater than the next price at index " + (i + 1) + " (" + priceList.get(i + 1) + ")");
            }
            return true;
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
