package com.Fabrika.pages.objects;


import com.Fabrika.pages.BasePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;



import java.util.HashMap;

public class ProfilePage extends BasePage {

    public WebDriver driver;
    public LoginPage loginPage;

    public ProfilePage(WebDriver driver){
        super(driver);
        this.PAGE_URL = PROFILE_PAGE_URL;
        this.PAGE_TITLE = PROFIEL_PAGE_TITLE;
    }


    public static final String PROFILE_PAGE_URL = BASE_URL + "default/user/profile";
    public static final String PROFIEL_PAGE_TITLE  = "Savva" + "'s Profile";
    public static final String DELETE_URL = BASE_URL + "default/after_delete";
    public static final String DELETE_MESSAGE  = "User DELETED!" + "\n" + "×";

    @FindBy(id = "delete_record") public static WebElement deleteCheckBox;
    @FindBy (id = "auth_user_first_name") public static WebElement firstNameField;
    @FindBy (id = "auth_user_last_name") public static WebElement lastNameField;
    @FindBy (id = "auth_user_email") public static WebElement emailField;
    @FindBy (id = "auth_user_password") public static WebElement passwordField;
    @FindBy(id = "auth_user_nickname") public static WebElement nickNameField;
    @FindBy(id = "auth_user_image") public static WebElement imageField;
    @FindBy (xpath = "//*/input[@value='Submit']") public static WebElement submitButton;
    @FindBy(className = "flash") public static WebElement flashMessageField;
    @FindBy(linkText = "Home") public static WebElement homeButton;

    private String cookieName = "session_id_test_1";


    HashMap<String, String> cookies = new HashMap<String, String>(){{
        put("profileCookieValue", "195.138.69.181-690f196f-8d52-456e-a47c-5260d2b2ee9b");
        put("testProfileCookieValue", "195.138.69.181-f793c268-5c70-4606-a206-aa0577f86fe2");
    }};

    public Cookie profileCookie = new Cookie.Builder(cookieName, cookies.get("profileCookieValue")).build();
    public Cookie testProfileCookie = new Cookie.Builder(cookieName, cookies.get("testProfileCookieValue")).build();



    public void openPage() throws Exception {
        getPage(BASE_URL);
        addCookie(profileCookie);
        loadPage();
    }

    public void openTestProfile() throws Exception {
        getPage(BASE_URL);
        addCookie(testProfileCookie);
        loadPage();
    }










}
