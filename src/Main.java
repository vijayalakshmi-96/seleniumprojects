import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public   static ArrayList<String> tabs;
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("Webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        var options = new ChromeOptions();
        // options.addArguments(@"user-data-dir=c:\Users\vijay\AppData\Local\Google\Chrome\User Data\");
        System.setProperty("Webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        setCurrentUrl(2000L,driver,0);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("maxi dress for women");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.linkText("Women's Floral Maxi Dress")).click();
        setCurrentUrl(2000L,driver,1);
        boolean isPresent;
        try {
            driver.findElement(By.cssSelector("#size_name_0 > span > input"));
            isPresent= true;
        } catch (Exception e){
            isPresent = false;
        }
        if ( isPresent){
            driver.findElement(By.cssSelector("#size_name_0 > span > input")).click();

        }else {
            Select se = new Select(driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']")));
            se.selectByVisibleText("S");
            Select se1 = new Select(driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']")));
            se1.selectByVisibleText("M");

        }
        setCurrentUrl(2000L,driver,1);
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();
        setCurrentUrl(2000L,driver,1);;
        driver.findElement(By.cssSelector("#sc-buy-box-ptc-button > span > input")).click();
        setCurrentUrl(2000L,driver,1);
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8778766897");
        driver.findElement(By.cssSelector("#continue")).click();
        driver.findElement(By.cssSelector("#ap_password")).sendKeys("Haivijieee");
        driver.findElement(By.cssSelector("#signInSubmit")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div.a-section.a-spacing-base > div > div > form > div > div:nth-child(7) > div > div > label > div > label > input[type=checkbox]")).click();

    }
    public static void setCurrentUrl(Long milliseconds, WebDriver driver, int tabPosition) throws InterruptedException {

        tabs = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(milliseconds);
        driver.switchTo().window(tabs.get(tabPosition));
        driver.getCurrentUrl();
    }
}




