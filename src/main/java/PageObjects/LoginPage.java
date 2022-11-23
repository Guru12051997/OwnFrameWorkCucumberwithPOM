package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1.By locator
	private By emaidId = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By SignInButton = By.xpath("//input[@value='Login']");
	private By ForgotPwdLink = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");

	// 2.Constructor of the page

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.page actions : feature (behavior)of the Page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(ForgotPwdLink).isDisplayed();
	}

	public void EnterUserName(String username) {
		driver.findElement(emaidId).sendKeys(username);
	}

	public void EnterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void ClickOnLogin() {
		driver.findElement(SignInButton).click();
	}

}
