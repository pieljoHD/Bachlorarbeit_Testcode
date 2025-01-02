package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageIOS;
import org.example.ios.TodoScreenIOS;
import org.testng.annotations.Test;

public class AddAndDeleteTodos extends BaseTestIOS {

    @Test
    public void addAndDeleteTodos() {
        IOSDriver driver = getDriver();
        new LoginPageIOS(driver)
                .loginWithRightCredentials();
        TodoScreenIOS todoScreen = new TodoScreenIOS(driver);
        for(int i = 0; i<3; i++) {
            int x = i+1;
            todoScreen.addTodo("TODO" + x,i);
        }
        todoScreen.deleteTodo(0);
        todoScreen.deleteTodo(1);
        todoScreen.todoHasText("TODO2",0);
    }
}
