package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.*;
import utilities.DataProviderUtilities;
import utilities.Utilities;

import java.util.List;

public class DarazTest extends Utilities {
    int maxValue = 50000;

    @Test
    public void filterDSLR() throws InterruptedException {
        BaseUrl baseUrl = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        DarazHomePage homePage = baseUrl.loadUrl("https://www.daraz.lk/#?");
        Thread.sleep(1000);
        homePage.scrollPage(0,200);
        Thread.sleep(1000);
        AllProductsPage allProductsPage = homePage.clickOnAllProducts();
        Thread.sleep(1000);
        allProductsPage.hoverCategories();
        Thread.sleep(1000);
        allProductsPage.hoverOnElectronicDevices();
        Thread.sleep(1000);
        allProductsPage.hoverOnCameras();
        Thread.sleep(1000);
        DSLRPage dslrPage = allProductsPage.clickOnDSLR();
        Thread.sleep(2000);
        Boolean value = dslrPage.lastBreadCrumbDSLR();
        Thread.sleep(1000);
        if (value){
            dslrPage.scrollPage(0,200);
            Thread.sleep(1000);
            dslrPage.enterMaxPrice(String.valueOf(maxValue));
            Thread.sleep(1000);
            dslrPage.clickPriceButton();
            Thread.sleep(1000);
            List<Integer> prices = dslrPage.getPriceList();
            System.out.println("Prices less than "+maxValue +": " + prices);
            Thread.sleep(1000);
            dslrPage.checkPricesWithMax(maxValue, prices);
            Thread.sleep(1000);
        }else{
            System.out.println("Not on the DSLR page. Skipping further actions.");
        }
    }

    @Test
    public void searchWallets() throws InterruptedException {
        BaseUrl baseUrl = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        DarazHomePage homePage = baseUrl.loadUrl("https://www.daraz.lk/#?");
        Thread.sleep(1000);
        WalletPage walletPage = (WalletPage) homePage.searchPage("wallet");
        Thread.sleep(1000);
        walletPage.clickOnLouisWillBrand();
        Thread.sleep(1000);
        walletPage.clickOnSort();
        Thread.sleep(1000);
        walletPage.clickOnPriceLowToHigh();
        Thread.sleep(2000);
        List<Integer> prices = walletPage.getPriceList();
        System.out.println("Prices from low to high :" + prices);
        Thread.sleep(1000);
        Boolean sortLowToHigh = walletPage.checkPriceSortLowToHigh(prices);
        System.out.println(sortLowToHigh);
        Thread.sleep(1000);

    }

    @Test(dataProvider = "MinMaxData", dataProviderClass = DataProviderUtilities.class)
    public void testMinMaxValues(int min, int max) throws InterruptedException {
        BaseUrl baseUrl = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        DarazHomePage homePage = baseUrl.loadUrl("https://www.daraz.lk/#?");
        Thread.sleep(1000);
        PhonePage phonePage = (PhonePage) homePage.searchPage("phones");
        Thread.sleep(1000);
        phonePage.scrollPage(0,1000);
        Thread.sleep(1000);
        phonePage.enterMinMaxPrice(String.valueOf(min),String.valueOf(max));
        Thread.sleep(2000);
        phonePage.clickPriceButton();
        Thread.sleep(2000);
        List<Integer> prices = phonePage.getPriceList();
        Thread.sleep(1000);
        phonePage.checkPricesMinMax( min, max, prices);
        Thread.sleep(1000);


        System.out.println("Min: "+ min + " Max: " + max);
        System.out.println("Prices from "+ min +  " to " + max + " prices : " + prices);

    }
}
