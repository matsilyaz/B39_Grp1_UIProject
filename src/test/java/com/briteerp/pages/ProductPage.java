package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//span[text()[normalize-space()='Inventory']]" )
    public WebElement inventoryButton;

    @FindBy(xpath ="(//span[text()[normalize-space()='Products']])[6]" )
    public WebElement productsButton;

    @FindBy(xpath = "//button[text()[normalize-space()='Create']]")//doğru
   public WebElement createButton;

    @FindBy(xpath = "//input[@placeholder='Product Name']")
    public WebElement productName;

    @FindBy(xpath = "//span[@name='name']")
    public WebElement actualProductName;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButton;

    @FindBy(xpath ="//ol/li[.='Products']")
    public WebElement productListHeader;

    @FindBy(xpath = "//strong/span")// tüm liste
    public List<WebElement> allProducts;

    public WebElement getProductName(String productName) {
        BrowserUtils.waitForVisibility(allProducts.get(0), 10);
        for (WebElement product : allProducts) {
            if (product.getText().trim().equalsIgnoreCase(productName.trim())) {
                return product;
            }
        }
        return null;
    }

    @FindBy(xpath = "//button[normalize-space(text())='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//div[@class='oe_kanban_global_click o_kanban_record']")
    public List<WebElement> productList; //birden fazla var bu nedenle list webelement.

    public void anyClickProductAtIndex(int index) {//istediğim indexi girip ürün açabilirim
        if (productList.isEmpty()) {
            System.out.println("Ürün listesi boş.");
            throw new RuntimeException("Hiç ürün bulunamadı.");
        }
        if (index < 0 || index >= productList.size()) {
            throw new IllegalArgumentException("Geçersiz ürün indeksi: " + index);
        }

        WebElement product = productList.get(index);

        BrowserUtils.waitForVisibility(product, 10);
        BrowserUtils.scrollToElement(product);
        BrowserUtils.waitForClickablility(product, 10);
        try {
            product.click();
        } catch (Exception e) {
            // Eğer normal click çalışmazsa JS ile tıklamayı dene
            BrowserUtils.clickWithJS(product);
        }
    }

    // all boxes
    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
   public WebElement canBeSold;

    @FindBy(xpath = "(//input[@type='checkbox'])[5]")
    public WebElement canBePurchased;

    @FindBy(xpath = "(//input[@type='checkbox'])[6]")
    public WebElement canBeExpensed;

    @FindBy(xpath = "//a[.='General Information']")
    public WebElement generalInformation;

    @FindBy(xpath = "//a[.='Inventory']")
    public WebElement inventory;

    @FindBy(xpath = "//a[.='Invoicing']")
    public WebElement invoicing;

    @FindBy(xpath = "//a[.='Notes']")
    public WebElement notes;

    @FindBy(xpath = "//select[@name='type']")
    public WebElement productType;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement category;

    @FindBy(xpath = "(//input[@class='o_field_char o_field_widget o_input'])[1]")
    public WebElement internalReference;

    @FindBy(xpath = "(//input[@class='o_field_char o_field_widget o_input'])[2]")
    public WebElement barcode;

    @FindBy(xpath = "(//input[@class='o_input'])[1]")
    public WebElement input1;

    @FindBy(xpath = "(//input[@class='o_input'])[2]")
    public WebElement input2;

    @FindBy(xpath = "(//button[@class='btn btn-sm oe_stat_button'])[1]")
    public WebElement onWebsiteButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm oe_stat_button'])[2]")
    public WebElement onHandButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm oe_stat_button'])[3]")
    public WebElement moreCastedButton;

    @FindBy(xpath = "(//button[@class='btn btn-sm oe_stat_button'])[4]")
    public WebElement productMovesButton;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[7]")
    public WebElement moreButton;
}
