package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.example.android.TodoScreenAndroid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndMarkTodo extends BaseTestAndroid {

    @Test
    public void addAndMarkTodo() {
        AndroidDriver driver = getDriver();
        new LoginPageAndroid(driver)
                .loginWithRightCredentials();
        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
        for(int i = 0; i<2; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
        todoScreen.markTodo(0);
        todoScreen.markTodo(1);
        todoScreen.unmarkTodo(0);
        Assert.assertTrue(todoScreen.isTodoMarked(1));
        Assert.assertFalse(todoScreen.isTodoMarked(0));
    }
}
