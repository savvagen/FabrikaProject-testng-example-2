package com.Fabrika;

import com.Fabrika.utilites.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.*;

import java.util.HashMap;


public class SmokeTests extends BaseTest {


    @Test
    public void positiveLogin() throws Exception {
        loginPage.openPage();
        loginPage.login(loginPage.USER_EMAIL, loginPage.USER_PASSWORD);
        verfier.verifyLogin();
    }

    @Test
    public void profileTest() throws Exception{
        profilePage.openPage();
        Thread.sleep(3000);
    }


}
