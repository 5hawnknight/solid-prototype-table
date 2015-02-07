package com.knight.pageobjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by shawnknight on 2/7/15.
 */

public class RowPageObject
{
    private WebElement element;

    public RowPageObject(WebElement element)
    {
        this.element = element;
    }
    public boolean isRowMatch(String searchString)
    {
        return StringUtils.equalsIgnoreCase(readLoremColumn(),searchString);
    }
    public String readLoremColumn()
    {
        return element.findElement(By.cssSelector(":nth-child(1)")).getText();
    }
    public String readIpsumColumn()
    {
        return element.findElement(By.cssSelector(":nth-child(2)")).getText();
    }
    public String readDolorColumn()
    {
        return element.findElement(By.cssSelector(":nth-child(3)")).getText();
    }
    public String readSitColumn()
    {
        return element.findElement(By.cssSelector(":nth-child(4)")).getText();
    }
    public String readAmetColumn()
    {
        return element.findElement(By.cssSelector(":nth-child(5)")).getText();
    }
    public String readDiceretColumn()
    {
        return element.findElement(By.cssSelector(":nth-child(6)")).getText();
    }
    public void edit()
    {
        element.findElement(By.cssSelector(":nth-child(7) a[href *= 'edit']")).click();
    }
    public void delete()
    {
        element.findElement(By.cssSelector(":nth-child(7) a[href *= 'delete']")).click();
    }
}