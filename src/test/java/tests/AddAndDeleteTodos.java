package tests;

import io.appium.java_client.AppiumDriver;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.SessionManager;

import static utils.SessionManager.getInstance;


public class AddAndDeleteTodos {

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
    public void addAndDeleteTodos() {
        new LoginPage(driver)
                .loginWithRightCredentials();
        TodoPage todoScreen = new TodoPage(driver);
        for (int i = 0; i < 3; i++) {
            int x = i + 1;
            todoScreen.addTodo("TODO" + x, i);
        }
        todoScreen.deleteTodo(0);
        todoScreen.deleteTodo(1);
        todoScreen.todoHasTodo("TODO2", 0);

        sessionManager.closeApp();
    }
}