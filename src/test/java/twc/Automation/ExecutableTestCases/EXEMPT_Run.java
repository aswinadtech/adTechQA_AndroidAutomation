package twc.Automation.ExecutableTestCases;

import twc.Automation.General.TwcAndroidBaseTest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Description;
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
import twc.Automation.General.loginModule;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
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
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Automation.General.Functions;
import twc.Automation.General.TwcAndroidBaseTest;
import twc.Automation.General.Utils;

public class EXEMPT_Run  extends  TwcAndroidBaseTest {
	
	private static final String CONFIG_FILE_PATH ="enableExempt.config";
	private CharlesProxy proxy;
	private File configFile;
	public static String  ipAddress=null;
	public static String  portNumber=null;
	
	public static String  defaultPortNumber=properties.getProperty("PortNumber");
	public static String CurrentWifiName=null;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** EXEMPT Privacy Test Started");
		logStep("****** EXEMPT  Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableEXEMPT(CONFIG_FILE_PATH);
		this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

		this.proxy.startCharlesProxyWithUI();
		this.proxy.disableRewriting();
		this.proxy.stopRecording();
		this.proxy.disableMapLocal();
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (this.configFile != null) {
			this.configFile.delete();
		}
		this.proxy.disableRewriting();
		//this.proxy.quitCharlesProxy();
		
		System.out.println("****** EXEMPT   Privacy Test Ended");
		logStep("****** EXEMPT  Privacy Test Ended");
	}
	
	

	
	
	@Test(priority = 6000)
	public void preConditionsTest_for_EXEMPT()throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		this.proxy.clearCharlesSession();
		     Thread.sleep(100000);
		AppiumFunctions.LaunchAppWithFullReset();
		System.out.println("Launching the app with full reset");
		   AppFunctions.resetApp();
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();
			System.out.println("App launched ");
			//CharlesFunctions.archive_folder("charles");
		//this.proxy.clearCharlesSession();
		//     Thread.sleep(5000);	
		//AppFunctions.Kill_Launch_App();
	//AppiumFunctions.ClickonIUnderstand();
		attachScreen();
  Functions.clickOnVideos_tile();
		attachScreen();
                  Thread.sleep(80000);	
                  CharlesFunctions.archive_folder("Charles");
		this.proxy.getXml();
		CharlesFunctions.createXMLFileForCharlesSessionFile();
	}
	
	
	

	/*
	 * This method validates Lotame call for not present
	 */
	@Test(priority = 6002, enabled = true)
	@Description("Lotame Call verification")
	public void Verify_Lotame_Call_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("****** bcp.crwdcntrl.net Call test case Started");
		logStep("****** bcp.crwdcntrl.net Call test case Started");
		Utils.verifyAPICal("Smoke", "Lotame", false);

	}
		
	/*
	 * This method validates FACTUAL call for not present
	 */
	@Test(priority = 6004, enabled = true)
	@Description("Factual Call verification")
	public void Verify_LocationWFXTriggers_Call__for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("****** location.wfxtriggers.com Call test case Started");
		logStep("location.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "LocationWFX", false);

	}
	
	/*
	 * This method validates WFXTriggers call for present
	 */
	@Test(priority = 6006, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);

	}
	
	/**
	 * This method verifies Amazon call
	 * @throws Exception
	 */
	@Test(priority = 6008, enabled = true)
	@Description("Amazon aax call verification")
	public void Verify_Amazon_Call() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** amazon-adsystem.com Call test case Started");
		logStep("****** amazon-adsystem.com Call test case Started");
		Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
	}

	
	
	/*@Test(priority = 6010, enabled = true)
	@Description("Verify amazon aax Feed1 preload ad call")
	public void Verify_amazon_aax_feed1_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== amazon aax feed1 preload ad call ====================");

		System.out.println("****** amazon aax feed1 preload ad call validation Started");
		logStep("****** amazon aax feed1 preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

	}

	@Test(priority = 6012, enabled = true)
	@Description("Verify amazon aax Feed2 preload ad call")
	public void Verify_amazon_aax_feed2_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== amazon aax feed2 preload ad call ====================");

		System.out.println("****** amazon aax feed2 preload ad call validation Started");
		logStep("****** amazon aax feed2 preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

	}
	 
	
	@Test(priority = 6014, enabled = true)
	@Description("Verify amazon aax Feed3 preload ad call")
	public void Verify_amazon_aax_feed3_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== amazon aax feed3 preload ad call ====================");

		System.out.println("****** amazon aax feed3 preload ad call validation Started");
		logStep("****** amazon aax feed3 preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

	}
	
	@Test(priority = 6016, enabled = true)
	@Description("Verify amazon aax PreRollVideo preload ad call")
	public void Verify_amazon_aax_PreRollVideo_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== amazon PreRollVideo preload ad call ====================");

		System.out.println("****** amazon aax PreRollVideo preload ad call validation Started");
		logStep("****** amazon aax PreRollVideo preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

	}

	@Test(priority = 6018, enabled = true)
	@Description("Verify amazon aax map details preload ad call")
	public void Verify_amazon_aax_map_details_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== amazon aax map details preload ad call ====================");

		System.out.println("****** amazon aax Map details preload ad call validation Started");
		logStep("****** amazon aax Map details preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Map", false);

	}

	@Test(priority = 6020, enabled = true)
	@Description("Verify amazon aax Daily Details preload ad call")
	public void Verify_amazon_aax_Daily_details_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== amazon aax Daily Details preload ad call ====================");

		System.out.println("****** amazon aax Daily Details preload ad call validation Started");
		logStep("****** amazon aax Daily Details preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

	}

	@Test(priority = 6022, enabled = true)
	@Description("Verify amazon aax Hourly Details preload ad call")
	public void Verify_amazon_aax_Hourly_details_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly Details preload ad call ====================");

		System.out.println("****** amazon aax Hourly Details preload ad call validation Started");
		logStep("****** amazon aax Hourly Details preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Hourly", false);
	}
	
	@Test(priority = 6024, enabled = true)
	@Description("Verify amazon aax Hourly1 Details preload ad call")
	public void Verify_amazon_aax_Hourly1_details_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly1 Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly1 Details preload ad call validation Started");
		logStep("****** amazon aax Hourly1 Details preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Hourly1", false);
	}
	
	@Test(priority = 6026, enabled = true)
	@Description("Verify amazon aax Hourly2 Details preload ad call")
	public void Verify_amazon_aax_Hourly2_details_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly2 Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly2 Details preload ad call validation Started");
		logStep("****** amazon aax Hourly2 Details preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Hourly2", false);
	}
	
	@Test(priority = 6028, enabled = true)
	@Description("Verify amazon aax Hourly3 Details preload ad call")
	public void Verify_amazon_aax_Hourly3_details_adcall_for_EXEMPT()throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== amazon aax Hourly2 Details preload ad call ====================");
		System.out.println("****** amazon aax Hourly2 Details preload ad call validation Started");
		logStep("****** amazon aax Hourly3 Details preload ad call validation Started");
		//Utils.verifyAAX_SlotId("Smoke", "Hourly3", false);
	}*/
	

	/*
		 * This method validates Criteo Bidder API call for not present
		 */
		@Test(priority = 6030, enabled = true)
		@Description("Verify Criteo SDK inapp v2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_for_EXEMPT()throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
			System.out.println("****** Criteo SDK inapp/v2 call validation Started");
			logStep("****** Criteo SDK inapp/v2 call validation Started");
			Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

		}

		/*
		 * This method validates Criteo Initialization API call for not present
		 */
		@Test(priority = 6032, enabled = true)
		@Description("Verify Criteo SDK config app call")
		public void Verify_Criteo_SDK_config_app_Call_for_EXEMPT()throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK config/app call ====================");
			System.out.println("****** Criteo SDK config/app call validation Started");
			logStep("****** Criteo SDK config/app call validation Started");
			Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);
			CharlesFunctions.archive_folder("Charles");

		}
	


}
