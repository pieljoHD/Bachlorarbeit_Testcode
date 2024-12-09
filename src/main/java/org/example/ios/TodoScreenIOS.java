package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenIOS extends BasePageIOS<TodoScreenIOS> {
    private final By AddTodoButton = By.id("AddButton");
    private final By InputTodoField = By.id("TodoInput");
    private final By InputTodoChangeField = By.id("changeTodoInput");
    private final By SaveTodoChangeButton = By.id("speichern");
    private final By CancelTodoChangeButton = By.id("abbrechen");
    public static By todoNr(int todoNr) { return By.id("todoText "+todoNr);}
    public static By deleteButtonNr(int todoNr) { return By.id("deleteButton "+todoNr);}
    private final By ClearButton = By.id("clearButton");

    public TodoScreenIOS(IOSDriver driver) {
        super(driver);
    }

    public void clearField() {
        click(ClearButton);
    }

    public void addTodo(String todo, int index) {
        sendKeys(InputTodoField, todo);
        click(AddTodoButton);
        swipeDown();

        Assert.assertTrue(isElementDisplayed(todoNr(index)));
    }

    public void deleteTodo(int index) {
        click(deleteButtonNr(index));
    }

    public void todoHasTodo(String text, int index) {
        Assert.assertEquals(getElement(todoNr(index)).getAttribute("label"), text);
    }

    public void todoHasNotTodo(String text, int index) {
        Assert.assertNotEquals(getElement(todoNr(index)).getAttribute("label"), text);
    }

    public void changeTodoAndSave(String text, int index) throws InterruptedException {
        click(todoNr(index));
        wait.wait(200);
        click(ClearButton);
        sendKeys(InputTodoChangeField, text);
        click(SaveTodoChangeButton);
    }

    public void changeTodoAndCancel(String text, int index) throws InterruptedException {
        click(todoNr(index));
        wait.wait(200);
        click(ClearButton);
        sendKeys(InputTodoChangeField, text);
        click(CancelTodoChangeButton);
    }
}

