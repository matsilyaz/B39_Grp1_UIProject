package com.briteerp.step_definitions;


import com.briteerp.pages.LoginPage;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.lang.module.Configuration;

public class US01_LoginFunctionality_StepDefinitions_FS {

    LoginPage loginPage=new LoginPage();

    @Given("the user is  on the login page")
    public void theUserIsOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("the user logs in as {string}")
    public void theUserLogsInAs(String roleName) {
        String username=ConfigurationReader.getProperty(roleName+"_manager_username");
        String password=ConfigurationReader.getProperty(roleName+"_manager_password");
        loginPage.email.clear();
        loginPage.email.sendKeys(username);

        loginPage.password.clear();
        loginPage.password.sendKeys(password);

        loginPage.loginButton.click();

    }

    @Then("the user should see the Dashboard page")
    public void theUserShouldSeeTheDashboardPage() {
       String actualTitle=Driver.getDriver().getTitle();
       String expectedTitle="Odoo";
       Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user enters valid {string} and presses the Enter key")
    public void theUserEntersValidAndPressesTheEnterKey(String RoleName) {
        loginPage.email.sendKeys(ConfigurationReader.getProperty(RoleName+"_manager_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty(RoleName+"_manager_password"));

        loginPage.password.sendKeys(Keys.ENTER);
    }


    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        loginPage.login("invalid_username", "invalid_password");
    }


    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage= loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @When("the user leaves username or password field blank")
    public void theUserLeavesUsernameOrPasswordFieldBlank() {
        loginPage.email.sendKeys("");
        loginPage.password.sendKeys("");
        loginPage.loginButton.click();
    }

    @Then("a message {string} should be displayed")
    public void aMessageShouldBeDisplayed(String expectedMessage) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       String actualMessage="";

       if (loginPage.email.getAttribute("value").isEmpty()) {
           actualMessage = (String) js.executeScript("return arguments[0].validationMessage;", loginPage.email);
       } else if (loginPage.password.getAttribute("value").isEmpty()) {
           actualMessage = (String) js.executeScript("return arguments[0].validationMessage;", loginPage.password);
       } else {
           Assert.fail("Both fields are filled. Can not check validation message.");
       }

        Assert.assertEquals(expectedMessage, actualMessage);
       }


    }



