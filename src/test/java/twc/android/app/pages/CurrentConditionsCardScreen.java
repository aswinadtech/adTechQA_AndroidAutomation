package twc.android.app.pages;

import twc.Automation.General.TwcAndroidBaseTest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
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

public class CurrentConditionsCardScreen extends Functions {
	private CharlesProxy proxy;
	AppiumDriver<MobileElement> Ad;	
	String currentConditionCard_AccessibilityId = "current-condition-updated-card-containerView";
	By byCurrentConditioncard = MobileBy.AccessibilityId(currentConditionCard_AccessibilityId);
	MobileElement currentConditionCard = null;
	
	public CurrentConditionsCardScreen(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}

	@Step("Swipe Up on Current Condition Card")
	public void swipe_Up_CurrentConditionCard() throws Exception {
		int relativeY = 80;
		boolean iscurrentconditioncard = false;
		Dimension dimensions = Ad.manage().window().getSize();
		int startY11 = dimensions.getHeight();

		//MobileElement currentCard = null;
		try {
			currentConditionCard = Ad.findElement(byCurrentConditioncard);
			iscurrentconditioncard = true;
		} catch (Exception e) {
			System.out.println("Current Conditions Card Not displayed");
			logStep("Current Conditions Card Not displayed");
		}

		Dimension d = currentConditionCard.getSize();
		System.out.println("Current-Condition Card Height is : " + d.getHeight());
		logStep("Current-Condition Card Height is : " + d.getHeight());
		System.out.println("Current-Condition Card  Width is: " + d.getWidth());
		logStep("Current-Condition Card  Width is: " + d.getWidth());

		int startx = d.width / 2;
		Double startY1 = d.getHeight() * 0.00;
		startY = startY1.intValue();
		startY = 0;
		Double endY1 = (double) ((d.getHeight()) * 1); // dimensions.getHeight() 0.2; == 512.0
		endY = endY1.intValue();
		int reEndY = 0;
		int variance = 21;
		int absStartY = endY + variance + relativeY;
		TouchAction ta = new TouchAction(Ad);
		TouchAction ta1 = new TouchAction(Ad);

	}
	
	public MobileElement returnCurrentConditionCard(MobileElement element) {
		return element.findElement(byCurrentConditioncard);
	}
}
