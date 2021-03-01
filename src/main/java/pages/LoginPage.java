package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@id = 'user']")
    private WebElement inputlogin;
    @FindBy(xpath = ".//input[@id='password']")
    private WebElement inputpass;
    @FindBy(xpath = ".//input[@type = 'submit']")
    private WebElement submitButton;
    @FindBy(xpath = ".//input[@id = 'login']")
    private WebElement atlassianButton;
    @FindBy(xpath = ".//button[@id = 'login-submit']")
    private WebElement submitButtonWithPass;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterLoginSignIn(String login){
        enterTextIntoElement(inputlogin,login);
        logger.info("Log In is entered");
    }
    public void enterPasswordSignIn(String pass){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id='password']")));
        enterTextIntoElement(inputpass,pass);
        logger.info("Pass is entered");
    }
    public LoginPage checkIsRedirectedOnLoginPage(){
        Assert.assertEquals("Invalid page", "https://trello.com/login",webDriver.getCurrentUrl());
        return this;
    }
    public void clickButtonLogIn(){
        clickOnElement(submitButton);
        logger.info("Login button is clicked");
    }
    public void clickButtonEnterWithPass(){
        clickOnElement(submitButtonWithPass);
        logger.info("Log in button is clicked");
    }

    public void fillLoginFormAndSubmit(String login, String pass){
        checkIsRedirectedOnLoginPage();
        enterLoginSignIn(login);
        clickButtonLogInWithAtlassian();
        enterPasswordSignIn(pass);
        clickButtonEnterWithPass();
    }
    public boolean isAlertErrorVisible() {
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id = 'error']"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


    public boolean buttonLogInIsVisible(){
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@type = 'submit']"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickButtonLogInWithAtlassian(){
        clickOnElement(atlassianButton);
        logger.info("Log in with Atlassian button is clicked");
    }

}
