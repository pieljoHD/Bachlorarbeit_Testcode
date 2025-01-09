package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageIOS;
import org.example.ios.TodoScreenIOS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndMarkTodo extends BaseTestIOS {

    @Test
    public void addAndMarkTodo() {
        IOSDriver driver = getDriver();
        new LoginPageIOS(driver)
                .loginWithRightCredentials();
        TodoScreenIOS todoScreen = new TodoScreenIOS(driver);
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
