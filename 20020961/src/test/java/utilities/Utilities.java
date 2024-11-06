package utilities;

import org.testng.annotations.*;

public class Utilities {
    protected BrowserFactory browserFactory;
    private long suiteStartTime;

    @BeforeTest
    public void initializeBrowser(){browserFactory = BrowserFactory.getBrowserFactory();}

    @AfterTest
    public void closeBrowser(){browserFactory.getDriver().quit();}

    @BeforeSuite
    public void beforeSuite() {
        suiteStartTime = System.currentTimeMillis();
        System.out.println("Test suite started.");
    }

    @AfterSuite
    public void afterSuite() {
        long suiteEndTime = System.currentTimeMillis();
        long duration = suiteEndTime - suiteStartTime;

        long minutes = (duration / 1000) / 60;
        long seconds = (duration / 1000) % 60;

        System.out.println("Test suite completed.");
        System.out.println("Total time taken for test suite: " + minutes + " minutes and " + seconds + " seconds.");
    }
}
