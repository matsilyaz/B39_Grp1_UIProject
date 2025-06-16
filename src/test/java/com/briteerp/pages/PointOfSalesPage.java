package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PointOfSalesPage {
    public PointOfSalesPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    /**
     *
     * @param DashboardElements
     */
  /*  public void navigateToDashboardElements( String DashboardElements) {

        String dashboardElementLocator = "//span[normalize-space(text())='" + DashboardElements + "']";

        BrowserUtils.waitForClickablility(By.xpath(dashboardElementLocator),5);
        Driver.getDriver().findElement(By.xpath(dashboardElementLocator)).click();
    }*/

    @FindBy(xpath ="//a[@data-action-id='663']")
    public WebElement ordersButton;







}
