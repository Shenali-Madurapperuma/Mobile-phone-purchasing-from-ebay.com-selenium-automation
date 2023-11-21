package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SelectMobileTest extends Main {

    @Test(priority = 1)
    @Parameters({ "url" })
    // navigate to URL
    public void getURL(String url) {
        webdriver.get(url);
    }

    @Test(priority = 2)
    @Parameters({ "url" })
    // verify URL
    public void verifyURL(String url) {
        Assert.assertEquals(webdriver.getCurrentUrl(), url);
        System.out.println("URL is Verified Successfully.");
    }

    // select “Cell Phones & Accessories” from All categories dropdown menu
    @Test(priority = 3)
    public void selectCategory() {
        WebElement categoryDropDown = webdriver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    // type “Mobile phone” on search bar
    @Test(priority = 4)
    public void typeMobile() {
        WebElement searchBar = webdriver.findElement(By.id("gh-ac"));
        searchBar.sendKeys("Mobile phone");
    }

    // click on Search button icon [ Left hand side]
    @Test(priority = 5)
    public void serchMobile() {
        WebElement searchButton = webdriver.findElement(By.id("gh-btn"));
        searchButton.click();
    }

    // select brand as “Apple” from side panel[checkbox]
    @Test(priority = 6)
    public void selectBrand() {
        WebElement appleCheckBox = webdriver
                .findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/div/div/span[1]"));
        appleCheckBox.click();
    }

    // select the first search item from the apple mobile phone list
    @Test(priority = 7)
    public void selectFirstItem() {
        WebElement firstItem = webdriver
                .findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span"));
        firstItem.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String winHandle : webdriver.getWindowHandles()) {
            webdriver.switchTo().window(winHandle);
        }
    }

}
