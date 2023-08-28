package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMobileTest extends MainTest{

    //navigate to URL
    @Test(priority = 1)
    @Parameters({"url"})
    public void getURL(String url){
        driver.get(url);
    }

    //verify URL
    @Test(priority = 2)
    @Parameters({"url"})
    public void verifyURL(String url){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    //select “Cell Phones & Accessories” from All categories drop down
    @Test(priority = 3)
    public void selectCategory(){
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    //type “Mobile phone” on search bar
    @Test(priority = 4)
    public void typeMobile(){
        Assert.assertEquals( driver.findElement(By.id("gh-ac")).isDisplayed());
        WebElement searchBar = driver.findElement(By.id("gh-ac"));
        searchBar.sendKeys("Mobile phone");
    }

    //click on Search button icon [ Left hand side]
    @Test(priority = 5)
    public void serchMobile(){
        Assert.assertEquals( driver.findElement(By.id("gh-btn")).isDisplayed());
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    //select brand as “Apple” from side panel[checkbox]
    @Test(priority = 6)
    public void selectBrand(){
        WebElement appleCheckBox = driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/div/div/span[1]"));
        appleCheckBox.click();
    }

    //select the first search item.
    @Test(priority = 7)
    public void selectFirstItem() throws InterruptedException {
        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span"));
        firstItem.click();
        Thread.sleep(5000);

        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }


}
