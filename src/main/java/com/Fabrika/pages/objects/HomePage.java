package com.Fabrika.pages.objects;


import com.Fabrika.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        this.PAGE_URL  = HOME_PAGE_URL;
        this.PAGE_TITLE = HOME_PAGE_TITLE;
    }


    public static final String HOME_PAGE_URL  = BASE_URL + "default/index";
    public static final String HOME_PAGE_TITLE = "Selenium Testing";
    public static final String FLASH_MESSAGE_NOT_LOGIN = "Welcome to Selenium course!" + "\n" + "×";
    public static final String FLASH_MESSAGE_LOGGED_IN = "Welcome to Selenium course, " + "Savva" + "!" + "\n" + "×";

    @FindBy(className = "flash") public static WebElement flashBoard;
    @FindBy(xpath = ".//*[@id='main']/div[3]/div/div[2]/div/table/tbody") public static WebElement postsTable;
    @FindBy(linkText = "Register") public static WebElement registerButtom;
    @FindBy(linkText = "Profile") public static WebElement profileButton;
    @FindBy(xpath = "//*/div[@class='seven columns alpha']/p/strong") public static WebElement homeMessageTitle;
    @FindBy(xpath = "//*/div[@class='seven columns alpha']/p/br") public static WebElement homeMessageText;
    @FindBy(xpath = "//*/a[@href='/test_1/default/about']") public static WebElement aboutLink;
    @FindBy(xpath = "//*/a[@href='/test_1/default/terms']") public static WebElement termsLink;
    @FindBy(xpath = "//*/a[@href='/test_1/default/contact']") public static WebElement contactLink;
    @FindBy(xpath = "//*/a[@href='/test_1/default/index']") public static WebElement homeButton;
    @FindBy(linkText = "Description") public static WebElement descriptionButton;
    @FindBy(linkText = "Help") public static WebElement helpButton;
    @FindBy(linkText = "Post Message") public static WebElement postMessageButton;





}
