package com.briteerp.step_definitions;


import com.briteerp.pages.LoginPage;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class LoginStepDefinitions {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Login to app in Before method");
    }

    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }

    @When("the user logged in with different valid credentials like the  email {string} and password {string}")
    public void the_user_logged_in_with_different_valid_credentials_like_the_email_and_password(String email, String password) {
        new LoginPage().login(email,password);
    }


    @When("the user logged in as {string} by clicking login button")
    public void the_user_logged_in_as_by_clicking_login_button(String userType) {
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equalsIgnoreCase("posmanager")){
            username = ConfigurationReader.getProperty("pos_manager_username");
            password = ConfigurationReader.getProperty("pos_manager_password");
        }else if(userType.equalsIgnoreCase("crmmanager")){
            username = ConfigurationReader.getProperty("crm_manager_username");
            password = ConfigurationReader.getProperty("crm_manager_password");
        }else if(userType.equalsIgnoreCase("salesmanager")){
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        } else if(userType.equalsIgnoreCase("inventorymanager")){
            username = ConfigurationReader.getProperty("inventory_manager_username");
            password = ConfigurationReader.getProperty("inventory_manager_password");
        } else if(userType.equalsIgnoreCase("expensesmanager")){
            username = ConfigurationReader.getProperty("expenses_manager_username");
            password = ConfigurationReader.getProperty("expenses_manager_password");
        }
        //send username and password and login
        new LoginPage().login(username,password);
    }

    @When("the user logged in as {string} by hitting enter key")
    public void the_user_logged_in_as_by_hitting_enter_key(String userType) {
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equalsIgnoreCase("posmanager")){
            username = ConfigurationReader.getProperty("pos_manager_username");
            password = ConfigurationReader.getProperty("pos_manager_password");
        }else if(userType.equalsIgnoreCase("crmmanager")){
            username = ConfigurationReader.getProperty("crm_manager_username");
            password = ConfigurationReader.getProperty("crm_manager_password");
        }else if(userType.equalsIgnoreCase("salesmanager")){
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        } else if(userType.equalsIgnoreCase("inventorymanager")){
            username = ConfigurationReader.getProperty("inventory_manager_username");
            password = ConfigurationReader.getProperty("inventory_manager_password");
        } else if(userType.equalsIgnoreCase("expensesmanager")){
            username = ConfigurationReader.getProperty("expenses_manager_username");
            password = ConfigurationReader.getProperty("expenses_manager_password");
        }

        //send username and password and login
        new LoginPage().loginWithEnterKey(username,password);

    }



    @Then("the user should see the Discuss page")
    public void the_user_should_see_the_discuss_page() {
        String expectedMainPageTitle = ConfigurationReader.getProperty("discuss_page_title");
        String actualPageTitle = Driver.getDriver().getTitle();
        System.out.println("actualPageTitle = " + actualPageTitle);
        Assert.assertEquals("login failed!!!",expectedMainPageTitle,actualPageTitle);
    }

    @When("the user enters invalid credentials as the  email {string} and password {string}")
    public void the_user_enters_invalid_credentials_as_the_email_and_password(String email, String password) {
        new LoginPage().login(email,password);

    }
    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String string) {
        Assert.assertTrue( new LoginPage().errorMessage.isDisplayed());
    }
    @When("the user leaves {string} or {string} field blank")
    public void the_user_leaves_or_field_blank(String email, String password) {
        new LoginPage().login(email,password);
    }

    // This method validates browser's message for email field (we cannot find this message in dom)
    @Then("a message {string} should be displayed")
    public void a_message_should_be_displayed(String expectedMessage) {
        LoginPage loginPage = new LoginPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String actualMessage1 = (String) js.executeScript("return arguments[0].validationMessage;", loginPage.email );
        String actualMessage2 = (String) js.executeScript("return arguments[0].validationMessage;", loginPage.password );

        System.out.println("Browser message " + actualMessage1);
        System.out.println("Browser message " + actualMessage2);
        if (actualMessage1.equals(expectedMessage)) {
            Assert.assertEquals(expectedMessage,actualMessage1);
        }else { Assert.assertEquals(expectedMessage,actualMessage2);}


    }



}
