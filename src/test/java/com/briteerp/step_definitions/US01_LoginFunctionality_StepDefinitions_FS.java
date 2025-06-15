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



    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String email, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(email, password);
    }

    @Then("the user should see the Discuss page")
    public void theUserShouldSeeTheDiscussPage() {
        String expectedTitle = ConfigurationReader.getProperty("discuss_page_title");
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

    }



    @When("the user enters {string} and {string} and presses Enter")
    public void theUserEntersAndAndPressesEnter(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithEnterKey(email, password);
    }



    @When("the user enters invalid {string} and {string}")
    public void theUserEntersInvalidAnd(String email, String password) {
        loginPage.login(email, password);

    }



    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {

        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user tries to login with email {string} and password {string}")
    public void theUserTriesToLoginWithEmailAndPassword(String email, String password) {
        loginPage.login(email, password);

    }

    @Then("a message {string} should be displayed")
    public void aMessageShouldBeDisplayed(String expectedMessage) {


        // email
        String validationMessage = loginPage.email.getAttribute("validationMessage");

        // password
        if (validationMessage == null || validationMessage.isEmpty()) {
            validationMessage = loginPage.password.getAttribute("validationMessage");
        }

        Assert.assertEquals(expectedMessage, validationMessage);
        System.out.println("User sees the message");
    }






}



