package com.Fabrika.pages;

import com.Fabrika.pages.objects.HomePage;
import com.Fabrika.pages.objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;


public class Verifications extends BasePage {


    public LoginPage loginPage;
    public HomePage homePage;


    public Verifications(WebDriver driver) {
        super(driver);
    }

    public void verifyLogin() {
        try {
            waitForElementToBeVisible(homePage.flashBoard);
            assertEquals(homePage.HOME_PAGE_TITLE, driver.getTitle());
            verify(homePage.flashBoard.getText(), homePage.FLASH_MESSAGE_LOGGED_IN);
            verify(driver.getTitle(), homePage.HOME_PAGE_TITLE);
            verify(driver.getCurrentUrl(), homePage.HOME_PAGE_URL);
            assertVisibility(homePage.profileButton);
        } finally {
            logOut();
        }
    }



}
