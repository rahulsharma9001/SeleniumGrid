import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;

public class GridTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome");
        capability.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        capability.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),capability);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void validateVisibilityOfLogo(){
        homePage.ValidateVisibilityOfLogo();
    }

    @Test(priority = 2)
    public void searchFirstProduct(){
        homePage.searchProduct();
    }

    @Test(priority = 3)
    public void clickFirstProductFromSearchResult(){
        homePage.clickFirstProduct();
    }

    @Test(priority = 4)
    public void placeOrder(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        homePage.clickBuyNow();

    }


}
