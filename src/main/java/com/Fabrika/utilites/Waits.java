package com.Fabrika.utilites;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


}
