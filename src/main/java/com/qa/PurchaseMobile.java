package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PurchaseMobile extends MainTest {

    private String itemTitleText;
    private String priceValue;
    private String quantity;

    //select model of the device
    @Test(priority = 8)
    public void selectModel() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel="Model"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        }
        catch (Exception 0){
            System.out.println("Model drop-down not found");
        }
    }

    //select carrier of the device
    @Test (priority = 9)
    public void selectCarrier() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel="Carrier"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        }
        catch (Exception 0){
            System.out.println("Carrier drop-down not found");
        }
    }


    //select storage capacity of the device
    @Test (priority = 10)
    public void selectStorageCapacity() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel="storage"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception 0){
            System.out.println("Storage Capacity drop-down not found");
        }
    }

    //select color of the device
    @Test (priority = 11)
    public void selectColor() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel="color"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception 0){
            System.out.println("Color drop-down not found");
        }
    }

}
