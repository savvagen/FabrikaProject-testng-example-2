package com.Fabrika.utilites;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

public class Waits {


    public static WebDriverWait wait;


    public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isDisplayed();
                } catch (NoSuchElementException | StaleElementReferenceException | AssertionError e) {
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> elementIsEnabled(final WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return element.isEnabled();
                }catch (AssertionError | StaleElementReferenceException e){
                    e.printStackTrace();
                    return false;
                } catch (NoSuchElementException e){
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> cookieExist(final Cookie cookie){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return cookie.toString() != null;
                } catch (Exception e){
                    e.printStackTrace();
                    return false;
                }
            }
        };

    }


}
