package com.appium.stepDefs;


import com.appium.pages.LoginPage;
import com.appium.utils.Driver;
import com.appium.utils.MobileUtils;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

public class LoginSteps {


        LoginPage appPage;


   @When("User login to mobile app with {string} setup")
   public void user_login_to_mobile_app_with_setup(String env) {

            appPage = new LoginPage(env);
            appPage.login();
  }


   }











