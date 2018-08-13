package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
 
public class TestCase1 {
	Logger logger=Logger.getLogger(TestCase1.class);

	public void brightnessControl() throws InterruptedException {
		new DesiredCapabilities();
		logger.info("Setting the driver Capabilities");
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MauryaJi");
		caps.setCapability(MobileCapabilityType.UDID, "93ffd01a0803"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "nu.lower.brightness");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "nu.lower.brightness.SplashScreenActivity");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, "7.0 NRD90M");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver;
		try {
			logger.info("Launching the app");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("nu.lower.brightness:id/onRadioButton").click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        MobileElement seekbar=driver.findElementByClassName("android.widget.SeekBar");
	        int startX=seekbar.getLocation().getX();
	        int startY=seekbar.getLocation().getY();
	        int endX=(startX+seekbar.getSize().getWidth());
	        TouchAction action=new TouchAction(driver);
	         action.longPress(startX, startY).moveTo((int) (endX*0.79), startY).release().perform();
	        //this.swipeScreen(startX, startY, (int) (endX*0.79), startY, 3, driver);
			logger.info("Execution successfully completed");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void NTES() throws InterruptedException {
		new DesiredCapabilities();
		logger.info("Setting the driver Capabilities");
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MauryaJi");
		caps.setCapability(MobileCapabilityType.UDID, "93ffd01a0803"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cris.icms.ntes");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cris.icms.ntes.LaunchApp");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, "7.0 NRD90M");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver;
		try {
			logger.info("Launching the App");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Click on spot your train
			driver.findElementByXPath("//android.widget.TextView[@text='Spot Your Train']").click();
			//Fill the train number
			driver.findElementById("cris.icms.ntes:id/train1").sendKeys("12225");
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			//Select the radio button
			driver.findElementById("cris.icms.ntes:id/spinner2").click();
			driver.findElementByXPath("//android.widget.CheckedTextView[@index='7']").click();
			//Click on show status button
			driver.findElementById("cris.icms.ntes:id/btnTR").click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			//Back to home
			//[@content-desc='Navigate up']
			logger.info("Going to click on back button");
			//driver.findElementByXPath("//android.view.ViewGroup[@index='0']/android.widget.ImageButton[contains(@content-desc,'Navigate up')]").click();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(20000);
			logger.info("Going to click on back button again");
			driver.navigate().back();
			Thread.sleep(20000);
			logger.info("Switching to another menu  Train Between Stations");
			driver.findElementByXPath("//android.widget.TextView[@text='Trains Between Stations']").click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//Select From station
			driver.findElementById("cris.icms.ntes:id/stnCodeF").sendKeys("abp");
			driver.findElementById("cris.icms.ntes:id/stnCodeT").click();
			//Select To station
			driver.findElementById("cris.icms.ntes:id/stnCodeT").sendKeys("fd");
			driver.findElementById("android:id/text1").click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.Button[@text='Get Trains']").click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			driver.navigate().back();
			Thread.sleep(20000);
			driver.navigate().back();
			logger.info("Execution successfully completed");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ContactScroll() {
		new DesiredCapabilities();
		logger.info("Setting the driver Capabilities");
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MauryaJi");
		caps.setCapability(MobileCapabilityType.UDID, "93ffd01a0803"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, "7.0 NRD90M");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver;
		try {
			logger.info("Launching the App");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
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
	public void contactSrollPrint() {
		new DesiredCapabilities();
		logger.info("Setting the driver Capabilities");
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MauryaJi");
		caps.setCapability(MobileCapabilityType.UDID, "93ffd01a0803"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, "7.0 NRD90M");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver;
		try {
			logger.info("Launching the App");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    String t=driver.findElementByXPath("//android.widget.TextView[@text='Contacts']").getText();
		    logger.info(t+"  App successufully opened");
		    boolean found=false,found_result=false;
		    ArrayList<String> content=new ArrayList<String>();
		    while(!found_result) {
		    	List<MobileElement> element=driver.findElementsByClassName("android.widget.TextView");
		    	for(MobileElement m:element) {
		    		String n=m.getText();
		    		content.add(n);
		    		if(n.contains("Garima")) {
		    			found=true;
		    			break;
		    		}
		    	}
		    	if(!found) {
		    		// MobileElement contactList=driver.findElementById("com.android.contacts:id/contacts_list_view");
		 		 //   String call=JOptionPane.showInputDialog("Please enter gthe contact name to which you want to call");
		 		  //  MobileElement c=((AndroidElement) contactList).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().textContains(\""+call+"\"));");
		    		Dimension size = driver.manage().window().getSize();
		    		  System.out.println(size);
		    		   
		    		  //Find swipe start and end point from screen's with and height.
		    		  //Find starty point which is at bottom side of screen.
		    		  int starty = (int) (size.height * 0.80);
		    		  //Find endy point which is at top side of screen.
		    		  int endy = (int) (size.height * 0.20);
		    		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		    		  int startx = size.width / 2;
		    		  this.swipeScreen(startx, starty, startx, endy, 3, driver);
		    	}else {
		    		break;
		    	}
		    }
		    logger.info(content);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void swipeScreen(int StartX,int StartY,int EndX,int EndY,int n,AppiumDriver<MobileElement> driver) {
		   Duration duration=Duration.ofSeconds(n);
		   TouchAction touchAction = new TouchAction(driver);
		   touchAction.longPress(StartX, StartY).waitAction(duration).moveTo(EndX, EndY).release().perform();
			   
	}
}