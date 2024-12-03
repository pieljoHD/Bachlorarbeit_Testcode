package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageIOS;
import org.example.ios.TodoScreenIOS;
import org.testng.annotations.Test;

public class AddManyTodos extends BaseTestIOS {
    @Test
    public void addManyTodos() {
        IOSDriver driver = getDriver();

        LoginPageIOS loginPage = new LoginPageIOS(driver);
        loginPage.loginWithRightCredentials();

        TodoScreenIOS todoScreen = new TodoScreenIOS(driver);
        for(int i = 0; i<20; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
    }
}
