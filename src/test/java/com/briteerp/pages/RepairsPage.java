package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.ResolutionException;
import java.util.List;

public class RepairsPage {


    public RepairsPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    /**
     * This method will navigate user to the specific 6 columns in breerp application.
     * For example: if moduleName is equals to ""
     * Then method will navigate user to this page: ""
     *
     * @param columns
     */
   public void navigateToColumns(String columns) {

        String columnsLocator = "//span[normalize-space(text())='" + columns + "']";

        BrowserUtils.waitForClickablility(By.xpath(columnsLocator), 5);
        Driver.getDriver().findElement(By.xpath(columnsLocator)).click();
    }

    @FindBy(xpath = "//th[.='Repair Reference']")
    public WebElement RepairReferenceColumns;

    @FindBy(xpath = "//th[.='Product to Repair']")
    public WebElement ProductToRepairColumns;

    @FindBy(xpath = "//th[.='Customer']")
    public WebElement CustomerColumns;

    @FindBy(xpath = "//th[.='Delivery Address']")
    public WebElement DeliveryAddressColumns;

    @FindBy(xpath = "//th[.='Warranty Expiration']")
    public WebElement WarrantyExpirationColumns;

    @FindBy(xpath = "//th[.='Status']")
    public WebElement StatusColumns;

  //  public void clickSearchRepairPage()


    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchbox;


    @FindBy(xpath = "//th[@class='o_column_sortable']")
    public List <WebElement> columnHeaders;


    @FindBy(xpath = "//td[.='RMA/00240']")
    public  WebElement actualRepairsReference;

    public void verifyColumnCount(Integer expectedColumnCount, List<String> expectedHeaders) {
        // 1. Sütun sayısı doğru mu?
        Assert.assertEquals("Column count is incorrect!", expectedColumnCount.intValue(),
                columnHeaders.size());

        // 2. Sütun başlıklarını tek tek karşılaştır
        for (int i = 0; i < expectedHeaders.size(); i++) {
            String actual = columnHeaders.get(i).getText().trim();
            String expected = expectedHeaders.get(i).trim();
            System.out.println("-----");
            System.out.println("Expected  : " + expected + " | Actual: " + actual);  // Hata ayıklamak için
            Assert.assertEquals("Column header at index " + i + " doesn't match!", expected, actual);
        }
    }





}