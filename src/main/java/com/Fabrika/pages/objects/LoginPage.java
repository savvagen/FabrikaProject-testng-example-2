package com.Fabrika.pages.objects;


import com.Fabrika.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.*;

public class LoginPage extends BasePage {

    public HomePage homePage;

    public LoginPage(WebDriver driver){
        super(driver);
        this.PAGE_URL = LOGIN_PAGE_URL;
        this.PAGE_TITLE = LOGIN_PAGE_TITLE;
    }

    @FindBy(id = "auth_user_email") public static WebElement emailField;
    @FindBy (id = "auth_user_password") public static WebElement passwordField;
    @FindBy (xpath = "//*/input[@value='Login']") public static WebElement loginButton;

    public static final String LOGIN_PAGE_URL = BASE_URL + "default/user/login";
    public static final String LOGIN_PAGE_TITLE  = "Selenium Testing";
    public static final String USER_EMAIL = "savva.genchevskiy@gmail.com";
    public static final String USER_PASSWORD = "19021992qa";


    public void openPage(){
        loadPage();
    }

    public void login(String email, String password) throws Exception {
        setElementText(emailField, email);
        setElementText(passwordField, password);
        clickElement(loginButton);
        waitForElementToBeVisible(homePage.profileButton);
    }



}
