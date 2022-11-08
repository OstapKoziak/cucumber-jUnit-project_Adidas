package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Adidas_BasePage {

    public Adidas_BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindAll(@FindBy(xpath = "//a[@class='list-group-item']"))
    public List<WebElement> categories;

    @FindBy (xpath = "//ul[@class='navbar-nav ml-auto']//li[4]")
    public WebElement cartButton;


    public void selectProduct(String category, String product){
        for(WebElement each : categories){
            if(each.getText().equals(category)){
                each.click();
            }
        }
        BrowserUtils.sleep(3);
        Driver.getDriver().findElement(By.xpath("//a[.='" + product +"']")).click();    }

    public void deleteFromCart(String product){
        cartButton.click();
        Driver.getDriver().findElement(By.xpath("//tr[@class='success']//td[.='" + product +"']/following-sibling::td[2]//a[.='Delete']")).click();
    }


}
