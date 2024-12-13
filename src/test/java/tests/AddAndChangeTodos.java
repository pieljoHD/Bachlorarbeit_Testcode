package tests;

import io.appium.java_client.AppiumDriver;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.SessionManager;

import static utils.SessionManager.getInstance;

public class AddAndChangeTodos {
    AppiumDriver driver = null;
    SessionManager sessionManager = null;

    @Parameters("platform")
    @BeforeMethod
    public void setUpDriver(String platform) {
        sessionManager = getInstance(platform);
        driver = sessionManager.driver;
        sessionManager.openApp();
    }

    @Test
    public void addAndChangeTodos() {
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

        sessionManager.closeApp();
    }
}
