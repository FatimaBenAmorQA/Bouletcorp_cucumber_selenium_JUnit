package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_object.BouletcorpPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnée;
import io.cucumber.java.fr.Quand;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Assert;


public class BouletcorpStepDefinition {
	
	private BouletcorpPage bouletcorpPage;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private ConfigFileReader configFileReader;
	
	public BouletcorpStepDefinition() {
		this.bouletcorpPage = new BouletcorpPage();
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
	}
	

	@Etantdonnée("je me rends sur le site boulecorp {string}")
	public void jeMeRendsSurLeSiteBoulecorp(String url) {
			seleniumUtils.get(configFileReader.getProperties("bouletcorp.url"));
	}
	
	@Quand("je clique sur Apropos")
	public void jeCliqueSurApropos() {
		seleniumUtils.click(bouletcorpPage.aProposBtn);
	}
	
	@Alors("la page a changé")
	public void laPageAChangé() {
		validations.assertNotEquals(seleniumUtils.getCurrentUrl(), configFileReader.getProperties("bouletcorp.url"));
	}
	
	
	@Alors("les widgets facebook, twitter et tumblr sont bien affichés")
	public void lesWidgetsFacebookTwitterEtTumblrSontBienAffichés() {
		//boolean twitch = bouletcorpPage.twitchBtn.isDisplayed();
		//Assert.assertTrue(twitch);
		validations.assertTrueBoolean(bouletcorpPage.twitchBtn);
		validations.assertTrueBoolean(bouletcorpPage.instaBtn);
		validations.assertTrueBoolean(bouletcorpPage.mastoBtn);

		
	}




}
