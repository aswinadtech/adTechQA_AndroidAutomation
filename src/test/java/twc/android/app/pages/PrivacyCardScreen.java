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


public class PrivacyCardScreen extends Functions {
	private CharlesProxy proxy;
	AppiumDriver<MobileElement> Ad;
	
	String radarCard_Xpath = "//XCUIElementTypeOther[@name='map-card-containerView']//XCUIElementTypeButton[@name='contentClickAction']";
	String closeLight_AccessibilityId = "close light";

	By byRadarCard = MobileBy.xpath(radarCard_Xpath);

	MobileElement radarCard = null;
	MobileElement closeLight = null;

	public PrivacyCardScreen(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}
	
	@Step("Navigate to Privacy Page")
	public void navigateToPrivacyPage(String Excelname, String sheetName) throws Exception {

	//	ReadExcelValues.excelValues(Excelname, sheetName);
		try {
			//Ad.findElementByName(ReadExcelValues.data[22][Cap]).click();
			Functions.waitForMilliSeconds(5000);
			attachScreen();
			System.out.println("Clicked on Privacy Card to navigate to Privacy page");
			logStep("Clicked on Privacy Card to navigate to Privacy page");
		} catch (Exception e) {

			try {
			//	Ad.findElementByName(ReadExcelValues.data[26][Cap]).click();
				Functions.waitForMilliSeconds(5000);
				attachScreen();
				System.out.println("Clicked on Privacy Card to navigate to Privacy page");
				logStep("Clicked on Privacy Card to navigate to Privacy page");
			} catch (Exception e1) {
				System.out.println("Cannot click on Privacy and Settings link on Privacy Card");
				logStep("Cannot click on Privacy and Settings link on Privacy Card");
				attachScreen();
				Assert.fail("Cannot click on Privacy and Settings link on Privacy Card");
			}
		}

	}
	
	@Step("Verify Privacy Card Options")
	public void verify_PrivacyCard_Options(String Excelname, String sheetName) throws Exception {
	//	ReadExcelValues.excelValues(Excelname, sheetName);
		String privacy_Optin_label = null;
		String privacy_Optout_label = null;
		String privacy_Optin_default_label = null;
		MobileElement privacy_Optout = null;
		MobileElement privacy_Optin = null;
		MobileElement privacy_Optin_default = null;
		try {
			navigateToPrivacyPage(Excelname, sheetName);
			System.out.println("Returned From 'Navigate to Privacy'");
			logStep("Returned From 'Navigate to Privacy'");
			Functions.waitForMilliSeconds(30000);
		} catch (Exception e) {
			System.out.println("An exception while navigating to Privacy Page");
			logStep("An exception while navigating to Privacy Page");
		}

		try {
			System.out.println("Current Context is: " + Ad.getContext());
			logStep("Current Context is: " + Ad.getContext());
			try {
				Ad.context("NATIVE_APP");
				System.out.println("Switching to Native App Context");
				logStep("Switching to Native App Context");
			} catch (Exception ex) {
				System.out.println("An Exception while Switching to Native App Context");
				logStep("An Exception while Switching to Native App Context");
			}
			Swipe();
			Swipe();
			Swipe();
			Functions.waitForMilliSeconds(5000);
			// swipe_Up();

			try {
				//privacy_Optin = Ad.findElementByXPath(ReadExcelValues.data[23][Cap]);
				privacy_Optin_label = privacy_Optin.getAttribute("name");
				try {
				
					privacy_Optout_label = privacy_Optout.getAttribute("name");
				} catch (Exception e) {
				//	privacy_Optout = Ad.findElementByXPath(ReadExcelValues.data[27][Cap]);
					privacy_Optout_label = privacy_Optout.getAttribute("name");
				}
				//privacy_Optin_default = Ad.findElementByXPath(ReadExcelValues.data[25][Cap]);
				privacy_Optin_default_label = privacy_Optin_default.getAttribute("value");
				if (!privacy_Optin_default_label.equalsIgnoreCase("1")) {
					System.out.println("By default Privacy Option is set to false");
					logStep("By default Privacy Option is set to false");
					attachScreen();
					Assert.fail("By default Privacy Option is set to false");
				} else {
					System.out.println("By default Privacy Option is set to true");
					logStep("By default Privacy Option is set to true");
				}
			} catch (Exception e) {
				System.out.println("Privacy feature options are not displayed on the Privacy Settings page");
				logStep("Privacy feature options are not displayed on the Privacy Settings page");
				attachScreen();
				Assert.fail("Privacy feature options are not displayed on the Privacy Settings page");
			}
		} catch (Exception e) {
			System.out.println(
					"There is an exception while validating Privacy feature options on the Privacy Settings page");
			logStep("There is an exception while validating Privacy feature options on the Privacy Settings page");
		} finally {
			navigateBackToFeedCard();
			attachScreen();
			/*
			 * if (!interStitialChecked) { handle_Interstitial_Ad(); }
			 */

		}
	}
	
	

}
