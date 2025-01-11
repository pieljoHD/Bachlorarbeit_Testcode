package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TodoScreenAndroid extends BasePageAndroid<TodoScreenAndroid>{
    @CacheLookup
    @AndroidFindBy(id = "AddButton")
    private WebElement addButton;

    @CacheLookup
    @AndroidFindBy(id = "TodoInput")
    private WebElement todoInput;

    @AndroidFindBy(id = "changeTodoInput")
    private WebElement changeTodoInput;

    @AndroidFindBy(id = "speichern")
    private WebElement speichern;

    @AndroidFindBy(id = "abbrechen")
    private WebElement abbrechen;

    public static By todoNr(int todoNr) { return new By.ById("todoText " + todoNr); }

    public static By deleteButtonNr(int todoNr) { return new By.ById("deleteButton " + todoNr);}

    @AndroidFindBy(id = "clearButton")
    private WebElement clearButton;

    public TodoScreenAndroid(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void addTodo(String todo, int index) {
        todoInput.sendKeys(todo);
        addButton.click();
        swipeDown();

        Assert.assertTrue(isElementDisplayed(todoNr(index)));
    }

    public void deleteTodo(int index) {
        click(deleteButtonNr(index));
    }

    public void todoHasTodo(String text, int index) {
        Assert.assertEquals(getElement(todoNr(index)).getAttribute("text"), text);
    }

    public void changeTodoAndSave(String text, int index) {
        click(todoNr(index));
        clearButton.click();
        changeTodoInput.sendKeys(text);
        speichern.click();
    }

    public void changeTodoAndCancel(String text, int index) {
        click(todoNr(index));
        clearButton.click();
        changeTodoInput.sendKeys(text);
        abbrechen.click();
    }
}
