package com.appium.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MobileUtils {


    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }



    /**
      Performs a pause
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void verifyTitle(AppiumDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }








   //with Javascript scripts:

    public static void scrollToEnd(String platformType){

        Driver.getDriver(platformType).findElement( new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10);"));
    }





    public static void scrollIntoView(String platformType, String text){

        Driver.getDriver(platformType).findElement( new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }







}
