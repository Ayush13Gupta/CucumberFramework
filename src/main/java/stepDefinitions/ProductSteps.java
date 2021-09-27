package stepDefinitions;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import pageObjects.BasePage;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory {
	private Scenario Scenario;

	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws InterruptedException, IOException {
		getDriver().get(url);
	}

	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String locator) throws InterruptedException, IOException {
		Assert.fail();
		
		BasePage basePage = new BasePage(Scenario);
		basePage.WaitUntilWebElementIsVisibleUsingByLocator(By.cssSelector(locator));
		getDriver().findElement(By.cssSelector(locator)).click();
	}

	@Then("^user should be presented with a promo alert$")
	public void user_should_be_presented_with_a_promo_alert() throws InterruptedException, IOException  {
		productsPage.printSpecialOffersVoucherCode();
		productsPage.clickOnProceedButton_Popup();
	}

}
