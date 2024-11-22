package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.example.android.TodoScreenAndroid;
import org.testng.annotations.Test;

public class AddTodoTestAndroid extends BaseTestAndroid {

//    @Test
//    public void addTodoTestAndroid() {
//        AndroidDriver driver = getDriver();
//
//        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
//        loginPage.loginWithRightCredentials();
//
//        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
//        todoScreen.addTodo("TODO1",0);
//        todoScreen.addTodo("TODO2",1);
//        todoScreen.addTodo("TODO3",2);
//    }

//    @Test
//    public void addAlotOfTodoTestAndroid() {
//        AndroidDriver driver = getDriver();
//
//        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
//        loginPage.loginWithRightCredentials();
//
//        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
//        for(int i = 0; i<30; i++) {
//            todoScreen.addTodo("TODOD " + i, i);
//        }
//    }

    @Test
    public void changeTodoTestAndroid() {
        AndroidDriver driver = getDriver();

        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
        loginPage.loginWithRightCredentials();

        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
        todoScreen.addTodo("TODO1",0);
        todoScreen.changeTodoAndSave("newTodo",0);
    }

//    @Test
//    public void deleteTodoTestAndroid() {
//        AndroidDriver driver = getDriver();
//
//        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
//        loginPage.loginWithRightCredentials();
//
//        TodoScreenAndroid todoScreen = new TodoScreenAndroid(driver);
//        todoScreen.addTodo("TODO1",0);
//
//        todoScreen.deleteTodo(0);
//    }
}
