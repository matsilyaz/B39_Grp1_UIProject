package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Orders {
    public Orders() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath= "//th//input[@type='checkbox']")
    public WebElement orderRef;

    @FindBy(xpath = "//button[normalize-space(text())='Action']")
    public static WebElement actionButton;

    @FindBy(xpath = "//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'][1]")
    public static List<WebElement> actionDropdownOptions;



}