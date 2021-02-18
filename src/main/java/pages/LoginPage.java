package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@id = 'user']")
    private WebElement inputlogin;
    @FindBy(xpath = ".//input[@id = 'password']")
    private WebElement inputpass;
    @FindBy(xpath = ".//input[@type = 'submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterLoginSignIn(String login){
        enterTextIntoElement(inputlogin,login);
        logger.info("Log In is entered");
    }
    public void enterPasswordSignIn(String pass){
        enterTextIntoElement(inputpass,pass);
        logger.info("Pass In is entered");
    }
    public LoginPage checkIsRedirectedOnLoginPage(){
        Assert.assertEquals("Invalid page", "https://trello.com/login",webDriver.getCurrentUrl());
        return this;
    }
    public void clickButtonLogIn(){
        clickOnElement(submitButton);
        logger.info("Login button is clicked");
    }

    public void fillLoginFormAndSubmit(String login,String pass){
        checkIsRedirectedOnLoginPage();
        enterLoginSignIn(login);
        enterPasswordSignIn(pass);
        clickButtonLogIn();
    }
    public boolean isAlertErrorVisible() {
        try{
            waitForSeconds(2);
        return webDriver.findElement(By.xpath(".//*[@id = 'error']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


    public boolean buttonLogInIsVisible(){
        try{
            return webDriver.findElement(By.xpath(".//input[@type = 'submit']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }



}
