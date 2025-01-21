package tests;

import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.example.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AddAndChangeTodos extends BaseTest {

    @Parameters("platform")
    @BeforeMethod
    public void setUpDriver(String platform) {
        setUp(platform);
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
        Map<String, String> params = new HashMap<>();
        params.put("status", "passed");
        driver.executeScript("devicefarm: setSessionStatus", params);
        driver.quit();
    }
}
