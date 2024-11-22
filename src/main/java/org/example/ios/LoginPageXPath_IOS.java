package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class LoginPageXPath_IOS extends BasePageIOS<LoginPageXPath_IOS> {
    private final By UserNameInput = By.xpath("//XCUIElementTypeTextField[@name='UsernameInput']");
    private final By PasswortInput = By.xpath("//XCUIElementTypeSecureTextField[@name='PasswortInput']");
    private final By ErrorText = By.xpath("//XCUIElementTypeStaticText[@name='ErrorText']");
    private final By LoginButton = By.xpath("//XCUIElementTypeButton[@name='LoginButton']");

    public LoginPageXPath_IOS(IOSDriver driver) {
        super(driver);
    }

    public void logIn() {
        String x = driver.getPageSource();
        System.out.println(x);
        sendKeys(UserNameInput, "test123");
        sendKeys(PasswortInput, "1234");
        click(LoginButton);
    }
}
