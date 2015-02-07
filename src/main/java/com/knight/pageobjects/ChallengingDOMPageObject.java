package com.knight.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawnknight on 2/7/15.
 */
public class ChallengingDOMPageObject
{
    private final WebDriver driver;

    @FindBy(css = "table")      private WebElement dataTable;
    @FindBy(css = "table tr")   private List<WebElement> tableRowElements;

    public ChallengingDOMPageObject searchAndEditRow(String text)
    {
        for (RowPageObject rowPageObject : getRowPageObjects())
        {
            if (rowPageObject.isRowMatch(text))
                return editRow(rowPageObject);
        }
        return PageFactory.initElements(driver,ChallengingDOMPageObject.class);
    }
    public ChallengingDOMPageObject searchAndDeleteRow(String text)
    {
        for (RowPageObject rowPageObject : getRowPageObjects())
        {
            if (rowPageObject.isRowMatch(text))
                return deleteRow(rowPageObject);
        }
        return PageFactory.initElements(driver,ChallengingDOMPageObject.class);
    }
    public String searchAndReadAmetColumn(String text)
    {
        for (RowPageObject rowPageObject : getRowPageObjects())
        {
            if (rowPageObject.isRowMatch(text))
                return rowPageObject.readAmetColumn();
        }
        return "";
    }
    private List<RowPageObject> getRowPageObjects()
    {
        List<RowPageObject> libraryEPublications = new ArrayList<>();
        for (WebElement element : tableRowElements)
        {
            libraryEPublications.add(new RowPageObject(element));
        }
        return libraryEPublications;
    }
    private ChallengingDOMPageObject editRow(RowPageObject rowPageObject)
    {
        rowPageObject.edit();
        return this;
    }
    private ChallengingDOMPageObject deleteRow(RowPageObject rowPageObject)
    {
        rowPageObject.delete();
        return this;
    }
    public ChallengingDOMPageObject isLoaded()
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElements(tableRowElements));
        return this;
    }
    public ChallengingDOMPageObject(WebDriver driver)
    {
        this.driver = driver;
    }
}