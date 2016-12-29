package com.knight.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by shawn knight
 * shawn.knight.work@gmail.com
 */

public class ChallengingDOMPageObject
{
    private final WebDriver driver;

    @FindBy(css = "table")      private WebElement table;
    @FindBy(css = "table tr")   private List<WebElement> rows;

    public ChallengingDOMPageObject searchAndEditRow(String text)
    {
        return editRow(rows.stream()
                .map(row -> new RowPageObject(row))
                .filter(poRow -> poRow.isMatch(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unable to find row to edit")));
    }
    public ChallengingDOMPageObject searchAndDeleteRow(String text)
    {
        return deleteRow(rows.stream()
                .map(row -> new RowPageObject(row))
                .filter(poRow -> poRow.isMatch(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unable to find row to delete")));
    }
    public String searchAndReadAmetColumn(String text)
    {
        return rows.stream()
                .map(row -> new RowPageObject(row))
                .filter(poRow -> poRow.isMatch(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unable to find row to read"))
                .readAmetColumn();
    }
    private ChallengingDOMPageObject editRow(RowPageObject rowPageObject)
    {
        rowPageObject.edit();
        return this; // this line would normally return a completely different page object but the example does not navigate to the next edit page
    }
    private ChallengingDOMPageObject deleteRow(RowPageObject rowPageObject)
    {
        rowPageObject.delete();
        return this; // this line would normally return a completely different page object but the example does not navigate to the next delete page
    }
    public ChallengingDOMPageObject isLoaded()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElements(rows));
        return this;
    }
    public ChallengingDOMPageObject(WebDriver driver)
    {
        this.driver = driver;
    }
}