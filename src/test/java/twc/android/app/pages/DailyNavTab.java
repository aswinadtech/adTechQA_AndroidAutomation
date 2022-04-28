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


public class DailyNavTab extends Functions {
	private CharlesProxy proxy;
	AppiumDriver<MobileElement> Ad;
	
	String dailyTab_AccessibilityId = "Daily Tab";
	String tooltipClose_AccessibilityId = "tooltip close";
	String dynamicDailyCell_Xpath = "//XCUIElementTypeCell[@name='dailyCollectionViewCell_";
	//android.widget.FrameLayout[@content-desc="Daily Tab"]
	String iDDAd_Id = "com.weather.Weather:id/background_image_view";
	
	By byDailyNavTab = MobileBy.AccessibilityId(dailyTab_AccessibilityId);
	By byToolTip = MobileBy.AccessibilityId(tooltipClose_AccessibilityId);
	By byIDDAd = MobileBy.AccessibilityId(iDDAd_Id);
	

	MobileElement dailyNavTab = null;
	MobileElement toolTip = null;
	MobileElement dynamicDailyCell = null;
	MobileElement iDDAd = null;

	public DailyNavTab(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}

	
	@Step("Navigate To Daily Tab")
	public void navigateToDailyTab() throws Exception {
		try {
			dailyNavTab = Ad.findElement(byDailyNavTab);
		Functions.clickOnElement(byDailyNavTab, dailyNavTab, "Daily Nav Tab");
		Functions.waitForMilliSeconds(10000);
			System.out.println("Navigated to Daily tab ");
			logStep("Navigated to Daily tab");
			attachScreen();
		} catch (Exception e) {
			System.out.println("Daily tab not displayed");
			logStep("Daily tab not displayed");
			attachScreen();
		}

	}
	
	/**
	 * This method Validates Daily Details Ad Units of 15 days, navigating from Daily Nav Tab
	 * @param excelName
	 * @param sheetName
	 * @throws Exception
	 */
	@Step("Validate Daily Details Ad Units of 15 days, navigating from Daily Nav Tab: {0}, {1}")
	public void validateDailyDetailsAdUnits(String excelName, String sheetName) throws Exception {
		HomeNavTab hmtab = new HomeNavTab(Ad);
		DailyNavTab dtab = new DailyNavTab(Ad);
		String[][] data = read_excel_data.exceldataread(sheetName);

		String expected =data[11][1];
		ArrayList<String> namesOfDays = new ArrayList<String>();
		
		String ddWeekDayName = dailyDetailsDayOfWeek;
		System.out.println("ddWeekDayName :" + ddWeekDayName);
		logStep("ddWeekDayName :" + ddWeekDayName);
		int dayn = 0;
		switch (ddWeekDayName) {
		case "sun":
			dayn = 1;
			break;
		case "mon":
			dayn = 2;
			break;
		case "tue":
			dayn = 3;
			break;
		case "wed":
			dayn = 4;
			break;
		case "thu":
			dayn = 5;
			break;
		case "fri":
			dayn = 6;
			break;
		case "sat":
			dayn = 7;
			break;
		}
		for (int i = 1; i <= 7; i++) {
			// calendar.add(Calendar.DATE, 1);

			// int daynum = calendar.get(Calendar.DAY_OF_WEEK);
			int daynum = dayn;
			String dayName = "";
			if (daynum == 1 || daynum == 8) {
				dayName = "sun";
			} else if (daynum == 2 || daynum == 9) {
				dayName = "mon";
			} else if (daynum == 3 || daynum == 10) {
				dayName = "tue";
			} else if (daynum == 4 || daynum == 11) {
				dayName = "wed";
			} else if (daynum == 5 || daynum == 12) {
				dayName = "thu";
			} else if (daynum == 6 || daynum == 13) {
				dayName = "fri";
			} else if (daynum == 7 || daynum == 14) {
				dayName = "sat";
			}
			namesOfDays.add(dayName);
			System.out.println(dayName);
			logStep(dayName);
			dayn++;
		}
		System.out.println(namesOfDays);

		CharlesFunctions.archive_folder("Charles");
		hmtab.clickonHomeTab();
		this.proxy.clearCharlesSession();
		dtab.navigateToDailyTab();

		int j = 0;
		int k = 0;
		int l = 0;
		String dayNotPresent = "";
		int failCount = 0;
		for (int i = 0; i < 15; i++) {

			//Ad.findElementByXPath("//XCUIElementTypeCell[@name='dailyCollectionViewCell_" + i + "'" + "]").click();
			By byDynamicDailyCell = MobileBy.xpath(dynamicDailyCell_Xpath+ i + "'" + "]");
			dynamicDailyCell = Ad.findElement(byDynamicDailyCell);
			Functions.clickOnElement(byDynamicDailyCell, dynamicDailyCell, "Daily Cell "+i);
			// Functions.delete_folder("Charles");
			CharlesFunctions.archive_folder("Charles");
			Thread.sleep(10000);
			attachScreen();
			this.proxy.getXml();
			Utils.createXMLFileForCharlesSessionFile();
			// Read the content form file
			File fXmlFile = new File(CharlesFunctions.outfile.getName());
			// File fXmlFile = outfile;

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setValidating(false);
			dbFactory.setNamespaceAware(true);
			dbFactory.setFeature("http://xml.org/sax/features/namespaces", false);
			dbFactory.setFeature("http://xml.org/sax/features/validation", false);
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(fXmlFile);
			// Getting the transaction element by passing xpath expression
			// NodeList nodeList = doc.getElementsByTagName("transaction");
			String xpathExpression = "charles-session/transaction/@query";
			List<String> getQueryList = evaluateXPath(doc, xpathExpression);
			if (i < 7) {

				String cday = namesOfDays.get(j).concat("1");
				// cday.concat("_").concat("1");
				// System.out.println(cday);
				String expectediu = expected.concat("_") + cday;
				String iuId = expectediu;
				boolean iuExists = false;

				for (String qry : getQueryList) {
					if (qry.contains(iuId)) {

						iuExists = true;

						break;

					}
				}
				if (iuExists) {
					System.out.println(expectediu + " ad call is present");
					logStep(expectediu + " ad call is present");
				} else {
					System.out.println(expectediu + " ad call is not present");
					logStep(expectediu + " ad call is not present");
					failCount++;
					// Assert.fail(feedCards[i] + " ad call is not present");
					dayNotPresent = dayNotPresent.concat(cday + ", ");

				}

				j++;
			} else if (i < 14) {

				String cday = namesOfDays.get(k).concat("2");
				// cday.concat("_").concat("1");
				// System.out.println(cday);
				String expectediu = expected.concat("_") + cday;
				String iuId = expectediu;
				boolean iuExists = false;

				for (String qry : getQueryList) {
					if (qry.contains(iuId)) {

						iuExists = true;

						break;

					}
				}
				if (iuExists) {
					System.out.println(expectediu + " ad call is present");
					logStep(expectediu + " ad call is present");
				} else {
					System.out.println(expectediu + " ad call is not present");
					logStep(expectediu + " ad call is not present");
					failCount++;
					// Assert.fail(feedCards[i] + " ad call is not present");
					dayNotPresent = dayNotPresent.concat(cday + ", ");

				}

				k++;
			} else {
				String cday = namesOfDays.get(l).concat("3");
				// cday.concat("_").concat("1");
				// System.out.println(cday);
				String expectediu = expected.concat("_") + cday;
				String iuId = expectediu;
				boolean iuExists = false;

				for (String qry : getQueryList) {
					if (qry.contains(iuId)) {

						iuExists = true;

						break;

					}
				}
				if (iuExists) {
					System.out.println(expectediu + " ad call is present");
					logStep(expectediu + " ad call is present");
				} else {
					System.out.println(expectediu + " ad call is not present");
					logStep(expectediu + " ad call is not present");
					failCount++;
					// Assert.fail(feedCards[i] + " ad call is not present");
					dayNotPresent = dayNotPresent.concat(cday + ", ");

				}
				l++;
			}
			this.proxy.clearCharlesSession();
		}

		if (failCount > 0) {
			System.out.println(dayNotPresent + " ad call is not present");
			logStep(dayNotPresent + " ad call is not present");
			Exception = dayNotPresent + " ad call is not present";
			System.out.println("Daily Details ad units Verification is failed");
			logStep("Daily Details ad units Verification is failed");
			Assert.fail(Exception);
		}

	}
	private static List<String> evaluateXPath(Document document, String xpathExpression) throws Exception {
		// Create XPathFactory object
		XPathFactory xpathFactory = XPathFactory.newInstance();
		// Create XPath object
		XPath xpath = xpathFactory.newXPath();
		List<String> values = new ArrayList<String>();
		try {
			// Create XPathExpression object
			XPathExpression expr = xpath.compile(xpathExpression);
			NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++) {
				values.add(nodes.item(i).getNodeValue());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return values;
	}
	
	
	/**
	 * Verifies IDD ad by call response
	 * @param Excelname
	 * @param sheetName
	 * @throws Exception
	 */
	public void verifyIDDAd_byCallResponse(String Excelname, String sheetName) throws Exception {

		boolean iMCallResponse = Utils.isIDDCall_hasResponse(Excelname, sheetName);
		String cardName = "homescreen";
		MobileElement adele;
		MobileElement nextGenAdImage;

		Thread.sleep(10000);
		if (iMCallResponse == true) {
			try {
				//adele = Ad.findElementByAccessibilityId("PROTOTYPE GRIDS FOR IDD - w/CREATIVE");
				iDDAd = Ad.findElement(byIDDAd);
				
				if (iDDAd.isDisplayed()) {
					logStep("IDD Ad presented on the page ");
					System.out.println("IDD Ad presented on the page ");
					attachScreen();

				}

			} catch (Exception e) {
				System.out.println("IDD Ad Not presented on the screen though call response true");
				logStep("IDD Ad Not presented on the screen though call response true");
				attachScreen();
				Assert.fail("IDD Ad Not presented on the screen though call response true");
			}

		} else {
			try {
				//adele = Ad.findElementByAccessibilityId("PROTOTYPE GRIDS FOR IDD - w/CREATIVE");
				iDDAd = Ad.findElement(byIDDAd);
				if (iDDAd.isDisplayed()) {
					logStep("IDD Ad presented on the page when response is false");
					System.out.println("IDD Ad presented on the page when response is false");
					attachScreen();
					Assert.fail("IDD Ad presented on the page when response is false");
				}

			} catch (Exception e) {
				System.out.println("IDD Ad Not presented on the screen since call response false");
				logStep("IDD Ad Not presented on the screen since call response false");
				attachScreen();

			}
		}

	}
	

}
