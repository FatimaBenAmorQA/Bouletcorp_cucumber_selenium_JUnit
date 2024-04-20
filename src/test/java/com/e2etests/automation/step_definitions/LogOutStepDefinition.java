package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_object.LogOutPage;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutStepDefinition {

	private LogOutPage logOutPage;

	public LogOutStepDefinition() {
		this.logOutPage = new LogOutPage();
	}

	@When("Je clique sur le menu burger")
	public void jeCliqueSurLeMenuBurger() {
		logOutPage.clickLogOutButton();

	}

	@When("Je clique surle bouton Logout")
	public void jeCliqueSurleBoutonLogout() {
		logOutPage.clickLogOutButton();

	}

	@Then("Je me redirige vers la page d authentification {string}")
	public void jeMeRedirigeVersLaPageDAuthentification(String text) {
		String logOutMessage = LogOutPage.messageLogOut.getText();
		Assert.assertEquals(text, logOutMessage);
	}

	@When("Je clique surle bouton About")
	public void jeCliqueSurleBoutonAbout() {
		logOutPage.clickAboutOutButton();

	}

	@Then("Je me redirige vers la page About {string}")
	public void jeMeRedirigeVersLaPageAbout(String text) {
		String currentUrl = Setup.driver.getCurrentUrl();
		Assert.assertTrue(text, currentUrl.contains("saucelabs.com"));

	}

}
