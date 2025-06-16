package com.briteerp.step_definitions;

import com.briteerp.pages.DiscussPage;
import com.briteerp.pages.LoginPage;
import com.briteerp.pages.RepairsPage;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class US8_RepairPage_StepDefinition {


    LoginPage loginPage = new LoginPage();

    DiscussPage discussPage = new DiscussPage();

    RepairsPage repairsPage = new RepairsPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @When("the user logged in with different valid credentials as the {string} and {string}")//1
    public void theUserLoggedInWithDifferentValidCredentialsAsTheAnd(String mail, String password) {
        loginPage.login(mail, password);

    }


    @Then("User should be on the Discuss page")//2
    public void userShouldBeOnTheDiscussPage() {

        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.verifyTitle("#Inbox - Odoo");
        System.out.println(" ----------------------------");
    }

    @When("user clicks on the  Repairs Page")//3
    public void userClicksOnTheRepairsPage() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(discussPage.repairsModule, 10);
        discussPage.navigateToModule("Repairs");


    }

    @Then("user should be on the Repairs page")//4
    public void userShouldBeOnTheRepairsPage() {

        wait.until(ExpectedConditions.titleIs("Repair Orders - Odoo"));
        BrowserUtils.verifyTitle("Repair Orders - Odoo");
    }

    @Then("User should see {int} columns in the repair orders table and The column headers should be:")//5
    public void userShouldSeeColumnsInTheRepairOrdersTableAndTheColumnHeadersShouldBe(Integer expectedColumnCount, List<String> expectedHeaders) {

        repairsPage.verifyColumnCount(expectedColumnCount, expectedHeaders);
    }

    @When("User clicks the Search button")//6
    public void user_clicks_the_search_button() {
        BrowserUtils.waitForClickablility(repairsPage.searchbox, 10);
        repairsPage.searchbox.click();
    }

    @When("User enters {string} into the Repair Reference search field")//7
    public void user_enters_into_the_repair_reference_search_field(String string) {


        repairsPage.searchbox.clear();
        repairsPage.searchbox.sendKeys(string + Keys.ENTER);

    }


    @Then("The repair record with Repair Reference {string} should be visible in the list")//8
    public void the_repair_record_with_repair_reference_should_be_visible_in_the_list(String expectedRepairReference) {


        String actualText = repairsPage.actualRepairsReference.getText().trim();

        Assert.assertEquals(expectedRepairReference, actualText);
    }


}