package com.briteerp.step_definitions;

import com.briteerp.pages.*;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class US9_ViewProductOrders_Step_Definition {

    LoginPage loginPage=new LoginPage();
    PointOfSalesPage pointOfSalesPage= new PointOfSalesPage();
    Orders orders=new Orders();


    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
      //  Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User logs in as POS Manager")
    public void userLogsInAsPOSManager() {
        loginPage.login(ConfigurationReader.getProperty("pos_manager_username"),ConfigurationReader.getProperty("pos_manager_password") );

    }

    @Then("The POS manager is on the Base page")
    public void thePOSManagerIsOnTheBasePage() {
        BrowserUtils.verifyTitle("Odoo");
    }



    @When("User click Point of the Sale")
    public void userClickPointOfTheSale() {
        DiscussPage pointOfSalePage = new DiscussPage();
        pointOfSalePage.navigateToModule("Point of Sale");

    }

    /*@Given("The POS manager is on the Point of Sale page")
    public void the_pos_manager_is_on_the_point_of_sale_page() {
        // Write code here that turns the phrase above into concrete actions
     BrowserUtils.verifyTitle("Point of Sale - Odoo");
    }*/
    @Then("User should be on the Point of Sales page")
    public void userShouldBeOnThePointOfSalesPage() {
        BrowserUtils.sleep(10);
        BrowserUtils.verifyTitle("Point of Sale - Odoo");

    }
    @Then("User click Orders button")
    public void userClickOrdersButton() {
        BrowserUtils.waitForClickablility(pointOfSalesPage.ordersButton,10);
        pointOfSalesPage.ordersButton.click();
    }

    @When("The POS manager checks the Order Reference")
    public void the_pos_manager_checks_the_order_reference() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.waitForClickablility(orders.orderRef,10);
        orders.orderRef.click();


    }

    @Then("All the orders should be displayed")
    public void all_the_orders_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions

    }


    @Given("The POS manager is on the Orders page")
    public void thePOSManagerIsOnTheOrdersPage() {
        BrowserUtils.waitForTitleContains("Orders"); // başlığın "Orders" içermesini bekle
        BrowserUtils.verifyTitle("Orders - Odoo");
    }

    @When("The POS manager clicks the Action drop-down")
    public void user_clicks_the_action_dropdown() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Orders.actionButton)).click();
    }

    @Then("The dropdown should contain Import, Export and Delete")
    public void the_dropdown_should_contain_import_export_and_delete() {
      //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.visibilityOfAllElements(Orders.actionDropdownOptions));

        List<String> expectedOptions = Arrays.asList("Import", "Export", "Delete");
        List<String> actualOptions = new ArrayList<>();

        for (WebElement option : Orders.actionDropdownOptions) {
            actualOptions.add(option.getText().trim());
        }

        // Assertion
        for (String expected : expectedOptions) {
            assertTrue("Eksik seçenek: " + expected, actualOptions.contains(expected));
        }
    }


}



