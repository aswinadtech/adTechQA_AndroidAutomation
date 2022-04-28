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

public class USA_Run extends  TwcAndroidBaseTest {
	private static final String CONFIG_FILE_PATH = "enableUSA.config";
	private static final String LGPD_CONFIG_FILE_PATH = "enableLGPD.config";
	private static final String GDPR_CONFIG_FILE_PATH ="enableGDPR.config";
	private static final String LATAMCO_CONFIG_FILE_PATH = "enableLATAMCO.config";
	private static final String SERBIA_CONFIG_FILE_PATH = "enableSerbia.config";
	private static final String USA_CONFIG_FILE_PATH = "enableUSA.config";
	
	private CharlesProxy proxy;
	private File configFile;
	
	
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** USA   Privacy Test Started");
		logStep("****** USA Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
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
		this.proxy.quitCharlesProxy();
		
		System.out.println("****** USA CCPA  Privacy Test Ended");
		logStep("****** USA CCPA  Privacy Test Ended");
	}

	@Test(priority = 1600)
	public void preConditionsTest_for_USA() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		this.proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
	    Thread.sleep(10000);	
		 Ad.resetApp();
		  Thread.sleep(60000);	
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();		
		  System.out.println("App launched ");
	 	this.proxy.clearCharlesSession();
		AppFunctions.Kill_Launch_App();
		AppiumFunctions.ClickonIUnderstand();
	
	}
	
	
	@Test(priority =1602, enabled = true)  
	  @Description("Verifying Privacy Card is present on the screen") public void
	 Verifying_PrivacyCard_PresenceonScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	 //AppiumFunctions.SwipeUp_Counter_privacy(25);
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 1604, enabled = true)	  
	  @Description("Selecting the  Do Not Sell My Information option  in the privacy card") 
	  public void Selecting_DoNotSellMyInformation_scenario() throws Exception {	  
	 System.out. println("=================Slecting Opt out mode scenario in privacy card testcase started =========================" );
	  Thread.sleep(10000); 
	  //Functions.selecting_opt_out_mode(); 
			  System.out.println("kill launch the app for two times");
		    Thread.sleep(20000);		
		  this.proxy.clearCharlesSession(); 
	  Thread.sleep(30000); 
	   AppFunctions.Kill_Launch_App();  
		this.proxy.clearCharlesSession();
	  System.out.println("================= Slecting Optout mode scenario in privacy card  testcase End =========================");	  
	  }
	  
	// DoNotSellMyInformation
		  @Test(priority = 1606, enabled = true)  
		  @Description("Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information") 
		  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_Privacy_DoNotSellMyInformation()  throws Exception {  
		  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information"); 
		  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy test case  started =========================");
			  this.proxy.clearCharlesSession();
		  AppFunctions.Kill_Launch_App();  
		   AppFunctions.click_radar_element();
		   Thread.sleep(10000);	
			Functions.clickOnVideos_tile();
			    Thread.sleep(80000);		
			 CharlesFunctions.archive_folder("Charles");
			this.proxy.getXml();
		    Thread.sleep(80000);		
			CharlesFunctions.createXMLFileForCharlesSessionFile();
			Utils.verifyAPICal("Smoke", "Lotame", false);
		  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy test case End =========================");	  
		  }
	
			@Test(priority = 1608, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout");
				logStep("Verify NextGen IM Adcall sod value when privacy optout");				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}
			
			

			@Test(priority = 1610, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Verify maps details Call sod value when privacy optout");
				logStep("Verify maps details Call sod value when privacy optout");
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");
			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1612, enabled = true)
			@Description("Amazon aax call verification when privacy optout")
			public void Verify_Amazon_Call_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

		

			/*@Test(priority = 1614, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax feed1 preload ad call validation Started when privacy optout");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout");
				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1616, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax feed2 preload ad call validation Started when privacy optout");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout");
				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1618, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax feed3 preload ad call validation Started when privacy optout");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout");				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}

		

			@Test(priority = 1620, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1622, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax Map details preload ad call validation Started when privacy optout");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1624, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout ====================");

				System.out.println("****** amazon aax Daily Details ad call validation Started when privacy optout");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1626, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout====================");

				System.out.println("****** amazon aax Hourly Details ad call validation Started when privacy optout");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout");
				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1628, enabled = true)
			@Description("Lotame Call when privacy optout")
			public void Verify_Lotame_Call_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** bcp.crwdcntrl.net Call test case Started when privacy optout");
				logStep("****** bcp.crwdcntrl.net Call test case Started when privacy optout");
				Utils.verifyAPICal("Smoke", "Lotame", false);
			}

			// FACTUAL Test cases
			/*
			 * Factual call is blocked, hence expected to not present this call in charles
			 * session from 12.6 builds onwards...
			 */

			@Test(priority = 1630, enabled = true)
			@Description("Factual Call when privacy optout")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** location.wfxtriggers.com Call test case Started when privacy optout");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);
			}
			
			/*
			 * This method validates WFXTriggers call
			 */
			@Test(priority = 1632, enabled = true)
			@Description("WFXTrigger Call when privacy optout")
			public void Verify_WFXTriggers_Call_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** triggers.wfxtriggers.com Call test case Started when privacy optout");
				logStep("****** triggers.wfxtriggers.com Call test case Started when privacy optout");
				Utils.verifyAPICal("Smoke", "WFXTrigger", true);

			}

			

			@Test(priority = 1634, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USA() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}
			@Test(priority = 1636, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGenIM Call rdp value when privacy optout");
				logStep("Validating NextGenIM Call rdp value when privacy optout ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1638, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout ====================");
				System.out.println("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1640, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout====================");
				System.out.println("****** Criteo SDK config/app call when privacy optout validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);
			}

			@Test(priority = 1642, enabled = true)
			@Description("Deriving Video Call when privacy optout")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USA() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall For USA when privacy optout");
				logStep("****** Deriving VideoCall For USA when privacy optout");
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1644, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Prerol-video Call sod value when privacy optout");
				logStep("Verify Prerol-video Call sod value when privacy optout");
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1646, enabled = true)
			@Description("Validating PrerollVideo Call rdp value when privacy optout")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating PrerollVideo Call rdp value when privacy optout");
				logStep("Validating PrerollVideo Call rdp value when privacy optout ");
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PrerollVideo", true);			
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			
			@Test(priority = 1648, enabled = true)
			@Description("Enabling Preconfiguration for USA To LGPD Travel Scenario")
			public void enable_PreConfiguration_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USA To LGPD Travel Scenario");
				logStep("Enable Preconfiguration for USA To LGPD Travel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableLGPD(LGPD_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, LGPD_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1650, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USA To LGPD Travel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USA To LGPD Travel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USA To LGPD Travel Scenario");
				this.proxy.clearCharlesSession();
				  AppFunctions.Kill_Launch_App();  
				  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					   AppFunctions.Kill_Launch_App();  
						  AppFunctions.Kill_Launch_App();
						   AppFunctions.Kill_Launch_App();  
							  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					  this.proxy.clearCharlesSession();
					  AppFunctions.Kill_Launch_App();  
					  AppFunctions.Kill_Launch_App();
					   Thread.sleep(10000);
					   AppFunctions.click_radar_element();
					   Thread.sleep(5000);
                   Functions.clickOnVideos_tile();
					   Thread.sleep(80000);	
				Thread.sleep(80000);
				Thread.sleep(80000);
					   CharlesFunctions.archive_folder("Charles");
					this.proxy.getXml();
					CharlesFunctions.createXMLFileForCharlesSessionFile();

			}
			
			@Test(priority = 1652, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USA To LGPD Travel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To LGPD Travel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To LGPD Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1654, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USA To LGPD Travel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USA To LGPD Travel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USA To LGPD Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1656, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

	

			/*@Test(priority = 1660, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USA To LGPD Travel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1662, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1664, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1666, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1668, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1670, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1672, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To LGPD Travel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1674, enabled = true)
			@Description("Lotame Call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USA To LGPD Travel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1676, enabled = true)
			@Description("Factual Call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To LGPD Travel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	
	@Test(priority = 1677, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1678, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USA To LGPD Travel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To LGPD Travel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USA To LGPD Travel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1680, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USATo_LGPD_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1682, enabled = true)
			@Description("Validating NextGen IM Call npa value for USA To LGPD Travel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USA To LGPD Travel Scenario");
				logStep("Validating NextGen IM Call npa value for USA To LGPD Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1684, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To LGPD Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA To LGPD Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To LGPD Travel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1686, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USA To LGPD Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA To LGPD Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA To LGPD Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA To LGPD Travel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1688, enabled = true)
			@Description("Deriving Video Call when privacy optout for USA To LGPD Travel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USA To LGPD Travel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1690, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To LGPD Travel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USA To LGPD Travel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USA To LGPD Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1692, enabled = true)
			@Description("Validating Video Call npa value for USA To LGPD Travel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USA To LGPD Travel Scenario");
				logStep("Validating Video Call npa value for USA To LGPD Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1694, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USA To LGPD Travel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USA To LGPD Travel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To LGPD Travel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			
			
			@Test(priority = 1700, enabled = true)
			@Description("Enabling Preconfiguration for USA To GDPR Travel Scenario")
			public void enable_PreConfiguration_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USA To GDPR Travel Scenario");
				logStep("Enable Preconfiguration for USA To GDPR Travel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableGDPR(GDPR_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, GDPR_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1702, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USA To GDPR Travel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USA To GDPR Travel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USA To GDPR Travel Scenario");
				this.proxy.clearCharlesSession();
				  AppFunctions.Kill_Launch_App();  
				  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					   AppFunctions.Kill_Launch_App();  
						  AppFunctions.Kill_Launch_App();
						   AppFunctions.Kill_Launch_App();  
							  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					  this.proxy.clearCharlesSession();
					  AppFunctions.Kill_Launch_App();  
					  AppFunctions.Kill_Launch_App();
					   Thread.sleep(10000);
					   AppFunctions.click_radar_element();
					   Thread.sleep(5000);
		           Functions.clickOnVideos_tile();
					   Thread.sleep(80000);	
				Thread.sleep(80000);
				Thread.sleep(80000);
					   CharlesFunctions.archive_folder("Charles");
					this.proxy.getXml();
					CharlesFunctions.createXMLFileForCharlesSessionFile();

			}
			
			@Test(priority = 1704, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USA To GDPR Travel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To GDPR Travel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To GDPR Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1706, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USA To GDPR Travel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USA To GDPR Travel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USA To GDPR Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1708, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

		

			/*@Test(priority = 1710, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USA To GDPR Travel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1712, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1714, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1716, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1718, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1720, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1722, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To GDPR Travel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1724, enabled = true)
			@Description("Lotame Call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USA To GDPR Travel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1726, enabled = true)
			@Description("Factual Call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To GDPR Travel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	
	@Test(priority = 1727, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1728, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USA To GDPR Travel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To GDPR Travel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USA To GDPR Travel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1730, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USATo_GDPR_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1732, enabled = true)
			@Description("Validating NextGen IM Call npa value for USA To GDPR Travel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USA To GDPR Travel Scenario");
				logStep("Validating NextGen IM Call npa value for USA To GDPR Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1734, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To GDPR Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA To GDPR Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To GDPR Travel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1736, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USA To GDPR Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA To GDPR Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA To GDPR Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA To GDPR Travel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1738, enabled = true)
			@Description("Deriving Video Call when privacy optout for USA To GDPR Travel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USA To GDPR Travel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1740, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To GDPR Travel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USA To GDPR Travel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USA To GDPR Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1742, enabled = true)
			@Description("Validating Video Call npa value for USA To GDPR Travel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USA To GDPR Travel Scenario");
				logStep("Validating Video Call npa value for USA To GDPR Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1746, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USA To GDPR Travel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USA To GDPR Travel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To GDPR Travel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			@Test(priority = 1748, enabled = true)
			@Description("Enabling Preconfiguration for USA To SERBIA Travel Scenario")
			public void enable_PreConfiguration_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USA To SERBIA Travel Scenario");
				logStep("Enable Preconfiguration for USA To SERBIA Travel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableSERBIA(SERBIA_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, SERBIA_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1750, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USA To SERBIA Travel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USA To SERBIA Travel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USA To SERBIA Travel Scenario");
				this.proxy.clearCharlesSession();
				  AppFunctions.Kill_Launch_App();  
				  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					   AppFunctions.Kill_Launch_App();  
						  AppFunctions.Kill_Launch_App();
						   AppFunctions.Kill_Launch_App();  
							  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					  this.proxy.clearCharlesSession();
					  AppFunctions.Kill_Launch_App();  
					  AppFunctions.Kill_Launch_App();
					   Thread.sleep(10000);
					   AppFunctions.click_radar_element();
					   Thread.sleep(5000);
		           Functions.clickOnVideos_tile();
					   Thread.sleep(80000);	
				Thread.sleep(80000);
				Thread.sleep(80000);
					   CharlesFunctions.archive_folder("Charles");
					this.proxy.getXml();
					CharlesFunctions.createXMLFileForCharlesSessionFile();

			}
			
			@Test(priority = 1752, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USA To SERBIA Travel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To SERBIA Travel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To SERBIA Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1754, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USA To SERBIA Travel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USA To SERBIA Travel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USA To SERBIA Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1756, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

			

			/*@Test(priority = 1758, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USA To SERBIA Travel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1760, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1762, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1764, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1766, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1768, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1770, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To SERBIA Travel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1772, enabled = true)
			@Description("Lotame Call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USA To SERBIA Travel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1774, enabled = true)
			@Description("Factual Call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To SERBIA Travel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	@Test(priority = 1775, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1776, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USA To SERBIA Travel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To SERBIA Travel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USA To SERBIA Travel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1778, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USATo_SERBIA_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1780, enabled = true)
			@Description("Validating NextGen IM Call npa value for USA To SERBIA Travel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USA To SERBIA Travel Scenario");
				logStep("Validating NextGen IM Call npa value for USA To SERBIA Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1782, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To SERBIA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA To SERBIA Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To SERBIA Travel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1784, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USA To SERBIA Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA To SERBIA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA To SERBIA Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA To SERBIA Travel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1786, enabled = true)
			@Description("Deriving Video Call when privacy optout for USA To SERBIA Travel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USA To SERBIA Travel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1788, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To SERBIA Travel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USA To SERBIA Travel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USA To SERBIA Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1790, enabled = true)
			@Description("Validating Video Call npa value for USA To SERBIA Travel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USA To SERBIA Travel Scenario");
				logStep("Validating Video Call npa value for USA To SERBIA Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1792, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USA To SERBIA Travel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USA To SERBIA Travel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To SERBIA Travel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			
			@Test(priority = 1794, enabled = true)
			@Description("Enabling Preconfiguration for USA To LATAMCOTravel Scenario")
			public void enable_PreConfiguration_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USA To LATAMCOTravel Scenario");
				logStep("Enable Preconfiguration for USA To LATAMCOTravel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableLATAMCO(LATAMCO_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, LATAMCO_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1796, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USA To LATAMCOTravel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USA To LATAMCOTravel Scenario");
				this.proxy.clearCharlesSession();
				  AppFunctions.Kill_Launch_App();  
				  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					   AppFunctions.Kill_Launch_App();  
						  AppFunctions.Kill_Launch_App();
						   AppFunctions.Kill_Launch_App();  
							  AppFunctions.Kill_Launch_App();
					   Thread.sleep(5000);
					  this.proxy.clearCharlesSession();
					  AppFunctions.Kill_Launch_App();  
					  AppFunctions.Kill_Launch_App();
					   Thread.sleep(10000);
					   AppFunctions.click_radar_element();
					   Thread.sleep(5000);
		           Functions.clickOnVideos_tile();
					   Thread.sleep(80000);	
				Thread.sleep(80000);
				Thread.sleep(80000);
					   CharlesFunctions.archive_folder("Charles");
					this.proxy.getXml();
					CharlesFunctions.createXMLFileForCharlesSessionFile();

			}
			
			@Test(priority = 1798, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USA To LATAMCOTravel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USA To LATAMCOTravel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1800, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USA To LATAMCOTravel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USA To LATAMCOTravel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1802, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USA To LATAMCOTravel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

	

			/*@Test(priority = 1804, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USA To LATAMCOTravel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1806, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1808, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1810, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1812, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1814, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1816, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USA To LATAMCOTravel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1818, enabled = true)
			@Description("Lotame Call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USA To LATAMCOTravel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1820, enabled = true)
			@Description("Factual Call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USA To LATAMCOTravel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	@Test(priority = 1821, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario()throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1822, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USA To LATAMCOTravel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USA To LATAMCOTravel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1824, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USATo_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1826, enabled = true)
			@Description("Validating NextGen IM Call npa value for USA To LATAMCOTravel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USA To LATAMCOTravel Scenario");
				logStep("Validating NextGen IM Call npa value for USA To LATAMCOTravel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1828, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA To LATAMCOTravel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA To LATAMCOTravel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA To LATAMCOTravel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1830, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USA To LATAMCOTravel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA To LATAMCOTravel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA To LATAMCOTravel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA To LATAMCOTravel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1832, enabled = true)
			@Description("Deriving Video Call when privacy optout for USA To LATAMCOTravel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USA To LATAMCOTravel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1834, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USA To LATAMCOTravel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USA To LATAMCOTravel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1836, enabled = true)
			@Description("Validating Video Call npa value for USA To LATAMCOTravel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USA To LATAMCOTravel Scenario");
				logStep("Validating Video Call npa value for USA To LATAMCOTravel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1838, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USA To LATAMCOTravel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USA To LATAMCOTravel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USA To LATAMCOTravel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			

			
			@Test(priority = 1900, enabled = true)
			public void preConditionsTest_for_USA_Selecting_StandardAdvertisingSettings() throws Exception {
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
				this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

				this.proxy.startCharlesProxyWithUI();
				this.proxy.disableMapLocal();
				this.proxy.enableRewriting();
          	         this.proxy.startRecording();
	               this.proxy.clearCharlesSession();
			//	Functions.close_launchApp();
				//Utils.navigateToAllCards(false);
			//	Utils.createXMLFileForCharlesSessionFile();
			}
 
 
 
  
  @Test(priority =1902, enabled = true)	  
  @Description("Selecting the  Standard Advertising Settings  in the privacy card") public void
  Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
  logStep("Selecting the Standard Advertising Settings  in the privacy card");
 System.out. println("=================Slecting Standard Advertising Settings  in privacy card testcase started =========================");
Ad.resetApp();
Thread.sleep(100000);	 
	  AppFunctions.Kill_Launch_App();
	//CharlesFunctions.archive_folder("charles");
  Thread.sleep(100000);	  
 // AppiumFunctions.SwipeUp_Counter_privacy(25);
  Thread.sleep(40000); 
 // Functions.selecting_opt_in_mode();
	   Thread.sleep(40000); 		  	
	  AppFunctions.Kill_Launch_App();
	this.proxy.clearCharlesSession();
  AppFunctions.Kill_Launch_App();
	this.proxy.clearCharlesSession();
  System.out.println("================= Slecting Standard Advertising Settings  in privacy card  testcase End ========================="); 
  }
  


  
  @Test(priority = 1904, enabled = true)	  
  @Description("Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings")
  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_presence_USA_Privacy_StandardAdvertisingSettings() throws  Exception { 
  logStep("Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings" ); 
  System.out.println("=================Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");	  
	this.proxy.clearCharlesSession();
	  AppFunctions.Kill_Launch_App();
	  AppFunctions.Kill_Launch_App();
	   Thread.sleep(40000); 		  
	   AppFunctions.click_radar_element();	
       Functions.clickOnVideos_tile();
	   Thread.sleep(80000);
		// CharlesFunctions.archive_folder("Charles");
		this.proxy.getXml();		
	    Thread.sleep(80000);		
	CharlesFunctions.createXMLFileForCharlesSessionFile();
		//Utils.verifyAPICal("Smoke", "Lotame", true);
  System.out.println("================= Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
  
  }
  
  
	@Test(priority = 1906, enabled = true)
	@Description("Verifying Home screen marquee ad call")
	public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USA_optin() throws Exception {
		System.out.println(
				"================= verifying iu value for home screen marquee test case started =========================");	
	
		//Utils.verifyPubadCal("Smoke", "Marquee");

		System.out.println(
				"================= verifying iu value for home screen marquee test case End =========================");
	}

  @Test(priority = 1908, enabled = true)
	@Description("Verify NextGen IM ad call sod value when privacy optin")
	public void validate_NextGen_IM_Adcall_sod_val_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		// Functions.retryclear();

		System.out.println("****** Verify NextGen IM Adcall sod value when privacy optin");
		logStep("Verify NextGen IM Adcall sod value when privacy optin");
		//Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "yes");

	}

	

	@Test(priority = 1910, enabled = true)
	@Description("Verify maps details page Call sod value when privacy optin")
	public void verify_maps_details_call_sod_val_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");

		System.out.println("****** Verify maps details Call sod value when privacy optin");
		logStep("Verify maps details Call sod value when privacy optin");
		//Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "yes");

	}

	

	@Test(priority = 1912, enabled = true)
	@Description("Verify amazon aax Feed1 preload ad call when privacy optin")
	public void Verify_amazon_aax_feed1_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax feed1 preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax feed1 preload ad call validation Started when privacy optin");
		logStep("****** amazon aax feed1 preload ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Feed1", true);

	}

	@Test(priority = 1914, enabled = true)
	@Description("Verify amazon aax Feed2 preload ad call when privacy optin")
	public void Verify_amazon_aax_feed2_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax feed2 preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax feed2 preload ad call validation Started when privacy optin");
		logStep("****** amazon aax feed2 preload ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Feed2", true);

	}

	@Test(priority = 1916, enabled = true)
	@Description("Verify amazon aax Feed3 preload ad call when privacy optin")
	public void Verify_amazon_aax_feed3_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax feed3 preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax feed3 preload ad call validation Started when privacy optin");
		logStep("****** amazon aax feed3 preload ad call validation Started when privacy optin");
		
		////Utils.verifyAAX_SlotId("Smoke", "Feed3", true);

	}



	@Test(priority = 1918, enabled = true)
	@Description("Verify amazon aax PreRollVideo preload ad call when privacy optin")
	public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon PreRollVideo preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax PreRollVideo preload ad call validation Started when privacy optin");
		logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optin");
		
		////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", true);

	}

	@Test(priority = 1920, enabled = true)
	@Description("Verify amazon aax map details preload ad call when privacy optin")
	public void Verify_amazon_aax_map_details_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax map details preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax Map details preload ad call validation Started when privacy optin");
		logStep("****** amazon aax Map details preload ad call validation Started when privacy optin");
		
		////Utils.verifyAAX_SlotId("Smoke", "Map", true);

	}

	@Test(priority = 1922, enabled = true)
	@Description("Verify amazon aax Daily Details ad call when privacy optin")
	public void Verify_amazon_aax_Daily_details_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax Daily Details  ad call when privacy optin ====================");

		System.out.println("****** amazon aax Daily Details ad call validation Started when privacy optin");
		logStep("****** amazon aax Daily Details ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", true);

	}

	@Test(priority = 1924, enabled = true)
	@Description("Verify amazon aax Hourly Details ad call when privacy optin")
	public void Verify_amazon_aax_Hourly_details_adcall_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax Hourly Details  ad call when privacy optin====================");

		System.out.println("****** amazon aax Hourly Details ad call validation Started when privacy optin");
		logStep("****** amazon aax Hourly Details ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Hourly", true);

	}

	// Lotame Test case
	@Test(priority = 1926, enabled = true)
	@Description("Lotame Call when privacy optin")
	public void Verify_Lotame_call_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** bcp.crwdcntrl.net Call test case Started when privacy optin");
		logStep("****** bcp.crwdcntrl.net Call test case Started when privacy optin");

	//	Utils.verifyAPICal("Smoke", "Lotame", true);

	}

	// FACTUAL Test cases
	/*
	 * Factual call is blocked, hence expected to not present this call in charles
	 * session from 12.6 builds onwards...
	 */

	@Test(priority = 1928, enabled = true)
	@Description("Factual Call when privacy optin")
	public void Verify_LocationWFXTriggers_Call_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** location.wfxtriggers.com Call test case Started when privacy optin");
		logStep("location.wfxtriggers.com Call test case Started when privacy optin");
		//Utils.verifyAPICal("Smoke", "LocationWFX", false);

	}
	
	/*
	 * This method validates WFXTriggers call
	 */
	@Test(priority = 1930, enabled = true)
	@Description("WFXTrigger Call when privacy optin")
	public void Verify_WFXTriggers_Call_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started when privacy optin");
		logStep("****** triggers.wfxtriggers.com Call test case Started when privacy optin");
		//Utils.verifyAPICal("Smoke", "WFXTrigger", true);

	}

	

	@Test(priority = 1934, enabled = true)
	@Description("Verify Criteo SDK inapp v2 call when privacy optin")
	public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== Criteo SDK inapp/v2 call when privacy optin====================");
		System.out.println("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
		logStep("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
	//	Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", true);

	}

	@Test(priority = 1936, enabled = true)
	@Description("Verify Criteo SDK config app call when privacy optin")
	public void Verify_Criteo_SDK_config_app_Call_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== Criteo SDK config/app call when privacy optin====================");
		System.out.println("****** Criteo SDK config/app call when privacy optin validation Started");
		logStep("****** Criteo SDK config/app call when privacy optin validation Started");
	//	Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", true);

	}

	@Test(priority = 1938, enabled = true)
	@Description("Deriving Video Call when privacy optin")
	public void derive_VideoCall_IU_when_Privacy_optin_for_USA() throws Exception {

		System.out.println("==============================================");
		System.out.println("****** Deriving VideoCall For USA when privacy optin");
		logStep("****** Deriving VideoCall For USA when privacy optin");
		//Utils.verifyPubadCal("Smoke", "PreRollVideo");
	}

	@Test(priority = 1940, enabled = true)
	@Description("Verify Preroll ad on Video Call sod value when privacy optin")
	public void verify_PrerollAd_call_sod_val_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");

		System.out.println("****** Prerol-video Call sod value when privacy optin");
		logStep("Verify Prerol-video Call sod value when privacy optin");
		//Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "yes");

	}

	@Test(priority = 1942, enabled = true)
	@Description("Validating PrerollVideo Call rdp value when privacy optin")
	public void validate_PrerollVideo_call_rdp_val_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating PrerollVideo Call rdp value when privacy optin");
		logStep("Validating PrerollVideo Call rdp value when privacy optin ");

		//Utils.validate_rdp_val_in_gampad_url("Smoke", "PrerollVideo", false);

	}
	
	
	@Test(priority = 1944, enabled = true)
	@Description("Validating marquee Call rdp value when privacy optin")
	public void validate_marquee_call_rdp_val_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating marquee Call rdp value when privacy optin");
		logStep("Validating marquee Call rdp value when privacy optin ");

		//Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", false);

	}
	
	@Test(priority = 1946, enabled = true)
	@Description("Validating maps details Call rdp value when privacy optin")
	public void validate_mapsdetails_call_rdp_val_privacy_optin_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating maps details Call rdp value when privacy optin");
		logStep("Validating maps details Call rdp value when privacy optin ");

		//Utils.validate_rdp_val_in_gampad_url("Smoke", "Map", false);
		 CharlesFunctions.archive_folder("Charles");

	}



	
		

}
