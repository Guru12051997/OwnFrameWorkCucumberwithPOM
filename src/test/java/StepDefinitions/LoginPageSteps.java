package StepDefinitions;



import org.testng.Assert;

import Driver.DriverFactory;
import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	private static String hometitle;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitleName) {

		Assert.assertTrue(title.contains(ExpectedTitleName));
		//Assert.assertEquals(title, "Account Login");

	}
	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	System.out.println(	loginPage.isForgotPwdLinkExist());
	Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	
	}

	@When("user enters username {string}")
	public void user_enters_username(String urname) {
	 loginPage.EnterUserName(urname);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.EnterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.ClickOnLogin();
	}

	@Then("user home gets the title of the page")
	public void user_home_gets_the_title_of_the_page() {
		hometitle =loginPage.getLoginPageTitle();
	}

	@Then("Home page title should be {string}")
	public void home_page_title_should_be(String Homepagetitle) {
		Assert.assertTrue(hometitle.contains(Homepagetitle));
		Assert.assertEquals(title, "Account Login");

	}

}


