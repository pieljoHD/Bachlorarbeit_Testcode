package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TodoScreenAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By AddTodoButton = By.xpath("//*[@resource-id='addButton']");
    private final By InputTodoField = By.xpath("//*[@resource-id='todoInput']");
    private final By InputTodoChangeField = By.xpath("//*[@resource-id='changeTodoInput']");
    private final By SaveTodoChangeButton = By.xpath("//*[@text='speichern']");
    private final By CancelTodoChangeButton = By.xpath("//*[@text='abbrechen']");
    public static By todoNr(int todoNr) { return By.xpath("//*[@resource-id='todoText "+todoNr+"']");}
    public static By deleteButtonNr(int todoNr) { return By.xpath("//*[@resource-id='deleteButton "+todoNr+"']");}

    public TodoScreenAndroid(AndroidDriver driver) {
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
        Assert.assertFalse(isElementDisplayed(todoNr(index)));
    }

    public void todoHasTodo(String text, int index) {
        Assert.assertSame(getElement(todoNr(index)).getAttribute("text"), text);
    }
    public void todoHasNotTodo(String text, int index) {
        Assert.assertNotSame(getElement(todoNr(index)).getAttribute("text"), text);
    }

    public void changeTodoAndSave(String text, int index) {
        click(todoNr(index));
        WebElement inputField = driver.findElement(By.id("changeTodoInput"));
        inputField.sendKeys("test123455");
        click(SaveTodoChangeButton);
        todoHasTodo(text, index);
    }

    public void changeTodoAndCancel(String text, int index) {
        click(todoNr(index));
        sendKeys(InputTodoChangeField, text);
        click(CancelTodoChangeButton);
        todoHasNotTodo(text, index);
    }
}
