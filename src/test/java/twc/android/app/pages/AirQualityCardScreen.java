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


public class AirQualityCardScreen extends Functions {
	private CharlesProxy proxy;
	AppiumDriver<MobileElement> Ad;
	
	String aQCard_Id = "com.weather.Weather:id/call_to_action_button";
	By byAQCard = MobileBy.id(aQCard_Id);
	MobileElement aQCard = null;

	

	@Step("Navigate To AirQuality Card Content Page")
	public void navigateToAirQualityCardContentPage() throws Exception {
		aQCard = Ad.findElement(byAQCard);
		Functions.clickOnElement(byAQCard, aQCard, "AQ Card Details");
		Functions.waitForMilliSeconds(6000);
		attachScreen();
		navigateBackToFeedCard();
		if (unlimitedInterstitial) {
			handle_Interstitial_Ad();
		}
	}
	
	@Step("Navigate To AirQuality Card Content Page And Not to Handle Interstitials")
	public void navigateToAirQualityCardContentPageAndDontHandleInterstitials() throws Exception {
		aQCard = Ad.findElement(byAQCard);
		Functions.clickOnElement(byAQCard, aQCard, "AQ Card Details");
		Functions.waitForMilliSeconds(6000);
		attachScreen();
	}
	
}
