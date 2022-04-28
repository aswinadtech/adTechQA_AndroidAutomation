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

public class USA_CCPA_Run extends  TwcAndroidBaseTest {
	private static final String CONFIG_FILE_PATH = "enableUSACCPA.config";
	private static final String LGPD_CONFIG_FILE_PATH = "enableLGPD.config";
	private static final String GDPR_CONFIG_FILE_PATH ="enableGDPR.config";
	private static final String LATAMCO_CONFIG_FILE_PATH = "enableLATAMCO.config";
	private static final String SERBIA_CONFIG_FILE_PATH = "enableSerbia.config";
	private static final String USA_CONFIG_FILE_PATH = "enableUSA.config";
	
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** USA CCPA  Privacy Test Started");
		logStep("****** LGPD Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableUSACCPA(CONFIG_FILE_PATH);
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
	
	@Test(priority = 1000)
	public void preConditionsTest_for_USA_CCPA() throws Exception {
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
	
	
	@Test(priority =1002, enabled = true)  
	  @Description("Verifying Privacy Card is present on the screen") public void
	 Verifying_PrivacyCard_PresenceonScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	 //AppiumFunctions.SwipeUp_Counter_privacy(25);
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 1004, enabled = true)	  
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
		  @Test(priority = 1006, enabled = true)  
		  @Description("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
		  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation()  throws Exception {  
		  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information"); 
		  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
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
		  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case End =========================");	  
		  }
	
			@Test(priority = 1008, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout");
				logStep("Verify NextGen IM Adcall sod value when privacy optout");				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}
			
			

			@Test(priority = 1010, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Verify maps details Call sod value when privacy optout");
				logStep("Verify maps details Call sod value when privacy optout");
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");
			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1012, enabled = true)
			@Description("Amazon aax call verification when privacy optout")
			public void Verify_Amazon_Call_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

		

			/*@Test(priority = 1015, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax feed1 preload ad call validation Started when privacy optout");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout");
				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1016, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax feed2 preload ad call validation Started when privacy optout");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout");
				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1018, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax feed3 preload ad call validation Started when privacy optout");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout");				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}

		

			@Test(priority = 1020, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1022, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout ====================");

				System.out.println("****** amazon aax Map details preload ad call validation Started when privacy optout");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1024, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout ====================");

				System.out.println("****** amazon aax Daily Details ad call validation Started when privacy optout");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1026, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout====================");

				System.out.println("****** amazon aax Hourly Details ad call validation Started when privacy optout");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout");
				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1028, enabled = true)
			@Description("Lotame Call when privacy optout")
			public void Verify_Lotame_Call_privacy_optout_for_USACCPA() throws Exception {
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

			@Test(priority = 1030, enabled = true)
			@Description("Factual Call when privacy optout")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** location.wfxtriggers.com Call test case Started when privacy optout");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);
			}
			
			/*
			 * This method validates WFXTriggers call
			 */
			@Test(priority = 1032, enabled = true)
			@Description("WFXTrigger Call when privacy optout")
			public void Verify_WFXTriggers_Call_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** triggers.wfxtriggers.com Call test case Started when privacy optout");
				logStep("****** triggers.wfxtriggers.com Call test case Started when privacy optout");
				Utils.verifyAPICal("Smoke", "WFXTrigger", true);

			}

			

			@Test(priority = 1034, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USACCPA() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}
			@Test(priority = 1036, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGenIM Call rdp value when privacy optout");
				logStep("Validating NextGenIM Call rdp value when privacy optout ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1038, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout ====================");
				System.out.println("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1040, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout====================");
				System.out.println("****** Criteo SDK config/app call when privacy optout validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);
			}

			@Test(priority = 1042, enabled = true)
			@Description("Deriving Video Call when privacy optout")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USACCPA() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall For USACCPA when privacy optout");
				logStep("****** Deriving VideoCall For USACCPA when privacy optout");
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1044, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USACCPA() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Prerol-video Call sod value when privacy optout");
				logStep("Verify Prerol-video Call sod value when privacy optout");
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1046, enabled = true)
			@Description("Validating PrerollVideo Call rdp value when privacy optout")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USACCPA() throws Exception {
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
			
			@Test(priority = 1048, enabled = true)
			@Description("Enabling Preconfiguration for USACCPA To LGPD Travel Scenario")
			public void enable_PreConfiguration_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USACCPA To LGPD Travel Scenario");
				logStep("Enable Preconfiguration for USACCPA To LGPD Travel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableLGPD(LGPD_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, LGPD_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1050, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USACCPA To LGPD Travel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USACCPA To LGPD Travel Scenario");
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
					   Thread.sleep(10000);
                   Functions.clickOnVideos_tile();
					   Thread.sleep(80000);	
				       Thread.sleep(80000);	
				Thread.sleep(80000);
					   CharlesFunctions.archive_folder("Charles");
					this.proxy.getXml();
					CharlesFunctions.createXMLFileForCharlesSessionFile();

			}
			
			@Test(priority = 1052, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USACCPA To LGPD Travel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USACCPA To LGPD Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1054, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USACCPA To LGPD Travel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USACCPA To LGPD Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1056, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To LGPD Travel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

	

			/*@Test(priority = 1060, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USACCPA To LGPD Travel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1062, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USACCPA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1064, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USACCPA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1066, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USACCPA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1068, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USACCPA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1070, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USACCPA To LGPD Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1072, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USACCPA To LGPD Travel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To LGPD Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1074, enabled = true)
			@Description("Lotame Call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USACCPA To LGPD Travel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1076, enabled = true)
			@Description("Factual Call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To LGPD Travel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	
	@Test(priority = 1077, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}

			@Test(priority = 1078, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USACCPA To LGPD Travel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USACCPA To LGPD Travel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1080, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USACCPATo_LGPD_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1082, enabled = true)
			@Description("Validating NextGen IM Call npa value for USACCPA To LGPD Travel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USACCPA To LGPD Travel Scenario");
				logStep("Validating NextGen IM Call npa value for USACCPA To LGPD Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1084, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA To LGPD Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To LGPD Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To LGPD Travel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1086, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USACCPA To LGPD Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USACCPA To LGPD Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USACCPA To LGPD Travel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1088, enabled = true)
			@Description("Deriving Video Call when privacy optout for USACCPA To LGPD Travel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USACCPA To LGPD Travel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1090, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USACCPA To LGPD Travel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USACCPA To LGPD Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1092, enabled = true)
			@Description("Validating Video Call npa value for USACCPA To LGPD Travel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USACCPA To LGPD Travel Scenario");
				logStep("Validating Video Call npa value for USACCPA To LGPD Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1094, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USACCPA To LGPD Travel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USACCPA_To_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USACCPA To LGPD Travel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USACCPA To LGPD Travel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			
			
			@Test(priority = 1100, enabled = true)
			@Description("Enabling Preconfiguration for USACCPA To GDPR Travel Scenario")
			public void enable_PreConfiguration_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USACCPA To GDPR Travel Scenario");
				logStep("Enable Preconfiguration for USACCPA To GDPR Travel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableGDPR(GDPR_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, GDPR_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1102, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USACCPA To GDPR Travel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USACCPA To GDPR Travel Scenario");
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
					   Thread.sleep(10000);
		           Functions.clickOnVideos_tile();
					   Thread.sleep(80000);	
				    Thread.sleep(80000);	
				       //Thread.sleep(80000)
				   Thread.sleep(80000);	
				       Thread.sleep(80000);
					   CharlesFunctions.archive_folder("Charles");
					this.proxy.getXml();
					CharlesFunctions.createXMLFileForCharlesSessionFile();

			}
			
			@Test(priority = 1104, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USACCPA To GDPR Travel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USACCPA To GDPR Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1106, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USACCPA To GDPR Travel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USACCPA To GDPR Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1108, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To GDPR Travel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

		

			/*@Test(priority = 1112, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USACCPA To GDPR Travel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1114, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USACCPA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1116, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USACCPA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1118, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USACCPA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1120, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USACCPA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1122, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USACCPA To GDPR Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1124, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USACCPA To GDPR Travel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To GDPR Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1126, enabled = true)
			@Description("Lotame Call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USACCPA To GDPR Travel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1128, enabled = true)
			@Description("Factual Call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To GDPR Travel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	
	@Test(priority = 1129, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1130, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USACCPA To GDPR Travel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USACCPA To GDPR Travel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1132, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USACCPATo_GDPR_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1134, enabled = true)
			@Description("Validating NextGen IM Call npa value for USACCPA To GDPR Travel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USACCPA To GDPR Travel Scenario");
				logStep("Validating NextGen IM Call npa value for USACCPA To GDPR Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1136, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA To GDPR Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To GDPR Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To GDPR Travel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1138, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USACCPA To GDPR Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USACCPA To GDPR Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USACCPA To GDPR Travel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1140, enabled = true)
			@Description("Deriving Video Call when privacy optout for USACCPA To GDPR Travel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USACCPA To GDPR Travel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1090, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USACCPA To GDPR Travel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USACCPA To GDPR Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1142, enabled = true)
			@Description("Validating Video Call npa value for USACCPA To GDPR Travel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USACCPA To GDPR Travel Scenario");
				logStep("Validating Video Call npa value for USACCPA To GDPR Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1146, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USACCPA To GDPR Travel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USACCPA_To_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USACCPA To GDPR Travel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USACCPA To GDPR Travel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			@Test(priority = 1200, enabled = true)
			@Description("Enabling Preconfiguration for USACCPA To SERBIA Travel Scenario")
			public void enable_PreConfiguration_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USACCPA To SERBIA Travel Scenario");
				logStep("Enable Preconfiguration for USACCPA To SERBIA Travel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableSERBIA(SERBIA_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, SERBIA_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1202, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USACCPA To SERBIA Travel Scenario");
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
			
			@Test(priority = 1204, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USACCPA To SERBIA Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1206, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USACCPA To SERBIA Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1208, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

			

			/*@Test(priority = 1212, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1214, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1216, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1218, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1220, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USACCPA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1222, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USACCPA To SERBIA Travel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1224, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USACCPA To SERBIA Travel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To SERBIA Travel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1226, enabled = true)
			@Description("Lotame Call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USACCPA To SERBIA Travel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1228, enabled = true)
			@Description("Factual Call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To SERBIA Travel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}

			@Test(priority = 1229, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USACCPA To SERBIA Travel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1230, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USACCPATo_SERBIA_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1232, enabled = true)
			@Description("Validating NextGen IM Call npa value for USACCPA To SERBIA Travel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USACCPA To SERBIA Travel Scenario");
				logStep("Validating NextGen IM Call npa value for USACCPA To SERBIA Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}
	@Test(priority = 1233, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1234, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA To SERBIA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To SERBIA Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To SERBIA Travel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1236, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USACCPA To SERBIA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USACCPA To SERBIA Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USACCPA To SERBIA Travel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1238, enabled = true)
			@Description("Deriving Video Call when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USACCPA To SERBIA Travel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1240, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USACCPA To SERBIA Travel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1242, enabled = true)
			@Description("Validating Video Call npa value for USACCPA To SERBIA Travel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USACCPA To SERBIA Travel Scenario");
				logStep("Validating Video Call npa value for USACCPA To SERBIA Travel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1244, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USACCPA To SERBIA Travel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USACCPA_To_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USACCPA To SERBIA Travel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USACCPA To SERBIA Travel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			
			@Test(priority = 1300, enabled = true)
			@Description("Enabling Preconfiguration for USACCPA To LATAMCOTravel Scenario")
			public void enable_PreConfiguration_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USACCPA To LATAMCOTravel Scenario");
				logStep("Enable Preconfiguration for USACCPA To LATAMCOTravel Scenario");
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableLATAMCO(LATAMCO_CONFIG_FILE_PATH);
				proxy = new CharlesProxy("localhost", 8333, LATAMCO_CONFIG_FILE_PATH);
				proxy.startCharlesProxyWithUI();
				proxy.enableRewriting();
				proxy.startRecording();
				proxy.disableMapLocal();

			}

			@Test(priority = 1302, enabled = true)
			@Description("Navigating to Feed Cards when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void navigate_To_Feed_Cards_when_Privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out.println("****** Navigating to Feed Cards when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("Navigating to Feed Cards when privacy optout for USACCPA To LATAMCOTravel Scenario");
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
			
			@Test(priority = 1304, enabled = true)
			@Description("Verify NextGen IM ad call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void validate_NextGen_IM_Adcall_sod_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Verify NextGen IM Adcall sod value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("Verify NextGen IM Adcall sod value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "no");

			}

			@Test(priority = 1306, enabled = true)
			@Description("Verify maps details page Call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void verify_maps_details_call_sod_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");

				System.out
						.println("****** Verify maps details Call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("Verify maps details Call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "no");

			}
			
			/**
			 * This method verifies Amazon call
			 * @throws Exception
			 */
			@Test(priority = 1308, enabled = true)
			@Description("Amazon aax call verification when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_Amazon_Call_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon-adsystem.com Call test case Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
			}

	

			/*@Test(priority = 1312, enabled = true)
			@Description("Verify amazon aax Feed1 preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_feed1_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed1 preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario====================");

				System.out.println(
						"****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax feed1 preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed1", false);

			}

			@Test(priority = 1314, enabled = true)
			@Description("Verify amazon aax Feed2 preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_feed2_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed2 preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax feed2 preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Feed2", false);

			}

			@Test(priority = 1316, enabled = true)
			@Description("Verify amazon aax Feed3 preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_feed3_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax feed3 preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax feed3 preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Feed3", false);

			}


			@Test(priority = 1318, enabled = true)
			@Description("Verify amazon aax PreRollVideo preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon PreRollVideo preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", false);

			}

			@Test(priority = 1320, enabled = true)
			@Description("Verify amazon aax map details preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_map_details_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax map details preload ad call when privacy optout for USACCPA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax Map details preload ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				
				////Utils.verifyAAX_SlotId("Smoke", "Map", false);

			}

			@Test(priority = 1324, enabled = true)
			@Description("Verify amazon aax Daily Details ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_Daily_details_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Daily Details  ad call when privacy optout for USACCPA To LATAMCOTravel Scenario ====================");

				System.out.println(
						"****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax Daily Details ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", false);

			}

			@Test(priority = 1326, enabled = true)
			@Description("Verify amazon aax Hourly Details ad call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_amazon_aax_Hourly_details_adcall_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== amazon aax Hourly Details  ad call when privacy optout for USACCPA To LATAMCOTravel Scenario====================");

				System.out.println(
						"****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** amazon aax Hourly Details ad call validation Started when privacy optout for USACCPA To LATAMCOTravel Scenario");

				////Utils.verifyAAX_SlotId("Smoke", "Hourly", false);

			}*/

			// Lotame Test case
			@Test(priority = 1328, enabled = true)
			@Description("Lotame Call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_Lotame_Call_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Lotame Call test case Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("****** Lotame Call test case Started when privacy optout for USACCPA To LATAMCOTravel Scenario");

				Utils.verifyAPICal("Smoke", "Lotame", false);

			}


			@Test(priority = 1330, enabled = true)
			@Description("Factual Call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_LocationWFXTriggers_Call_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("location.wfxtriggers.com Call test case Started when privacy optout for USACCPA To LATAMCOTravel Scenario");
				Utils.verifyAPICal("Smoke", "LocationWFX", false);

			}
	@Test(priority = 1331, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", true);
	}


			@Test(priority = 1332, enabled = true)
			@Description("Validating NextGen IM Call rdp value when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void validate_NextGen_IM_call_rdp_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("****** Validating NextGenIM Call rdp value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("Validating NextGenIM Call rdp value when privacy optout for USACCPA To LATAMCOTravel Scenario ");

				Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", true);

			}
			
			@Test(priority = 1334, enabled = true)
			@Description("Verifying Home screen marquee ad call")
			public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USACCPATo_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println(
						"================= verifying iu value for home screen marquee test case started =========================");	
			
				Utils.verifyPubadCal("Smoke", "Marquee");

				System.out.println(
						"================= verifying iu value for home screen marquee test case End =========================");
			}

			@Test(priority = 1336, enabled = true)
			@Description("Validating NextGen IM Call npa value for USACCPA To LATAMCOTravel Scenario")
			public void validate_NextGen_IM_call_npa_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating NextGen IM Call npa value for USACCPA To LATAMCOTravel Scenario");
				logStep("Validating NextGen IM Call npa value for USACCPA To LATAMCOTravel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "Marquee", true);

			}

			@Test(priority = 1338, enabled = true)
			@Description("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA To LATAMCOTravel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To LATAMCOTravel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA To LATAMCOTravel Scenario validation Started");
				Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1340, enabled = true)
			@Description("Verify Criteo SDK config app call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USACCPA To LATAMCOTravel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USACCPA To LATAMCOTravel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USACCPA To LATAMCOTravel Scenario validation Started");
				Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

			}

			@Test(priority = 1342, enabled = true)
			@Description("Deriving Video Call when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void derive_VideoCall_IU_when_Privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {

				System.out.println("==============================================");
				System.out.println("****** Deriving VideoCall when privacy optout for USACCPA To LATAMCOTravel Scenario");
			
				Utils.verifyPubadCal("Smoke", "PreRollVideo");
			}

			@Test(priority = 1346, enabled = true)
			@Description("Verify Preroll ad on Video Call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void verify_PrerollAd_call_sod_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				
				System.out.println("****** Prerol-video Call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("Verify Prerol-video Call sod value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				
				Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "no");

			}

			@Test(priority = 1348, enabled = true)
			@Description("Validating Video Call npa value for USACCPA To LATAMCOTravel Scenario")
			public void validate_Video_call_npa_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Validating Video Call npa value for USACCPA To LATAMCOTravel Scenario");
				logStep("Validating Video Call npa value for USACCPA To LATAMCOTravel Scenario ");

				Utils.validate_npa_val_in_gampad_url("Smoke", "PreRollVideo", true);

			}

			@Test(priority = 1350, enabled = true)
			@Description("Validating Preroll Video Call rdp value when privacy optout for USACCPA To LATAMCOTravel Scenario")
			public void validate_PrerollVideo_call_rdp_val_privacy_optout_for_USACCPA_To_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"****** Validating PreRollVideo Call rdp value when privacy optout for USACCPA To LATAMCOTravel Scenario");
				logStep("Validating PreRollVideo Call rdp value when privacy optout for USACCPA To LATAMCOTravel Scenario ");

				
				Utils.validate_rdp_val_in_gampad_url("Smoke", "PreRollVideo", true);
				/*
				 * Instead of Uninstall and install app for every regime, waiting for 5 mins to get dsx call is more time saviour
				 * hence below hard wait steps are added and corresponding uninstall and install steps will be commented in next regimes.
				 */
				System.out.println("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				logStep("****** Waiting for five minutes to get dsx call to override privacy and geo ip country for next test");
				Thread.sleep(240000);

			}
			

			
			@Test(priority = 1500, enabled = true)
			public void preConditionsTest_for_USACCPA_Selecting_StandardAdvertisingSettings() throws Exception {
				proxy.quitCharlesProxy();
				this.configFile = this.rewriteRuleToEnableUSACCPA(CONFIG_FILE_PATH);
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
 
 
 
  
  @Test(priority =1502, enabled = true)	  
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
  


  
  @Test(priority = 1504, enabled = true)	  
  @Description("Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_presence_USA_CCPA_Privacy_StandardAdvertisingSettings() throws  Exception { 
  logStep("Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
  System.out.println("=================Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================");	  
	this.proxy.clearCharlesSession();
	  AppFunctions.Kill_Launch_App();
	  AppFunctions.Kill_Launch_App();
	   Thread.sleep(40000); 		  
	   AppFunctions.click_radar_element();	
       Functions.clickOnVideos_tile();
	  Thread.sleep(80000);
	  CharlesFunctions.archive_folder("Charles");
		this.proxy.getXml();		
	    Thread.sleep(80000);		
		CharlesFunctions.createXMLFileForCharlesSessionFile();
		//Utils.verifyAPICal("Smoke", "Lotame", true);
  System.out.println("================= Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
  
  }
  
  
	@Test(priority = 1506, enabled = true)
	@Description("Verifying Home screen marquee ad call")
	public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_USACCPA_optin() throws Exception {
		System.out.println(
				"================= verifying iu value for home screen marquee test case started =========================");	
	
		//Utils.verifyPubadCal("Smoke", "Marquee");

		System.out.println(
				"================= verifying iu value for home screen marquee test case End =========================");
	}

  @Test(priority = 1508, enabled = true)
	@Description("Verify NextGen IM ad call sod value when privacy optin")
	public void validate_NextGen_IM_Adcall_sod_val_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		// Functions.retryclear();

		System.out.println("****** Verify NextGen IM Adcall sod value when privacy optin");
		logStep("Verify NextGen IM Adcall sod value when privacy optin");
		//Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "sod", "yes");

	}

	

	@Test(priority = 1510, enabled = true)
	@Description("Verify maps details page Call sod value when privacy optin")
	public void verify_maps_details_call_sod_val_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");

		System.out.println("****** Verify maps details Call sod value when privacy optin");
		logStep("Verify maps details Call sod value when privacy optin");
		//Utils.validate_custom_param_val_of_gampad("Smoke", "Map", "sod", "yes");

	}

	

	@Test(priority = 1512, enabled = true)
	@Description("Verify amazon aax Feed1 preload ad call when privacy optin")
	public void Verify_amazon_aax_feed1_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax feed1 preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax feed1 preload ad call validation Started when privacy optin");
		logStep("****** amazon aax feed1 preload ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Feed1", true);

	}

	@Test(priority = 1514, enabled = true)
	@Description("Verify amazon aax Feed2 preload ad call when privacy optin")
	public void Verify_amazon_aax_feed2_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax feed2 preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax feed2 preload ad call validation Started when privacy optin");
		logStep("****** amazon aax feed2 preload ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Feed2", true);

	}

	@Test(priority = 1516, enabled = true)
	@Description("Verify amazon aax Feed3 preload ad call when privacy optin")
	public void Verify_amazon_aax_feed3_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax feed3 preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax feed3 preload ad call validation Started when privacy optin");
		logStep("****** amazon aax feed3 preload ad call validation Started when privacy optin");
		
		////Utils.verifyAAX_SlotId("Smoke", "Feed3", true);

	}



	@Test(priority = 1518, enabled = true)
	@Description("Verify amazon aax PreRollVideo preload ad call when privacy optin")
	public void Verify_amazon_aax_PreRollVideo_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon PreRollVideo preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax PreRollVideo preload ad call validation Started when privacy optin");
		logStep("****** amazon aax PreRollVideo preload ad call validation Started when privacy optin");
		
		////Utils.verifyAAX_SlotId("Smoke", "PreRollVideo", true);

	}

	@Test(priority = 1520, enabled = true)
	@Description("Verify amazon aax map details preload ad call when privacy optin")
	public void Verify_amazon_aax_map_details_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax map details preload ad call when privacy optin ====================");

		System.out.println("****** amazon aax Map details preload ad call validation Started when privacy optin");
		logStep("****** amazon aax Map details preload ad call validation Started when privacy optin");
		
		////Utils.verifyAAX_SlotId("Smoke", "Map", true);

	}

	@Test(priority = 1522, enabled = true)
	@Description("Verify amazon aax Daily Details ad call when privacy optin")
	public void Verify_amazon_aax_Daily_details_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax Daily Details  ad call when privacy optin ====================");

		System.out.println("****** amazon aax Daily Details ad call validation Started when privacy optin");
		logStep("****** amazon aax Daily Details ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Daily(10day)", true);

	}

	@Test(priority = 1524, enabled = true)
	@Description("Verify amazon aax Hourly Details ad call when privacy optin")
	public void Verify_amazon_aax_Hourly_details_adcall_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== amazon aax Hourly Details  ad call when privacy optin====================");

		System.out.println("****** amazon aax Hourly Details ad call validation Started when privacy optin");
		logStep("****** amazon aax Hourly Details ad call validation Started when privacy optin");

		////Utils.verifyAAX_SlotId("Smoke", "Hourly", true);

	}

	// Lotame Test case
	@Test(priority = 1526, enabled = true)
	@Description("Lotame Call when privacy optin")
	public void Verify_Lotame_call_privacy_optin_for_USACCPA() throws Exception {
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

	@Test(priority = 1528, enabled = true)
	@Description("Factual Call when privacy optin")
	public void Verify_LocationWFXTriggers_Call_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** location.wfxtriggers.com Call test case Started when privacy optin");
		logStep("location.wfxtriggers.com Call test case Started when privacy optin");
		//Utils.verifyAPICal("Smoke", "LocationWFX", false);

	}
	
	/*
	 * This method validates WFXTriggers call
	 */
	@Test(priority = 1530, enabled = true)
	@Description("WFXTrigger Call when privacy optin")
	public void Verify_WFXTriggers_Call_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started when privacy optin");
		logStep("****** triggers.wfxtriggers.com Call test case Started when privacy optin");
		//Utils.verifyAPICal("Smoke", "WFXTrigger", true);

	}



	@Test(priority = 1534, enabled = true)
	@Description("Verify Criteo SDK inapp v2 call when privacy optin")
	public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out
				.println("=========================== Criteo SDK inapp/v2 call when privacy optin====================");
		System.out.println("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
		logStep("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
	//	Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", true);

	}

	@Test(priority = 1536, enabled = true)
	@Description("Verify Criteo SDK config app call when privacy optin")
	public void Verify_Criteo_SDK_config_app_Call_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== Criteo SDK config/app call when privacy optin====================");
		System.out.println("****** Criteo SDK config/app call when privacy optin validation Started");
		logStep("****** Criteo SDK config/app call when privacy optin validation Started");
	//	Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", true);

	}

	@Test(priority = 1538, enabled = true)
	@Description("Deriving Video Call when privacy optin")
	public void derive_VideoCall_IU_when_Privacy_optin_for_USACCPA() throws Exception {

		System.out.println("==============================================");
		System.out.println("****** Deriving VideoCall For USACCPA when privacy optin");
		logStep("****** Deriving VideoCall For USACCPA when privacy optin");
		//Utils.verifyPubadCal("Smoke", "PreRollVideo");
	}

	@Test(priority = 1540, enabled = true)
	@Description("Verify Preroll ad on Video Call sod value when privacy optin")
	public void verify_PrerollAd_call_sod_val_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");

		System.out.println("****** Prerol-video Call sod value when privacy optin");
		logStep("Verify Prerol-video Call sod value when privacy optin");
		//Utils.validate_custom_param_val_of_gampad("Smoke", "PreRollVideo", "sod", "yes");

	}

	@Test(priority = 1542, enabled = true)
	@Description("Validating PrerollVideo Call rdp value when privacy optin")
	public void validate_PrerollVideo_call_rdp_val_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating PrerollVideo Call rdp value when privacy optin");
		logStep("Validating PrerollVideo Call rdp value when privacy optin ");

		//Utils.validate_rdp_val_in_gampad_url("Smoke", "PrerollVideo", false);

	}
	
	
	@Test(priority = 1544, enabled = true)
	@Description("Validating marquee Call rdp value when privacy optin")
	public void validate_marquee_call_rdp_val_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating marquee Call rdp value when privacy optin");
		logStep("Validating marquee Call rdp value when privacy optin ");

		//Utils.validate_rdp_val_in_gampad_url("Smoke", "Marquee", false);

	}
	
	@Test(priority = 1546, enabled = true)
	@Description("Validating maps details Call rdp value when privacy optin")
	public void validate_mapsdetails_call_rdp_val_privacy_optin_for_USACCPA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating maps details Call rdp value when privacy optin");
		logStep("Validating maps details Call rdp value when privacy optin ");

		//Utils.validate_rdp_val_in_gampad_url("Smoke", "Map", false);
		 CharlesFunctions.archive_folder("Charles");

	}




			
			
			
			
			

}
