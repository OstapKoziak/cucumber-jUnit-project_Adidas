package com.cydeo.step_definitions;

import com.cydeo.pages.Adidas_BasePage;
import com.cydeo.pages.Adidas_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class Adidas_StepDef extends Adidas_BasePage {

    Adidas_Page adidas = new Adidas_Page();
    Adidas_BasePage adidas_basePage = new Adidas_BasePage();

    @Given("User navigates to the home page")
    public void user_navigates_to_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("AdidasShop"));

    }
    @Then("User navigates to the {string} section and clicks on {string}")
    public void user_navigates_to_the_laptops_section_and_clicks_on_it(String string1, String string2) {

        adidas_basePage.selectProduct(string1,string2);
    }

    @Then("User clicks on Add to cart and accepts the pop up confirmation")
    public void user_clicks_on_add_to_cart_and_accepts_the_pop_up_confirmation() {

    adidas.addToCart.click();
    BrowserUtils.sleep(3);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        adidas.homeButton.click();
        BrowserUtils.sleep(2);
    }
    @Then("User navigates back to the home page and to the {string} sections again and clicks on {string}")
    public void user_navigates_back_to_the_home_page_and_to_the_laptops_sections_again(String string1, String string2) {

        adidas_basePage.selectProduct(string1, string2);

    }

    @Then("User clicks Add to cart and accepts pop up confirmation")
    public void user_clicks_add_to_cart_and_accepts_pop_up_confirmation() {

        adidas.addToCart.click();
        BrowserUtils.sleep(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(2);

    }
    @Then("User navigates to Cart section and deletes {string} from cart")
    public void user_navigates_to_cart_section(String string) {

        adidas_basePage.deleteFromCart(string);

        BrowserUtils.sleep(2);
        adidas.placeOrderButton.click();
        BrowserUtils.sleep(2);
    }

    @And("User enters {string} to name")
    public void userEntersToName(String string) {
        BrowserUtils.waitForVisibilityOf(adidas.formBody);
        BrowserUtils.sleep(2);
        adidas.nameInput.sendKeys(string);
    }

    @And("User enters {string} to country")
    public void userEntersToCountry(String string) {
        adidas.countryInput.sendKeys(string);
    }

    @And("user enters {string} to city")
    public void userEntersToCity(String string) {
        adidas.cityInput.sendKeys(string);
    }

    @And("User enters {string} to cardNumber")
    public void userEntersToCardNumber(String string) {
        adidas.cardInput.sendKeys(string);
    }

    @And("User enters {string} to month")
    public void userEntersToMonth(String string) {
        adidas.monthInput.sendKeys(string);
    }

    @And("User enters {string} to year")
    public void userEntersToYear(String string) {
        adidas.yearInput.sendKeys(string);
    }

    @And("Click on Purchase")
    public void clickOnPurchase() {
        BrowserUtils.sleep(3);
        adidas.purchaseButton.click();
    }

    @And("Capture and log purchase Id and Amount.")
    public void captureAndLogPurchaseIdAndAmount() {

        String text = adidas.purchaseAmount.getText();
        String id = text.substring(0, text.indexOf('A'));
        String purchaseAmount = text.substring(text.indexOf('A'), text.indexOf('D')+1);
        System.out.println(purchaseAmount);
    }

    @And("Assert purchase amount equals expected.")
    public void assertPurchaseAmountEqualsExpected() {

        System.out.println(adidas.purchaseAmount.getText());
        //String str = adidas.purchaseAmount.getText();
        String expectedAmount = "Amount: 790 USD";
        String text = adidas.purchaseAmount.getText();
        String actualAmount = text.substring(text.indexOf('A'), text.indexOf('D')+1);

        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Then("User clicks Ok")
    public void user_clicks_ok() {

        adidas.purchaseConfirmationButton.click();
        BrowserUtils.sleep(2);
    }



}
