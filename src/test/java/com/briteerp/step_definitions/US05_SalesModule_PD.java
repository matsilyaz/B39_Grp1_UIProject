package com.briteerp.step_definitions;

import com.briteerp.pages.LoginPage;
import com.briteerp.pages.SalesPage;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.ht.E;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US05_SalesModule_PD {

    LoginPage loginPage = new LoginPage();
    SalesPage salesPage = new SalesPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @Given("the user is logged in as Sales Manager using {string} and {string}")
    public void the_user_is_logged_in_as_sales_manager_using_and(String username, String password) {
        loginPage.login(username, password);
       /* wait.until(ExpectedConditions.elementToBeClickable(loginPage.submit));
        loginPage.submit.click();*/
    }

    @When("the user clicks on the Sales module")
    public void the_user_clicks_on_the_sales_module() {
        BrowserUtils.waitForPageToLoad(3);
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.salesModule));
        salesPage.salesModule.click();

    }

    @Then("the user clicks Customers button")
    public void the_user_clicks_customers_button() {
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.customersButton));
        salesPage.customersButton.click();
    }

    @Then("the user clicks on Create button")
    public void the_user_clicks_on_create_button() {
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.createButton));
        salesPage.createButton.click();
    }

    String expectedCustomerName = "A.A.Pınar Deniz";
    String updatedCustomerName = expectedCustomerName + "....";

    @Then("the user fills in customer name field")
    public void the_user_fills_in_customer_name_field() {
        wait.until(ExpectedConditions.visibilityOf(salesPage.nameInput));
        salesPage.nameInput.sendKeys(expectedCustomerName);
    }

    @Then("the user clicks on Save button")
    public void the_user_clicks_on_save_button() {
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.saveButton));
        salesPage.saveButton.click();
    }

    @Then("the name of the new customer should created in the name field")
    public void the_name_of_the_new_customer_should_created_in_the_name_field() {
        String actualCustomerName = salesPage.actualName.getText();
        Assert.assertEquals(expectedCustomerName, actualCustomerName);
    }

    @When("the user clicks on the newly created customer")
    public void the_user_clicks_on_the_newly_created_customer() {
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.cratedCustomer));
        salesPage.cratedCustomer.click();


    }
    @When("the user clicks on Edit button")
    public void the_user_clicks_on_edit_button() {
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.editButton));
        salesPage.editButton.click();
    }
    @When("the user modifies the customer name")
    public void the_user_modifies_the_customer_name() {
        wait.until(ExpectedConditions.visibilityOf(salesPage.nameInput));
        salesPage.nameInput.clear();
        salesPage.nameInput.sendKeys(updatedCustomerName);


    }
    @When("the user clicks on Save button after editing")
    public void the_user_clicks_on_save_button_after_editing() {
        wait.until(ExpectedConditions.elementToBeClickable(salesPage.saveButtonAgain));
        salesPage.saveButtonAgain.click();

    }

}