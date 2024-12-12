package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TodoScreenIOS extends BasePageIOS<TodoScreenIOS> {
    @FindBy(id = "AddButton")
    private WebElement addButton;

    @FindBy(id = "TodoInput")
    private WebElement todoInput;

    @FindBy(id = "changeTodoInput")
    private WebElement changeTodoInput;

    @FindBy(id = "speichern")
    private WebElement speichern;

    @FindBy(id = "abbrechen")
    private WebElement abbrechen;

    public static By todoNr(int todoNr) { return new By.ById("todoText " + todoNr); }

    public static By deleteButtonNr(int todoNr) { return new By.ById("deleteButton " + todoNr);}

    @FindBy(id = "clearButton")
    private WebElement clearButton;
    public TodoScreenIOS(IOSDriver driver) {
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
        Assert.assertEquals(getElement(todoNr(index)).getAttribute("label"), text);
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

