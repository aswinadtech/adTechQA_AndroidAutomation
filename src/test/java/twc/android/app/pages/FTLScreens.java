
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

public class FTLScreens  extends  TwcAndroidBaseTest {
	
	AppiumDriver<MobileElement> Ad;
	String NextButton_Id = "com.weather.Weather:id/ok_button";
	String closeButton_Id = "android:id/button2";
	String cancelButton_Name = "Cancel";
	String changeToAlwaysAllow_Name = "Change to Always Allow";
	String letsGoButton_AccessibilityId = "letsGoButton";
	String continueButton_AccessibilityId = "Continue";
	String allowButton_AccessibilityId = "Allow";
	String iUnderstand_Id = "com.weather.Weather:id/next_button_text";
	String oKButton_Name = "OK";
	String alwaysAllow_AccessibilityId = "Always Allow";
	String allowWhileUsingApp_Id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	
	By byNextButton = MobileBy.id(NextButton_Id);
	By byCloseButton = MobileBy.id(closeButton_Id);
	By byCancelButton = MobileBy.name(cancelButton_Name);
	By byChangeToAlwaysAllow = MobileBy.name(changeToAlwaysAllow_Name);
	By byLetsGoButton = MobileBy.AccessibilityId(letsGoButton_AccessibilityId);
	By byContinueButton = MobileBy.AccessibilityId(continueButton_AccessibilityId);
	By byAllow = MobileBy.AccessibilityId(allowButton_AccessibilityId);
	By byIUnderstand = MobileBy.id(iUnderstand_Id);
	By byOKButton = MobileBy.name(oKButton_Name);
	By byAlwaysAllow = MobileBy.AccessibilityId(alwaysAllow_AccessibilityId);
	By byAllowWhileUsingApp = MobileBy.id(allowWhileUsingApp_Id);
	
	
	MobileElement NextButton = null;
	MobileElement closeButton = null;
	MobileElement cancelButton = null;
	MobileElement changeToAlwaysAllow = null;
	MobileElement letsGoButton = null;
	MobileElement continueButton = null;
	MobileElement allowButton = null;
	MobileElement iUnderstand = null;
	MobileElement oKButton = null;
	MobileElement alwaysAllow = null;
	MobileElement allowWhileUsingApp = null;

	public FTLScreens(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}
	
	
	@Step("Handle Unwanted Popups during app launch")
	public void handle_Unwanted_Popups() throws Exception {

			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byNextButton);
				NextButton = Ad.findElement(byNextButton);
				Functions.clickOnElement(byNextButton, NextButton, "Next Button");
				System.out.println("Next Button available on the screen and handled");
				logStep("Next Button available on the screen and handled");
			} catch (Exception e) {
				System.out.println("Next Button not available on the screen and handled");
				logStep("Next Button not available on the screen and handled");
			}
			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byIUnderstand);
				letsGoButton = Ad.findElement(byIUnderstand);
				Functions.clickOnElement(byIUnderstand, iUnderstand, " i Understand button");
				System.out.println("i Understand button available on the screen and handled");
				logStep("i Understand button available on the screen and handled");
			} catch (Exception e) {
				System.out.println("i Understand not  button not available on the screen");
				logStep("i Understand button not available on the screen");
			}

			
	
			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byAllowWhileUsingApp);
				allowButton = Ad.findElement(byAllowWhileUsingApp);
				Functions.clickOnElement(byAllowWhileUsingApp, allowButton, "Allow Button");
				System.out.println("Allow button available on the App Tracking screen and handled");
				logStep("Allow button available on the App Tracking screen and handled");
			} catch (Exception e) {
				System.out.println("Allow button not available on the App Tracking screen");
				logStep("Allow button not available on the App Tracking screen");
			}
			/**
			 * on iPhone 7, we need to scroll on Location and Weatcher screen due to size of
			 * screen as privacy content increased, then only I Understand button enabled,
			 * else it is disabled.
			 */

			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byIUnderstand);
				iUnderstand = Ad.findElement(byIUnderstand);
				Functions.clickOnElement(byIUnderstand, iUnderstand, "iUnderstand Button");
				System.out.println("I Understand button available on the screen and handled");
				logStep("I Understand button available on the screen and handled");
				try {
					oKButton = Ad.findElement(byOKButton);
					Functions.clickOnElement(byOKButton, oKButton, "OK Button");
				    byIUnderstand = MobileBy.AccessibilityId("I Understand");
					iUnderstand = Ad.findElement(byIUnderstand);
					Functions.clickOnElement(byIUnderstand, iUnderstand, "iUnderstand Button");
					
				} catch (Exception e) {

				}

			} catch (Exception e) {
				System.out.println("I Understand button not available on the screen");
				logStep("I Understand button not available on the screen");
			}

			/**
			 * on iPhone 7, we need to scroll on Location and Weatcher screen due to size of
			 * screen as privacy content increased, then only I Understand button enabled,
			 * else it is disabled.
			 */

			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byIUnderstand);
				iUnderstand = Ad.findElement(byIUnderstand);
				Functions.clickOnElement(byIUnderstand, iUnderstand, "iUnderstand Button");
				System.out.println("I Understand button available on the screen and handled");
				logStep("I Understand button available on the screen and handled");
				try {
					oKButton = Ad.findElement(byOKButton);
					Functions.clickOnElement(byOKButton, oKButton, "OK Button");
				    byIUnderstand = MobileBy.AccessibilityId("I Understand");
					iUnderstand = Ad.findElement(byIUnderstand);
					Functions.clickOnElement(byIUnderstand, iUnderstand, "iUnderstand Button");
					
				} catch (Exception e) {

				}

			} catch (Exception e) {
				System.out.println("I Understand button not available on the screen");
				logStep("I Understand button not available on the screen");
			}

			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byAlwaysAllow);
				alwaysAllow = Ad.findElement(byAlwaysAllow);
				Functions.clickOnElement(byAlwaysAllow, alwaysAllow, "Always Allow Button");
				System.out.println("Always Allow button available on the screen and handled");
				logStep("Always Allow button available on the screen and handled");
			} catch (Exception e) {
				System.out.println("Always Allow button not available on the screen");
				logStep("Always Allow button not available on the screen");
			}
			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byAllowWhileUsingApp);
				allowWhileUsingApp = Ad.findElement(byAllowWhileUsingApp);
				Functions.clickOnElement(byAllowWhileUsingApp, allowWhileUsingApp, "Allow While Using App Button");
				System.out.println("Allow While Using App button available on the screen and handled");
				logStep("Allow While Using App button available on the screen and handled");
			} catch (Exception e) {
				System.out.println("Allow While Using App button not available on the screen");
				logStep("Allow While Using App button not available on the screen");
			}
			
				

			try {
				Functions.waitForVisibilityOfElementLocated(Ad, 40, byCloseButton);
				closeButton = Ad.findElement(byCloseButton);
				Functions.clickOnElement(byCloseButton, closeButton, "Close Button");
				System.out.println("Close Button displayed on the screen and handled");
				logStep("Close Button displayed on the screen and handled");
			} catch (Exception e) {
				System.out.println("Close Button not displayed on the screen");
				logStep("Close Button not displayed on the screen");
			}
		
	

	}

}
