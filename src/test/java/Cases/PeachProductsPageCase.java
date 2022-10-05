package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class PeachProductsPageCase extends BaseCase{
    private final By adressObj = new By.ByCssSelector("#header-wrapper > div.header-middle.ng-tns-c303-1.ng-star-inserted > sm-header-address-delivery-time > button > div > div > div");

    private final By deliveryOptionHomeObj = new By.ByCssSelector("#delivery-options-modal_home > mat-card > mat-card-content");

    private final By citiesObj = new By.ByCssSelector("#mat-select-value-1 > span");

    private final By districtObj = new By.ByCssSelector("#mat-select-value-3");

    private final By neighbourhoodObj = new By.ByCssSelector("#mat-select-value-5");

    private final By istanbulLocationObj=new By.ByCssSelector("#mat-option-1 > span");

    private final By atasehirObj = new By.ByCssSelector("#mat-option-84 > span");

    private final By ataturkObj = new By.ByCssSelector("#mat-option-122 > span");

    private final By searchBoxObj = new By.ByCssSelector("#product-search-combobox--trigger");

    private final By addToCartButtonsObj = new By.ByXPath("//*[@class='ng-fa-icon add-to-cart-button ng-star-inserted']");

    private final By productUrlBeforeCartObj = new By.ByXPath("//*[@class='mat-caption text-color-black product-name']");

    private final By productUrlAfterCartObj =new By.ByXPath("//*[@class='subtitle-2 text-color-black ng-star-inserted']");

    private By brandFiltersObj;

    private String beforeCartUrl;

    private String afterCartUrl;

    public void clickAdressButton() {
        clickElement(getChromeDriver().findElement(adressObj));
        clickElement(getChromeDriver().findElement(deliveryOptionHomeObj));
        clickElement(getChromeDriver().findElement(citiesObj));
        clickElement(getChromeDriver().findElement(istanbulLocationObj));
        clickElement(getChromeDriver().findElement(districtObj));
        clickElement(getChromeDriver().findElement(atasehirObj));
        clickElement(getChromeDriver().findElement(neighbourhoodObj));
        clickElement(getChromeDriver().findElement(ataturkObj));
    }

    public void searchAndPressEnter() throws InterruptedException {
        WebElement element = getChromeDriver().findElement(searchBoxObj);
        clickElement(element);
        element.sendKeys("Seftali");
        Thread.sleep(1500);
        element.sendKeys(Keys.ENTER);
    }

    /* Locator is added into the method to prevent array index out of bound error after the first brand selection. */
    public void selectBrandFilters() throws InterruptedException {
        brandFiltersObj = new By.ByXPath("//*[@class='mdc-checkbox__native-control mdc-checkbox--upgraded']");
        Thread.sleep(2000);
        List<WebElement> result = getChromeDriver().findElements(brandFiltersObj);
        result.get(new Random().nextInt(result.size()-1)).click();
    }

    public void getLastProductUrl() throws InterruptedException {
        List<WebElement> result = getChromeDriver().findElements(productUrlBeforeCartObj);
        WebElement element = result.get(result.size()-1);
        beforeCartUrl = element.getAttribute("href");
        Thread.sleep(1000);
    }

    public void chooseLastProduct() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> result = getChromeDriver().findElements(addToCartButtonsObj);
        clickElement(result.get(result.size()-1));
        Thread.sleep(2000);
    }

    public void navigateToCart() throws InterruptedException {
        getChromeDriver().navigate().to("https://www.migros.com.tr/sepetim");
        Thread.sleep(2000);
        WebElement productUrlElement = getChromeDriver().findElement(productUrlAfterCartObj);
        afterCartUrl=productUrlElement.getAttribute("href");
    }


    public String getBeforeCartUrl() {
        return beforeCartUrl;
    }

    public String getAfterCartUrl() {
        return afterCartUrl;
    }
}
