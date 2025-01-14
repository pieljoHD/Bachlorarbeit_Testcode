package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TodoPage extends BasePage {

    @CacheLookup
    @FindBy(id = "AddButton")
    private WebElement addButton;

    @CacheLookup
    @FindBy(id = "TodoInput")
    private WebElement todoInput;

    @FindBy(id = "changeTodoInput")
    private WebElement changeTodoInput;

    @FindBy(id = "speichern")
    private WebElement speichern;

    @FindBy(id = "abbrechen")
    private WebElement abbrechen;

    private static By todoNr(int todoNr) { return new By.ById("todoText " + todoNr); }

    private static By deleteButtonNr(int todoNr) { return new By.ById("deleteButton " + todoNr);}

    private static By MarkTodoButton(int todoNr) { return new By.ById("MarkTodoButton " + todoNr);}
    private static By UnMarkTodoButton(int todoNr) { return new By.ById("UnMarkTodoButton " + todoNr);}

    @FindBy(id = "clearButton")
    private WebElement clearButton;

    public TodoPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        if(driver instanceof AndroidDriver) {
            Assert.assertEquals(getElement(todoNr(index)).getAttribute("text"), text);
        } else if(driver instanceof IOSDriver) {
            Assert.assertEquals(getElement(todoNr(index)).getAttribute("label"), text);
        }
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
