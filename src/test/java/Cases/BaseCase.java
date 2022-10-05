package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCase {
    private final By acceptAdsObj = new By.ByCssSelector("#close-modal > button > span.mdc-button__label");

    private final By acceptCookiesObj = new By.ByCssSelector("body > sm-root > div > fe-product-cookie-indicator > div > div > button.mat-caption-normal.btn.accept-all.ng-tns-c259-0");

    private final By regionSelectionCloseButton = new By.ByCssSelector("#header-wrapper > div.header-middle.ng-tns-c303-1.ng-star-inserted > div > div > fa-icon > svg");

    private ChromeDriver chromeDriver;

    /*Wait until element be clickable then click to the element*/
    public void clickElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getChromeDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        getChromeDriver().findElement(locator).click();
    }

    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getChromeDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void handleSetting(By locator) {
        if (chromeDriver.findElement(locator).isDisplayed()) {
            clickElement(locator);
        }
    }

    public void acceptAds() {
        handleSetting(acceptAdsObj);
    }

    public void acceptCookies() {
        handleSetting(acceptCookiesObj);
    }

    public void rejectLocationPopup() {
        handleSetting(regionSelectionCloseButton);
    }

    public ChromeDriver getChromeDriver() {
        return chromeDriver;
    }

    public void setChromeDriver(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public By getAcceptAdsObj() {
        return acceptAdsObj;
    }
}
