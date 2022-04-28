package twc.android.app.pages;

import twc.Automation.General.TwcAndroidBaseTest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

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
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

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


public class DailyCardScreen extends Functions {
	private CharlesProxy proxy;
	static AppiumDriver<MobileElement> Ad;
	
	String dailyDetails_Id = "com.weather.Weather:id/daily_forecast_adapter_column";
	String dailyCardIFAd_Name = "weather.card.daily-adContentView";
	
	By byDailyDetails = MobileBy.id(dailyDetails_Id);
	By byDailyCardIFAd = MobileBy.AccessibilityId(dailyCardIFAd_Name);

	MobileElement dailyDetails = null;
	MobileElement toolTip = null;
	MobileElement dailyCardIFAd = null;
	
	public DailyCardScreen(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}
	
	@Step("Navigate To Daily Card Content Page")
	public void navigateToDailyCardContentPage() throws Exception {
		//MobileElement dailyDetails = Ad.findElementByAccessibilityId("dailyCollectionViewCell_0");
		try {
			dailyDetails = Ad.findElement(byDailyDetails);
			Functions.clickOnElement(byDailyDetails, dailyDetails, "Daily Details");
			Functions.waitForMilliSeconds(6000);
		} catch (Exception e) {
			System.out.println("daily details not displayed");
			logStep("daily details not displayed");
		}
		attachScreen();
		navigateBackToFeedCard();
		if (unlimitedInterstitial) {
			handle_Interstitial_Ad();
		} else {
			if (!interStitialDisplayed) {
				/*
				 * Since Exit Interstitial displayed upon click on back icon, handling it once
				 * click on back
				 */
				handle_Interstitial_Ad();
			} else {
				System.out.println("Interstitial Ad is already handled, hence not handling again");
				logStep("Interstitial Ad is already handled, hence not handling again");

			}
		}
	}
	
	@Step("Navigate To Daily Card Content Page And Not to Handle Interstitials")
	public void navigateToDailyCardContentPageAndDontHandleInterstitials() throws Exception {
		//MobileElement dailyDetails = Ad.findElementByAccessibilityId("dailyCollectionViewCell_0");
	
		// ScreenShot(cardName,"Passed");
		// attachScreen();
		try {
			dailyDetails = Ad.findElement(byDailyDetails);
			Functions.clickOnElement(byDailyDetails, dailyDetails, "Daily Details");
			Functions.waitForMilliSeconds(6000);

		} catch (Exception e) {
			System.out.println("Tooltip not displayed on daily details page");
			logStep("Tooltip not displayed on daily details page");
		}
		attachScreen();
	}
	
	
	/**
	 * Verify Daily IF Ad by response
	 * @param Excelname
	 * @param sheetName
	 * @throws Exception
	 */
	public void verifyDailyIFAd_byCallResponse(String Excelname, String sheetName) throws Exception {

		boolean iMCallResponse = Utils.isNextGenIMorIFCall_hasResponse(Excelname, sheetName);
		String cardName = "Dailycard";
		MobileElement adele;

		Thread.sleep(10000);
		if (iMCallResponse == true) {
			try {
				//adele = Ad.findElementByName("weather.card.daily-adContentView");
				dailyCardIFAd = Ad.findElement(byDailyCardIFAd);
				if (dailyCardIFAd.isDisplayed()) {
					logStep("Daily IF Ad presented on the page " + cardName + " :--- Sizes are " + dailyCardIFAd.getSize());
					System.out.println(
							"Daily IF Ad presented on the page " + cardName + " :--- Sizes are " + dailyCardIFAd.getSize());
					attachScreen();

				}

			} catch (Exception e) {
				System.out.println("Ad Not presented on the " + cardName + " screen though IF call response true");
				logStep("Ad Not presented on the " + cardName + " screen though IF call response true");
				attachScreen();
				Assert.fail("Ad Not presented on the " + cardName + " screen though IF call response true");
			}

		} else {
			try {
				//adele = Ad.findElementByName("weather.card.daily-adContentView");
				dailyCardIFAd = Ad.findElement(byDailyCardIFAd);
				if (dailyCardIFAd.isDisplayed()) {
					logStep("Daily IF Ad presented on the page " + cardName + " when response is false :--- Sizes are "
							+ dailyCardIFAd.getSize());
					System.out.println("Daily IF Ad presented on the page " + cardName
							+ " when response is false :--- Sizes are " + dailyCardIFAd.getSize());
					attachScreen();
					Assert.fail("Daily IF Ad presented on the page " + cardName + " when response is false");
				}

			} catch (Exception e) {
				System.out.println("Ad Not presented on the " + cardName + " screen since IF call response false");
				logStep("Ad Not presented on the " + cardName + " screen since IF call response false");
				attachScreen();

			}
		}

	}
}
