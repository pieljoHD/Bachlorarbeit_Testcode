package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.testng.annotations.Test;

public class AddAndChangeTodos extends BaseTestIOS {

    @Test
    public void addAndChangeTodos() {
        IOSDriver driver = getDriver();

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
