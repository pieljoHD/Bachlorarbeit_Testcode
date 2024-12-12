package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.testng.annotations.Test;

public class AddAndDeleteTodos extends BaseTestAndroid {

    @Test
    public void addAndDeleteTodos() {
        AndroidDriver driver = getDriver();
        new LoginPage(driver)
                .loginWithRightCredentials();
        TodoPage todoScreen = new TodoPage(driver);
        for(int i = 0; i<3; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
        todoScreen.deleteTodo(0);
        todoScreen.deleteTodo(1);
        todoScreen.todoHasTodo("TODO2",0);
    }
}
