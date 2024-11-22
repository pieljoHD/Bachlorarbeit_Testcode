package org.example.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class LoginPageID_IOS extends BasePageIOS<LoginPageID_IOS>{
    private final By UserNameInput = AppiumBy.accessibilityId("UsernameInput");
    private final By PasswortInput = AppiumBy.accessibilityId("PasswortInput");
    private final By ErrorText = AppiumBy.accessibilityId("ErrorText");
    private final By LoginButton = AppiumBy.accessibilityId("LoginButton");

    public LoginPageID_IOS(IOSDriver driver) {
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
