package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_object.LoginPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	private LoginPage loginPage;
	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;


	
	public LoginStepDefinition() {
		this.loginPage = new LoginPage();
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
	}

	@Given("je suis sur la page de connexion Swag Labs")
	public void queJeSuisSurLaPageDeConnexionSwagLabs() {
		loginPage.goToUrl();
	}

	@When("je saisie le username valide {string}")
	public void jeSaisieLeUsernameValide(String username) {
		loginPage.fillUsername(username);
	}

	@When("je saisie le password valide {string}")
	public void jeSaisieLePasswordValide(String password) {
		loginPage.fillPassword(password);
	}

	@When("je clique sur le boutton login")
	public void jeCliqueSurLeBouttonLogin() {
		loginPage.clickOnLoginButton();
	}

	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String text) {
		String successMessage = LoginPage.SuccessLogin.getText();
		Assert.assertEquals(text, successMessage);

	}

	//Invalid connection with invalid username
	
	@When("je saisie le username invalide {string}")
	public void jeSaisieLeUsernameInvalide(String invalidUsername) {
		loginPage.fillInvalidUsername(invalidUsername);
	}
	
	
	@Then("Je me redirige vers un message d erreur {string}")
	public void jeMeRedirigeVersUnMessageDErreur(String text) {
		String errorMessage = LoginPage.errorMessage.getText();
		Assert.assertEquals(text, errorMessage);
	}
	
	
	//Invalid connection with invalid password

	@When("je saisie le password invalide {string}")
	public void jeSaisieLePasswordInvalide(String invalidPassword) {
		loginPage.fillInvalidPassword(invalidPassword);
	}
	
	//Invalid connection with empty password

	@When("je laisse le password vide {string}")
	public void jeLaisseLePasswordVide(String string) {
		loginPage.fillWithEmptyPassword();

	}

	//Invalid connection with empty username

	@When("je laisse le username vide {string}")
	public void jeLaisseLeUsernameVide(String string) {
		loginPage.fillWithEmptyUsername();
	}


	@Given("Je me connecte à l application web Swag Labs avec des identifiants incorrects")
	public void jeMeConnecteÀLApplicationWebSwagLabsAvecDesIdentifiantsIncorrects() throws InterruptedException {
		//loginPage.Nplogin();
		seleniumUtils.get(configFileReader.getProperties("home.url"));
		seleniumUtils.writeText(loginPage.inputUsername, configFileReader.getProperties("home.loginNp"));
		
		Long mediumWait =  seleniumUtils.getWait("MediumWait");
		Thread.sleep(mediumWait);
		
		seleniumUtils.writeText(loginPage.inpuPassword, configFileReader.getProperties("home.passwordNp"));
		seleniumUtils.click(loginPage.loginButton);


	}





	

}
