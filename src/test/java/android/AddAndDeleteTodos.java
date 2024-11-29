package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.example.android.TodoScreenAndroid;
import org.testng.annotations.Test;

public class AddAndDeleteTodos extends BaseTestAndroid {

    @Test
    public void addAndDeleteTodos() {
        AndroidDriver driver = getDriver();
        new LoginPageAndroid(driver)
                .loginWithRightCredentials();
        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
        for(int i = 0; i<3; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
        todoScreen.deleteTodo(0);
        todoScreen.deleteTodo(1);
        todoScreen.todoHasTodo("TODO2",0);
    }
}
