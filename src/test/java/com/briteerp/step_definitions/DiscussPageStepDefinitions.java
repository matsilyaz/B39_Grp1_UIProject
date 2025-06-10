package com.briteerp.step_definitions;

import com.briteerp.pages.DiscussPage;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DiscussPageStepDefinitions {

    DiscussPage discussPage = new DiscussPage();

    @When("the user clicked on Discuss module.")
    public void the_user_clicked_on_discuss_module() {
        discussPage.clickModule(discussPage.discussModule);

    }

    @Then("the user should see the Discuss module page.")
    public void the_user_should_see_the_discuss_module_page() {
        Assert.assertTrue(discussPage.titleVerification("- Odoo"));
    }

    @When("the user clicked on Calender module.")
    public void the_user_clicked_on_calender_module() {
        discussPage.clickModule(discussPage.calenderModule);
    }
    @Then("the user should see the Calender module page.")
    public void the_user_should_see_the_calender_module_page() {
       Assert.assertTrue(discussPage.titleVerification("- Odoo"));

    }

    @When("the user clicked on {string}.")
    public void the_user_clicked_on(String moduleName) {
        discussPage.navigateToModule(moduleName);

    }
    @Then("the user should see the module page.")
    public void the_user_should_see_the_module_page() {
        Assert.assertTrue(discussPage.titleVerification("- Odoo"));

    }




}
