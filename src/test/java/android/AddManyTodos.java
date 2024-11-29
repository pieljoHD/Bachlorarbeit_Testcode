package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.example.android.TodoScreenAndroid;
import org.testng.annotations.Test;

public class AddManyTodos extends BaseTestAndroid {
    @Test
    public void addManyTodos() {
        AndroidDriver driver = getDriver();

        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
        loginPage.loginWithRightCredentials();

        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
        for(int i = 0; i<20; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
    }
}
