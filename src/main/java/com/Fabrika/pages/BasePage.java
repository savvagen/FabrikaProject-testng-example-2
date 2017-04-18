package com.Fabrika.pages;


import com.Fabrika.pages.objects.HomePage;
import com.Fabrika.pages.objects.LoginPage;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.*;
import static com.Fabrika.utilites.Waits.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public static WebDriverWait wait;

    public HomePage homePage;

    public String PAGE_URL;
    public String PAGE_TITLE;
    public static  final String BASE_URL = "http://vlay.pythonanywhere.com/test_1/";


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    @FindBy(linkText = "Logout") public static WebElement logoutButton;
    @FindBy(linkText = "Login") public static WebElement loginButton;


    public void loadPage(){
        driver.get(getPageUrl());
        waitForTitle(getPAgeTitle());
        assertEquals(driver.getCurrentUrl(), getPageUrl());
        assertEquals(driver.getTitle(), getPAgeTitle());
    }


    public String getPageUrl(){
        return PAGE_URL;
    }

    public String getPAgeTitle(){
        return  PAGE_TITLE;
    }

    public void waitForTitle(String title){
        try {
            wait.until(titleIs(title));
            assertEquals(title, driver.getTitle());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void waitForElementToBeVisible(WebElement element){
        try {
            wait.until(visibilityOfElement(element));
            assertTrue(element.isDisplayed());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void waitElementToBeClickable(WebElement element){
        try {
            wait.until(elementToBeClickable(element));
            assertTrue(element.isEnabled());
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void setElementText(WebElement element, String text){
        try {
            visibilityOfElement(element);
            element.clear();
            element.sendKeys(text);
            //assertEquals(element.getAttribute("value"), text);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void clickElement(WebElement element){
        try {
            waitElementToBeClickable(element);
            element.click();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void logOut(){
        try {
            if (logoutButton.isDisplayed()){
                clickElement(logoutButton);
                waitForTitle(homePage.HOME_PAGE_TITLE);
                waitForElementToBeVisible(loginButton);
                assertTrue(loginButton.isDisplayed());
            } else if (loginButton.isDisplayed()){
                System.out.println("User is allready logged out.");
            }
        } catch (Exception | AssertionError e){
            e.printStackTrace();
        }
    }


    public static boolean assertVisibility(WebElement element) {
        try {
            assertTrue(element.isDisplayed());
            return true;
        } catch (AssertionError e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verify(String expected, String actual){
        try {
            assertEquals(expected, actual);
            return true;
        } catch (AssertionError e){
            e.printStackTrace();
            return false;
        }
    }



}
