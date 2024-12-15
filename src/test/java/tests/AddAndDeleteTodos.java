package tests;

import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.example.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddAndDeleteTodos extends BaseTest {

    @Parameters("platform")
    @BeforeMethod
    public void setUpDriver(String platform) {
        setUp(platform);
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

        driver.quit();

    }
}