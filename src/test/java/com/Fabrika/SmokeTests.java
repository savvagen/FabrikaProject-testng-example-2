package com.Fabrika;

import com.Fabrika.utilites.BaseTest;
import org.testng.annotations.*;



public class SmokeTests extends BaseTest {


    @Test
    public void positiveLogin() throws Exception {
        loginPage.openPage();
        loginPage.login(loginPage.USER_EMAIL, loginPage.USER_PASSWORD);
        verfier.verifyLogin();
    }


}
