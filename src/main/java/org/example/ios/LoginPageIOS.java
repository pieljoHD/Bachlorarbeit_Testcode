package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageIOS extends BasePageIOS<LoginPageIOS>{
    @FindBy(id = "UserNameInput")
    private WebElement UserNameInput;

    @FindBy(id = "PasswortInput")
    private WebElement PasswortInput;

    @FindBy(id = "ErrorText")
    private WebElement ErrorText;

    @FindBy(id = "LoginButton")
    private WebElement LoginButton;

    @FindBy(id = "TodoInput")
    private WebElement InputTodoField;

    @FindBy(id = "clearButtonUserName")
    private WebElement ClearButtonUsername;

    @FindBy(id = "clearButtonPassword")
    private WebElement ClearButtonPassword;

    public LoginPageIOS(IOSDriver driver) {
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
