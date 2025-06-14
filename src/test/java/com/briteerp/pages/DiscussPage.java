package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscussPage {

    public DiscussPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    /**
     * This method will navigate user to the specific module in breerp application.
     * For example: if moduleName is equals to "Sales"
     * Then method will navigate user to this page: "Sales order menu"
     * @param module
     */

    public void navigateToModule( String module) {

        String moduleLocator = "//span[normalize-space(text())='" + module + "']";

            BrowserUtils.waitForClickablility(By.xpath(moduleLocator),5);
            Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
    }

    @FindBy(xpath ="//span[normalize-space(text())='Discuss']")
    public WebElement discussModule;

    @FindBy(xpath ="//span[normalize-space(text())='Calendar']")
    public WebElement calenderModule;

    @FindBy(xpath ="//span[normalize-space(text())='Notes']")
    public WebElement notesModule;

    @FindBy(xpath ="//span[normalize-space(text())='Contacts'][1]")
    public WebElement contactsModule;

    @FindBy(xpath ="//span[normalize-space(text())='CRM']")
    public WebElement cRMModule;

    @FindBy(xpath ="//span[normalize-space(text())='Sales'][1]")
    public WebElement salesModule;

    @FindBy(xpath ="//span[normalize-space(text())='Website']")
    public WebElement websiteModule;

    @FindBy(xpath ="//span[normalize-space(text())='Point of Sale'][1]")
    public WebElement pointOfSaleModule;

    @FindBy(xpath ="//*[contains(text(),'More')]")
    public WebElement moreModule;

    @FindBy(xpath ="//span[normalize-space(text())='Purchases']")
    public WebElement purchasesModule;

    @FindBy(xpath ="//span[normalize-space(text())='Inventory']")
    public WebElement inventoryModule;

    @FindBy(xpath ="//span[normalize-space(text())='Repairs']")
    public WebElement repairsModule;

    @FindBy(xpath ="//span[normalize-space(text())='Invoicing']")
    public WebElement invoicingModule;

    @FindBy(xpath ="//span[normalize-space(text())='Email Marketing']")
    public WebElement emailMarketingModule;

    @FindBy(xpath ="//span[normalize-space(text())='Events'][1]")
    public WebElement eventsModule;

    @FindBy(xpath ="//span[normalize-space(text())='Employees'][1]")
    public WebElement employeesModule;

    @FindBy(xpath ="//span[normalize-space(text())='Leaves']")
    public WebElement leavesModule;

    @FindBy(xpath ="//span[normalize-space(text())='Expenses']")
    public WebElement expensesModule;

    @FindBy(xpath ="//span[normalize-space(text())='Maintenance']")
    public WebElement maintenanceModule;

    @FindBy(xpath ="//span[normalize-space(text())='Dashboards']")
    public WebElement dashboardsModule;

    @FindBy(xpath = "//i[@class='fa fa-clock-o']")
    public WebElement clockActivityButton;

    @FindBy(xpath = "//i[@class='fa fa-comments']")
    public WebElement conversationsButton;

    @FindBy(xpath = "//img[@class='img-circle oe_topbar_avatar']")
    public WebElement circleAvatar;

    @FindBy(xpath ="//span[normalize-space(text())='SalesManager50']")
    public WebElement usernameTopBar;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@class='o_searchview_more fa fa-search-plus']")
    public WebElement advancedSearchButton;

    @FindBy(xpath = "//div[@class='o_mail_chat_title_main o_mail_chat_channel_item o_active']")
    public WebElement mailInboxTitle;

    @FindBy(xpath = "//i[@class=\'fa fa-inbox mr8\']")
    public WebElement inboxSymbol;

    @FindBy(xpath = "//span[.='Starred']")
    public WebElement starredTitle;

    @FindBy(xpath = "//i[@class='fa fa-star-o mr8']")
    public WebElement starredSymbol;

    @FindBy(xpath = "//b[.='Channels']")
    public WebElement channelsTitle;

    @FindBy(xpath = "//span[@data-type='public']")
    public WebElement addChannelButton;

    @FindBy(xpath = "//b[.='Direct Messages']")
    public WebElement directMessagesTitle;

    @FindBy(xpath = "//span[@data-type='dm']")
    public WebElement addDirectMessagesUserButton;

    @FindBy(xpath = "//b[.='Private Channels']")
    public WebElement privateChannelsTitle;

    @FindBy(xpath = "//span[@data-type='private']")
    public WebElement addPrivateChannelsButton;


    @FindBy(xpath = "//div[@title='general']")
    public WebElement generalChannelTitle;

    @FindBy(xpath = "//span[@class='o_mail_hash']")
    public WebElement generalChannelHashButton;


    public static void clickModule(WebElement element) {
            BrowserUtils.waitForClickablility(element,5);
            element.click();

    }
    public static boolean titleVerification(String title) {
        BrowserUtils.waitForTitleContains(title);
        String actualTitle = Driver.getDriver().getTitle();
         return actualTitle.contains(title);
    }






}
