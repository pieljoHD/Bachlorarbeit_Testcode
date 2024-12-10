package org.example.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenIOS extends BasePageIOS<TodoScreenIOS> {
    private final By AddTodoButton = AppiumBy.iOSNsPredicateString("name == 'AddButton'");
    private final By InputTodoField = AppiumBy.iOSNsPredicateString("name == 'TodoInput'");
    private final By InputTodoChangeField = AppiumBy.iOSNsPredicateString("name == 'changeTodoInput'");
    private final By SaveTodoChangeButton = AppiumBy.iOSNsPredicateString("name == 'speichern'");
    private final By CancelTodoChangeButton = AppiumBy.iOSNsPredicateString("name == 'abbrechen'");
    public static By todoNr(int todoNr) { return AppiumBy.iOSNsPredicateString("name == 'todoText "+todoNr+"'");}
    public static By deleteButtonNr(int todoNr) { return AppiumBy.iOSNsPredicateString("name == 'deleteButton "+todoNr+"'");}
    private final By ClearButton = AppiumBy.iOSNsPredicateString("name == 'clearButton'");

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

    public void changeTodoAndSave(String text, int index)  {
        click(todoNr(index));
        click(ClearButton);
        sendKeys(InputTodoChangeField, text);
        click(SaveTodoChangeButton);
    }

    public void changeTodoAndCancel(String text, int index)  {
        click(todoNr(index));
        click(ClearButton);
        sendKeys(InputTodoChangeField, text);
        click(CancelTodoChangeButton);
    }
}

