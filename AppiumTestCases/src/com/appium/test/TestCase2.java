package com.appium.test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCase2 {
	Logger logger=Logger.getLogger(TestCase2.class);
	@Test
	public void ContactScroll() {
		new DesiredCapabilities();
		logger.info("Setting the driver Capabilities");
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		caps.setCapability(MobileCapabilityType.UDID, "e5b1c2a27d53"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, "6.0.1 MMB29M");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver;
		try {
			logger.info("Launching the App");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4724/wd/hub"), caps);
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
			logger.info("Select sim airtel");
			String sim=JOptionPane.showInputDialog("Please enter network name from which you want to call");
			if(sim.contains("airtel")) {
				logger.info("Calling By Airtel");
				driver.findElementByXPath("//android.widget.TextView[@text='airtel']").click();
				Thread.sleep(3000);
			}else {
				logger.info("Calling by Vodafone");
				driver.findElementByXPath("//android.widget.TextView[@text='Vodafone IN']").click();
				Thread.sleep(500);
			}
			logger.info("Canceling  the call  ");
			driver.findElementByXPath("//android.widget.Button[@content-desc='End']").click();
			Thread.sleep(3000);
		    logger.info("Execution has been completed successfully.  ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
