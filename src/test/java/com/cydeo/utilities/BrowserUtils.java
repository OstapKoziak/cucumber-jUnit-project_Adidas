package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrowserUtils {

    // Methods are static because we do not want to create an object to call this methods, we just want to call those methods with class name. That's why they are static
    public static void sleep(int seconds){

        //BrowserUtils.sleep(3); -> will convert it to seconds from milliseconds

        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in this method");
        }

    }

    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    public static void verifyTitle(String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Verification test failed", actualTitle, expectedTitle);

    }

    public static class ConfigurationReader {

        // 1 - create the object of properties class
        // We need properties class to use methods coming from class like load(), getProperty("key")
        // it is static since we use it in static method
       private static Properties properties = new Properties();

       // We want to open the properties file and load to properties object ONLY ONCE before reading
        // having static block because static runs first
        {// static block starts
            try {
                // 2- Create the object of FileInputStream
                // We need this object to open file as a stream in Java memory
                FileInputStream file = new FileInputStream("configuration.properties");

                // 3- Load the properties object using FileInputStream object
                // Load "properties" object with the "file" we opened using FileInputStream
                properties.load(file);

               // close the file after loading
               // if we do not close the file, it will take space from computer memory like Scanner
            file.close();
            } catch(IOException e) {
            e.printStackTrace();
            }
        }//static block ends

        public static String getProperty(String keyword){
            return properties.getProperty(keyword);

        }

    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element){
        WebDriverWait wait  =new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a WebElement
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month options as a String
        List<String> actualOptionsAsString = new ArrayList<>();

        // with using for loop we will convert each WebElement of options to String wit using getText() method
        // with using add() method we will add each String option in List<String> actual options as String
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButton, String attributeValue){

        for(WebElement each : radioButton){
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }


}
