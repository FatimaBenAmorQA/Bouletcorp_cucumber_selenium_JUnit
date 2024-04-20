package com.e2etests.automation.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class BouletcorpPage {
	
	
	/* @FindBy */

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='à propos']")
	public static WebElement aProposBtn;

	@FindBy(how = How.XPATH, using = "//img[@src='/buttons/twitch.png']")
	public static WebElement twitchBtn;

	@FindBy(how = How.XPATH, using = "//img[@src='/buttons/masto.png']")
	public static WebElement mastoBtn;

	@FindBy(how = How.XPATH, using = "//img[@src='/buttons/insta.png']")
	public static WebElement instaBtn;
	
	public BouletcorpPage() {
		PageFactory.initElements(Setup.driver, this);
	}

}
