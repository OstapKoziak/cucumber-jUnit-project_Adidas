package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.ref.WeakReference;

public class Adidas_Page {

    public Adidas_Page(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy (xpath = "//div[@class='list-group']//a[3]")
    public WebElement laptopsButton;

    @FindBy (xpath = "(//div[@class='card-block'])[1]//h4")
    public WebElement SonyI5;

    @FindBy (xpath = "(//div[@class='row'])[2]//a[@href='#']")
    public WebElement addToCart;

    @FindBy (xpath = "(//div[@class='card-block'])[2]//h4")
    public WebElement SonyI7;

    @FindBy (xpath = "//a[@class='navbar-brand']")
    public WebElement homeButton;

    @FindBy (xpath = "//ul[@class='navbar-nav ml-auto']//li[4]")
    public WebElement cartButton;

    @FindBy (xpath = "(//tr[@class='success']//a[.='Delete'])[1]")
    public WebElement deleteButton;

    @FindBy (xpath = "//button[@class='btn btn-success']")
    public WebElement placeOrderButton;

    @FindBy (xpath = "(//div[@class='modal-body'])[3]")
    public WebElement formBody;

    @FindBy (id= "name")
    public WebElement nameInput;

    @FindBy (id= "country")
    public WebElement countryInput;

    @FindBy (id= "city")
    public WebElement cityInput;

    @FindBy (id= "card")
    public WebElement cardInput;

    @FindBy (id= "month")
    public WebElement monthInput;

    @FindBy (id = "year")
    public WebElement yearInput;

    @FindBy (xpath = "//button[@onclick='purchaseOrder()']")
    public WebElement purchaseButton;

    @FindBy (xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    public WebElement purchaseConfirmationButton;

    @FindBy (xpath = "//p[@class='lead text-muted ']")
    public WebElement purchaseAmount;

}
