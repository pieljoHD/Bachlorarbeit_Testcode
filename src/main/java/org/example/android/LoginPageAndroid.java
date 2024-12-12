package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageAndroid extends BasePageAndroid<LoginPageAndroid>{
    @AndroidFindBy(id = "UserNameInput")
    private WebElement UserNameInput;

    @AndroidFindBy(id = "PasswortInput")
    private WebElement PasswortInput;

    @AndroidFindBy(id = "ErrorText")
    private WebElement ErrorText;

    @AndroidFindBy(id = "LoginButton")
    private WebElement LoginButton;

    @AndroidFindBy(id = "todoInput")
    private WebElement InputTodoField;

    @AndroidFindBy(id = "clearButtonUserName")
    private WebElement ClearButtonUsername;

    @AndroidFindBy(id = "clearButtonPassword")
    private WebElement ClearButtonPassword;


    public LoginPageAndroid(AndroidDriver driver) {
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
