package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TodoScreenAndroid extends BasePageAndroid {
    private final By AddTodoButton = By.xpath("//*[@resource-id='AddButton']");
    private final By InputTodoField = By.xpath("//*[@resource-id='TodoInput']");
    private final By InputTodoChangeField = By.xpath("//*[@resource-id='changeTodoInput']");
    private final By SaveTodoChangeButton = By.xpath("//*[@text='speichern']");
    private final By CancelTodoChangeButton = By.xpath("//*[@text='abbrechen']");
    private static By todoNr(int todoNr) { return By.xpath("//*[@resource-id='todoText "+todoNr+"']");}
    private static By deleteButtonNr(int todoNr) { return By.xpath("//*[@resource-id='deleteButton "+todoNr+"']");}
    private final By ClearButton = By.xpath("//*[@resource-id='clearButton']");

    private static By MarkTodoButton(int todoNr) { return By.xpath("//*[@resource-id='MarkTodoButton "+todoNr+"']");}
    private static By UnMarkTodoButton(int todoNr) { return By.xpath("//*[@resource-id='UnMarkTodoButton "+todoNr+"']");}

    public TodoScreenAndroid(AndroidDriver driver) {
        super(driver);
    }

    public void addTodo(String todo, int index) {
        sendKeys(InputTodoField, todo);
        click(AddTodoButton);
        swipeDown();

        Assert.assertTrue(isElementDisplayed(todoNr(index)));
    }

    public void markTodo(int todoIndex) {
        click(MarkTodoButton(todoIndex));
    }
    public void unmarkTodo(int todoIndex) {
        click(UnMarkTodoButton(todoIndex));
    }
    public Boolean isTodoMarked(int todoIndex) {
        return isElementDisplayed(UnMarkTodoButton(todoIndex));
    }

    public void deleteTodo(int index) {
        click(deleteButtonNr(index));
    }

    public void todoHasTodo(String text, int index) {
        Assert.assertEquals(getElement(todoNr(index)).getAttribute("text"), text);
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
