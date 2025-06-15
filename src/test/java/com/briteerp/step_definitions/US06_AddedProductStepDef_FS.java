package com.briteerp.step_definitions;

import com.briteerp.pages.LoginPage;
import com.briteerp.pages.ProductPage;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class US06_AddedProductStepDef_FS {
    public String expectedProductName;

    // Objects
    ProductPage productPage=new ProductPage();
    LoginPage loginPage = new LoginPage();
    Faker faker=new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    // Step_1=Login
    @Given("User logs in using {string} and {string}")
    public void userLogsInUsingAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @When("the POS Manager clicks the Inventory button")
    public void thePOSManagerClicksTheInventoryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(productPage.inventoryButton));
        productPage.inventoryButton.click();
    }

    @And("the POS Manager clicks the Products button")
    public void thePOSManagerClicksTheProductsButton() {
        BrowserUtils.waitForClickablility(productPage.productsButton, 10);
        productPage.productsButton.click();
    }

    @And("clicks the Create button")
    public void clicksTheCreateButton() {
        BrowserUtils.waitForClickablility(productPage.createButton, 10);
        productPage.createButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @And("enters product name")
    public void entersProductName() {
        expectedProductName=faker.food().fruit();
        BrowserUtils.waitForVisibility(productPage.productName, 10);
        productPage.productName.sendKeys(expectedProductName);
        System.out.println("Generated product name: " + expectedProductName);
    }

    @And("clicks the Save button")
    public void clicksTheSaveButton() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForClickablility(productPage.saveButton, 10);
        productPage.saveButton.click();
    }

    @And("clicks the Products button")
    public void clicksTheProductsButton() {
        BrowserUtils.waitForClickablility(productPage.productsButton, 10);
        productPage.productsButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("Verify the user sees information of the product name")
    public void verifyTheUserSeesInformationOfTheProductName() {
        wait.until(ExpectedConditions.visibilityOf(productPage.actualProductName));
        Assert.assertEquals(expectedProductName, productPage.actualProductName.getText());
    }
    //EDIT--->

    @Given("the POS Manager is on the Product List page")
    public void thePOSManagerIsOnTheProductListPage() {
        BrowserUtils.verifyElementDisplayed(productPage.productListHeader);
    }

    @When("the user clicks any product")
    public void theUserClicksAnyProduct() {
        BrowserUtils.waitForClickablility(productPage.productList.get(0), 10);
        productPage.anyClickProductAtIndex(0);
        BrowserUtils.waitForPageToLoad(10);
    }

    @And("the user clicks the Edit button")
    public void theUserClicksTheEditButton() {
        BrowserUtils.waitForClickablility(productPage.editButton, 10);
//        BrowserUtils.scrollToElement(productPage.editButton);
        BrowserUtils.clickWithJS(productPage.editButton);
        BrowserUtils.waitForPageToLoad(10);
    }
    @And("the user changes the Product Name")
    public void theUserChangesTheProductName() {
       productPage.productName.clear();
        productPage.productName.sendKeys("Electrical Car" + Keys.ENTER);
    }
    @And("Verify all the boxes  are editable")
    public void verifyAllTheBoxesAreEditable() {
        // General information
        Assert.assertTrue(productPage.productType.isEnabled());
        Assert.assertTrue(productPage.category.isEnabled());
        Assert.assertTrue(productPage.internalReference.isEnabled());
        Assert.assertTrue(productPage.barcode.isEnabled());

        // Checkboxes
        Assert.assertTrue(productPage.canBeSold.isDisplayed());
        Assert.assertTrue(productPage.canBePurchased.isDisplayed());
        Assert.assertTrue(productPage.canBeExpensed.isDisplayed());

        // Different selects
        productPage.inventory.click();
        Assert.assertTrue(productPage.inventory.isDisplayed());
        productPage.invoicing.click();
        Assert.assertTrue(productPage.invoicing.isDisplayed());
        productPage.notes.click();
        Assert.assertTrue(productPage.notes.isDisplayed());

        // 2 input area
        Assert.assertTrue(productPage.input1.isEnabled());
        Assert.assertTrue(productPage.input2.isEnabled());

        //Other button
        Assert.assertTrue(productPage.onWebsiteButton.isDisplayed());
        Assert.assertTrue(productPage.onHandButton.isDisplayed());
        Assert.assertTrue(productPage.moreCastedButton.isDisplayed());
        Assert.assertTrue(productPage.productMovesButton.isDisplayed());
        Assert.assertTrue(productPage.moreButton.isDisplayed());

        System.out.println("All fields are editable.");
    }

    @And("the user clicks the Save button")
    public void theUserClicksTheSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(productPage.saveButton));
        productPage.saveButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }
    @And("the user clicks the Products button")
    public void theUserClicksTheProductsButton() {
        BrowserUtils.waitForClickablility(productPage.productsButton, 10);
        productPage.productsButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the new information of product should be displayed in the product list.")
    public void theNewInformationOfProductShouldBeDisplayedInTheProductList() {
        wait.until(ExpectedConditions.visibilityOf(productPage.actualProductName));
        expectedProductName="Electrical Car";
        Assert.assertEquals(expectedProductName, productPage.actualProductName.getText());
    }




}


