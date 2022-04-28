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


public class HourlyNavTab extends Functions {
	
	AppiumDriver<MobileElement> Ad;
	String hourlyTab_AccessibilityId = "Hourly Tab";

	By byHourlyNavTab = MobileBy.AccessibilityId(hourlyTab_AccessibilityId);

	

	MobileElement hourlyNavTab = null;

	public HourlyNavTab(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}

	@Step("Navigate To Hourly Tab")
	public void navigateToHourlyTab() throws Exception {
		try {
			hourlyNavTab = Ad.findElement(byHourlyNavTab);
			Functions.clickOnElement(byHourlyNavTab, hourlyNavTab, "Hourly Nav Tab");
			Functions.waitForMilliSeconds(10000);
			System.out.println("Navigated to Hourly tab ");
			logStep("Navigated to Hourly tab");
			attachScreen();

		} catch (Exception e) {
			System.out.println("Hourly tab not displayed");
			logStep("Hourly tab not displayed");
			attachScreen();
		}
	}

	@Step("Navigate to Hourly tab and Handle Entry interstitial")
	public void navigateToHourlyTabAndHandleInterstitialAd() throws Exception {
		navigateToHourlyTab();
		/**
		 * Since Hourly has Entry Interstitial, handling it once navigated to Hourly Tab
		 */
		if (!interStitialDisplayed) {
			handle_Interstitial_Ad();
		} else {
			System.out.println("Interstitial Ad is already handled, hence not handling again");
			logStep("Interstitial Ad is already handled, hence not handling again");

		}

	}

}
