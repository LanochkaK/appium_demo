package com.appium.pages;

import com.appium.utils.ConfigurationReader;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


  public LoginPage(String env) {      //is used parent const
      super(env);
  }


    @AndroidFindBy(xpath = "//*[@text='Username']")
    public WebElement userName;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement password;


    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;



    public void login() {
        userName.sendKeys(ConfigurationReader.getProperty("userName"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }







}
