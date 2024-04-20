package com.e2etests.automation.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;

public class LoginPage {

	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;

	/* @FindBy */

	@FindBy(how = How.ID, using = "user-name")
	public static WebElement inputUsername;

	@FindBy(how = How.ID, using = "password")
	public static WebElement inpuPassword;

	@FindBy(how = How.ID, using = "login-button")
	public static WebElement loginButton;

	@FindBy(how = How.TAG_NAME, using = "h3")
	public static WebElement errorMessage;

	@FindBy(how = How.CLASS_NAME, using = "title")
	public static WebElement SuccessLogin;

	public LoginPage() {
		PageFactory.initElements(Setup.driver, this);
		this.configFileReader = new ConfigFileReader();
	}

	/* @Create Method */

	public void goToUrl() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}

	public void fillUsername(String username) {
		inputUsername.sendKeys(username);
	}

	public void fillInvalidUsername(String invalidusername) {
		inputUsername.sendKeys(invalidusername);
	}

	public void fillPassword(String password) {
		inpuPassword.sendKeys(password);
	}

	public void fillInvalidPassword(String invalidpassword) {
		inpuPassword.sendKeys(invalidpassword);
	}

	public void fillWithEmptyPassword() {
		inpuPassword.clear();
	}

	public void fillWithEmptyUsername() {
		inpuPassword.clear();
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void login() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
		
		inputUsername.clear();
		inputUsername.sendKeys(configFileReader.getProperties("home.login"));
		
		inpuPassword.clear();
		inpuPassword.sendKeys(configFileReader.getProperties("home.password"));
		
		loginButton.click();
	}

	public void Nplogin() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));

		inputUsername.clear();
		inputUsername.sendKeys(configFileReader.getProperties("home.loginNp"));
		
		
		inpuPassword.clear();
		inpuPassword.sendKeys(configFileReader.getProperties("home.passwordNp"));
		
		loginButton.click();

	}
}
