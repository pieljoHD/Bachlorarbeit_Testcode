package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By AddTodoButton = By.id("addButton");
    private final By InputTodoField = By.id("todoInput");
    private final By InputTodoChangeField = By.id("changeTodoInput");
    private final By SaveTodoChangeButton = By.id("speichern");
    private final By CancelTodoChangeButton = By.id("abbrechen");
    public static By todoNr(int todoNr) { return By.id("todoText "+todoNr);}
    public static By deleteButtonNr(int todoNr) { return By.id("deleteButton "+todoNr);}
    private final By ClearButton = By.id("clearButton");

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
