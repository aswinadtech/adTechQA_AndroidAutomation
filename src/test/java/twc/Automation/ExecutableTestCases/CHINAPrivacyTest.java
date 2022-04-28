package twc.Automation.ExecutableTestCases;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import twc.Automation.General.Functions;
import twc.Automation.General.TwcAndroidBaseTest;
import twc.Automation.General.Utils;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.HandleWithCharles.CharlesProxy;

public class CHINAPrivacyTest extends TwcAndroidBaseTest {
	
	private static final String CONFIG_FILE_PATH = "enableCHINA.config";
	private CharlesProxy proxy;
	private File configFile;
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** China Privacy Test Started");
		logStep("****** China CO  Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableCHINA(CONFIG_FILE_PATH);
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
		
		System.out.println("****** China   Privacy Test Ended");
		logStep("****** China  Privacy Test Ended");
	}
	
	@Test(priority = 300)
	public void preConditionsTest_for_China() throws Exception {
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
                  CharlesFunctions.archive_folder("Charles");
		this.proxy.getXml();
		CharlesFunctions.createXMLFileForCharlesSessionFile();
	}
	
	/*
	 * This method validates Lotame call for not present
	 */
	@Test(priority = 302, enabled = true)
	@Description("Lotame Call verification")
	public void Verify_Lotame_Call_for_CHINA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** bcp.crwdcntrl.net Call test case Started");
		logStep("****** bcp.crwdcntrl.net Call test case Started");
		Utils.verifyAPICal("Smoke", "Lotame", false);

	}

	/*
	 * This method validates FACTUAL call for not present
	 */
	@Test(priority = 304, enabled = true)
	@Description("Factual Call verification")
	public void Verify_LocationWFXTriggers_Call_for_CHINA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** location.wfxtriggers.com Call test case Started");
		logStep("location.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "LocationWFX", false);

	}
	
	/*
	 * This method validates WFXTriggers call for present
	 */
	@Test(priority = 306, enabled = true)
	@Description("WFXTrigger Call verification")
	public void Verify_WFXTriggers_Call_or_CHINA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** triggers.wfxtriggers.com Call test case Started");
		logStep("****** triggers.wfxtriggers.com Call test case Started");
		Utils.verifyAPICal("Smoke", "WFXTrigger", false);

	}

	/**
	 * This method verifies Amazon call
	 * @throws Exception
	 */
	@Test(priority = 308, enabled = true)
	@Description("Amazon aax call verification")
	public void Verify_Amazon_Call() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** amazon-adsystem.com Call test case Started");
		logStep("****** amazon-adsystem.com Call test case Started");
		Utils.verify_Amazon_aax_call("Smoke", "Amazon", false);
	}
	
	
	/*
	 * This method validates Criteo Bidder API call for not present
	 */
	@Test(priority = 310, enabled = true)
	@Description("Verify Criteo SDK inapp v2 call")
	public void Verify_Criteo_SDK_inapp_v2_Call_for_CHINA() throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
		System.out.println("****** Criteo SDK inapp/v2 call validation Started");
		logStep("****** Criteo SDK inapp/v2 call validation Started");
		Utils.verifyCriteo_inapp_v2_Call("Smoke", "Criteo", false);

	}

	/*
	 * This method validates Criteo Initialization API call for not present
	 */
	@Test(priority = 312, enabled = true)
	@Description("Verify Criteo SDK config app call")
	public void Verify_Criteo_SDK_config_app_Call_for_CHINA() throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== Criteo SDK config/app call ====================");
		System.out.println("****** Criteo SDK config/app call validation Started");
		logStep("****** Criteo SDK config/app call validation Started");
		Utils.verifyCriteo_config_app_Call("Smoke", "Criteo", false);

	}
	

}
