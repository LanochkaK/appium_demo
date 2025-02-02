package com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class Driver {

    // AppiumDriver == Webdriver  --> from Selenium,  (covers  iOS, Android)
    public static AppiumDriver driver;
    public static URL url;
    public static UiAutomator2Options options = new UiAutomator2Options(); // Class need to set up capabilities to driver



    private Driver(){

    }


    public static AppiumDriver getDriver(String platformType){

        //  String platform = ConfigurationReader.getProperty(platformType);

        String testDirectory = System.getProperty("user.dir");


        if(Objects.isNull(driver)){

            String platform = ConfigurationReader.getProperty(platformType);

            switch (platform){                      //platform come from config.prop. file    // local env running
                case "local-android-sauceApp":
                    options.setApp(testDirectory + "/sauceLab.apk");
                    options.setAppActivity("com.swaglabsmobileapp.MainActivity");
                    options.setAppPackage("com.swaglabsmobileapp");
                    try {
                        url = new URL("http://192.168.1.199:4723");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url,options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;

                case "remote-android-sauceApp":
                    // this part of script came from SauseLabs site where we test remotely
                    MutableCapabilities caps = new MutableCapabilities();
                    caps.setCapability("platformName", "Android");

                    // change Application part (our app under testing)
                    caps.setCapability("appium:app", "https://github   .com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    caps.setCapability("appium:deviceName", "Google Pixel 3 GoogleAPI Emulator");
                    caps.setCapability("appium:platformVersion", "11.0");
                    caps.setCapability("appium:automationName", "UiAutomator2");
                    caps.setCapability("appPackage","com.swaglabsmobileapp");
                    caps.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");

                    // add app activity and package (//NEED CHANGE for MY OWN from CLI)
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("appiumVersion", "2.0.0");

                    // username and access key is unique to the user (NEED CHANGE for MY OWN, get into company)
                    sauceOptions.setCapability("username", "oauth-testermichael77-6fc8b");
                    sauceOptions.setCapability("accessKey", "54923638-aed6-4432-8e2e-d8b72784bc1b");  // find from MY souceLAbs aacout's SEttings
                    sauceOptions.setCapability("build", "sauceLab123");
                    sauceOptions.setCapability("name", "smokeTest");
                    sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                    caps.setCapability("sauce:options", sauceOptions);

                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;


                case "remoteIOS-sauceApp":  //iOS
                    MutableCapabilities capsI = new MutableCapabilities();
                    capsI.setCapability("platformName", "iOS");
                    capsI.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");  // The filename of the mobile app
                    capsI.setCapability("appium:deviceName", "iPhone.*");
                    capsI.setCapability("appium:automationName", "XCUITest");
                    MutableCapabilities sauceOptionsI = new MutableCapabilities();

                    sauceOptionsI.setCapability("username", "oauth-testermichael77-6fc8b");
                    sauceOptionsI.setCapability("accessKey", "54923638-aed6-4432-8e2e-d8b72784bc1b");
                    sauceOptionsI.setCapability("build", "Test123");
                    sauceOptionsI.setCapability("name", "IOS_Test");
                    sauceOptionsI.setCapability("deviceOrientation", "PORTRAIT");
                    capsI.setCapability("sauce:options", sauceOptionsI);
                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new IOSDriver(url, capsI);
                    break;
            }

        }
        return driver;
    }



    public static void closeDriver(){

        if(Objects.nonNull(driver)){
            driver.quit();
            driver = null;
        }
    }




}
