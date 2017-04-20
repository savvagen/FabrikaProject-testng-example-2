package com.Fabrika.utilites;


import com.Fabrika.pages.Verifications;
import com.Fabrika.pages.objects.HomePage;
import com.Fabrika.pages.objects.LoginPage;
import com.Fabrika.pages.objects.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.Fabrika.utilites.Browser.getBrowser;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public ProfilePage profilePage;
    public Verifications verfier;


    public static WebDriverWait wait;


    @BeforeSuite(alwaysRun = true)
    public void startSuite(){
        System.out.println("Suite is strating!!!");
    }

    @AfterSuite(alwaysRun = true)
    public void stopSuite(){
        System.out.println("Suite is ending!");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType"})
    public void setUpClass(@Optional String browserType) throws Exception {
        //this.driver = getDriver(getBrowserTypeByProperty());
        this.driver = getBrowser("firefox", false);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        verfier  =PageFactory.initElements(driver, Verifications.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);

    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }

}
