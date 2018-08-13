package com.appium.test;

	import org.testng.annotations.Test;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.AfterMethod;
public class TestCase3 {
	Logger logger=Logger.getLogger(TestCase3.class);
	private static AndroidDriver<MobileElement> driver;

	@Test
	public void f() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    String t=driver.findElementByXPath("//android.widget.TextView[@text='Contacts']").getText();
	    logger.info(t+"  App successufully opened");
	    MobileElement contactList=driver.findElementById("com.android.contacts:id/contacts_list_view");
	    String call=JOptionPane.showInputDialog("Please enter gthe contact name to which you want to call");
	    MobileElement c=((AndroidElement) contactList).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().textContains(\""+call+"\"));");
		Thread.sleep(3000);
		logger.info("Clicking on the desired contact");
		c.click();
		Thread.sleep(2000);
		logger.info("Clicking on the number for call");
		driver.findElementById("com.android.contacts:id/primary_action_view").click();
		/*logger.info("Select sim airtel");
		String sim=JOptionPane.showInputDialog("Please enter network name from which you want to call");
		if(sim.contains("airtel")) {
			logger.info("Calling By Airtel");
			driver.findElementByXPath("//android.widget.TextView[@text='airtel']").click();
			Thread.sleep(3000);
		}else {
			logger.info("Calling by Vodafone");
			driver.findElementByXPath("//android.widget.TextView[@text='Vodafone IN']").click();
			Thread.sleep(500);
		}*/
		logger.info("Canceling  the call  ");
		driver.findElementByXPath("//android.widget.Button[@content-desc='End']").click();
		Thread.sleep(3000);
	    logger.info("Execution has been completed successfully.  ");
	}

	@Parameters({ "deviceName_","UDID_","platformVersion_", "URL_" })
	@BeforeMethod
	public void beforeMethod(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException, InterruptedException {
		/*File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Apps/Amazon/");
		File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");*/
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", deviceName_);
		capabilities.setCapability("udid", UDID_);
		capabilities.setCapability("platformVersion", platformVersion_);
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

	@AfterMethod
	public void afterMethod() {
	}
}

