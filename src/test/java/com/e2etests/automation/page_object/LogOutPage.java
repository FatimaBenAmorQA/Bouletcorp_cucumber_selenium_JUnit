package com.e2etests.automation.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class LogOutPage {

	private ConfigFileReader configFileReader;

	/* @FindBy */
	
	@FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']")
	public static WebElement burgerMenu;

	@FindBy(how = How.ID, using = "logout_sidebar_link")
	public static WebElement LogOutButton;
	
	@FindBy(how = How.ID, using = "about_sidebar_link")
	public static WebElement aboutButton;
	
	@FindBy(how = How.CLASS_NAME, using = "login_logo")
	public static WebElement messageLogOut;
	
	public LogOutPage() {
		PageFactory.initElements(Setup.driver, this);
		this.configFileReader = new ConfigFileReader();
	}

	/* @Create Method */

	public void goToUrl() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}

	public void clickBurgerButton() {
		Actions actions = new Actions(Setup.driver);
        actions.moveToElement(burgerMenu).click().perform();
      
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void clickLogOutButton() {
		LogOutButton.click();
	}
	
	public void clickAboutOutButton() {
		aboutButton.click();
	}
}
