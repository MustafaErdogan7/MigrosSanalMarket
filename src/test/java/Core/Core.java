package Core;

import Cases.BaseCase;
import Cases.PeachProductsPageCase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Core {
    BaseCase baseCase = new BaseCase();
    PeachProductsPageCase peachProductsPageCase = new PeachProductsPageCase();
    @Before
    public void testStarter(){
        RunCucumberTest runCucumberTest = new RunCucumberTest();
        runCucumberTest.setChromeDriversPath();
        baseCase.setChromeDriver(new ChromeDriver());
        peachProductsPageCase.setChromeDriver(baseCase.getChromeDriver());
    }

    @After
    public void stopTest() { baseCase.getChromeDriver().close(); }

    @Given("Go to {string}")
    public void goTo(String url) {
        baseCase.getChromeDriver().get(url);
        WebDriverWait wait = new WebDriverWait(baseCase.getChromeDriver(), 10); // WebDriverWait used to wait until page load.
        wait.until(ExpectedConditions.elementToBeClickable(baseCase.getAcceptAdsObj()));
    }

    @Then("Do screen settings")
    public void doSettings() {
        baseCase.acceptAds();
        baseCase.acceptCookies();
        baseCase.rejectLocationPopup();
    }

    @Then("Set current location")
    public void setAdress()  {
        peachProductsPageCase.clickAdressButton();
    }

    @Then("Search text and Submit")
    public void searh() throws InterruptedException {
        peachProductsPageCase.searchAndPressEnter();
    }

    @Then("Select two brands randomly")
    public void filtre() throws InterruptedException {
        peachProductsPageCase.selectBrandFilters();
        peachProductsPageCase.selectBrandFilters();
    }

    @Then("Click last product on product page")
    public void lastProduct() throws InterruptedException {
        peachProductsPageCase.chooseLastProduct();
    }

    @Then("Go to cart")
    public void goToCart() throws InterruptedException {
        peachProductsPageCase.getLastProductUrl();
        peachProductsPageCase.navigateToCart();
    }

    @Then("Compare products")
    public void compareProductUrls()  {
        Assert.assertEquals(peachProductsPageCase.getBeforeCartUrl(),peachProductsPageCase.getAfterCartUrl());
    }
}
