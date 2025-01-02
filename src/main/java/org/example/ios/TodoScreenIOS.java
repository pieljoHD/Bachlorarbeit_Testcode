package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenIOS extends BasePageIOS {
    private final By AddTodoButton = By.xpath("//*[@name='AddButton']");
    private final By InputTodoField = By.xpath("//*[@name='TodoInput']");
    private final By InputTodoChangeField = By.xpath("//*[@name='changeTodoInput']");
    private final By SaveTodoChangeButton = By.xpath("//*[@name='speichern']");
    private final By CancelTodoChangeButton = By.xpath("//*[@name='abbrechen']");
    public static By todoNr(int todoNr) { return By.xpath("//*[@name='todoText "+todoNr+"']");}
    public static By deleteButtonNr(int todoNr) { return By.xpath("//*[@name='deleteButton "+todoNr+"']");}
    private final By ClearButton = By.xpath("//*[@name='clearButton']");

    public TodoScreenIOS(IOSDriver driver) {
        super(driver);
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

