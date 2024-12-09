package org.example.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By AddTodoButton = AppiumBy.id("addButton");
    private final By InputTodoField = AppiumBy.id("todoInput");
    private final By InputTodoChangeField = AppiumBy.id("changeTodoInput");
    private final By SaveTodoChangeButton = AppiumBy.id("speichern");
    private final By CancelTodoChangeButton = AppiumBy.id("abbrechen");
    public static By todoNr(int todoNr) { return AppiumBy.id("todoText "+todoNr);}
    public static By deleteButtonNr(int todoNr) { return AppiumBy.id("deleteButton "+todoNr);}
    private final By ClearButton = AppiumBy.id("clearButton");

    public TodoScreenAndroid(AndroidDriver driver) {
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
        Assert.assertEquals(getElement(todoNr(index)).getAttribute("text"), text);
    }

    public void todoHasNotTodo(String text, int index) {
        Assert.assertNotEquals(getElement(todoNr(index)).getAttribute("text"), text);
    }

    public void changeTodoAndSave(String text, int index) {
        click(todoNr(index));
        click(ClearButton);
        sendKeys(InputTodoChangeField, text);
        click(SaveTodoChangeButton);
    }

    public void changeTodoAndCancel(String text, int index) {
        click(todoNr(index));
        click(ClearButton);
        sendKeys(InputTodoChangeField, text);
        click(CancelTodoChangeButton);
    }
}
