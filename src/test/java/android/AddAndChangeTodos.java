package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.example.android.TodoScreenAndroid;
import org.testng.annotations.Test;

public class AddAndChangeTodos extends BaseTestAndroid {

    @Test
    public void addAndChangeTodos() {
        AndroidDriver driver = getDriver();

        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
        loginPage.loginWithRightCredentials();

        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
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
