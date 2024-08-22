package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#nav-logo-sprites")
    WebElement logo;

    @FindBy(css = "#twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(css = "#nav-search-submit-button")
    WebElement searchButton;

    @FindBy(css = "div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']")
    WebElement firstProduct;

    @FindBy(css = "#buy-now-button")
    WebElement buyNow;

    @FindBy(css ="input[value='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"attach-sidesheet-checkout-button-announce\"]")
    WebElement proceedToCheckoutButton1;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean ValidateVisibilityOfLogo(){
        wait.until(ExpectedConditions.visibilityOf(logo));
        return logo.isDisplayed();
    }

    public void searchProduct(){
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys("Boat headphones");
        searchButton.click();
    }

    public void clickFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(firstProduct));
        firstProduct.click();
    }

    public void clickBuyNow(){
        wait.until(ExpectedConditions.visibilityOf(buyNow));
        buyNow.click();
    }

}
