package com.briteerp.pages;


import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="login")
    public WebElement email;



    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessage;


    public void login(String userNameStr, String passwordStr) {
        email.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
        // verification that we logged
    }

    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return null; // If error message is not displayed, null is returned.
        }
    }
}
