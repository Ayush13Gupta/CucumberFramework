package stepDefinitions;


import io. cucumber.java.*;

import pageObjects.BasePage;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() {
		driver = getDriver();
	}
	
	@After
	public void tearDownAndScreenshotOnFailure(io.cucumber.java.Scenario scenario) {
		try {
			if(driver != null && scenario.isFailed()) {
				//scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				BasePage.captureScreenshot(scenario);
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
			if(driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
}
}
