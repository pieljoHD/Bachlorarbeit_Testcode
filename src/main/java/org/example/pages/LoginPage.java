package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage<LoginPage> {

    @CacheLookup
    @FindBy(id = "UserNameInput")
    private WebElement UserNameInput;

    @CacheLookup
    @FindBy(id = "PasswortInput")
    private WebElement PasswortInput;

    @FindBy(id = "ErrorText")
    private WebElement ErrorText;

    @CacheLookup
    @FindBy(id = "LoginButton")
    private WebElement LoginButton;

    @CacheLookup
    @FindBy(id = "TodoInput")
    private WebElement InputTodoField;

    @FindBy(id = "clearButtonUserName")
    private WebElement ClearButtonUsername;

    @FindBy(id = "clearButtonPassword")
    private WebElement ClearButtonPassword;


    public LoginPage(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public LoginPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clearFieldUsername() {
        click(ClearButtonUsername);
    }

    public void clearFieldPassword() {
        click(ClearButtonPassword);
    }

    public void loginWithRightCredentials() {
        UserNameInput.sendKeys("test123");
        PasswortInput.sendKeys("1234");
        click(LoginButton);
        Assert.assertTrue(InputTodoField.isDisplayed());
    }

    public void loginWithCredentials(String username, String password) {
        UserNameInput.sendKeys(username);
        PasswortInput.sendKeys(password);
        click(LoginButton);
    }

    public void checkNotOnLoginPage() {
        waitElementToBeClickable(InputTodoField);
        Assert.assertTrue(InputTodoField.isDisplayed());
    }

    public void checkErrorTextVisible() {
        Assert.assertTrue(ErrorText.isDisplayed());
    }
}
