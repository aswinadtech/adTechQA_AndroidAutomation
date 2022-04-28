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


public class VideoNavTab extends Functions {
	private CharlesProxy proxy;
	AppiumDriver<MobileElement> Ad;
	String videoTab_AccessibilityId = "Videos Tab";
	String winterTab_AccessibilityId = "Winter Tab";
	By byVideoNavTab = MobileBy.AccessibilityId(videoTab_AccessibilityId);
	By byWinterNavTab = MobileBy.AccessibilityId(winterTab_AccessibilityId);
	MobileElement videoNavTab = null;
	public VideoNavTab(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
		
	}
	
	@Step("Navigate To Video Tab")
	public void navigateToVideoTab() throws Exception {
		try {
			videoNavTab = Ad.findElement(byVideoNavTab);
			Functions.clickOnElement(byVideoNavTab, videoNavTab, "Video Nav Tab");
			Functions.waitForMilliSeconds(20000);
			System.out.println("Navigated to Video tab ");
			logStep("Navigated to Video tab");
			attachScreen();
		} catch (Exception e) {
			try {
				videoNavTab = Ad.findElement(byWinterNavTab);
				Functions.clickOnElement(byWinterNavTab, videoNavTab, "Winter Nav Tab");
				Functions.waitForMilliSeconds(20000);
				System.out.println("Navigated to Winter tab ");
				logStep("Navigated to Winter tab");
				attachScreen();
			} catch (Exception ex) {
				System.out.println("Video tab not displayed");
				logStep("Video tab not displayed");
				attachScreen();
			}
		}

	}
	
	@Step("Navigate To Video Tab: {0}")
	public void navigateToVideoTab(boolean clearCharles, CharlesProxy proxy) throws Exception {
		try {
			videoNavTab = Ad.findElement(byVideoNavTab);
			if (clearCharles) {
				proxy.clearCharlesSession();
			}
			Functions.clickOnElement(byVideoNavTab, videoNavTab, "Video Nav Tab");
			Functions.waitForMilliSeconds(20000);
			System.out.println("Navigated to Video tab ");
			logStep("Navigated to Video tab");
			attachScreen();
		} catch (Exception e) {
			try {
				videoNavTab = Ad.findElement(byWinterNavTab);
				if (clearCharles) {
				proxy.clearCharlesSession();
				}
				Functions.clickOnElement(byWinterNavTab, videoNavTab, "Winter Nav Tab");
				Functions.waitForMilliSeconds(20000);
				System.out.println("Navigated to Winter tab ");
				logStep("Navigated to Winter tab");
				attachScreen();
			} catch (Exception ex) {
				System.out.println("Video tab not displayed");
				logStep("Video tab not displayed");
				attachScreen();
			}
		}

	}
	

}
