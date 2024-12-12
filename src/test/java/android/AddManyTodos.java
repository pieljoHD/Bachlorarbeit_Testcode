package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.testng.annotations.Test;

public class AddManyTodos extends BaseTestAndroid {
    @Test
    public void addManyTodos() {
        AndroidDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithRightCredentials();

        TodoPage todoScreen = new TodoPage(driver);
        for(int i = 0; i<20; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
    }
}
