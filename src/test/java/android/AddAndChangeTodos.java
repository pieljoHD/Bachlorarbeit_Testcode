package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.example.utils.BaseTest;
import org.example.utils.PLATFORM;
import org.testng.annotations.Test;

public class AddAndChangeTodos extends BaseTest {

    public AddAndChangeTodos(PLATFORM platform) {
        super(platform);
    }

    @Test
    public void addAndChangeTodos() {
        AndroidDriver driver = (AndroidDriver) getDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithRightCredentials();

        TodoPage todoScreen = new TodoPage(driver);
        for(int i = 0; i<3; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
        todoScreen.changeTodoAndSave("todo1",0);
        todoScreen.changeTodoAndSave("neuesTodo",1);
        todoScreen.changeTodoAndCancel("nichtEinTodo",2);

        todoScreen.todoHasTodo("todo1",0);
        todoScreen.todoHasTodo("neuesTodo",1);
        todoScreen.todoHasTodo("TODO3",2);
    }
}
