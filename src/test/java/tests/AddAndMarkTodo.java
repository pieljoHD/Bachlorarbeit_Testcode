package tests;

import org.example.pages.LoginPage;
import org.example.pages.TodoPage;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndMarkTodo extends BaseTest {

    @Test
    public void addAndMarkTodo() {
        new LoginPage(driver)
                .loginWithRightCredentials();
        TodoPage todoScreen = new TodoPage(driver);
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