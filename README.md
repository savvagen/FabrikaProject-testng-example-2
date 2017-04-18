# Selenium testNg example - 2
In this project we are using another variant of PageObject realizing:
In the prevoius project we had
 ```
public class Page {

    publick Webdriver webdriver

    pulick Page page(Webdriver driver){
        this.webdriver = driver;
        PageFactory.initElements(driver, this);
    }
}
 ```
 In the new version we are using BasePage.class:
 
  ```
 public class Page extends BasePage {
 
     pulick Page page(Webdriver driver){
         super(driver)
     }
 }
  ```