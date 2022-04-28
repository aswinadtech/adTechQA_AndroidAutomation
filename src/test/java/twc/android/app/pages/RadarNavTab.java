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


public class RadarNavTab extends Functions {
	private CharlesProxy proxy;
	AppiumDriver<MobileElement> Ad;
	
	String radarTab_AccessibilityId = "Radar Tab";
	String closeLight_AccessibilityId = "close light";

	By byRadarNavTab = MobileBy.AccessibilityId(radarTab_AccessibilityId);
	By byCloseLight = MobileBy.AccessibilityId(closeLight_AccessibilityId);

	MobileElement radarNavTab = null;
	MobileElement closeLight = null;
	
	
	public RadarNavTab(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}
	
	@Step("Navigate To Radar Tab")
	public void navigateToRadarTab() throws Exception {
		try {
			radarNavTab = Ad.findElement(byRadarNavTab);
			Functions.clickOnElement(byRadarNavTab, radarNavTab, "Radar Nav Tab");
			Functions.waitForMilliSeconds(10000);
			System.out.println("Navigated to Radar tab ");
			logStep("Navigated to Radar tab");
			attachScreen();

		} catch (Exception e) {
			System.out.println("Radar tab not displayed");
			logStep("Radar tab not displayed");
			attachScreen();
		}

	}

}
