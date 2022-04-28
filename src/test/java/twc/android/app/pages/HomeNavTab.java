package twc.android.app.pages;

import twc.Automation.General.TwcAndroidBaseTest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import twc.Automation.Driver.Drivers;
import twc.Automation.General.DeviceStatus;
import twc.Automation.General.Functions;
import twc.Automation.General.loginModule;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.HandleWithCharles.CharlesProxy;
import twc.Automation.ReadDataFromFile.read_excel_data;
import twc.Automation.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import twc.Automation.Driver.Drivers;
import twc.Automation.General.loginModule;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Automation.General.Utils;
import twc.Automation.General.TwcAndroidBaseTest;
import twc.Automation.General.Utils;

public class HomeNavTab  extends  Functions {
	
	AppiumDriver<MobileElement> Ad;
	String homeTab_AccessibilityId = "feedTab";
	String integratedMarqueeCard_AccessibilityId = "nextgen-integrated-marquee-card-containerView";
	

	By byFeedTab = MobileBy.AccessibilityId(homeTab_AccessibilityId);
	By byIntegratedMarqueeCard = MobileBy.AccessibilityId(integratedMarqueeCard_AccessibilityId);
	
	
	MobileElement feedTab = null;

	public HomeNavTab(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}
	
	@Step("Click on Home Tab")
	public void clickonHomeTab() throws Exception {
		try {
			feedTab = Ad.findElement(byFeedTab);
		Functions.clickOnElement(byFeedTab, feedTab, "Home Nav Tab");
		Functions.waitForMilliSeconds(5000);
			System.out.println("Clicked on Home tab ");
			logStep("Clicked on Home tab");
			attachScreen();

		} catch (Exception e) {
			System.out.println("Home Tab is not displayed, launching app");
			logStep("Home Tab is not displayed, launching app");
			attachScreen();
			AppFunctions.Kill_Launch_App();
		}
	}
	
	@Step("Click on Home Tab and Handle Interstitial")
	public void clickonHomeTabAndHandleInterstitialAd() throws Exception {
		try {
			feedTab = Ad.findElement(byFeedTab);
	Functions.clickOnElement(byFeedTab, feedTab, "Home Nav Tab");
			Functions.waitForMilliSeconds(5000);
			System.out.println("Clicked on Home tab ");
			logStep("Clicked on Home tab");
			attachScreen();
			/*
			 * Since Exit Interstitial displayed upon click on home tab, handling it once
			 * navigated to home Tab
			 */
			if (!interStitialDisplayed) {
				handle_Interstitial_Ad();
			} else {
				System.out.println("Interstitial Ad is already handled, hence not handling again");
				logStep("Interstitial Ad is already handled, hence not handling again");

			}

		} catch (Exception e) {
			System.out.println("Home Tab is not displayed, launching app");
			logStep("Home Tab is not displayed, launching app");
			attachScreen();
         AppFunctions.Kill_Launch_App();
		}
		// handle_Interstitial_Ad();
	}
	
	/**
	 * This method to be used to findout whether NextGen IM Ad displayed on the
	 * screen and set the flag 'nextGenIMadDisplayed' value
	 */
	@Step("Verify Whether NextGen IM Ad Displayed on HomeScreen and Set 'nextGenIMadDisplayed' flag accordingly")
	public void verifyForNextGenIMAdOnHomeScreen() {
		MobileElement currentCard = null;
		nextGenIMadDisplayed = false;
		try {
			//currentCard = Ad.findElementByAccessibilityId("nextgen-integrated-marquee-card-containerView");
			currentCard = Ad.findElement(byIntegratedMarqueeCard);
			nextGenIMadDisplayed = true;
		} catch (Exception e) {
			System.out.println("NextGen IM Card Not displayed");
			logStep("NextGen IM Card Not displayed");
		}
	}
	

}
