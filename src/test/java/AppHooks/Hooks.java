package AppHooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Driver.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@BeforeMethod
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@BeforeMethod
	@Before(order = 1)
	public void LaunchBrowser() {
		String BrowserName = prop.getProperty("browser");

		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(BrowserName);

	}

	@AfterMethod
	@After(order = 0)
public void quitBrowser() {
	driver.quit();
}

	@AfterMethod
	@After(order = 1)
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			// takeScreenShot

			String ScreenshotName = scenario.getName().replaceAll(" ", "_");

			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenshotName);

		}
	}

}
