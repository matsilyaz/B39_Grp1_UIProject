package com.briteerp.pages;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage {
    public SalesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()[normalize-space()='Sales']])[1]")
    public WebElement salesModule;

    @FindBy(xpath = "(//span[text()[normalize-space()='Customers']])[2]")
    public WebElement customersButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public WebElement createButton;

    @FindBy(xpath = "//input[@name='name' and contains(@class,'o_field_char')]")  // Örn: Musteri adı girişi
    public WebElement nameInput;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath ="//span[@name='name']")
    public WebElement actualName;

    @FindBy(xpath ="//span[.='A.A.Pınar Deniz']")
    public WebElement cratedCustomer;

    @FindBy(xpath ="//button[normalize-space(.)='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveButtonAgain;



}
