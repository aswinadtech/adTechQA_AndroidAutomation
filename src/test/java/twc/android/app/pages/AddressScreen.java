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


public class AddressScreen extends Functions {
	private CharlesProxy proxy;
	static AppiumDriver<MobileElement> Ad;
	
	
	String currentLocation_AccessibilityId = "Search";
	String addCityOrZIPCode_Id = "com.weather.Weather:id/txt_location_name";
	String searchBar_AccessibilityId = "searchBar";
	String searchForYourLocation_Id = "com.weather.Weather:id/txt_location_name";
	String cancel_Name =  "Cancel";
	String done_Name =  "Done";
	String done_Xpath =  "//XCUIElementTypeButton[@name='Done']";
	String search_Name = "Search";
	String eyeglassGrey_Xpath = "//XCUIElementTypeButton[@name='eyeglassGrey']";
	String settingsButton_AccessibilityId = "settingsButton";
	String locationSettingsDetailLabel_AccessibilityId = "location_settings_detail_label";
	String locationCell_Xpath = "//XCUIElementTypeCell[contains(@name,'Location')]";
	String neverLocation_Xpath = "//XCUIElementTypeCell[@name='Never']";
	String returnToTheWeather_AccessibilityId = "Return to The Weather";
	String labelCurrentLocation_Id = "label_currentLocation";
	String buttonLocationManagementClear_AccessibilityId = "button_locationManagementClear";
	String oK_AccessibilityId = "OK";
	
	By bySearchForYourLocation = MobileBy.id(searchForYourLocation_Id);
	By byCurrentLocation = MobileBy.AccessibilityId(currentLocation_AccessibilityId);
	By byAddCityOrZIPCode = MobileBy.id(addCityOrZIPCode_Id);
	By bySearchBar = MobileBy.AccessibilityId(searchBar_AccessibilityId);
	By byCancel = MobileBy.name(cancel_Name);
	By byDone = MobileBy.name(done_Name);
	By bySearch = MobileBy.name(search_Name);
	By byEyeglassGrey = MobileBy.xpath(eyeglassGrey_Xpath);
	By bySettingsButton = MobileBy.AccessibilityId(settingsButton_AccessibilityId);
	By byLocationSettingsDetailLabel = MobileBy.AccessibilityId(locationSettingsDetailLabel_AccessibilityId);
	By byLocationCell = MobileBy.xpath(locationCell_Xpath);
	By byNeverLocation = MobileBy.xpath(neverLocation_Xpath);
	By byReturnToTheWeather = MobileBy.AccessibilityId(returnToTheWeather_AccessibilityId);
	By byLabelCurrentLocation = MobileBy.id(labelCurrentLocation_Id);
	By byButtonLocationManagementClear = MobileBy.id(buttonLocationManagementClear_AccessibilityId);
	By byOK = MobileBy.id(oK_AccessibilityId);
	
	
	MobileElement searchForYourLocation = null;
	MobileElement cancel = null;
	MobileElement done = null;
	MobileElement search = null;
	MobileElement PresentAddress = null;
	MobileElement locationNameElement = null;
	MobileElement eyeglassGrey =  null;
	MobileElement settingsButton = null;
	MobileElement locationSettingsDetailLabel = null;
	MobileElement locationCell = null;
	MobileElement neverLocation = null;
	MobileElement returnToTheWeather = null;
	MobileElement labelCurrentLocation = null;
	MobileElement buttonLocationManagementClear = null;
	MobileElement oK = null;
	
	MobileElement allowButton = null;
	MobileElement iUnderstand = null;
	MobileElement oKButton = null;
	MobileElement alwaysAllow = null;
	MobileElement allowWhileUsingApp = null;

	public AddressScreen(AppiumDriver<MobileElement> Ad) throws Exception {
		this.Ad = Ad;
	
	
	}
	
	@Step("Select New Address Go With Default Location : {0} OR Select By Given Zip: {1} And Location Name: {2}")
	public void enternewAddress(boolean goWithDefaultLocation, String zip, String locationName) throws Exception {


		String PresentLocation = "Local Address";
		//WebElement PresentAddress = null;
		//MobileElement done = null;

		try {
			Functions.waitForMilliSeconds(5000);
			searchForYourLocation = Ad.findElement(bySearchForYourLocation);
			//Ad.findElementByXPath("//XCUIElementTypeButton[@name=\" Or search for your location\"]").click();
			Functions.clickOnElement(bySearchForYourLocation, searchForYourLocation, "Search For Your Location Link");
			
		} catch (Exception e) {
			System.out.println("Or search for your location button not available on the screen");
			logStep("Or search for your location button not available on the screen");
		}
		try {
			//PresentAddress = Ad.findElementByAccessibilityId("currentLocation");
			PresentAddress = Ad.findElement(byCurrentLocation);
			PresentLocation = PresentAddress.getAttribute("label");
			PresentLocation = PresentLocation.split(":")[1].trim();
			System.out.println("Current displayed location: " + PresentLocation);
			logStep("Current displayed location: " + PresentLocation);

		} catch (Exception e) {
			// PrsentLocation ="Local Address";
			System.out.println("PresentLocation =" + PresentLocation);
			logStep("PresentLocation =" + PresentLocation);
		}
		try {
			
			}
			catch(Exception e1) {
				
			}
			

	}
	
	
	public static void enter_requiredLocation(String location) throws Exception {
		new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementByAccessibilityId("Search")));	
	Ad.findElementByAccessibilityId("Search").click();
	new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.weather.Weather:id/search_text")));	
	Ad.findElementById("com.weather.Weather:id/search_text").sendKeys(location);
	Thread.sleep(10000);
	new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementById("com.weather.Weather:id/title")));	
	List<MobileElement> allLocations=Ad.findElementsById("com.weather.Weather:id/title");
	Thread.sleep(6000);

	//allLocations.get(0).getText();
	//System.out.println(allLocations.size());

	for(int i=0;i<=allLocations.size();i++) {


		if(location.contains("New York City")) {
			//System.out.println(loc.getText());
			if(allLocations.get(i).getText().contains("New York City")) {
				Thread.sleep(6000);
				allLocations.get(i).click();
			Thread.sleep(6000);
			attachScreen();
			break;
			}
		}
		
		if(location.contains("10010")) {
			//System.out.println(loc.getText());
			if(allLocations.get(i).getText().contains("New York City")) {
				Thread.sleep(6000);
				allLocations.get(i).click();
			Thread.sleep(6000);
			attachScreen();
			break;
			}
		}

		if(location.contains("07095")) {
			//System.out.println(loc.getText());
			if(allLocations.get(i).getText().contains("Woodbridge Township")) {
				Thread.sleep(6000);
				allLocations.get(i).click();
				Thread.sleep(6000);
			break;
			}
		}
		if(location.contains("73645")) {
			//System.out.println(loc.getText());
			if(allLocations.get(i).getText().contains("Eric")) {
				Thread.sleep(6000);
				allLocations.get(i).click();
				Thread.sleep(6000);
			break;
			}
		}
		
		if(location.contains("30124")) {
			//System.out.println(loc.getText());
			if(allLocations.get(i).getText().contains("Cave Spring")) {

				allLocations.get(i).click();
			Thread.sleep(3000);
			break;
			}
		}

		
		if(location.contains("08824")) {
			//System.out.println(loc.getText());
			if(allLocations.get(i).getText().contains("South Brunswick")) {

				allLocations.get(i).click();
			Thread.sleep(3000);
			break;
			}
		}
			
	}
	}
	
}

	


