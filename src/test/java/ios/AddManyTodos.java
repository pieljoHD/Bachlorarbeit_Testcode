package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.testng.annotations.Test;

public class AddManyTodos extends BaseTestIOS {
    @Test
    public void addManyTodos() {
        IOSDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithRightCredentials();

        TodoPage todoScreen = new TodoPage(driver);
        for(int i = 0; i<20; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
    }
}
