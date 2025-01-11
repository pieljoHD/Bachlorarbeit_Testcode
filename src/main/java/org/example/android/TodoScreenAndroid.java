package org.example.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By AddTodoButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"AddButton\")");
    private final By InputTodoField = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"TodoInput\")");
    private final By InputTodoChangeField = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"changeTodoInput\")");
    private final By SaveTodoChangeButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"speichern\")");
    private final By CancelTodoChangeButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"abbrechen\")");
    public static By todoNr(int todoNr) { return AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"todoText "+todoNr+"\")");}
    public static By deleteButtonNr(int todoNr) { return AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"deleteButton "+todoNr+"\")");}
    private final By ClearButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"clearButton\")");

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
