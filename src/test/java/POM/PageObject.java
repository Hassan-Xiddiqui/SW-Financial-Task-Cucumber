package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class PageObject {
    public static WebDriver driver;
    public static Actions action;

//  To Open Chrome Browser and Navigate to the URL
    public static void chromeConfig() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Dependency\\chromedriver.exe");

        driver = new ChromeDriver();

        action = new Actions(driver);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

//  To Open Edge Browser and Navigate to the URL
    public static void edgeConfig() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Dependency\\msedgedriver.exe");

        driver = new EdgeDriver();

        action = new Actions(driver);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

//  To Sign-in with Specified Username and Password
    public static void signIn(String userName, String passWord) {

        driver.findElement(By.cssSelector("#user-name")).clear();
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#user-name")).sendKeys(userName);
        driver.findElement(By.cssSelector("#password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("#login-button")).click();

    }

//  To Filter Products Based On Option Value such as
//  az ; za ; lohi ; hilo
    public static void filterProducts(String filterValue) {
        driver.findElement(By.cssSelector("option[value='" + filterValue + "']")).click();
    }

//  It will only add those products that are below than 15.99$
    public static void addProductcondition() {
        List<WebElement> productContainers = driver.findElements(By.cssSelector(".inventory_item"));
        for (WebElement productContainer : productContainers) {
            WebElement productPrice = productContainer.findElement(By.cssSelector(".inventory_item_price"));
            System.out.println(productPrice.getText().substring(1));
            if (Double.parseDouble(productPrice.getText().substring(1)) < 15.99)
            {   driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click(); }

        }
    }

//  User can will click on cart icon
    public static void clickCart(){
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

//  It will only remove those items that are greater than 9$
    public static void removeProductcondition(){
        List<WebElement> cartContainers = driver.findElements(By.cssSelector(".cart_item"));
        for (WebElement cartContainer : cartContainers) {
            WebElement productPrice = cartContainer.findElement(By.cssSelector(".inventory_item_price"));
            System.out.println(productPrice.getText().substring(1));
            if (Double.parseDouble(productPrice.getText().substring(1)) > 9) {
                driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button")).click();
            }
        }
    }

//  It will click on checkout icon
    public static void clickCheckout(){
        driver.findElement(By.cssSelector("#checkout")).click();
    }

//  It will click on continue button
    public static void contButton(){
        driver.findElement(By.cssSelector("#continue")).click();
    }

//  It will fill the form
    public static void fillForm(String firstName, String lastName, Integer zipCode){
        driver.findElement(By.cssSelector("#first-name")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#last-name")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#postal-code")).sendKeys(""+zipCode+"");
    }

//  It will click on Finish Button
    public static void finishButton(){
        driver.findElement(By.cssSelector("#finish")).click();
    }

//  It will logout the user
    public static void logout(){
        driver.findElement(By.cssSelector("#back-to-products")).click();
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        driver.findElement(By.cssSelector("a#logout_sidebar_link")).click();
    }

//  It will close the driver
    public static void close(){
        driver.close();
    }
}