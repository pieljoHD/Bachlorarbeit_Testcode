package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageIOS;
import org.example.ios.TodoScreenIOS;
import org.testng.annotations.Test;

public class AddAndChangeTodos extends BaseTestIOS {

    @Test
    public void addAndChangeTodos() throws InterruptedException {
        IOSDriver driver = getDriver();

        LoginPageIOS loginPage = new LoginPageIOS(driver);
        loginPage.loginWithRightCredentials();

        TodoScreenIOS todoScreen = new TodoScreenIOS(driver);
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
