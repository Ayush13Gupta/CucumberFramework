package runners;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

//import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;

//@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/resources/features/" }, glue = {
		"stepDefinitions" },  
plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
,monochrome = true
,publish = true)


public class MainRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() throws IOException {
		//Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
		//BasePage.copyLatestExtentReport();
	}
}